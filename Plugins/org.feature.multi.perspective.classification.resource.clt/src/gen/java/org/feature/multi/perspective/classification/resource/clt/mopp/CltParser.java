// $ANTLR 3.4

	package org.feature.multi.perspective.classification.resource.clt.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CltParser extends CltANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMA", "COMMENT", "LINEBREAK", "QUOTED_34_34", "QUOTED_60_62", "TEXT", "WHITESPACE", "':'", "'afeatures'", "'alive'", "'autocomplete'", "'classification'", "'dead'", "'dfeatures'", "'feature'", "'featuremodel'", "'mapping'", "'on'", "'references'", "'stage'", "'stages'", "'ufeatures'", "'unbound'", "'views'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int COMMA=4;
    public static final int COMMENT=5;
    public static final int LINEBREAK=6;
    public static final int QUOTED_34_34=7;
    public static final int QUOTED_60_62=8;
    public static final int TEXT=9;
    public static final int WHITESPACE=10;

    // delegates
    public CltANTLRParserBase[] getDelegates() {
        return new CltANTLRParserBase[] {};
    }

    // delegators


    public CltParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CltParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(21 + 1);
         

    }

    public String[] getTokenNames() { return CltParser.tokenNames; }
    public String getGrammarFileName() { return "Clt.g"; }


    	private org.feature.multi.perspective.classification.resource.clt.ICltTokenResolverFactory tokenResolverFactory = new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenResolverFactory();
    	
    	/**
    	 * the index of the last token that was handled by collectHiddenTokens()
    	 */
    	private int lastPosition;
    	
    	/**
    	 * A flag that indicates whether the parser should remember all expected elements.
    	 * This flag is set to true when using the parse for code completion. Otherwise it
    	 * is set to false.
    	 */
    	private boolean rememberExpectedElements = false;
    	
    	private Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	
    	/**
    	 * A list of expected elements the were collected while parsing the input stream.
    	 * This list is only filled if <code>rememberExpectedElements</code> is set to
    	 * true.
    	 */
    	private java.util.List<org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal> expectedElements = new java.util.ArrayList<org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
    	
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private int tokenIndexOfLastCompleteElement;
    	
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	/**
    	 * The offset indicating the cursor position when the parser is used for code
    	 * completion by calling parseToExpectedElements().
    	 */
    	private int cursorOffset;
    	
    	/**
    	 * The offset of the first hidden token of the last expected element. This offset
    	 * is used to discard expected elements, which are not needed for code completion.
    	 */
    	private int lastStartIncludingHidden;
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>() {
    			public boolean execute(org.feature.multi.perspective.classification.resource.clt.ICltTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.feature.multi.perspective.classification.resource.clt.ICltProblem() {
    					public org.feature.multi.perspective.classification.resource.clt.CltEProblemSeverity getSeverity() {
    						return org.feature.multi.perspective.classification.resource.clt.CltEProblemSeverity.ERROR;
    					}
    					public org.feature.multi.perspective.classification.resource.clt.CltEProblemType getType() {
    						return org.feature.multi.perspective.classification.resource.clt.CltEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement terminal = org.feature.multi.perspective.classification.resource.clt.grammar.CltFollowSetProvider.TERMINALS[terminalID];
    		org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[] containmentFeatures = new org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = org.feature.multi.perspective.classification.resource.clt.grammar.CltFollowSetProvider.LINKS[ids[i]];
    		}
    		org.feature.multi.perspective.classification.resource.clt.grammar.CltContainmentTrace containmentTrace = new org.feature.multi.perspective.classification.resource.clt.grammar.CltContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal expectedElement = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal(container, terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    			this.expectedElementsIndexOfLastCompleteElement = 0;
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>() {
    			public boolean execute(org.feature.multi.perspective.classification.resource.clt.ICltTextResource resource) {
    				org.feature.multi.perspective.classification.resource.clt.ICltLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>() {
    			public boolean execute(org.feature.multi.perspective.classification.resource.clt.ICltTextResource resource) {
    				org.feature.multi.perspective.classification.resource.clt.ICltLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				if (source == null) {
    					return true;
    				}
    				locationMap.setCharStart(target, source.getStartIndex());
    				locationMap.setCharEnd(target, source.getStopIndex());
    				locationMap.setColumn(target, source.getCharPositionInLine());
    				locationMap.setLine(target, source.getLine());
    				return true;
    			}
    		});
    	}
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(java.util.Collection<org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>() {
    			public boolean execute(org.feature.multi.perspective.classification.resource.clt.ICltTextResource resource) {
    				org.feature.multi.perspective.classification.resource.clt.ICltLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.feature.multi.perspective.classification.resource.clt.ICltTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new CltParser(new org.antlr.runtime3_4_0.CommonTokenStream(new CltLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new CltParser(new org.antlr.runtime3_4_0.CommonTokenStream(new CltLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new org.feature.multi.perspective.classification.resource.clt.util.CltRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public CltParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((CltLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((CltLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.feature.multi.perspective.classification.ClassificationModel.class) {
    				return parse_org_feature_multi_perspective_classification_ClassificationModel();
    			}
    			if (type.getInstanceClass() == org.feature.multi.perspective.classification.Classification.class) {
    				return parse_org_feature_multi_perspective_classification_Classification();
    			}
    			if (type.getInstanceClass() == org.feature.multi.perspective.classification.ClassifiedFeature.class) {
    				return parse_org_feature_multi_perspective_classification_ClassifiedFeature();
    			}
    		}
    		throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	public Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected Object getTypeObject() {
    		Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(org.feature.multi.perspective.classification.resource.clt.ICltOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.feature.multi.perspective.classification.resource.clt.ICltParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource>>();
    		org.feature.multi.perspective.classification.resource.clt.mopp.CltParseResult parseResult = new org.feature.multi.perspective.classification.resource.clt.mopp.CltParseResult();
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    			}
    		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public java.util.List<org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.feature.multi.perspective.classification.resource.clt.ICltTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		org.feature.multi.perspective.classification.resource.clt.ICltParseResult result = parse();
    		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
    			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			org.eclipse.emf.ecore.EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (org.feature.multi.perspective.classification.resource.clt.ICltCommand<org.feature.multi.perspective.classification.resource.clt.ICltTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal>();
    		java.util.List<org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal> newFollowSet = new java.util.ArrayList<org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 48;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<org.feature.multi.perspective.classification.resource.clt.util.CltPair<org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement, org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.feature.multi.perspective.classification.resource.clt.util.CltPair<org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement, org.feature.multi.perspective.classification.resource.clt.mopp.CltContainedFeature[]> newFollowerPair : newFollowers) {
    							org.feature.multi.perspective.classification.resource.clt.ICltExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							org.feature.multi.perspective.classification.resource.clt.grammar.CltContainmentTrace containmentTrace = new org.feature.multi.perspective.classification.resource.clt.grammar.CltContainmentTrace(null, newFollowerPair.getRight());
    							org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal newFollowTerminal = new org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal(container, newFollower, followSetID, containmentTrace);
    							newFollowSet.add(newFollowTerminal);
    							expectedElements.add(newFollowTerminal);
    						}
    					}
    				}
    				currentFollowSet.clear();
    				currentFollowSet.addAll(newFollowSet);
    			}
    			followSetID++;
    		}
    		// after the last token in the stream we must set the position for the elements
    		// that were added during the last iteration of the loop
    		for (org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
    			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
    			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    	}
    	
    	private void startIncompleteElement(Object object) {
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
    		}
    	}
    	
    	private void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			boolean exists = this.incompleteObjects.remove(object);
    			if (!exists) {
    			}
    		}
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
    		if (incompleteObjects.isEmpty()) {
    			return null;
    		}
    		return incompleteObjects.get(incompleteObjects.size() - 1);
    	}
    	



    // $ANTLR start "start"
    // Clt.g:505:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_feature_multi_perspective_classification_ClassificationModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.feature.multi.perspective.classification.ClassificationModel c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Clt.g:506:2: ( (c0= parse_org_feature_multi_perspective_classification_ClassificationModel ) EOF )
            // Clt.g:507:2: (c0= parse_org_feature_multi_perspective_classification_ClassificationModel ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Clt.g:512:2: (c0= parse_org_feature_multi_perspective_classification_ClassificationModel )
            // Clt.g:513:3: c0= parse_org_feature_multi_perspective_classification_ClassificationModel
            {
            pushFollow(FOLLOW_parse_org_feature_multi_perspective_classification_ClassificationModel_in_start82);
            c0=parse_org_feature_multi_perspective_classification_ClassificationModel();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_org_feature_multi_perspective_classification_ClassificationModel"
    // Clt.g:521:1: parse_org_feature_multi_perspective_classification_ClassificationModel returns [org.feature.multi.perspective.classification.ClassificationModel element = null] : a0= 'classification' a1= 'references' ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) ) ( (a6_0= parse_org_feature_multi_perspective_classification_Classification ) )* ;
    public final org.feature.multi.perspective.classification.ClassificationModel parse_org_feature_multi_perspective_classification_ClassificationModel() throws RecognitionException {
        org.feature.multi.perspective.classification.ClassificationModel element =  null;

        int parse_org_feature_multi_perspective_classification_ClassificationModel_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        org.feature.multi.perspective.classification.Classification a6_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Clt.g:524:2: (a0= 'classification' a1= 'references' ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) ) ( (a6_0= parse_org_feature_multi_perspective_classification_Classification ) )* )
            // Clt.g:525:2: a0= 'classification' a1= 'references' ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) ) ( (a6_0= parse_org_feature_multi_perspective_classification_Classification ) )*
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_org_feature_multi_perspective_classification_ClassificationModel115); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[1]);
            	}

            a1=(Token)match(input,22,FOLLOW_22_in_parse_org_feature_multi_perspective_classification_ClassificationModel129); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_2, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[2]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[3]);
            	}

            // Clt.g:554:2: ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==20) ) {
                alt1=1;
            }
            else if ( (LA1_0==19) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // Clt.g:555:3: (a2= 'mapping' (a3= QUOTED_60_62 ) )
                    {
                    // Clt.g:555:3: (a2= 'mapping' (a3= QUOTED_60_62 ) )
                    // Clt.g:556:4: a2= 'mapping' (a3= QUOTED_60_62 )
                    {
                    a2=(Token)match(input,20,FOLLOW_20_in_parse_org_feature_multi_perspective_classification_ClassificationModel152); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_0_0_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[4]);
                    			}

                    // Clt.g:570:4: (a3= QUOTED_60_62 )
                    // Clt.g:571:5: a3= QUOTED_60_62
                    {
                    a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_ClassificationModel178); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
                    						startIncompleteElement(element);
                    					}
                    					if (a3 != null) {
                    						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
                    						tokenResolver.setOptions(getOptions());
                    						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
                    						}
                    						String resolved = (String) resolvedObject;
                    						org.feature.multi.perspective.mapping.viewmapping.MappingModel proxy = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMappingModel();
                    						collectHiddenTokens(element);
                    						registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.ClassificationModel, org.feature.multi.perspective.mapping.viewmapping.MappingModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationModelViewMappingReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING), resolved, proxy);
                    						if (proxy != null) {
                    							Object value = proxy;
                    							element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_0_0_0_0_2, proxy, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[5]);
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[6]);
                    		}

                    }
                    break;
                case 2 :
                    // Clt.g:617:6: (a4= 'featuremodel' (a5= QUOTED_60_62 ) )
                    {
                    // Clt.g:617:6: (a4= 'featuremodel' (a5= QUOTED_60_62 ) )
                    // Clt.g:618:4: a4= 'featuremodel' (a5= QUOTED_60_62 )
                    {
                    a4=(Token)match(input,19,FOLLOW_19_in_parse_org_feature_multi_perspective_classification_ClassificationModel232); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_1_0_0_0_0, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[7]);
                    			}

                    // Clt.g:632:4: (a5= QUOTED_60_62 )
                    // Clt.g:633:5: a5= QUOTED_60_62
                    {
                    a5=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_ClassificationModel258); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
                    						startIncompleteElement(element);
                    					}
                    					if (a5 != null) {
                    						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
                    						tokenResolver.setOptions(getOptions());
                    						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
                    						tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL), result);
                    						Object resolvedObject = result.getResolvedToken();
                    						if (resolvedObject == null) {
                    							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
                    						}
                    						String resolved = (String) resolvedObject;
                    						org.featuremapper.models.feature.FeatureModel proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
                    						collectHiddenTokens(element);
                    						registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.ClassificationModel, org.featuremapper.models.feature.FeatureModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationModelFeatureModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL), resolved, proxy);
                    						if (proxy != null) {
                    							Object value = proxy;
                    							element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL), value);
                    							completedElement(value, false);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_1_0_0_0_2, proxy, true);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
                    						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, proxy);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[8]);
                    			}

                    }


                    if ( state.backtracking==0 ) {
                    			// expected elements (follow set)
                    			addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[9]);
                    		}

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[10]);
            	}

            // Clt.g:684:2: ( (a6_0= parse_org_feature_multi_perspective_classification_Classification ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==23) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Clt.g:685:3: (a6_0= parse_org_feature_multi_perspective_classification_Classification )
            	    {
            	    // Clt.g:685:3: (a6_0= parse_org_feature_multi_perspective_classification_Classification )
            	    // Clt.g:686:4: a6_0= parse_org_feature_multi_perspective_classification_Classification
            	    {
            	    pushFollow(FOLLOW_parse_org_feature_multi_perspective_classification_Classification_in_parse_org_feature_multi_perspective_classification_ClassificationModel317);
            	    a6_0=parse_org_feature_multi_perspective_classification_Classification();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a6_0 != null) {
            	    					if (a6_0 != null) {
            	    						Object value = a6_0;
            	    						addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_7, a6_0, true);
            	    					copyLocalizationInfos(a6_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[11]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_feature_multi_perspective_classification_ClassificationModel_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_feature_multi_perspective_classification_ClassificationModel"



    // $ANTLR start "parse_org_feature_multi_perspective_classification_Classification"
    // Clt.g:714:1: parse_org_feature_multi_perspective_classification_Classification returns [org.feature.multi.perspective.classification.Classification element = null] : a0= 'stage' (a1= QUOTED_60_62 ) a2= 'on' ( ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) ) )? a11= ':' ( (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* ( (a13= 'afeatures' (a14= TEXT ) |a15= 'dfeatures' (a16= TEXT ) |a17= 'ufeatures' (a18= TEXT ) ) )* ( (a19= 'autocomplete' a20= '{' (a21_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) ( (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a23= '}' ) )? ;
    public final org.feature.multi.perspective.classification.Classification parse_org_feature_multi_perspective_classification_Classification() throws RecognitionException {
        org.feature.multi.perspective.classification.Classification element =  null;

        int parse_org_feature_multi_perspective_classification_Classification_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        Token a18=null;
        Token a19=null;
        Token a20=null;
        Token a23=null;
        org.feature.multi.perspective.classification.ClassifiedFeature a12_0 =null;

        org.feature.multi.perspective.classification.ClassifiedFeature a21_0 =null;

        org.feature.multi.perspective.classification.ClassifiedFeature a22_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Clt.g:717:2: (a0= 'stage' (a1= QUOTED_60_62 ) a2= 'on' ( ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) ) )? a11= ':' ( (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* ( (a13= 'afeatures' (a14= TEXT ) |a15= 'dfeatures' (a16= TEXT ) |a17= 'ufeatures' (a18= TEXT ) ) )* ( (a19= 'autocomplete' a20= '{' (a21_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) ( (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a23= '}' ) )? )
            // Clt.g:718:2: a0= 'stage' (a1= QUOTED_60_62 ) a2= 'on' ( ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) ) )? a11= ':' ( (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* ( (a13= 'afeatures' (a14= TEXT ) |a15= 'dfeatures' (a16= TEXT ) |a17= 'ufeatures' (a18= TEXT ) ) )* ( (a19= 'autocomplete' a20= '{' (a21_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) ( (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a23= '}' ) )?
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_org_feature_multi_perspective_classification_Classification358); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_0, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[12]);
            	}

            // Clt.g:732:2: (a1= QUOTED_60_62 )
            // Clt.g:733:3: a1= QUOTED_60_62
            {
            a1=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_Classification376); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            				startIncompleteElement(element);
            			}
            			if (a1 != null) {
            				org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
            				tokenResolver.setOptions(getOptions());
            				org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ID), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            				}
            				java.lang.String resolved = (java.lang.String) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ID), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_2, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[13]);
            	}

            a2=(Token)match(input,21,FOLLOW_21_in_parse_org_feature_multi_perspective_classification_Classification397); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_4, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[14]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[15]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[16]);
            	}

            // Clt.g:784:2: ( ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24||LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Clt.g:785:3: ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) )
                    {
                    // Clt.g:785:3: ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==27) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==24) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;

                    }
                    switch (alt7) {
                        case 1 :
                            // Clt.g:786:4: (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? )
                            {
                            // Clt.g:786:4: (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? )
                            // Clt.g:787:5: a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )?
                            {
                            a3=(Token)match(input,27,FOLLOW_27_in_parse_org_feature_multi_perspective_classification_Classification426); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_5_0_0_0_0_0_0, null, true);
                            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[17]);
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[18]);
                            				}

                            // Clt.g:802:5: ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )?
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( (LA4_0==QUOTED_34_34) ) {
                                alt4=1;
                            }
                            switch (alt4) {
                                case 1 :
                                    // Clt.g:803:6: ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* )
                                    {
                                    // Clt.g:803:6: ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* )
                                    // Clt.g:804:7: (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )*
                                    {
                                    // Clt.g:804:7: (a4= QUOTED_34_34 )
                                    // Clt.g:805:8: a4= QUOTED_34_34
                                    {
                                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification473); if (state.failed) return element;

                                    if ( state.backtracking==0 ) {
                                    								if (terminateParsing) {
                                    									throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
                                    								}
                                    								if (element == null) {
                                    									element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                                    									startIncompleteElement(element);
                                    								}
                                    								if (a4 != null) {
                                    									org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                                    									tokenResolver.setOptions(getOptions());
                                    									org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
                                    									tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS), result);
                                    									Object resolvedObject = result.getResolvedToken();
                                    									if (resolvedObject == null) {
                                    										addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
                                    									}
                                    									String resolved = (String) resolvedObject;
                                    									org.feature.multi.perspective.model.viewmodel.AbstractGroup proxy = org.feature.multi.perspective.model.viewmodel.ViewmodelFactory.eINSTANCE.createAbstractGroup();
                                    									collectHiddenTokens(element);
                                    									registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.model.viewmodel.AbstractGroup>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationViewgroupsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS), resolved, proxy);
                                    									if (proxy != null) {
                                    										Object value = proxy;
                                    										addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS, value);
                                    										completedElement(value, false);
                                    									}
                                    									collectHiddenTokens(element);
                                    									retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_5_0_0_0_0_0_1_0_0_1, proxy, true);
                                    									copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
                                    									copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
                                    								}
                                    							}

                                    }


                                    if ( state.backtracking==0 ) {
                                    							// expected elements (follow set)
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[19]);
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[20]);
                                    						}

                                    // Clt.g:845:7: ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )*
                                    loop3:
                                    do {
                                        int alt3=2;
                                        int LA3_0 = input.LA(1);

                                        if ( (LA3_0==COMMA) ) {
                                            alt3=1;
                                        }


                                        switch (alt3) {
                                    	case 1 :
                                    	    // Clt.g:846:8: ( (a5= COMMA ) (a6= QUOTED_34_34 ) )
                                    	    {
                                    	    // Clt.g:846:8: ( (a5= COMMA ) (a6= QUOTED_34_34 ) )
                                    	    // Clt.g:847:9: (a5= COMMA ) (a6= QUOTED_34_34 )
                                    	    {
                                    	    // Clt.g:847:9: (a5= COMMA )
                                    	    // Clt.g:848:10: a5= COMMA
                                    	    {
                                    	    a5=(Token)match(input,COMMA,FOLLOW_COMMA_in_parse_org_feature_multi_perspective_classification_Classification554); if (state.failed) return element;

                                    	    }


                                    	    if ( state.backtracking==0 ) {
                                    	    									anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a5);
                                    	    								}

                                    	    if ( state.backtracking==0 ) {
                                    	    									// expected elements (follow set)
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[21]);
                                    	    								}

                                    	    // Clt.g:858:9: (a6= QUOTED_34_34 )
                                    	    // Clt.g:859:10: a6= QUOTED_34_34
                                    	    {
                                    	    a6=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification627); if (state.failed) return element;

                                    	    if ( state.backtracking==0 ) {
                                    	    										if (terminateParsing) {
                                    	    											throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
                                    	    										}
                                    	    										if (element == null) {
                                    	    											element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                                    	    											startIncompleteElement(element);
                                    	    										}
                                    	    										if (a6 != null) {
                                    	    											org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                                    	    											tokenResolver.setOptions(getOptions());
                                    	    											org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
                                    	    											tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS), result);
                                    	    											Object resolvedObject = result.getResolvedToken();
                                    	    											if (resolvedObject == null) {
                                    	    												addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
                                    	    											}
                                    	    											String resolved = (String) resolvedObject;
                                    	    											org.feature.multi.perspective.model.viewmodel.AbstractGroup proxy = org.feature.multi.perspective.model.viewmodel.ViewmodelFactory.eINSTANCE.createAbstractGroup();
                                    	    											collectHiddenTokens(element);
                                    	    											registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.model.viewmodel.AbstractGroup>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationViewgroupsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS), resolved, proxy);
                                    	    											if (proxy != null) {
                                    	    												Object value = proxy;
                                    	    												addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS, value);
                                    	    												completedElement(value, false);
                                    	    											}
                                    	    											collectHiddenTokens(element);
                                    	    											retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_5_0_0_0_0_0_1_0_0_2_0_0_2, proxy, true);
                                    	    											copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
                                    	    											copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
                                    	    										}
                                    	    									}

                                    	    }


                                    	    if ( state.backtracking==0 ) {
                                    	    									// expected elements (follow set)
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[22]);
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[23]);
                                    	    								}

                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop3;
                                        }
                                    } while (true);


                                    if ( state.backtracking==0 ) {
                                    							// expected elements (follow set)
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[24]);
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[25]);
                                    						}

                                    }


                                    }
                                    break;

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[26]);
                            				}

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[27]);
                            			}

                            }
                            break;
                        case 2 :
                            // Clt.g:921:8: (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? )
                            {
                            // Clt.g:921:8: (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? )
                            // Clt.g:922:5: a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )?
                            {
                            a7=(Token)match(input,24,FOLLOW_24_in_parse_org_feature_multi_perspective_classification_Classification783); if (state.failed) return element;

                            if ( state.backtracking==0 ) {
                            					if (element == null) {
                            						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                            						startIncompleteElement(element);
                            					}
                            					collectHiddenTokens(element);
                            					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_5_0_1_0_0_0_0, null, true);
                            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
                            				}

                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[28]);
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[29]);
                            				}

                            // Clt.g:937:5: ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )?
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( (LA6_0==QUOTED_34_34) ) {
                                alt6=1;
                            }
                            switch (alt6) {
                                case 1 :
                                    // Clt.g:938:6: ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* )
                                    {
                                    // Clt.g:938:6: ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* )
                                    // Clt.g:939:7: (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )*
                                    {
                                    // Clt.g:939:7: (a8= QUOTED_34_34 )
                                    // Clt.g:940:8: a8= QUOTED_34_34
                                    {
                                    a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification830); if (state.failed) return element;

                                    if ( state.backtracking==0 ) {
                                    								if (terminateParsing) {
                                    									throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
                                    								}
                                    								if (element == null) {
                                    									element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                                    									startIncompleteElement(element);
                                    								}
                                    								if (a8 != null) {
                                    									org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                                    									tokenResolver.setOptions(getOptions());
                                    									org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
                                    									tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__COMPOSE), result);
                                    									Object resolvedObject = result.getResolvedToken();
                                    									if (resolvedObject == null) {
                                    										addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
                                    									}
                                    									String resolved = (String) resolvedObject;
                                    									org.feature.multi.perspective.classification.Classification proxy = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                                    									collectHiddenTokens(element);
                                    									registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.classification.Classification>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationComposeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__COMPOSE), resolved, proxy);
                                    									if (proxy != null) {
                                    										Object value = proxy;
                                    										addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__COMPOSE, value);
                                    										completedElement(value, false);
                                    									}
                                    									collectHiddenTokens(element);
                                    									retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_5_0_1_0_0_0_1_0_0_1, proxy, true);
                                    									copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
                                    									copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, proxy);
                                    								}
                                    							}

                                    }


                                    if ( state.backtracking==0 ) {
                                    							// expected elements (follow set)
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[30]);
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[31]);
                                    						}

                                    // Clt.g:980:7: ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )*
                                    loop5:
                                    do {
                                        int alt5=2;
                                        int LA5_0 = input.LA(1);

                                        if ( (LA5_0==COMMA) ) {
                                            alt5=1;
                                        }


                                        switch (alt5) {
                                    	case 1 :
                                    	    // Clt.g:981:8: ( (a9= COMMA ) (a10= QUOTED_34_34 ) )
                                    	    {
                                    	    // Clt.g:981:8: ( (a9= COMMA ) (a10= QUOTED_34_34 ) )
                                    	    // Clt.g:982:9: (a9= COMMA ) (a10= QUOTED_34_34 )
                                    	    {
                                    	    // Clt.g:982:9: (a9= COMMA )
                                    	    // Clt.g:983:10: a9= COMMA
                                    	    {
                                    	    a9=(Token)match(input,COMMA,FOLLOW_COMMA_in_parse_org_feature_multi_perspective_classification_Classification911); if (state.failed) return element;

                                    	    }


                                    	    if ( state.backtracking==0 ) {
                                    	    									anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a9);
                                    	    								}

                                    	    if ( state.backtracking==0 ) {
                                    	    									// expected elements (follow set)
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[32]);
                                    	    								}

                                    	    // Clt.g:993:9: (a10= QUOTED_34_34 )
                                    	    // Clt.g:994:10: a10= QUOTED_34_34
                                    	    {
                                    	    a10=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification984); if (state.failed) return element;

                                    	    if ( state.backtracking==0 ) {
                                    	    										if (terminateParsing) {
                                    	    											throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
                                    	    										}
                                    	    										if (element == null) {
                                    	    											element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                                    	    											startIncompleteElement(element);
                                    	    										}
                                    	    										if (a10 != null) {
                                    	    											org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
                                    	    											tokenResolver.setOptions(getOptions());
                                    	    											org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
                                    	    											tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__COMPOSE), result);
                                    	    											Object resolvedObject = result.getResolvedToken();
                                    	    											if (resolvedObject == null) {
                                    	    												addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a10).getStopIndex());
                                    	    											}
                                    	    											String resolved = (String) resolvedObject;
                                    	    											org.feature.multi.perspective.classification.Classification proxy = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                                    	    											collectHiddenTokens(element);
                                    	    											registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.Classification, org.feature.multi.perspective.classification.Classification>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationComposeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__COMPOSE), resolved, proxy);
                                    	    											if (proxy != null) {
                                    	    												Object value = proxy;
                                    	    												addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__COMPOSE, value);
                                    	    												completedElement(value, false);
                                    	    											}
                                    	    											collectHiddenTokens(element);
                                    	    											retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_5_0_1_0_0_0_1_0_0_2_0_0_2, proxy, true);
                                    	    											copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, element);
                                    	    											copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a10, proxy);
                                    	    										}
                                    	    									}

                                    	    }


                                    	    if ( state.backtracking==0 ) {
                                    	    									// expected elements (follow set)
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[33]);
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[34]);
                                    	    								}

                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop5;
                                        }
                                    } while (true);


                                    if ( state.backtracking==0 ) {
                                    							// expected elements (follow set)
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[35]);
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[36]);
                                    						}

                                    }


                                    }
                                    break;

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[37]);
                            				}

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[38]);
                            			}

                            }
                            break;

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[39]);
            	}

            a11=(Token)match(input,11,FOLLOW_11_in_parse_org_feature_multi_perspective_classification_Classification1139); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		if (element == null) {
            			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            			startIncompleteElement(element);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_6, null, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
            	}

            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[40]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[41]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[42]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[43]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[44]);
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[45]);
            	}

            // Clt.g:1081:2: ( (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Clt.g:1082:3: (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature )
            	    {
            	    // Clt.g:1082:3: (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature )
            	    // Clt.g:1083:4: a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature
            	    {
            	    pushFollow(FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1162);
            	    a12_0=parse_org_feature_multi_perspective_classification_ClassifiedFeature();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (terminateParsing) {
            	    					throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
            	    				}
            	    				if (element == null) {
            	    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            	    					startIncompleteElement(element);
            	    				}
            	    				if (a12_0 != null) {
            	    					if (a12_0 != null) {
            	    						Object value = a12_0;
            	    						addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES, value);
            	    						completedElement(value, true);
            	    					}
            	    					collectHiddenTokens(element);
            	    					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_8, a12_0, true);
            	    					copyLocalizationInfos(a12_0, element);
            	    				}
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[50]);
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[51]);
            	}

            // Clt.g:1114:2: ( (a13= 'afeatures' (a14= TEXT ) |a15= 'dfeatures' (a16= TEXT ) |a17= 'ufeatures' (a18= TEXT ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==12||LA11_0==17||LA11_0==25) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Clt.g:1115:3: (a13= 'afeatures' (a14= TEXT ) |a15= 'dfeatures' (a16= TEXT ) |a17= 'ufeatures' (a18= TEXT ) )
            	    {
            	    // Clt.g:1115:3: (a13= 'afeatures' (a14= TEXT ) |a15= 'dfeatures' (a16= TEXT ) |a17= 'ufeatures' (a18= TEXT ) )
            	    int alt10=3;
            	    switch ( input.LA(1) ) {
            	    case 12:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case 17:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // Clt.g:1116:4: a13= 'afeatures' (a14= TEXT )
            	            {
            	            a13=(Token)match(input,12,FOLLOW_12_in_parse_org_feature_multi_perspective_classification_Classification1197); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_0_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[52]);
            	            			}

            	            // Clt.g:1130:4: (a14= TEXT )
            	            // Clt.g:1131:5: a14= TEXT
            	            {
            	            a14=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_feature_multi_perspective_classification_Classification1223); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a14 != null) {
            	            						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a14.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ALIVE_FEATURES), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a14).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a14).getStopIndex());
            	            						}
            	            						String resolved = (String) resolvedObject;
            	            						org.featuremapper.models.feature.Feature proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
            	            						collectHiddenTokens(element);
            	            						registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.Classification, org.featuremapper.models.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationAliveFeaturesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ALIVE_FEATURES), resolved, proxy);
            	            						if (proxy != null) {
            	            							Object value = proxy;
            	            							addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ALIVE_FEATURES, value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_0_1, proxy, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, element);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a14, proxy);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[53]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[54]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[55]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[56]);
            	            				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[57]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Clt.g:1175:8: a15= 'dfeatures' (a16= TEXT )
            	            {
            	            a15=(Token)match(input,17,FOLLOW_17_in_parse_org_feature_multi_perspective_classification_Classification1264); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_1_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a15, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[58]);
            	            			}

            	            // Clt.g:1189:4: (a16= TEXT )
            	            // Clt.g:1190:5: a16= TEXT
            	            {
            	            a16=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_feature_multi_perspective_classification_Classification1290); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a16 != null) {
            	            						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a16.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__DEAD_FEATURES), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a16).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a16).getStopIndex());
            	            						}
            	            						String resolved = (String) resolvedObject;
            	            						org.featuremapper.models.feature.Feature proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
            	            						collectHiddenTokens(element);
            	            						registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.Classification, org.featuremapper.models.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationDeadFeaturesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__DEAD_FEATURES), resolved, proxy);
            	            						if (proxy != null) {
            	            							Object value = proxy;
            	            							addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__DEAD_FEATURES, value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_1_1, proxy, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, element);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a16, proxy);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[59]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[60]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[61]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[62]);
            	            				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[63]);
            	            			}

            	            }
            	            break;
            	        case 3 :
            	            // Clt.g:1234:8: a17= 'ufeatures' (a18= TEXT )
            	            {
            	            a17=(Token)match(input,25,FOLLOW_25_in_parse_org_feature_multi_perspective_classification_Classification1331); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            				if (element == null) {
            	            					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            	            					startIncompleteElement(element);
            	            				}
            	            				collectHiddenTokens(element);
            	            				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_2_0, null, true);
            	            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a17, element);
            	            			}

            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[64]);
            	            			}

            	            // Clt.g:1248:4: (a18= TEXT )
            	            // Clt.g:1249:5: a18= TEXT
            	            {
            	            a18=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_feature_multi_perspective_classification_Classification1357); if (state.failed) return element;

            	            if ( state.backtracking==0 ) {
            	            					if (terminateParsing) {
            	            						throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
            	            					}
            	            					if (element == null) {
            	            						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
            	            						startIncompleteElement(element);
            	            					}
            	            					if (a18 != null) {
            	            						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            	            						tokenResolver.setOptions(getOptions());
            	            						org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
            	            						tokenResolver.resolve(a18.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__UNBOUND_FEATURES), result);
            	            						Object resolvedObject = result.getResolvedToken();
            	            						if (resolvedObject == null) {
            	            							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a18).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a18).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a18).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a18).getStopIndex());
            	            						}
            	            						String resolved = (String) resolvedObject;
            	            						org.featuremapper.models.feature.Feature proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
            	            						collectHiddenTokens(element);
            	            						registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.Classification, org.featuremapper.models.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationUnboundFeaturesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__UNBOUND_FEATURES), resolved, proxy);
            	            						if (proxy != null) {
            	            							Object value = proxy;
            	            							addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__UNBOUND_FEATURES, value);
            	            							completedElement(value, false);
            	            						}
            	            						collectHiddenTokens(element);
            	            						retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_2_1, proxy, true);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a18, element);
            	            						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a18, proxy);
            	            					}
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[65]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[66]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[67]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[68]);
            	            				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[69]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[72]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[73]);
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[74]);
            	}

            // Clt.g:1303:2: ( (a19= 'autocomplete' a20= '{' (a21_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) ( (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a23= '}' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==14) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Clt.g:1304:3: (a19= 'autocomplete' a20= '{' (a21_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) ( (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a23= '}' )
                    {
                    // Clt.g:1304:3: (a19= 'autocomplete' a20= '{' (a21_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) ( (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a23= '}' )
                    // Clt.g:1305:4: a19= 'autocomplete' a20= '{' (a21_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) ( (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a23= '}'
                    {
                    a19=(Token)match(input,14,FOLLOW_14_in_parse_org_feature_multi_perspective_classification_Classification1412); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_10_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a19, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[75]);
                    			}

                    a20=(Token)match(input,28,FOLLOW_28_in_parse_org_feature_multi_perspective_classification_Classification1432); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_10_0_0_3, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a20, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[76]);
                    			}

                    // Clt.g:1333:4: (a21_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature )
                    // Clt.g:1334:5: a21_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature
                    {
                    pushFollow(FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1458);
                    a21_0=parse_org_feature_multi_perspective_classification_ClassifiedFeature();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (terminateParsing) {
                    						throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
                    					}
                    					if (element == null) {
                    						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                    						startIncompleteElement(element);
                    					}
                    					if (a21_0 != null) {
                    						if (a21_0 != null) {
                    							Object value = a21_0;
                    							addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES, value);
                    							completedElement(value, true);
                    						}
                    						collectHiddenTokens(element);
                    						retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_10_0_0_5, a21_0, true);
                    						copyLocalizationInfos(a21_0, element);
                    					}
                    				}

                    }


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[77]);
                    				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[78]);
                    			}

                    // Clt.g:1360:4: ( (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==18) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Clt.g:1361:5: (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature )
                    	    {
                    	    // Clt.g:1361:5: (a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature )
                    	    // Clt.g:1362:6: a22_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature
                    	    {
                    	    pushFollow(FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1499);
                    	    a22_0=parse_org_feature_multi_perspective_classification_ClassifiedFeature();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    						if (terminateParsing) {
                    	    							throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
                    	    						}
                    	    						if (element == null) {
                    	    							element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                    	    							startIncompleteElement(element);
                    	    						}
                    	    						if (a22_0 != null) {
                    	    							if (a22_0 != null) {
                    	    								Object value = a22_0;
                    	    								addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES, value);
                    	    								completedElement(value, true);
                    	    							}
                    	    							collectHiddenTokens(element);
                    	    							retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_10_0_0_6, a22_0, true);
                    	    							copyLocalizationInfos(a22_0, element);
                    	    						}
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[79]);
                    				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[80]);
                    			}

                    a23=(Token)match(input,29,FOLLOW_29_in_parse_org_feature_multi_perspective_classification_Classification1539); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_10_0_0_8, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a23, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[81]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[82]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_feature_multi_perspective_classification_Classification_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_feature_multi_perspective_classification_Classification"



    // $ANTLR start "parse_org_feature_multi_perspective_classification_ClassifiedFeature"
    // Clt.g:1412:1: parse_org_feature_multi_perspective_classification_ClassifiedFeature returns [org.feature.multi.perspective.classification.ClassifiedFeature element = null] : (a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? ) ) ;
    public final org.feature.multi.perspective.classification.ClassifiedFeature parse_org_feature_multi_perspective_classification_ClassifiedFeature() throws RecognitionException {
        org.feature.multi.perspective.classification.ClassifiedFeature element =  null;

        int parse_org_feature_multi_perspective_classification_ClassifiedFeature_StartIndex = input.index();

        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Clt.g:1415:2: ( (a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? ) ) )
            // Clt.g:1416:2: (a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? ) )
            {
            // Clt.g:1416:2: (a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? ) )
            // Clt.g:1417:3: a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? )
            {
            a0=(Token)match(input,18,FOLLOW_18_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1591); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (element == null) {
            				element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassifiedFeature();
            				startIncompleteElement(element);
            				// initialize enumeration attribute
            				Object value = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifier().getEEnumLiteral(org.feature.multi.perspective.classification.Classifier.UNCLASSIFIED_VALUE).getInstance();
            				element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED), value);
            			}
            			collectHiddenTokens(element);
            			retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_2_0_0_0_0_0_1, null, true);
            			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            		}

            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[83]);
            		}

            // Clt.g:1434:3: (a1= QUOTED_34_34 )
            // Clt.g:1435:4: a1= QUOTED_34_34
            {
            a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1613); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            				if (terminateParsing) {
            					throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
            				}
            				if (element == null) {
            					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassifiedFeature();
            					startIncompleteElement(element);
            					// initialize enumeration attribute
            					Object value = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifier().getEEnumLiteral(org.feature.multi.perspective.classification.Classifier.UNCLASSIFIED_VALUE).getInstance();
            					element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED), value);
            				}
            				if (a1 != null) {
            					org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
            					tokenResolver.setOptions(getOptions());
            					org.feature.multi.perspective.classification.resource.clt.ICltTokenResolveResult result = getFreshTokenResolveResult();
            					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__FEATURE), result);
            					Object resolvedObject = result.getResolvedToken();
            					if (resolvedObject == null) {
            						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
            					}
            					String resolved = (String) resolvedObject;
            					org.featuremapper.models.feature.Feature proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
            					collectHiddenTokens(element);
            					registerContextDependentProxy(new org.feature.multi.perspective.classification.resource.clt.mopp.CltContextDependentURIFragmentFactory<org.feature.multi.perspective.classification.ClassifiedFeature, org.featuremapper.models.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassifiedFeatureFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__FEATURE), resolved, proxy);
            					if (proxy != null) {
            						Object value = proxy;
            						element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__FEATURE), value);
            						completedElement(value, false);
            					}
            					collectHiddenTokens(element);
            					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_2_0_0_0_0_0_3, proxy, true);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
            					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
            				}
            			}

            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[84]);
            		}

            // Clt.g:1477:3: ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? )
            // Clt.g:1478:4: (a2= 'unbound' |a3= 'dead' |a4= 'alive' )?
            {
            // Clt.g:1478:4: (a2= 'unbound' |a3= 'dead' |a4= 'alive' )?
            int alt14=4;
            switch ( input.LA(1) ) {
                case 26:
                    {
                    alt14=1;
                    }
                    break;
                case 16:
                    {
                    alt14=2;
                    }
                    break;
                case 13:
                    {
                    alt14=3;
                    }
                    break;
            }

            switch (alt14) {
                case 1 :
                    // Clt.g:1479:5: a2= 'unbound'
                    {
                    a2=(Token)match(input,26,FOLLOW_26_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1651); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassifiedFeature();
                    						startIncompleteElement(element);
                    						// initialize enumeration attribute
                    						Object value = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifier().getEEnumLiteral(org.feature.multi.perspective.classification.Classifier.UNCLASSIFIED_VALUE).getInstance();
                    						element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED), value);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_2_0_0_0_0_0_5, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
                    					// set value of enumeration attribute
                    					Object value = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifier().getEEnumLiteral(org.feature.multi.perspective.classification.Classifier.UNBOUND_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED), value);
                    					completedElement(value, false);
                    				}

                    }
                    break;
                case 2 :
                    // Clt.g:1495:10: a3= 'dead'
                    {
                    a3=(Token)match(input,16,FOLLOW_16_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1668); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassifiedFeature();
                    						startIncompleteElement(element);
                    						// initialize enumeration attribute
                    						Object value = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifier().getEEnumLiteral(org.feature.multi.perspective.classification.Classifier.UNCLASSIFIED_VALUE).getInstance();
                    						element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED), value);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_2_0_0_0_0_0_5, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
                    					// set value of enumeration attribute
                    					Object value = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifier().getEEnumLiteral(org.feature.multi.perspective.classification.Classifier.DEAD_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED), value);
                    					completedElement(value, false);
                    				}

                    }
                    break;
                case 3 :
                    // Clt.g:1511:10: a4= 'alive'
                    {
                    a4=(Token)match(input,13,FOLLOW_13_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1685); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    					if (element == null) {
                    						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassifiedFeature();
                    						startIncompleteElement(element);
                    						// initialize enumeration attribute
                    						Object value = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifier().getEEnumLiteral(org.feature.multi.perspective.classification.Classifier.UNCLASSIFIED_VALUE).getInstance();
                    						element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED), value);
                    					}
                    					collectHiddenTokens(element);
                    					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_2_0_0_0_0_0_5, null, true);
                    					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
                    					// set value of enumeration attribute
                    					Object value = org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassifier().getEEnumLiteral(org.feature.multi.perspective.classification.Classifier.ALIVE_VALUE).getInstance();
                    					element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED), value);
                    					completedElement(value, false);
                    				}

                    }
                    break;

            }


            }


            if ( state.backtracking==0 ) {
            			// expected elements (follow set)
            			addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[85]);
            			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[86]);
            			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[87]);
            			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[88]);
            			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[89]);
            			addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[90]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[91]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[96]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_feature_multi_perspective_classification_ClassifiedFeature_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_feature_multi_perspective_classification_ClassifiedFeature"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_feature_multi_perspective_classification_ClassificationModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_org_feature_multi_perspective_classification_ClassificationModel115 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_parse_org_feature_multi_perspective_classification_ClassificationModel129 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_20_in_parse_org_feature_multi_perspective_classification_ClassificationModel152 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_ClassificationModel178 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_19_in_parse_org_feature_multi_perspective_classification_ClassificationModel232 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_ClassificationModel258 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_parse_org_feature_multi_perspective_classification_Classification_in_parse_org_feature_multi_perspective_classification_ClassificationModel317 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_parse_org_feature_multi_perspective_classification_Classification358 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_Classification376 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_org_feature_multi_perspective_classification_Classification397 = new BitSet(new long[]{0x0000000009000800L});
    public static final BitSet FOLLOW_27_in_parse_org_feature_multi_perspective_classification_Classification426 = new BitSet(new long[]{0x0000000000000880L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification473 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_COMMA_in_parse_org_feature_multi_perspective_classification_Classification554 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification627 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_24_in_parse_org_feature_multi_perspective_classification_Classification783 = new BitSet(new long[]{0x0000000000000880L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification830 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_COMMA_in_parse_org_feature_multi_perspective_classification_Classification911 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification984 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_parse_org_feature_multi_perspective_classification_Classification1139 = new BitSet(new long[]{0x0000000002065002L});
    public static final BitSet FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1162 = new BitSet(new long[]{0x0000000002065002L});
    public static final BitSet FOLLOW_12_in_parse_org_feature_multi_perspective_classification_Classification1197 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_feature_multi_perspective_classification_Classification1223 = new BitSet(new long[]{0x0000000002025002L});
    public static final BitSet FOLLOW_17_in_parse_org_feature_multi_perspective_classification_Classification1264 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_feature_multi_perspective_classification_Classification1290 = new BitSet(new long[]{0x0000000002025002L});
    public static final BitSet FOLLOW_25_in_parse_org_feature_multi_perspective_classification_Classification1331 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_feature_multi_perspective_classification_Classification1357 = new BitSet(new long[]{0x0000000002025002L});
    public static final BitSet FOLLOW_14_in_parse_org_feature_multi_perspective_classification_Classification1412 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_org_feature_multi_perspective_classification_Classification1432 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1458 = new BitSet(new long[]{0x0000000020040000L});
    public static final BitSet FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1499 = new BitSet(new long[]{0x0000000020040000L});
    public static final BitSet FOLLOW_29_in_parse_org_feature_multi_perspective_classification_Classification1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1591 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1613 = new BitSet(new long[]{0x0000000004012002L});
    public static final BitSet FOLLOW_26_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1685 = new BitSet(new long[]{0x0000000000000002L});

}