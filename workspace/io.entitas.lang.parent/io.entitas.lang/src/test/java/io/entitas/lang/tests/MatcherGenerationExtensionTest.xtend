package io.entitas.lang.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import io.entitas.lang.dsl.Root
import io.entitas.lang.generator.entitas_csharp.MatcherGenerationExtension

@RunWith(XtextRunner)
@InjectWith(DSLInjectorProvider)
class MatcherGenerationExtensionTest {
	@Inject
	ParseHelper<Root> parseHelper
	
	@Test
	def void matchersClass() {
		val result = parseHelper.parse('''
			target A
			context Core, Input, Map
		''')
		
		Assert.assertEquals('''
			public sealed partial class CoreMatcher  {
				public static Entitas.IAllOfMatcher<CoreEntity> AllOf(params int[] indices) {
					return Entitas.Matcher<CoreEntity>.AllOf(indices);
				}
				
				public static Entitas.IAllOfMatcher<CoreEntity> AllOf(params Entitas.IMatcher<CoreEntity>[] matchers) {
					return Entitas.Matcher<CoreEntity>.AllOf(matchers);
				}
				
				public static Entitas.IAnyOfMatcher<CoreEntity> AnyOf(params Entitas.IMatcher<CoreEntity>[] matchers) {
					return Entitas.Matcher<CoreEntity>.AnyOf(matchers);
				}
			}
			public sealed partial class InputMatcher  {
				public static Entitas.IAllOfMatcher<InputEntity> AllOf(params int[] indices) {
					return Entitas.Matcher<InputEntity>.AllOf(indices);
				}
				
				public static Entitas.IAllOfMatcher<InputEntity> AllOf(params Entitas.IMatcher<InputEntity>[] matchers) {
					return Entitas.Matcher<InputEntity>.AllOf(matchers);
				}
				
				public static Entitas.IAnyOfMatcher<InputEntity> AnyOf(params Entitas.IMatcher<InputEntity>[] matchers) {
					return Entitas.Matcher<InputEntity>.AnyOf(matchers);
				}
			}
			public sealed partial class MapMatcher  {
				public static Entitas.IAllOfMatcher<MapEntity> AllOf(params int[] indices) {
					return Entitas.Matcher<MapEntity>.AllOf(indices);
				}
				
				public static Entitas.IAllOfMatcher<MapEntity> AllOf(params Entitas.IMatcher<MapEntity>[] matchers) {
					return Entitas.Matcher<MapEntity>.AllOf(matchers);
				}
				
				public static Entitas.IAnyOfMatcher<MapEntity> AnyOf(params Entitas.IMatcher<MapEntity>[] matchers) {
					return Entitas.Matcher<MapEntity>.AnyOf(matchers);
				}
			}
			'''.toString,
			MatcherGenerationExtension.matchersClass(result.context).toString)
		
		
	}
}
