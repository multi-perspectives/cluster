SYNTAXDEF mtext
FOR <http://www.tudresden.de/viewmapping> <optional/path/to/myLanguage.genmodel>
START MappingModel

OPTIONS {
	additionalDependencies = "org.featuremapper.models.feature";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	overrideLaunchConfigurationDelegate = "false";
	
 	srcFolder = "src/main/java";
	srcGenFolder = "src/gen/java";
	
	uiSrcFolder = "src/main/java";
	uiSrcGenFolder = "src/gen/java";
}

RULES {
	// syntax definition for class 'MappingModel'
	MappingModel   ::= 	"viewmapping" !0
						#4 ("featuremodel" #1 featureModel['<','>']) !0
						#4 ("viewmodel" #1 viewModel['<','>']) !0
						(mappings*);
	
	// syntax definition for class 'AnotherMetaClass'
	Mapping ::= "view group" #1 viewgroup['"','"'] #1 "contains" !0
				#4 (features['"','"'])+; 
				
}