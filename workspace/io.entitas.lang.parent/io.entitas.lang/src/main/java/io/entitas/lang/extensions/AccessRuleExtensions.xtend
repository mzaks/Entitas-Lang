package io.entitas.lang.extensions

import io.entitas.lang.dsl.AccessRule
import java.util.HashSet

import static extension io.entitas.lang.extensions.ComponentExtensions.*

class AccessRuleExtensions {
	public static def contextName(AccessRule rule, String defaultContext){
		if (rule.scope !== null) {
			return rule.scope.reference.name
		}
		if (rule.contextRef !== null){
			return rule.contextRef.name
		}
		var HashSet<String> result = null
		val components = newArrayList()
		for (comp : rule.matcherRule.allComponents){
			components.add(comp)
		}
		for (comp : rule.matcherRule.anyComponents){
			components.add(comp)
		}
		for (comp : rule.matcherRule.noneComponents){
			components.add(comp)
		}
		for (comp : components) {
			if(result === null) {
				result = newHashSet(comp.contextNameList(defaultContext))
			} else {
				result.retainAll(comp.contextNameList(defaultContext))
			}
		}
		if (result.size != 1){
			return null
		}
		return result.head
	}
}