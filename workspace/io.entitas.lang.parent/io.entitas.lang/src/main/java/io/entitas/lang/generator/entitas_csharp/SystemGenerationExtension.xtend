package io.entitas.lang.generator.entitas_csharp

import static extension io.entitas.lang.extensions.SystemExtensions.*
import static extension io.entitas.lang.extensions.ComponentExtensions.*
import static extension io.entitas.lang.extensions.AccessRuleExtensions.*
import io.entitas.lang.dsl.MatcherRule
import io.entitas.lang.dsl.TriggerRule
import io.entitas.lang.dsl.AccessRule

class SystemGenerationExtension {
	public static def abstractSystemClass(io.entitas.lang.dsl.System system, String defaultContextName)'''
		«val triggerContext = system.triggerContextName(defaultContextName)»
		public abstract class Abstract«system.systemTypeName» : «FOR interfaceName : system.interfacesToImplement(defaultContextName) SEPARATOR ', '»«interfaceName»«ENDFOR»{
			«FOR rule : system.accessRules»
			«rule.accessStatememnt(defaultContextName)»
			«ENDFOR»
		
			«IF system.isExplicitContextList»
			protected Abstract«system.systemTypeName»(«FOR ctxName : system.contextNameList(defaultContextName) SEPARATOR ', '»«ctxName»Context «ctxName.toFirstLower»«ENDFOR»)«IF system.isReactive» : base(«triggerContext.toFirstLower»)«ENDIF» {
				«FOR rule : system.accessRules»
				«rule.assignmentStatememntForExplicitContextList(defaultContextName)»
				«ENDFOR»
			}
			«ELSE»
			protected Abstract«system.systemTypeName»(Contexts contexts)«IF system.isReactive» : base(contexts.«triggerContext.toFirstLower»)«ENDIF» {
				«FOR rule : system.accessRules»
				«rule.assignmentStatememnt(defaultContextName)»
				«ENDFOR»
			}
			«ENDIF»
			«IF system.isReactive»
			protected override Collector<«triggerContext»Entity> GetTrigger(IContext<«triggerContext»Entity> context) {
				«IF system.triggerRules.size == 1»
				«val pair = system.triggerRules.get(0).parameterExpression(triggerContext)»
				return context.CreateCollector(«pair.key», «pair.value»);
				«ELSE»
				«val pairs = system.triggerRules.map[it.parameterExpression(triggerContext)]»
				return new Collector<«triggerContext»Entity>(
							new [] {
								«FOR pair : pairs SEPARATOR ', '»
								context.GetGroup(«pair.key»)
								«ENDFOR»
							},
							new [] {
								«FOR pair : pairs SEPARATOR ', '»
								«pair.value»
								«ENDFOR»
							}
						);
				«ENDIF»
			}
			«IF system.noFilter»
			protected override bool Filter(«triggerContext»Entity entity) {
				return true;
			}
			«ENDIF»
			«IF system.matcherRules !== null»
			readonly IMatcher<«triggerContext»Entity> filterMatcher = «system.matcherRules.matcherExpression(triggerContext)»;
			protected override bool Filter(«triggerContext»Entity entity) {
				return filterMatcher.Matches(entity);
			}
			«ENDIF»
			«ENDIF»
			«FOR method : system.abstractMethods(defaultContextName)»
			«method»
			«ENDFOR»
		}
	'''
	
	private static def parameterExpression(TriggerRule rule, String contextName){
		val matcher =  if(rule.components.size == 1){
			contextName + "Matcher." + rule.components.head.componentName
		} else {
			'''Matcher<«contextName»Entity>.AllOf(«FOR comp : rule.components SEPARATOR ', '»«contextName»Matcher.«comp.componentName»«ENDFOR»)'''.toString
		}
		val event = if(rule.isAdded){
			"GroupEvent.Added"
		} else if(rule.isRemoved){
			"GroupEvent.Removed"
		} else {
			"GroupEvent.AddedOrRemoved"
		}
		return new Pair(matcher, event)
	}
	
	private static def matcherExpression(MatcherRule rule, String contextName){
		if (rule.allComponents.size == 1 && rule.anyComponents.size == 0 && rule.noneComponents.size == 0){
			return contextName + "Matcher." + rule.allComponents.head.componentName
		}
		
		if (rule.anyComponents.size == 1 && rule.allComponents.size == 0 && rule.noneComponents.size == 0){
			return contextName + "Matcher." + rule.anyComponents.head.componentName
		}
		if (rule.allComponents.size > 0){
			val code = '''
				Matcher<«contextName»Entity>.AllOf(«FOR comp : rule.allComponents SEPARATOR ', '»«contextName»Matcher.«comp.componentName»«ENDFOR»)
					«IF rule.anyComponents.isNullOrEmpty == false».AnyOf(«FOR comp : rule.anyComponents SEPARATOR ', '»«contextName»Matcher.«comp.componentName»«ENDFOR»)«ENDIF»
					«IF rule.noneComponents.isNullOrEmpty == false».NoneOf(«FOR comp : rule.noneComponents SEPARATOR ', '»«contextName»Matcher.«comp.componentName»«ENDFOR»)«ENDIF»
			'''
			return code.toString
		}
		if (rule.anyComponents.size > 0){
			val code = '''
				Matcher<«contextName»Entity>.AnyOf(«FOR comp : rule.anyComponents SEPARATOR ', '»«contextName»Matcher.«comp.componentName»«ENDFOR»)
						«IF rule.noneComponents.isNullOrEmpty == false».NoneOf(«FOR comp : rule.noneComponents SEPARATOR ', '»«contextName»Matcher.«comp.componentName»«ENDFOR»)«ENDIF»
			'''
			return code.toString
		}
	}
	
	private static def accessStatememnt(AccessRule rule, String defaultContext){
		if (rule.contextRef !== null){
			return '''protected readonly «rule.contextRef.name.toFirstUpper»Context «rule.name»;'''
		}
		if (rule.matcherRule !== null){
			val context = rule.contextName(defaultContext)
			return '''protected readonly IGroup<«context»Entity> «rule.name»;'''
		}
	}
	
	private static def assignmentStatememnt(AccessRule rule, String defaultContext){
		if (rule.contextRef !== null){
			return '''«rule.name» = contexts.«rule.contextRef.name.toFirstLower»;'''
		} else if (rule.matcherRule !== null){
			val context = rule.contextName(defaultContext)
			return '''«rule.name» = contexts.«context.toFirstLower».GetGroup(«rule.matcherRule.matcherExpression(context)»);'''
		}
	}
	
	private static def assignmentStatememntForExplicitContextList(AccessRule rule, String defaultContext){
		if (rule.contextRef !== null){
			return '''this.«rule.name» = «rule.contextRef.name.toFirstLower»;'''
		} else if (rule.matcherRule !== null){
			val context = rule.contextName(defaultContext)
			return '''this.«rule.name» = «context.toFirstLower».GetGroup(«rule.matcherRule.matcherExpression(context)»);'''
		}
	}
}