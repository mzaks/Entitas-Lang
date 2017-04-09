package io.entitas.lang.extensions

import io.entitas.lang.dsl.Alias

class AliasExtensions {
	static def typeName(Alias alias) {
		if (alias.singleAlias !== null){
			return alias.singleAlias.typeAlias
		}
	}
	
	static def typeName(Alias alias, String targetName) {
		if (alias.singleAlias !== null){
			return alias.singleAlias.typeAlias
		}
		for(rule : alias.listOfAliases.rules){
			if(rule.target.name == targetName){
				return rule.typeAlias
			}
		}
	}
}