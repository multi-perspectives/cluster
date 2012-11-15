/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.model.constraint.resource.csl.mopp;

public class CslPrinter implements org.feature.model.constraint.resource.csl.ICslTextPrinter {
	
	protected org.feature.model.constraint.resource.csl.ICslTokenResolverFactory tokenResolverFactory = new org.feature.model.constraint.resource.csl.mopp.CslTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.feature.model.constraint.resource.csl.ICslTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public CslPrinter(java.io.OutputStream outputStream, org.feature.model.constraint.resource.csl.ICslTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.feature.model.constraint.Constraint) {
			print_org_feature_model_constraint_Constraint((org.feature.model.constraint.Constraint) element, globaltab, out);
			return;
		}
		if (element instanceof org.feature.model.constraint.Require) {
			print_org_feature_model_constraint_Require((org.feature.model.constraint.Require) element, globaltab, out);
			return;
		}
		if (element instanceof org.feature.model.constraint.Exclude) {
			print_org_feature_model_constraint_Exclude((org.feature.model.constraint.Exclude) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.feature.model.constraint.resource.csl.mopp.CslReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.feature.model.constraint.resource.csl.mopp.CslReferenceResolverSwitch) new org.feature.model.constraint.resource.csl.mopp.CslMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.feature.model.constraint.resource.csl.ICslTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.feature.model.constraint.resource.csl.mopp.CslProblem(errorMessage, org.feature.model.constraint.resource.csl.CslEProblemType.PRINT_PROBLEM, org.feature.model.constraint.resource.csl.CslEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public org.feature.model.constraint.resource.csl.ICslTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_org_feature_model_constraint_Constraint(org.feature.model.constraint.Constraint element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.CONSTRAINT__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.CONSTRAINT__EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expression", count - 1);
		}
	}
	
	
	public void print_org_feature_model_constraint_Require(org.feature.model.constraint.Require element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__LEFT_FEATURE));
		printCountingMap.put("leftFeature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__RIGHT_FEATURE));
		printCountingMap.put("rightFeature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("leftFeature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__LEFT_FEATURE));
			if (o != null) {
				org.feature.model.constraint.resource.csl.ICslTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureExpressionLeftFeatureReferenceResolver().deResolve((org.featuremapper.models.feature.Feature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__LEFT_FEATURE)), element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__LEFT_FEATURE), element));
			}
			printCountingMap.put("leftFeature", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("requires");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("rightFeature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__RIGHT_FEATURE));
			if (o != null) {
				org.feature.model.constraint.resource.csl.ICslTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureExpressionRightFeatureReferenceResolver().deResolve((org.featuremapper.models.feature.Feature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__RIGHT_FEATURE)), element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.REQUIRE__RIGHT_FEATURE), element));
				out.print(" ");
			}
			printCountingMap.put("rightFeature", count - 1);
		}
	}
	
	
	public void print_org_feature_model_constraint_Exclude(org.feature.model.constraint.Exclude element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__LEFT_FEATURE));
		printCountingMap.put("leftFeature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__RIGHT_FEATURE));
		printCountingMap.put("rightFeature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("leftFeature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__LEFT_FEATURE));
			if (o != null) {
				org.feature.model.constraint.resource.csl.ICslTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureExpressionLeftFeatureReferenceResolver().deResolve((org.featuremapper.models.feature.Feature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__LEFT_FEATURE)), element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__LEFT_FEATURE), element));
			}
			printCountingMap.put("leftFeature", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("excludes");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("rightFeature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__RIGHT_FEATURE));
			if (o != null) {
				org.feature.model.constraint.resource.csl.ICslTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureExpressionRightFeatureReferenceResolver().deResolve((org.featuremapper.models.feature.Feature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__RIGHT_FEATURE)), element.eClass().getEStructuralFeature(org.feature.model.constraint.ConstraintPackage.EXCLUDE__RIGHT_FEATURE), element));
				out.print(" ");
			}
			printCountingMap.put("rightFeature", count - 1);
		}
	}
	
	
}
