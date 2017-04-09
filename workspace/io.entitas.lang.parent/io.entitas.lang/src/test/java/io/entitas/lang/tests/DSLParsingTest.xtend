/*
 * generated by Xtext 2.11.0
 */
package io.entitas.lang.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import io.entitas.lang.dsl.Root
import org.junit.Ignore

@RunWith(XtextRunner)
@InjectWith(DSLInjectorProvider)
class DSLParsingTest {
	@Inject
	ParseHelper<Root> parseHelper
	
	@Test
	def void parseTargetWithoutVersion() {
		val result = parseHelper.parse('''
			target entitas_csharp
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		val target1 = result.target.ids.get(0)
		Assert.assertEquals("entitas_csharp", target1.name)
		Assert.assertNull(target1.version)
	}
	
	@Test
	def void parseTargetWithVersion() {
		val result = parseHelper.parse('''
			target entitas_csharp 0.37.0
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		val target1 = result.target.ids.get(0)
		Assert.assertEquals("entitas_csharp", target1.name)
		Assert.assertEquals(0, target1.version.major)
		Assert.assertEquals(37, target1.version.minor)
		Assert.assertEquals(0, target1.version.patch)
	}
	
	@Test
	def void parseTargetWithVersionPart() {
		val result = parseHelper.parse('''
			target entitas_csharp 0.37
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		val target1 = result.target.ids.get(0)
		Assert.assertEquals("entitas_csharp", target1.name)
		Assert.assertEquals(0, target1.version.major)
		Assert.assertEquals(37, target1.version.minor)
		Assert.assertEquals(0, target1.version.patch)
	}
	
	@Test
	def void parseTargetWithShortVersion() {
		val result = parseHelper.parse('''
			target entitas_csharp 37
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		val target1 = result.target.ids.get(0)
		Assert.assertEquals("entitas_csharp", target1.name)
		Assert.assertEquals(37, target1.version.major)
		Assert.assertEquals(0, target1.version.minor)
		Assert.assertEquals(0, target1.version.patch)
	}
	
	@Test
	def void parseMultipleTargetsWithoutVersion() {
		val result = parseHelper.parse('''
			target entitas_csharp, json
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		val target1 = result.target.ids.get(0)
		Assert.assertEquals("entitas_csharp", target1.name)
		Assert.assertNull(target1.version)
		
		val target2 = result.target.ids.get(1)
		Assert.assertEquals("json", target2.name)
		Assert.assertNull(target1.version)
	}
	
	@Test
	def void parseMultipleTargetsWithShortVersion() {
		val result = parseHelper.parse('''
			target entitas_csharp 37, json 1
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		val target1 = result.target.ids.get(0)
		Assert.assertEquals("entitas_csharp", target1.name)
		Assert.assertEquals(37, target1.version.major)
		Assert.assertEquals(0, target1.version.minor)
		Assert.assertEquals(0, target1.version.patch)
		
		val target2 = result.target.ids.get(1)
		Assert.assertEquals("json", target2.name)
		Assert.assertEquals(1, target2.version.major)
		Assert.assertEquals(0, target2.version.minor)
		Assert.assertEquals(0, target2.version.patch)
	}
	
	@Test
	def void parseNamespace() {
		val result = parseHelper.parse('''
			namespace MyGame
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals("MyGame", result.namespace.name)
	}
	
	@Test
	def void parseContext() {
		val result = parseHelper.parse('''
			context Core, Meta, Input
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals(3, result.context.ids.length)
		val ctx1 = result.context.ids.get(0)
		Assert.assertEquals("Core", ctx1.name)
		val ctx2 = result.context.ids.get(1)
		Assert.assertEquals("Meta", ctx2.name)
		val ctx3 = result.context.ids.get(2)
		Assert.assertEquals("Input", ctx3.name)
	}
	
	@Test
	def void parseContextWithParameter() {
		val result = parseHelper.parse('''
			context Core(default), Meta, Input
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals(3, result.context.ids.length)
		val ctx1 = result.context.ids.get(0)
		Assert.assertEquals("Core", ctx1.name)
		Assert.assertEquals(1, ctx1.parameters.length)
		Assert.assertEquals("default", ctx1.parameters.get(0))
		val ctx2 = result.context.ids.get(1)
		Assert.assertEquals("Meta", ctx2.name)
		val ctx3 = result.context.ids.get(2)
		Assert.assertEquals("Input", ctx3.name)
	}
	
	@Test
	def void parseAlias() {
		val result = parseHelper.parse('''
			target A
			alias i32 : "int"
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals(1, result.typeAliases.length)
		val alias1 = result.typeAliases.get(0)
		Assert.assertEquals("i32", alias1.name)
		Assert.assertEquals("int", alias1.singleAlias.typeAlias)
	}
	
	@Test
	def void parseAliasWithTarget() {
		val result = parseHelper.parse('''
			target A
			alias i32 
				A : "int"
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals(1, result.typeAliases.length)
		val alias1 = result.typeAliases.get(0)
		Assert.assertEquals("i32", alias1.name)
		Assert.assertEquals("int", alias1.listOfAliases.rules.get(0).typeAlias)
	}
	
	@Test
	def void parseAliasWithMultipleTargets() {
		val result = parseHelper.parse('''
			target A, B
			alias i32
				A : "int"
				B : "Integer"
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals(1, result.typeAliases.length)
		val alias1 = result.typeAliases.get(0)
		Assert.assertEquals("i32", alias1.name)
		Assert.assertEquals("int", alias1.listOfAliases.rules.get(0).typeAlias)
		Assert.assertEquals("A", alias1.listOfAliases.rules.get(0).target.name)
		Assert.assertEquals("Integer", alias1.listOfAliases.rules.get(1).typeAlias)
		Assert.assertEquals("B", alias1.listOfAliases.rules.get(1).target.name)
	}
	
	@Test
	def void parseFlagComponent() {
		val result = parseHelper.parse('''
			target A
			context Core
			comp Finished in Core
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		
		Assert.assertEquals("Finished", result.components.get(0).name)
		Assert.assertEquals("Core", result.components.get(0).scope.references.get(0).name)
		Assert.assertEquals(0, result.components.get(0).parameters.length)
		Assert.assertNull(result.components.get(0).listOfProperties)
		Assert.assertNull(result.components.get(0).propertyPrefix)
	}
	
	@Test
	def void parseFlagWithCustomPrefixComponent() {
		val result = parseHelper.parse('''
			target A
			context Core
			comp Finished in Core 
				prefix("has")
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals("has", result.components.get(0).propertyPrefix.string)
	}
	
	@Test
	def void parseUniqueFlagComponent() {
		val result = parseHelper.parse('''
			target A
			context Core
			comp Finished(unique) in Core
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals("unique", result.components.get(0).parameters.get(0))
	}
	
	@Test
	def void parseSingleValueComponent() {
		val result = parseHelper.parse('''
			target A
			context Core
			alias i32 : "int"
			comp Health in Core 
				value : i32
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals("value", result.components.get(0).listOfProperties.rules.get(0).name)
		Assert.assertEquals("i32", result.components.get(0).listOfProperties.rules.get(0).alias.name)
	}
	
	@Test
	def void parseMultipleValuesComponent() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		Assert.assertEquals("x", result.components.get(0).listOfProperties.rules.get(0).name)
		Assert.assertEquals("i32", result.components.get(0).listOfProperties.rules.get(0).alias.name)
		Assert.assertEquals("y", result.components.get(0).listOfProperties.rules.get(1).name)
		Assert.assertEquals("i32", result.components.get(0).listOfProperties.rules.get(1).alias.name)
		
		Assert.assertEquals("Core", result.components.get(0).scope.references.get(0).name)
		Assert.assertEquals("Map", result.components.get(0).scope.references.get(1).name)
	}
	
	@Test
	def void parseSimpleExecuteSystem() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys Move
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		
	}
	
	@Test
	def void parseExecuteSystemWithParameters() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys MoveSystem (init, cleanup, teardown)
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		
	}
	
	@Test
	def void parseReactiveSystem() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys DestroySystem
				trigger :
					removed(Health), added(Destroy)
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		
	}
	
	@Test
	def void parseReactiveSystemMultipleComponentsIOneRule() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys DestroySystem
				trigger :
					removed(Health, Position), added(Destroy, Health)
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
		
	}
	
	@Test
	def void parseReactiveSystemNoFilter() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys DestroySystem
				trigger :
					removed(Health), added(Destroy)
					noFilter
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
	
	@Test
	def void parseReactiveSystemWithFilter() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys DestroySystem
				trigger :
					removed(Health), added(Destroy)
					filter anyOf(Destroy, Position) noneOf(Health)
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
	
	@Test
	def void parseReactiveSystemSpecialisedContext() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys DestroySystem
				trigger in Core:
					added(Position)
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
	
	@Test
	def void parseSystemWithQueries() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys MoveSystem
				access :
					movable : allOf(Position, Health)
					destroyed : allOf(Destroyed) noneOf(Health)
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
	
	@Test
	def void parseReactiveSystemWithQuery() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys MoveSystem
				trigger :
					added(Position, Health)
				access :
					destroyed : allOf(Destroyed) noneOf(Health)
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
	
	@Test
	def void parseReactiveSystemWithQueryAndExplicitContext() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys MoveSystem
				trigger :
					added(Position, Health)
				access :
					destroyed : allOf(Position) in Map
		''')
		Assert.assertNotNull(result)
		print(result.eResource.errors)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
	
	@Test
	@Ignore
	def void parseReactiveSystemWithComponentRefQueryAndExplicitContext() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys MoveSystem
				trigger :
					added(Position, Health)
				access :
					destroyed : Position in Map
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
	
	@Test
	def void parseReactiveSystemWithComponentRefQueryExplicitContextAndInject() {
		val result = parseHelper.parse('''
			target A
			context Core, Map
			alias i32 : "int"
			comp Position in Core, Map
				x : i32
				y : i32
			comp Health
				value : i32
			comp Destroyed
			sys MoveSystem
				trigger :
					added(Position, Health)
				access :
					coreCtx : Core
					mapCtx : Map
		''')
		Assert.assertNotNull(result)
		Assert.assertTrue(result.eResource.errors.isEmpty)
	}
}