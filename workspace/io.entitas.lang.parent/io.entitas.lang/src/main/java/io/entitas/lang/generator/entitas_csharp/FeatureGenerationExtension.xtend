package io.entitas.lang.generator.entitas_csharp

class FeatureGenerationExtension {
	static def featureClass()'''
	#if (!ENTITAS_DISABLE_VISUAL_DEBUGGING && UNITY_EDITOR)
	
	public class Feature : Entitas.VisualDebugging.Unity.DebugSystems {
	
		public Feature(string name) : base(name) {
		}
	
		public Feature() : base(true) {
			var typeName = DesperateDevs.Utils.SerializationTypeExtension.ToCompilableString(GetType());
	        var shortType = DesperateDevs.Utils.SerializationTypeExtension.ShortTypeName(typeName);
	        var readableType = DesperateDevs.Utils.StringExtension.ToSpacedCamelCase(shortType);
	
			initialize(readableType);
		}
	}
	
	#else
	
	public class Feature : Entitas.Systems {
	
		public Feature(string name) {
		}
	
		public Feature() {
		}
	}
	
	#endif
		
	'''
}