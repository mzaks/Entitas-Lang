package io.entitas.lang.generator.entitas_csharp

import io.entitas.lang.dsl.Context

class ContextGenerationExtension {
	static def entityClassDefinitions(Context ctx)'''
	«FOR id : ctx.ids»
	public sealed partial class «id.name»Entity : Entity {}
	«ENDFOR»
	'''
	
	static def contextClassDefinitions(Context ctx)'''
	«FOR id : ctx.ids»
	public sealed partial class «id.name»Context : Context<«id.name»Entity> {
	
		public «id.name»Context() : base(
			«id.name»ComponentsLookup.TotalComponents,
			0,
			new ContextInfo(
				"«id.name» Context",
				«id.name»ComponentsLookup.componentNames,
				«id.name»ComponentsLookup.componentTypes
			),
			(entity) =>

			#if (ENTITAS_FAST_AND_UNSAFE)
				new Entitas.UnsafeAERC()
			#else
				new Entitas.SafeAERC(entity)
			#endif
		) {}
	}
	«ENDFOR»
	'''
	
	static def contextsHelperClassDefinition(Context ctx)'''
	public partial class Contexts : IContexts {
	
		public static Contexts sharedInstance {
			get {
				if(_sharedInstance == null) {
					_sharedInstance = new Contexts();
				}
	
				return _sharedInstance;
			}
			set { _sharedInstance = value; }
		}
	
		static Contexts _sharedInstance;
	
	
		«FOR id : ctx.ids»
		public «id.name»Context «id.name.toFirstLower» { get; set; }
		«ENDFOR»
	
		public IContext[] allContexts { get { return new IContext [] { «FOR id : ctx.ids SEPARATOR ', '»«id.name.toFirstLower»«ENDFOR» }; } }
	
	
		public Contexts() {
			
			«FOR id : ctx.ids»
			«id.name.toFirstLower» = new «id.name.toFirstUpper»Context();
			«ENDFOR»
	
			var postConstructors = System.Linq.Enumerable.Where(
				GetType().GetMethods(),
				method => System.Attribute.IsDefined(method, typeof(Entitas.CodeGeneration.Attributes.PostConstructorAttribute))
			);
	
			foreach (var postConstructor in postConstructors) {
				postConstructor.Invoke(this, null);
			}
		}
		
		public void Reset() {
			var contexts = allContexts;
			for (int i = 0; i < contexts.Length; i++) {
				contexts[i].Reset();
			}
		}
		    
	}
	    
	public partial class Contexts {
	
	#if (!ENTITAS_DISABLE_VISUAL_DEBUGGING && UNITY_EDITOR)
	
		[Entitas.CodeGeneration.Attributes.PostConstructor]
		public void InitializeContexObservers() {
			try {
				«FOR id : ctx.ids»
				CreateContextObserver(«id.name.toFirstLower»);
				«ENDFOR»
			} catch(System.Exception) {
			}
		}
	
		public void CreateContextObserver(Entitas.IContext context) {
			if (UnityEngine.Application.isPlaying) {
				var observer = new Entitas.VisualDebugging.Unity.ContextObserver(context);
				UnityEngine.Object.DontDestroyOnLoad(observer.gameObject);
			}
		}
	
	#endif
	}
	
	'''
}