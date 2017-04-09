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
			)
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
	
		public static void CreateContextObserver(IContext context) {
	#if(!ENTITAS_DISABLE_VISUAL_DEBUGGING && UNITY_EDITOR)
			if(UnityEngine.Application.isPlaying) {
				var observer = new Entitas.Unity.VisualDebugging.ContextObserver(context);
				UnityEngine.Object.DontDestroyOnLoad(observer.gameObject);
			}
	#endif
		}
		«FOR id : ctx.ids»
		public «id.name»Context «id.name.toFirstLower» { get; set; }
		«ENDFOR»
	
		public IContext[] allContexts { get { return new IContext [] { «FOR id : ctx.ids SEPARATOR ', '»«id.name.toFirstLower»«ENDFOR» }; } }
	
		public virtual void SetAllContexts() {
			«FOR id : ctx.ids»
			«id.name.toFirstLower» = new «id.name»Context();
			«ENDFOR»
			
			«FOR id : ctx.ids»
			CreateContextObserver(«id.name.toFirstLower»);
			«ENDFOR»
		}
	}
	'''
}