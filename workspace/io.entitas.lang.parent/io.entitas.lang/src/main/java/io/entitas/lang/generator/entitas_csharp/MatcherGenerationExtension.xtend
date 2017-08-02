package io.entitas.lang.generator.entitas_csharp

import io.entitas.lang.dsl.Context

class MatcherGenerationExtension {
	static def matchersClass(Context ctx)'''
	«FOR id : ctx.ids»
	public sealed partial class «id.name»Matcher  {
		public static Entitas.IAllOfMatcher<«id.name»Entity> AllOf(params int[] indices) {
			return Entitas.Matcher<«id.name»Entity>.AllOf(indices);
		}
		
		public static Entitas.IAllOfMatcher<«id.name»Entity> AllOf(params Entitas.IMatcher<«id.name»Entity>[] matchers) {
			return Entitas.Matcher<«id.name»Entity>.AllOf(matchers);
		}
		
		public static Entitas.IAnyOfMatcher<«id.name»Entity> AnyOf(params Entitas.IMatcher<«id.name»Entity>[] matchers) {
			return Entitas.Matcher<«id.name»Entity>.AnyOf(matchers);
		}
	}
	«ENDFOR»
	'''
}	
