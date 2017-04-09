package io.entitas.lang.generator.entitas_csharp

import java.util.List
import io.entitas.lang.dsl.Root
import static extension io.entitas.lang.extensions.ComponentExtensions.*
import com.google.common.collect.ArrayListMultimap

class GenerationExtension {
	static def wrapWithNamespace(CharSequence code, String namespace)'''
		«IF namespace !== null»
		namespace «namespace» {
			«code»
		}
		«ELSE»
		«code»
		«ENDIF»
	'''
	
	static def addEntitasUsing(CharSequence code)'''
		using Entitas;
		
		«code»
	'''
	
	static def componentLookup(List<Root> roots, String defaultCtx)'''
		«val contextComponentMap = roots.computeContextComponentMap(defaultCtx)»
		«FOR ctx : contextComponentMap.keySet.sort»
		«val componentList = contextComponentMap.get(ctx).sortBy[it.componentName]»
		public static class «ctx»ComponentsLookup {
			«FOR component : componentList.indexed»
			public const int «component.value.componentName» = «component.key»;
			«ENDFOR»
		
			public const int TotalComponents = «componentList.size»;
		
			public static readonly string[] componentNames = {
				«FOR component : componentList SEPARATOR ', '»"«component.componentName»"«ENDFOR»«»
			};
		
			public static readonly System.Type[] componentTypes = {
				«FOR component : componentList SEPARATOR ', '»typeof(«component.componentTypeName»)«ENDFOR»«»
			};
		}
		«ENDFOR»
	'''
	
	static def computeContextComponentMap(List<Root> roots, String defaultCtx){
		val result = ArrayListMultimap.create
		for (root : roots){
			for (component : root.components){
				for (ctx : component.contextNameList(defaultCtx)){
					result.put(ctx, component);
				}
			}
		}
		return result.asMap
	}
}