SYNTAXDEF clt
FOR <http://www.conper.de/classification> 
START ClassificationModel

OPTIONS {
	reloadGeneratorModel = "true";
    additionalDependencies = "org.featuremapper.models.feature, org.feature.multi.perspective.model, org.feature.model.utilities";
	generateCodeFromGeneratorModel = "true";
	overrideLaunchConfigurationDelegate = "false";
	overrideManifest = "false";
	overridePluginXML = "false";
	overrideBuilder = "false";

 	srcFolder = "src/main/java";
	srcGenFolder = "src/gen/java";

	uiSrcFolder = "src/main/java";
	uiSrcGenFolder = "src/gen/java";
}

RULES {
	// syntax definition for class 'ClassificationModel'
	ClassificationModel   ::= "classification" !0    
							  "references" #1 (("mapping" #1 viewMapping['<','>']) | ("featuremodel" #1 featureModel['<','>']) )+ !0!0
							  classifications*;

	// syntax definition for class 'Classification'
	Classification ::=  ("stage" #1 id['<','>'] #1 "on" "view" #1 viewgroup['"','"'] #1 ":" !0)
						 classifiedFeatures* 
						 (#3 "autocomplete" #1 "{" !1 autoCompleteFeatures* #3 "}")? !0 ; 

	// syntax definition for class 'ClassifiedFeature'
	ClassifiedFeature ::= (#3 "feature" #1 feature['"','"'] #1 classified[Unclassified : "", Unbound: "unbound", Dead: "dead", Alive: "alive"]) !0;
}