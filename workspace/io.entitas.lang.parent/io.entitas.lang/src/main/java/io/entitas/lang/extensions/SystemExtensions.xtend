package io.entitas.lang.extensions

import static extension io.entitas.lang.extensions.ComponentExtensions.*
import static extension io.entitas.lang.extensions.AccessRuleExtensions.*
import java.util.HashSet

class SystemExtensions {
	static def systemTypeName(io.entitas.lang.dsl.System system) {
		if (system.name.endsWith("System")) {
			return system.name.toFirstUpper
		} else {
			return system.name.toFirstUpper + "System"
		}
	}
	
	static def systemName(io.entitas.lang.dsl.System system) {
		if (system.name.endsWith("System")) {
			return system.name.substring(0, system.name.length - 6).toFirstUpper
		} else {
			return system.name.toFirstUpper
		}
	}
	
	static def isInit(io.entitas.lang.dsl.System system) {
		system.parameters.contains("init")
	}
	
	static def isExecute(io.entitas.lang.dsl.System system) {
		system.parameters.contains("no_exec") == false
	}
	
	static def isCleanup(io.entitas.lang.dsl.System system) {
		system.parameters.contains("cleanup")
	}
	
	static def isTeardown(io.entitas.lang.dsl.System system) {
		system.parameters.contains("teardown")
	}
	
	static def isExplicitContextList(io.entitas.lang.dsl.System system) {
		system.parameters.contains("explicit_context_list")
	}
	
	static def String triggerContextName(io.entitas.lang.dsl.System system, String defaultContextName) {
		if (system.scope !== null){
			return system.scope.reference.name.toFirstUpper
		}
		return system.triggerContextNameWithoutConcideringScope(defaultContextName)
	}
	
	static def String triggerContextNameWithoutConcideringScope(io.entitas.lang.dsl.System system, String defaultContextName) {
		
		if (system.triggerRules.isNullOrEmpty){
			return null
		}
		var HashSet<String> result = null 
		for(rule : system.triggerRules){
			for (component : rule.components){
				if (result === null){
					result = newHashSet(component.contextNameList(defaultContextName))
				} else {
					result.retainAll(component.contextNameList(defaultContextName))
				}
			}
		}
		if(system.matcherRules !== null) {
			for(component : system.matcherRules.allComponents){
				result.retainAll(component.contextNameList(defaultContextName))
			}
		}
		
		if (result.size != 1){
			return null
		}
		result.head
	}
	
	static def interfacesToImplement(io.entitas.lang.dsl.System system, String defaultContextName){
		var result = newArrayList()
		if (system.isReactive){
			result.add("ReactiveSystem<" + system.triggerContextName(defaultContextName) + "Entity>")
		} else {
			if (system.isExecute){
				result.add("IExecuteSystem")
			}
		}
		if (system.isInit){
			result.add("IInitializeSystem")
		}
		if (system.isCleanup){
			result.add("ICleanupSystem")
		}
		if (system.isTeardown){
			result.add("ITearDownSystem")
		}
		return result
	}
	
	static def contextNameList(io.entitas.lang.dsl.System system, String defaultContextName){
		var result = newHashSet()
		if (system.isReactive){
			result.add(system.triggerContextName(defaultContextName))
		}
		for (rule : system.accessRules){
			result.add(rule.contextName(defaultContextName))
		}
		return result.sort
	}
	
	static def abstractMethods(io.entitas.lang.dsl.System system, String defaultContextName){
		var result = newArrayList()
		if (system.isReactive){
			result.add("protected abstract override void Execute(System.Collections.Generic.List<" + system.triggerContextName(defaultContextName) + "Entity> entities);")
			if(system.noFilter == false && system.matcherRules === null){
				result.add("protected abstract override bool Filter(" + system.triggerContextName(defaultContextName) + "Entity entity);")
			}
		} else {
			if (system.isExecute){
				result.add("public abstract void Execute();")
			}
		}
		if (system.isInit){
			result.add("public abstract void Initialize();")
		}
		if (system.isCleanup){
			result.add("public abstract void Cleanup();")
		}
		if (system.isTeardown){
			result.add("public abstract void TearDown();")
		}
		return result
	}
}