package io.entitas.lang.extensions

import io.entitas.lang.dsl.Component

class ComponentExtensions {
	static def componentTypeName(Component component) {
		if (component.name.endsWith("Component")) {
			return component.name.toFirstUpper
		} else {
			return component.name.toFirstUpper + "Component"
		}
	}
	
	static def componentName(Component component) {
		if (component.name.endsWith("Component")) {
			return component.name.substring(0, component.name.length - 9).toFirstUpper
		} else {
			return component.name.toFirstUpper
		}
	}
	
	static def isFlag(Component component) {
		component.listOfProperties === null
	}
	
	static def isUnique(Component component) {
		component.parameters.contains("unique")
	}
	
	static def contextNameList(Component component, String defaultContext){
		if(component.scope === null){
			if(defaultContext !== null){
				return newLinkedList(defaultContext)
			}
			return newLinkedList()
		} 
		
		return component.scope.references.map[it.name]
	}
}