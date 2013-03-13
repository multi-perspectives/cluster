SYNTAXDEF csl
FOR <http://www.conper.de/constraint>
START Constraint

OPTIONS {
	reloadGeneratorModel = "true";
    additionalDependencies = "org.featuremapper.models.feature";
	generateCodeFromGeneratorModel = "true";
	overrideLaunchConfigurationDelegate = "false";
	overrideBuilder = "false";

	overrideManifest = "false";
	overridePluginXML = "false";
	
	overrideUIManifest ="false";
	overrideUIPluginXML = "false";
	

 	srcFolder = "src/main/java";
	srcGenFolder = "src/gen/java";

	uiSrcFolder = "src/main/java";
	uiSrcGenFolder = "src/gen/java";
}

RULES {
	// syntax definition for class 'Constraint'
	  Constraint ::= expression ;
	
	Require ::= leftFeature['\'','\''] #1 "requires" #1 rightFeature['"','"'];
	Exclude ::= leftFeature['"','"'] #1 "excludes" #1 rightFeature['"','"'];
}