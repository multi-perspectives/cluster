SYNTAXDEF clt
FOR <http://www.conper.de/classification> 
START ClassificationModel

OPTIONS {
	reloadGeneratorModel = "true";
    additionalDependencies = "org.featuremapper.models.feature, org.feature.multi.perspective.model, org.feature.model.utilities";
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

TOKENS {
	DEFINE COMMA $(','|';')$;
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
}

TOKENSTYLES {
	"COMMENT" COLOR #AAAAAA;
}	

RULES {
	// syntax definition for class 'ClassificationModel'
	@SuppressWarnings(explicitSyntaxChoice) 
	ClassificationModel   ::= "classification" !0    
							  "references" #1 (("mapping" #1 viewMapping['<','>']) | ("featuremodel" #1 featureModel['<','>']) ) !0!0
							  classifications*;

	// syntax definition for class 'Classification'
	@SuppressWarnings(explicitSyntaxChoice) 
	Classification ::=  "stage" #1 id['<','>'] #1 "on" 
						(("views" (#1 viewgroups['"','"'] (_[COMMA] #1 viewgroups['"','"'])*)? #1 ) |
						("stages" (#1 compose['"','"'] (_[COMMA] #1 compose['"','"'])*)? #1 ))?
						 ":" !0 classifiedFeatures* 
						 ("afeatures" aliveFeatures[] | "dfeatures" deadFeatures[] | "ufeatures" unboundFeatures[])* 
						 (#3 "autocomplete" #1 "{" !0 autoCompleteFeatures autoCompleteFeatures* #3 "}")? !0 ; 

	// syntax definition for class 'ClassifiedFeature'
	ClassifiedFeature ::= (#3 "feature" #1 feature['"','"'] #1 classified[Unclassified : "", Unbound: "unbound", Dead: "dead", Alive: "alive"]) !0;
}