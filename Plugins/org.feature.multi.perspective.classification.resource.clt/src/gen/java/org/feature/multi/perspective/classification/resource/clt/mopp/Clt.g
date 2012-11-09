grammar Clt;

options {
	superClass = CltANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.feature.multi.perspective.classification.resource.clt.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.feature.multi.perspective.classification.resource.clt.mopp;
}

@members{
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
		int followSetID = 27;
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_feature_multi_perspective_classification_ClassificationModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_feature_multi_perspective_classification_ClassificationModel returns [org.feature.multi.perspective.classification.ClassificationModel element = null]
@init{
}
:
	a0 = 'classification' {
		if (element == null) {
			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = 'references' {
		if (element == null) {
			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[3]);
	}
	
	(
		(
			(
				a2 = 'mapping' {
					if (element == null) {
						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_0_0_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[4]);
				}
				
				(
					a3 = QUOTED_60_62					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[5]);
					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[6]);
					addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[7]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[8]);
				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[9]);
				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[10]);
			}
			
			
			|			(
				a4 = 'featuremodel' {
					if (element == null) {
						element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassificationModel();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_0_0_0_4_0_1_0_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[11]);
				}
				
				(
					a5 = QUOTED_60_62					
					{
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
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[12]);
					addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[13]);
					addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[14]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[15]);
				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[17]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[20]);
	}
	
	(
		(
			a6_0 = parse_org_feature_multi_perspective_classification_Classification			{
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
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[21]);
	}
	
;

parse_org_feature_multi_perspective_classification_Classification returns [org.feature.multi.perspective.classification.Classification element = null]
@init{
}
:
	a0 = 'stage' {
		if (element == null) {
			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[22]);
	}
	
	(
		a1 = QUOTED_60_62		
		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[23]);
	}
	
	a2 = 'on' {
		if (element == null) {
			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[24]);
	}
	
	a3 = 'view' {
		if (element == null) {
			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[25]);
	}
	
	(
		a4 = QUOTED_34_34		
		{
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
				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_7, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[26]);
	}
	
	a5 = ':' {
		if (element == null) {
			element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[28]);
		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[29]);
	}
	
	(
		(
			a6_0 = parse_org_feature_multi_perspective_classification_ClassifiedFeature			{
				if (terminateParsing) {
					throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
				}
				if (element == null) {
					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
					startIncompleteElement(element);
				}
				if (a6_0 != null) {
					if (a6_0 != null) {
						Object value = a6_0;
						addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_11, a6_0, true);
					copyLocalizationInfos(a6_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[30]);
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[32]);
	}
	
	(
		(
			a7 = 'autocomplete' {
				if (element == null) {
					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_12_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[33]);
			}
			
			a8 = '{' {
				if (element == null) {
					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_12_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[34]);
				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[35]);
			}
			
			(
				(
					a9_0 = parse_org_feature_multi_perspective_classification_ClassifiedFeature					{
						if (terminateParsing) {
							throw new org.feature.multi.perspective.classification.resource.clt.mopp.CltTerminateParsingException();
						}
						if (element == null) {
							element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
							startIncompleteElement(element);
						}
						if (a9_0 != null) {
							if (a9_0 != null) {
								Object value = a9_0;
								addObjectToList(element, org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_12_0_0_5, a9_0, true);
							copyLocalizationInfos(a9_0, element);
						}
					}
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[36]);
				addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[37]);
			}
			
			a10 = '}' {
				if (element == null) {
					element = org.feature.multi.perspective.classification.ClassificationFactory.eINSTANCE.createClassification();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.feature.multi.perspective.classification.resource.clt.grammar.CltGrammarInformationProvider.CLT_1_0_0_12_0_0_7, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[38]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[39]);
	}
	
;

parse_org_feature_multi_perspective_classification_ClassifiedFeature returns [org.feature.multi.perspective.classification.ClassifiedFeature element = null]
@init{
}
:
	(
		a0 = 'feature' {
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
		{
			// expected elements (follow set)
			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[40]);
		}
		
		(
			a1 = QUOTED_34_34			
			{
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
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[41]);
		}
		
		(
			(
				a2 = 'unbound' {
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
				|				a3 = 'dead' {
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
				|				a4 = 'alive' {
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
			)?		)
		{
			// expected elements (follow set)
			addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[42]);
			addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[43]);
			addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[44]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassification(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[45]);
		addExpectedElement(null, org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(org.feature.multi.perspective.classification.ClassificationPackage.eINSTANCE.getClassificationModel(), org.feature.multi.perspective.classification.resource.clt.mopp.CltExpectationConstants.EXPECTATIONS[47]);
	}
	
;

TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
	{ _channel = 99; }
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
QUOTED_60_62:
	(('<')(~('>'))*('>'))
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

