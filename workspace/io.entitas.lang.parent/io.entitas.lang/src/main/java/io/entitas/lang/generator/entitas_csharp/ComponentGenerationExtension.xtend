package io.entitas.lang.generator.entitas_csharp

import io.entitas.lang.dsl.Component
import static extension io.entitas.lang.extensions.ComponentExtensions.*
import static extension io.entitas.lang.extensions.AliasExtensions.*

class ComponentGenerationExtension {
	static def componentInterface(Component component, String target) '''
		«IF component.isFlag»
		public interface I«component.componentTypeName» : IComponent {}
		«ELSE»
		public interface I«component.componentTypeName» : IComponent {
			«FOR rule : component.listOfProperties.rules»
			«rule.alias.typeName(target)» «rule.name» { get; }
			«ENDFOR»
		}
		«ENDIF»
	'''
	
	static def componentClass(Component component, String target) '''
		«IF component.isFlag»
		public sealed partial class «component.componentTypeName» : I«component.componentTypeName» {}
		«ELSE»
		public sealed partial class «component.componentTypeName» : I«component.componentTypeName» {
			«FOR rule : component.listOfProperties.rules»
			public «rule.alias.typeName(target)» «rule.name» { get; set; }
			«ENDFOR»
		}
		«ENDIF»
	'''
	
	static def entityExtension(Component component, String target, String defaultContext) '''
		«val typeName = component.componentTypeName»
		«val name = component.componentName»
		«IF component.isFlag»
		«FOR ctx : component.contextNameList(defaultContext)»
		public partial class «ctx»Entity {
			«val propertyName = typeName.toFirstLower»
			«val prefix = component.propertyPrefix?.string ?: "is"»
			«val lookup = ctx+"ComponentsLookup." + name»
			static readonly «typeName» «propertyName» = new «typeName»();
			public bool «prefix»«name» {
				get { return HasComponent(«lookup»); }
				set {
					if(value != «prefix»«name») {
						if(value) {
							AddComponent(«lookup», «propertyName»);
						} else {
							RemoveComponent(«lookup»);
						}
					}
				}
			}
		}
		«ENDFOR»
		«ELSE»
		«FOR ctx : component.contextNameList(defaultContext)»
		public partial class «ctx»Entity {
			«val lookup = ctx+"ComponentsLookup." + component.componentName»
			public I«typeName» «name.toFirstLower» { get { return (I«typeName»)GetComponent(«lookup»); } }
			public bool has«name» { get { return HasComponent(«lookup»); } }
		
			public void Add«name»(«FOR rule : component.listOfProperties.rules SEPARATOR ', '»«rule.alias.typeName(target)» new«rule.name.toFirstUpper»«ENDFOR») {
				var component = CreateComponent<«typeName»>(«lookup»);
				«FOR rule : component.listOfProperties.rules»
				component.«rule.name» = new«rule.name.toFirstUpper»;
				«ENDFOR»
				AddComponent(«lookup», component);
			}
		
			public void Replace«name»(«FOR rule : component.listOfProperties.rules SEPARATOR ', '»«rule.alias.typeName(target)» new«rule.name.toFirstUpper»«ENDFOR») {
				var component = CreateComponent<«typeName»>(«lookup»);
				«FOR rule : component.listOfProperties.rules»
				component.«rule.name» = new«rule.name.toFirstUpper»;
				«ENDFOR»
				ReplaceComponent(«lookup», component);
			}
		
			public void Remove«name»() {
				RemoveComponent(«lookup»);
			}
		}
		«ENDFOR»
		«ENDIF»
	'''
	
	static def contextExtension(Component component, String target, String defaultContext) '''
		«IF component.isUnique»
		«val typeName = component.componentTypeName»
		«val name = component.componentName»
		«IF component.isFlag»
		«FOR ctx : component.contextNameList(defaultContext)»
		«val propertyName = name.toFirstLower»
		«val prefix = component.propertyPrefix?.string ?: "is"»
		«val accessor = prefix + name»
		public partial class «ctx»Context {
			
			public «ctx»Entity «propertyName» { get { return GetGroup(«ctx»Matcher.«name»).GetSingleEntity(); } }
		
			public bool «accessor» {
				get { return «propertyName» != null; }
				set {
					var entity = «propertyName»;
					if(value != (entity != null)) {
						if(value) {
							CreateEntity().«accessor» = true;
						} else {
							DestroyEntity(entity);
						}
					}
				}
			}
		}
		«ENDFOR»
		«ELSE»
		«FOR ctx : component.contextNameList(defaultContext)»
		«val lowerName = name.toFirstLower»
		«val propertyName = lowerName + "Entity"»
		«val entityType = ctx + "Entity"»
		public partial class «ctx»Context {
		
			public «entityType» «propertyName» { get { return GetGroup(«ctx»Matcher.«name»).GetSingleEntity(); } }
			public I«typeName» «lowerName» { get { return «propertyName».«lowerName»; } }
			public bool has«name» { get { return «propertyName» != null; } }
		
			public «entityType» Set«name»(«FOR rule : component.listOfProperties.rules SEPARATOR ', '»«rule.alias.typeName(target)» new«rule.name.toFirstUpper»«ENDFOR») {
				if(has«name») {
					throw new EntitasException("Could not set «lowerName»!\n" + this + " already has an entity with «typeName»!",
						"You should check if the context already has a «propertyName» before setting it or use context.Replace«name»().");
				}
				var entity = CreateEntity();
				entity.Add«name»(«FOR rule : component.listOfProperties.rules SEPARATOR ', '»new«rule.name.toFirstUpper»«ENDFOR»);
				return entity;
			}
		
			public void Replace«name»(«FOR rule : component.listOfProperties.rules SEPARATOR ', '»«rule.alias.typeName(target)» new«rule.name.toFirstUpper»«ENDFOR») {
				var entity = «propertyName»;
				if(entity == null) {
					entity = Set«name»(«FOR rule : component.listOfProperties.rules SEPARATOR ', '»new«rule.name.toFirstUpper»«ENDFOR»);
				} else {
					entity.Replace«name»(«FOR rule : component.listOfProperties.rules SEPARATOR ', '»new«rule.name.toFirstUpper»«ENDFOR»);
				}
			}
		
			public void Destroy«name»() {
				«propertyName».Destroy();
			}
		}
		«ENDFOR»
		«ENDIF»
		«ENDIF»
	'''
	
	static def matcherExtension(Component component, String defaultContext)'''
		«val name = component.componentName»
		«FOR ctx : component.contextNameList(defaultContext)»
		public sealed partial class «ctx»Matcher {
		
			static IMatcher<«ctx»Entity> _matcher«name»;
		
			public static IMatcher<«ctx»Entity> «name» {
				get {
					if(_matcher«name» == null) {
						var matcher = (Matcher<«ctx»Entity>)Matcher<«ctx»Entity>.AllOf(«ctx»ComponentsLookup.«name»);
						matcher.componentNames = «ctx»ComponentsLookup.componentNames;
						_matcher«name» = matcher;
					}

					return _matcher«name»;
				}
			}
		}
		«ENDFOR»
	'''
}