package io.entitas.lang.extensions

import io.entitas.lang.dsl.TargetId

class TargetExtensions {
	static def String getPath(TargetId targetId) {
		return targetId.parameters.findFirst[it.path !== null].path
	}
}