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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMA", "COMMENT", "LINEBREAK", "QUOTED_34_34", "QUOTED_60_62", "TEXT", "WHITESPACE", "':'", "'alive'", "'autocomplete'", "'classification'", "'dead'", "'feature'", "'featuremodel'", "'mapping'", "'on'", "'references'", "'stage'", "'stages'", "'unbound'", "'views'", "'{'", "'}'"
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
        this.state.initializeRuleMemo(19 + 1);
         

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
    		int followSetID = 40;
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
    // Clt.g:521:1: parse_org_feature_multi_perspective_classification_ClassificationModel returns [org.feature.multi.perspective.classification.ClassificationModel element = null] : a0= 'classification' a1= 'references' ( ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) ) )+ ( (a6_0= parse_org_feature_multi_perspective_classification_Classification ) )* ;
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

            // Clt.g:524:2: (a0= 'classification' a1= 'references' ( ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) ) )+ ( (a6_0= parse_org_feature_multi_perspective_classification_Classification ) )* )
            // Clt.g:525:2: a0= 'classification' a1= 'references' ( ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) ) )+ ( (a6_0= parse_org_feature_multi_perspective_classification_Classification ) )*
            {
            a0=(Token)match(input,14,FOLLOW_14_in_parse_org_feature_multi_perspective_classification_ClassificationModel115); if (state.failed) return element;

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

            a1=(Token)match(input,20,FOLLOW_20_in_parse_org_feature_multi_perspective_classification_ClassificationModel129); if (state.failed) return element;

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

            // Clt.g:554:2: ( ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= 17 && LA2_0 <= 18)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Clt.g:555:3: ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) )
            	    {
            	    // Clt.g:555:3: ( (a2= 'mapping' (a3= QUOTED_60_62 ) ) | (a4= 'featuremodel' (a5= QUOTED_60_62 ) ) )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==18) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==17) ) {
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
            	            // Clt.g:556:4: (a2= 'mapping' (a3= QUOTED_60_62 ) )
            	            {
            	            // Clt.g:556:4: (a2= 'mapping' (a3= QUOTED_60_62 ) )
            	            // Clt.g:557:5: a2= 'mapping' (a3= QUOTED_60_62 )
            	            {
            	            a2=(Token)match(input,18,FOLLOW_18_in_parse_org_feature_multi_perspective_classification_ClassificationModel158); if (state.failed) return element;

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

            	            // Clt.g:571:5: (a3= QUOTED_60_62 )
            	            // Clt.g:572:6: a3= QUOTED_60_62
            	            {
            	            a3=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_ClassificationModel188); if (state.failed) return element;

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
            	            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[5]);
            	            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[6]);
            	            					addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[7]);
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[8]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[9]);
            	            				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[10]);
            	            			}

            	            }
            	            break;
            	        case 2 :
            	            // Clt.g:622:8: (a4= 'featuremodel' (a5= QUOTED_60_62 ) )
            	            {
            	            // Clt.g:622:8: (a4= 'featuremodel' (a5= QUOTED_60_62 ) )
            	            // Clt.g:623:5: a4= 'featuremodel' (a5= QUOTED_60_62 )
            	            {
            	            a4=(Token)match(input,17,FOLLOW_17_in_parse_org_feature_multi_perspective_classification_ClassificationModel254); if (state.failed) return element;

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
            	            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[11]);
            	            				}

            	            // Clt.g:637:5: (a5= QUOTED_60_62 )
            	            // Clt.g:638:6: a5= QUOTED_60_62
            	            {
            	            a5=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_ClassificationModel284); if (state.failed) return element;

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
            	            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[12]);
            	            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[13]);
            	            					addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[14]);
            	            				}

            	            }


            	            if ( state.backtracking==0 ) {
            	            				// expected elements (follow set)
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[15]);
            	            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[16]);
            	            				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[17]);
            	            			}

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return element;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[18]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[20]);
            	}

            // Clt.g:696:2: ( (a6_0= parse_org_feature_multi_perspective_classification_Classification ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==21) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Clt.g:697:3: (a6_0= parse_org_feature_multi_perspective_classification_Classification )
            	    {
            	    // Clt.g:697:3: (a6_0= parse_org_feature_multi_perspective_classification_Classification )
            	    // Clt.g:698:4: a6_0= parse_org_feature_multi_perspective_classification_Classification
            	    {
            	    pushFollow(FOLLOW_parse_org_feature_multi_perspective_classification_Classification_in_parse_org_feature_multi_perspective_classification_ClassificationModel358);
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
            	    break loop3;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[21]);
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
    // Clt.g:726:1: parse_org_feature_multi_perspective_classification_Classification returns [org.feature.multi.perspective.classification.Classification element = null] : a0= 'stage' (a1= QUOTED_60_62 ) a2= 'on' ( ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) ) )? a11= ':' ( (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* ( (a13= 'autocomplete' a14= '{' ( (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a16= '}' ) )? ;
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
        Token a16=null;
        org.feature.multi.perspective.classification.ClassifiedFeature a12_0 =null;

        org.feature.multi.perspective.classification.ClassifiedFeature a15_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Clt.g:729:2: (a0= 'stage' (a1= QUOTED_60_62 ) a2= 'on' ( ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) ) )? a11= ':' ( (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* ( (a13= 'autocomplete' a14= '{' ( (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a16= '}' ) )? )
            // Clt.g:730:2: a0= 'stage' (a1= QUOTED_60_62 ) a2= 'on' ( ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) ) )? a11= ':' ( (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* ( (a13= 'autocomplete' a14= '{' ( (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a16= '}' ) )?
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_org_feature_multi_perspective_classification_Classification399); if (state.failed) return element;

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
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[22]);
            	}

            // Clt.g:744:2: (a1= QUOTED_60_62 )
            // Clt.g:745:3: a1= QUOTED_60_62
            {
            a1=(Token)match(input,QUOTED_60_62,FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_Classification417); if (state.failed) return element;

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
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[23]);
            	}

            a2=(Token)match(input,19,FOLLOW_19_in_parse_org_feature_multi_perspective_classification_Classification438); if (state.failed) return element;

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
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[25]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[26]);
            	}

            // Clt.g:796:2: ( ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22||LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Clt.g:797:3: ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) )
                    {
                    // Clt.g:797:3: ( (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? ) | (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==24) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==22) ) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;

                    }
                    switch (alt8) {
                        case 1 :
                            // Clt.g:798:4: (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? )
                            {
                            // Clt.g:798:4: (a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )? )
                            // Clt.g:799:5: a3= 'views' ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )?
                            {
                            a3=(Token)match(input,24,FOLLOW_24_in_parse_org_feature_multi_perspective_classification_Classification467); if (state.failed) return element;

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
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[27]);
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[28]);
                            				}

                            // Clt.g:814:5: ( ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* ) )?
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==QUOTED_34_34) ) {
                                alt5=1;
                            }
                            switch (alt5) {
                                case 1 :
                                    // Clt.g:815:6: ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* )
                                    {
                                    // Clt.g:815:6: ( (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )* )
                                    // Clt.g:816:7: (a4= QUOTED_34_34 ) ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )*
                                    {
                                    // Clt.g:816:7: (a4= QUOTED_34_34 )
                                    // Clt.g:817:8: a4= QUOTED_34_34
                                    {
                                    a4=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification514); if (state.failed) return element;

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
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[29]);
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[30]);
                                    						}

                                    // Clt.g:857:7: ( ( (a5= COMMA ) (a6= QUOTED_34_34 ) ) )*
                                    loop4:
                                    do {
                                        int alt4=2;
                                        int LA4_0 = input.LA(1);

                                        if ( (LA4_0==COMMA) ) {
                                            alt4=1;
                                        }


                                        switch (alt4) {
                                    	case 1 :
                                    	    // Clt.g:858:8: ( (a5= COMMA ) (a6= QUOTED_34_34 ) )
                                    	    {
                                    	    // Clt.g:858:8: ( (a5= COMMA ) (a6= QUOTED_34_34 ) )
                                    	    // Clt.g:859:9: (a5= COMMA ) (a6= QUOTED_34_34 )
                                    	    {
                                    	    // Clt.g:859:9: (a5= COMMA )
                                    	    // Clt.g:860:10: a5= COMMA
                                    	    {
                                    	    a5=(Token)match(input,COMMA,FOLLOW_COMMA_in_parse_org_feature_multi_perspective_classification_Classification595); if (state.failed) return element;

                                    	    }


                                    	    if ( state.backtracking==0 ) {
                                    	    									anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a5);
                                    	    								}

                                    	    if ( state.backtracking==0 ) {
                                    	    									// expected elements (follow set)
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[31]);
                                    	    								}

                                    	    // Clt.g:870:9: (a6= QUOTED_34_34 )
                                    	    // Clt.g:871:10: a6= QUOTED_34_34
                                    	    {
                                    	    a6=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification668); if (state.failed) return element;

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
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[32]);
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[33]);
                                    	    								}

                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop4;
                                        }
                                    } while (true);


                                    if ( state.backtracking==0 ) {
                                    							// expected elements (follow set)
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[34]);
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[35]);
                                    						}

                                    }


                                    }
                                    break;

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[36]);
                            				}

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[37]);
                            			}

                            }
                            break;
                        case 2 :
                            // Clt.g:933:8: (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? )
                            {
                            // Clt.g:933:8: (a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )? )
                            // Clt.g:934:5: a7= 'stages' ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )?
                            {
                            a7=(Token)match(input,22,FOLLOW_22_in_parse_org_feature_multi_perspective_classification_Classification824); if (state.failed) return element;

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
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[38]);
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[39]);
                            				}

                            // Clt.g:949:5: ( ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* ) )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==QUOTED_34_34) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // Clt.g:950:6: ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* )
                                    {
                                    // Clt.g:950:6: ( (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )* )
                                    // Clt.g:951:7: (a8= QUOTED_34_34 ) ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )*
                                    {
                                    // Clt.g:951:7: (a8= QUOTED_34_34 )
                                    // Clt.g:952:8: a8= QUOTED_34_34
                                    {
                                    a8=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification871); if (state.failed) return element;

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
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[40]);
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[41]);
                                    						}

                                    // Clt.g:992:7: ( ( (a9= COMMA ) (a10= QUOTED_34_34 ) ) )*
                                    loop6:
                                    do {
                                        int alt6=2;
                                        int LA6_0 = input.LA(1);

                                        if ( (LA6_0==COMMA) ) {
                                            alt6=1;
                                        }


                                        switch (alt6) {
                                    	case 1 :
                                    	    // Clt.g:993:8: ( (a9= COMMA ) (a10= QUOTED_34_34 ) )
                                    	    {
                                    	    // Clt.g:993:8: ( (a9= COMMA ) (a10= QUOTED_34_34 ) )
                                    	    // Clt.g:994:9: (a9= COMMA ) (a10= QUOTED_34_34 )
                                    	    {
                                    	    // Clt.g:994:9: (a9= COMMA )
                                    	    // Clt.g:995:10: a9= COMMA
                                    	    {
                                    	    a9=(Token)match(input,COMMA,FOLLOW_COMMA_in_parse_org_feature_multi_perspective_classification_Classification952); if (state.failed) return element;

                                    	    }


                                    	    if ( state.backtracking==0 ) {
                                    	    									anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a9);
                                    	    								}

                                    	    if ( state.backtracking==0 ) {
                                    	    									// expected elements (follow set)
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[42]);
                                    	    								}

                                    	    // Clt.g:1005:9: (a10= QUOTED_34_34 )
                                    	    // Clt.g:1006:10: a10= QUOTED_34_34
                                    	    {
                                    	    a10=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification1025); if (state.failed) return element;

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
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[43]);
                                    	    									addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[44]);
                                    	    								}

                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop6;
                                        }
                                    } while (true);


                                    if ( state.backtracking==0 ) {
                                    							// expected elements (follow set)
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[45]);
                                    							addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[46]);
                                    						}

                                    }


                                    }
                                    break;

                            }


                            if ( state.backtracking==0 ) {
                            					// expected elements (follow set)
                            					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[47]);
                            				}

                            }


                            if ( state.backtracking==0 ) {
                            				// expected elements (follow set)
                            				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[48]);
                            			}

                            }
                            break;

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[49]);
            	}

            a11=(Token)match(input,11,FOLLOW_11_in_parse_org_feature_multi_perspective_classification_Classification1180); if (state.failed) return element;

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
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[50]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[51]);
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[52]);
            	}

            // Clt.g:1090:2: ( (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==16) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Clt.g:1091:3: (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature )
            	    {
            	    // Clt.g:1091:3: (a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature )
            	    // Clt.g:1092:4: a12_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature
            	    {
            	    pushFollow(FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1203);
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
            	    break loop10;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[53]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[54]);
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[55]);
            	}

            // Clt.g:1120:2: ( (a13= 'autocomplete' a14= '{' ( (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a16= '}' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==13) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // Clt.g:1121:3: (a13= 'autocomplete' a14= '{' ( (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a16= '}' )
                    {
                    // Clt.g:1121:3: (a13= 'autocomplete' a14= '{' ( (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a16= '}' )
                    // Clt.g:1122:4: a13= 'autocomplete' a14= '{' ( (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )* a16= '}'
                    {
                    a13=(Token)match(input,13,FOLLOW_13_in_parse_org_feature_multi_perspective_classification_Classification1238); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_0_1, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[56]);
                    			}

                    a14=(Token)match(input,25,FOLLOW_25_in_parse_org_feature_multi_perspective_classification_Classification1258); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_0_3, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a14, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[57]);
                    				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[58]);
                    			}

                    // Clt.g:1151:4: ( (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==16) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Clt.g:1152:5: (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature )
                    	    {
                    	    // Clt.g:1152:5: (a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature )
                    	    // Clt.g:1153:6: a15_0= parse_org_feature_multi_perspective_classification_ClassifiedFeature
                    	    {
                    	    pushFollow(FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1291);
                    	    a15_0=parse_org_feature_multi_perspective_classification_ClassifiedFeature();

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
                    	    						if (a15_0 != null) {
                    	    							if (a15_0 != null) {
                    	    								Object value = a15_0;
                    	    								addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES, value);
                    	    								completedElement(value, true);
                    	    							}
                    	    							collectHiddenTokens(element);
                    	    							retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_0_5, a15_0, true);
                    	    							copyLocalizationInfos(a15_0, element);
                    	    						}
                    	    					}

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[59]);
                    				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[60]);
                    			}

                    a16=(Token)match(input,26,FOLLOW_26_in_parse_org_feature_multi_perspective_classification_Classification1331); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    				if (element == null) {
                    					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
                    					startIncompleteElement(element);
                    				}
                    				collectHiddenTokens(element);
                    				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9_0_0_7, null, true);
                    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a16, element);
                    			}

                    if ( state.backtracking==0 ) {
                    				// expected elements (follow set)
                    				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[61]);
                    			}

                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[62]);
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
    // Clt.g:1203:1: parse_org_feature_multi_perspective_classification_ClassifiedFeature returns [org.feature.multi.perspective.classification.ClassifiedFeature element = null] : (a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? ) ) ;
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

            // Clt.g:1206:2: ( (a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? ) ) )
            // Clt.g:1207:2: (a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? ) )
            {
            // Clt.g:1207:2: (a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? ) )
            // Clt.g:1208:3: a0= 'feature' (a1= QUOTED_34_34 ) ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? )
            {
            a0=(Token)match(input,16,FOLLOW_16_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1383); if (state.failed) return element;

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
            			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[63]);
            		}

            // Clt.g:1225:3: (a1= QUOTED_34_34 )
            // Clt.g:1226:4: a1= QUOTED_34_34
            {
            a1=(Token)match(input,QUOTED_34_34,FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1405); if (state.failed) return element;

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
            			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[64]);
            		}

            // Clt.g:1268:3: ( (a2= 'unbound' |a3= 'dead' |a4= 'alive' )? )
            // Clt.g:1269:4: (a2= 'unbound' |a3= 'dead' |a4= 'alive' )?
            {
            // Clt.g:1269:4: (a2= 'unbound' |a3= 'dead' |a4= 'alive' )?
            int alt13=4;
            switch ( input.LA(1) ) {
                case 23:
                    {
                    alt13=1;
                    }
                    break;
                case 15:
                    {
                    alt13=2;
                    }
                    break;
                case 12:
                    {
                    alt13=3;
                    }
                    break;
            }

            switch (alt13) {
                case 1 :
                    // Clt.g:1270:5: a2= 'unbound'
                    {
                    a2=(Token)match(input,23,FOLLOW_23_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1443); if (state.failed) return element;

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
                    // Clt.g:1286:10: a3= 'dead'
                    {
                    a3=(Token)match(input,15,FOLLOW_15_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1460); if (state.failed) return element;

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
                    // Clt.g:1302:10: a4= 'alive'
                    {
                    a4=(Token)match(input,12,FOLLOW_12_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1477); if (state.failed) return element;

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
            			addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[65]);
            			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[66]);
            			addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[67]);
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[69]);
            		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[70]);
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
    public static final BitSet FOLLOW_14_in_parse_org_feature_multi_perspective_classification_ClassificationModel115 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_org_feature_multi_perspective_classification_ClassificationModel129 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_parse_org_feature_multi_perspective_classification_ClassificationModel158 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_ClassificationModel188 = new BitSet(new long[]{0x0000000000260002L});
    public static final BitSet FOLLOW_17_in_parse_org_feature_multi_perspective_classification_ClassificationModel254 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_ClassificationModel284 = new BitSet(new long[]{0x0000000000260002L});
    public static final BitSet FOLLOW_parse_org_feature_multi_perspective_classification_Classification_in_parse_org_feature_multi_perspective_classification_ClassificationModel358 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parse_org_feature_multi_perspective_classification_Classification399 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUOTED_60_62_in_parse_org_feature_multi_perspective_classification_Classification417 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_org_feature_multi_perspective_classification_Classification438 = new BitSet(new long[]{0x0000000001400800L});
    public static final BitSet FOLLOW_24_in_parse_org_feature_multi_perspective_classification_Classification467 = new BitSet(new long[]{0x0000000000000880L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification514 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_COMMA_in_parse_org_feature_multi_perspective_classification_Classification595 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification668 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_22_in_parse_org_feature_multi_perspective_classification_Classification824 = new BitSet(new long[]{0x0000000000000880L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification871 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_COMMA_in_parse_org_feature_multi_perspective_classification_Classification952 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_Classification1025 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_parse_org_feature_multi_perspective_classification_Classification1180 = new BitSet(new long[]{0x0000000000012002L});
    public static final BitSet FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1203 = new BitSet(new long[]{0x0000000000012002L});
    public static final BitSet FOLLOW_13_in_parse_org_feature_multi_perspective_classification_Classification1238 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_parse_org_feature_multi_perspective_classification_Classification1258 = new BitSet(new long[]{0x0000000004010000L});
    public static final BitSet FOLLOW_parse_org_feature_multi_perspective_classification_ClassifiedFeature_in_parse_org_feature_multi_perspective_classification_Classification1291 = new BitSet(new long[]{0x0000000004010000L});
    public static final BitSet FOLLOW_26_in_parse_org_feature_multi_perspective_classification_Classification1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1383 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_QUOTED_34_34_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1405 = new BitSet(new long[]{0x0000000000809002L});
    public static final BitSet FOLLOW_23_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_parse_org_feature_multi_perspective_classification_ClassifiedFeature1477 = new BitSet(new long[]{0x0000000000000002L});

}