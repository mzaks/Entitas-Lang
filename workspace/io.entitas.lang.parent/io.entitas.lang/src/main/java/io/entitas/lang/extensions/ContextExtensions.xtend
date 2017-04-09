package io.entitas.lang.extensions

import io.entitas.lang.dsl.Context
import io.entitas.lang.dsl.ContextId

class ContextExtensions {
	
	static def defaultContextName(Context ctx){
		return ctx.defaultContextNameOrNull ?: ctx.ids.get(0).name
	}
	
	static def defaultContextNameOrNull(Context ctx){
		return ctx.ids.findFirst[it.isDefault()]?.name
	}
	
	static def isDefault(ContextId ctx) {
		ctx.parameters.contains("default")
	}
	
}