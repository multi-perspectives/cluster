grammar Csl;

options {
	superClass = CslANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.feature.model.constraint.resource.csl.mopp;
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
	package org.feature.model.constraint.resource.csl.mopp;
}

@members{
	private org.feature.model.constraint.resource.csl.ICslTokenResolverFactory tokenResolverFactory = new org.feature.model.constraint.resource.csl.mopp.CslTokenResolverFactory();
	
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
	private java.util.List<org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal> expectedElements = new java.util.ArrayList<org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal>();
	
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
		postParseCommands.add(new org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>() {
			public boolean execute(org.feature.model.constraint.resource.csl.ICslTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.feature.model.constraint.resource.csl.ICslProblem() {
					public org.feature.model.constraint.resource.csl.CslEProblemSeverity getSeverity() {
						return org.feature.model.constraint.resource.csl.CslEProblemSeverity.ERROR;
					}
					public org.feature.model.constraint.resource.csl.CslEProblemType getType() {
						return org.feature.model.constraint.resource.csl.CslEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.feature.model.constraint.resource.csl.ICslQuickFix> getQuickFixes() {
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
		org.feature.model.constraint.resource.csl.ICslExpectedElement terminal = org.feature.model.constraint.resource.csl.grammar.CslFollowSetProvider.TERMINALS[terminalID];
		org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[] containmentFeatures = new org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.feature.model.constraint.resource.csl.grammar.CslFollowSetProvider.LINKS[ids[i]];
		}
		org.feature.model.constraint.resource.csl.grammar.CslContainmentTrace containmentTrace = new org.feature.model.constraint.resource.csl.grammar.CslContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal expectedElement = new org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		postParseCommands.add(new org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>() {
			public boolean execute(org.feature.model.constraint.resource.csl.ICslTextResource resource) {
				org.feature.model.constraint.resource.csl.ICslLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>() {
			public boolean execute(org.feature.model.constraint.resource.csl.ICslTextResource resource) {
				org.feature.model.constraint.resource.csl.ICslLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>() {
			public boolean execute(org.feature.model.constraint.resource.csl.ICslTextResource resource) {
				org.feature.model.constraint.resource.csl.ICslLocationMap locationMap = resource.getLocationMap();
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
	
	public org.feature.model.constraint.resource.csl.ICslTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new CslParser(new org.antlr.runtime3_4_0.CommonTokenStream(new CslLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new CslParser(new org.antlr.runtime3_4_0.CommonTokenStream(new CslLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new org.feature.model.constraint.resource.csl.util.CslRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public CslParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((CslLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((CslLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.feature.model.constraint.Constraint.class) {
				return parse_org_feature_model_constraint_Constraint();
			}
			if (type.getInstanceClass() == org.feature.model.constraint.Require.class) {
				return parse_org_feature_model_constraint_Require();
			}
			if (type.getInstanceClass() == org.feature.model.constraint.Exclude.class) {
				return parse_org_feature_model_constraint_Exclude();
			}
		}
		throw new org.feature.model.constraint.resource.csl.mopp.CslUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(org.feature.model.constraint.resource.csl.ICslOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.feature.model.constraint.resource.csl.ICslParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource>>();
		org.feature.model.constraint.resource.csl.mopp.CslParseResult parseResult = new org.feature.model.constraint.resource.csl.mopp.CslParseResult();
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
	
	public java.util.List<org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.feature.model.constraint.resource.csl.ICslTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.feature.model.constraint.resource.csl.ICslParseResult result = parse();
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
			for (org.feature.model.constraint.resource.csl.ICslCommand<org.feature.model.constraint.resource.csl.ICslTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal>();
		java.util.List<org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal> newFollowSet = new java.util.ArrayList<org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 8;
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
				for (org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.feature.model.constraint.resource.csl.util.CslPair<org.feature.model.constraint.resource.csl.ICslExpectedElement, org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.feature.model.constraint.resource.csl.util.CslPair<org.feature.model.constraint.resource.csl.ICslExpectedElement, org.feature.model.constraint.resource.csl.mopp.CslContainedFeature[]> newFollowerPair : newFollowers) {
							org.feature.model.constraint.resource.csl.ICslExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.feature.model.constraint.resource.csl.grammar.CslContainmentTrace containmentTrace = new org.feature.model.constraint.resource.csl.grammar.CslContainmentTrace(null, newFollowerPair.getRight());
							org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal newFollowTerminal = new org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.feature.model.constraint.resource.csl.mopp.CslExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getConstraint(), org.feature.model.constraint.resource.csl.mopp.CslExpectationConstants.EXPECTATIONS[0]);
		addExpectedElement(org.feature.model.constraint.ConstraintPackage.eINSTANCE.getConstraint(), org.feature.model.constraint.resource.csl.mopp.CslExpectationConstants.EXPECTATIONS[1]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_feature_model_constraint_Constraint{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_feature_model_constraint_Constraint returns [org.feature.model.constraint.Constraint element = null]
@init{
}
:
	(
		a0_0 = parse_org_feature_model_constraint_FeatureExpression		{
			if (terminateParsing) {
				throw new org.feature.model.constraint.resource.csl.mopp.CslTerminateParsingException();
			}
			if (element == null) {
				element = org.feature.model.constraint.ConstraintFactory.eINSTANCE.createConstraint();
				startIncompleteElement(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.CONSTRAINT__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_0_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_feature_model_constraint_Require returns [org.feature.model.constraint.Require element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.feature.model.constraint.resource.csl.mopp.CslTerminateParsingException();
			}
			if (element == null) {
				element = org.feature.model.constraint.ConstraintFactory.eINSTANCE.createRequire();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.feature.model.constraint.resource.csl.ICslTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.feature.model.constraint.resource.csl.ICslTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__LEFT_FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.featuremapper.models.feature.Feature proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.feature.model.constraint.resource.csl.mopp.CslContextDependentURIFragmentFactory<org.feature.model.constraint.FeatureExpression, org.featuremapper.models.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureExpressionLeftFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__LEFT_FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__LEFT_FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_1_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.model.constraint.resource.csl.mopp.CslExpectationConstants.EXPECTATIONS[2]);
	}
	
	a1 = 'requires' {
		if (element == null) {
			element = org.feature.model.constraint.ConstraintFactory.eINSTANCE.createRequire();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_1_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.model.constraint.resource.csl.mopp.CslExpectationConstants.EXPECTATIONS[3]);
	}
	
	(
		a2 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.feature.model.constraint.resource.csl.mopp.CslTerminateParsingException();
			}
			if (element == null) {
				element = org.feature.model.constraint.ConstraintFactory.eINSTANCE.createRequire();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.feature.model.constraint.resource.csl.ICslTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.feature.model.constraint.resource.csl.ICslTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__RIGHT_FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.featuremapper.models.feature.Feature proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.feature.model.constraint.resource.csl.mopp.CslContextDependentURIFragmentFactory<org.feature.model.constraint.FeatureExpression, org.featuremapper.models.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureExpressionRightFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__RIGHT_FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__RIGHT_FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_1_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_feature_model_constraint_Exclude returns [org.feature.model.constraint.Exclude element = null]
@init{
}
:
	(
		a0 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.feature.model.constraint.resource.csl.mopp.CslTerminateParsingException();
			}
			if (element == null) {
				element = org.feature.model.constraint.ConstraintFactory.eINSTANCE.createExclude();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.feature.model.constraint.resource.csl.ICslTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.feature.model.constraint.resource.csl.ICslTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__LEFT_FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.featuremapper.models.feature.Feature proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.feature.model.constraint.resource.csl.mopp.CslContextDependentURIFragmentFactory<org.feature.model.constraint.FeatureExpression, org.featuremapper.models.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureExpressionLeftFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__LEFT_FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__LEFT_FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_2_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.model.constraint.resource.csl.mopp.CslExpectationConstants.EXPECTATIONS[4]);
	}
	
	a1 = 'excludes' {
		if (element == null) {
			element = org.feature.model.constraint.ConstraintFactory.eINSTANCE.createExclude();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.model.constraint.resource.csl.mopp.CslExpectationConstants.EXPECTATIONS[5]);
	}
	
	(
		a2 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.feature.model.constraint.resource.csl.mopp.CslTerminateParsingException();
			}
			if (element == null) {
				element = org.feature.model.constraint.ConstraintFactory.eINSTANCE.createExclude();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.feature.model.constraint.resource.csl.ICslTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.feature.model.constraint.resource.csl.ICslTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__RIGHT_FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.featuremapper.models.feature.Feature proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.feature.model.constraint.resource.csl.mopp.CslContextDependentURIFragmentFactory<org.feature.model.constraint.FeatureExpression, org.featuremapper.models.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureExpressionRightFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__RIGHT_FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__RIGHT_FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.feature.model.constraint.resource.csl.grammar.CslGrammarInformationProvider.CSL_2_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_feature_model_constraint_FeatureExpression returns [org.feature.model.constraint.FeatureExpression element = null]
:
	c0 = parse_org_feature_model_constraint_Require{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_feature_model_constraint_Exclude{ element = c1; /* this is a subclass or primitive expression choice */ }
	
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
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

