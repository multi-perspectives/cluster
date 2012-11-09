/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.classification.resource.clt.mopp;

public class CltPrinter implements org.feature.multi.perspective.classification.resource.clt.ICltTextPrinter {
	
	protected org.feature.multi.perspective.classification.resource.clt.ICltTokenResolverFactory tokenResolverFactory = new org.feature.multi.perspective.classification.resource.clt.mopp.CltTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.feature.multi.perspective.classification.resource.clt.ICltTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public CltPrinter(java.io.OutputStream outputStream, org.feature.multi.perspective.classification.resource.clt.ICltTextResource resource) {
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
		
		if (element instanceof org.feature.multi.perspective.classification.ClassificationModel) {
			print_org_feature_multi_perspective_classification_ClassificationModel((org.feature.multi.perspective.classification.ClassificationModel) element, globaltab, out);
			return;
		}
		if (element instanceof org.feature.multi.perspective.classification.Classification) {
			print_org_feature_multi_perspective_classification_Classification((org.feature.multi.perspective.classification.Classification) element, globaltab, out);
			return;
		}
		if (element instanceof org.feature.multi.perspective.classification.ClassifiedFeature) {
			print_org_feature_multi_perspective_classification_ClassifiedFeature((org.feature.multi.perspective.classification.ClassifiedFeature) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected org.feature.multi.perspective.classification.resource.clt.mopp.CltReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.feature.multi.perspective.classification.resource.clt.mopp.CltReferenceResolverSwitch) new org.feature.multi.perspective.classification.resource.clt.mopp.CltMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.feature.multi.perspective.classification.resource.clt.ICltTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.feature.multi.perspective.classification.resource.clt.mopp.CltProblem(errorMessage, org.feature.multi.perspective.classification.resource.clt.CltEProblemType.PRINT_PROBLEM, org.feature.multi.perspective.classification.resource.clt.CltEProblemSeverity.WARNING), cause);
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
	
	public org.feature.multi.perspective.classification.resource.clt.ICltTextResource getResource() {
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
	
	public void print_org_feature_multi_perspective_classification_ClassificationModel(org.feature.multi.perspective.classification.ClassificationModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL));
		printCountingMap.put("featureModel", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS));
		printCountingMap.put("classifications", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING));
		printCountingMap.put("viewMapping", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("classification");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("references");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_feature_multi_perspective_classification_ClassificationModel_0(element, localtab, out, printCountingMap);
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_org_feature_multi_perspective_classification_ClassificationModel_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("classifications");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__CLASSIFICATIONS));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("classifications", 0);
		}
	}
	
	public void print_org_feature_multi_perspective_classification_ClassificationModel_0(org.feature.multi.perspective.classification.ClassificationModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"viewMapping"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"featureModel"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_org_feature_multi_perspective_classification_ClassificationModel_0_1(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (CompoundDefinition)
			print_org_feature_multi_perspective_classification_ClassificationModel_0_0(element, localtab, out, printCountingMap);
		}
	}
	
	public void print_org_feature_multi_perspective_classification_ClassificationModel_0_0(org.feature.multi.perspective.classification.ClassificationModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("mapping");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("viewMapping");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING));
			if (o != null) {
				org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationModelViewMappingReferenceResolver().deResolve((org.feature.multi.perspective.mapping.viewmapping.MappingModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING)), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__VIEW_MAPPING), element));
				out.print(" ");
			}
			printCountingMap.put("viewMapping", count - 1);
		}
	}
	
	public void print_org_feature_multi_perspective_classification_ClassificationModel_0_1(org.feature.multi.perspective.classification.ClassificationModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("featuremodel");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("featureModel");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL));
			if (o != null) {
				org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationModelFeatureModelReferenceResolver().deResolve((org.featuremapper.models.feature.FeatureModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL)), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION_MODEL__FEATURE_MODEL), element));
				out.print(" ");
			}
			printCountingMap.put("featureModel", count - 1);
		}
	}
	
	
	public void print_org_feature_multi_perspective_classification_Classification(org.feature.multi.perspective.classification.Classification element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS));
		printCountingMap.put("viewgroups", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES));
		printCountingMap.put("classifiedFeatures", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES));
		printCountingMap.put("autoCompleteFeatures", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__UNBOUND_FEATURES));
		printCountingMap.put("unboundFeatures", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ALIVE_FEATURES));
		printCountingMap.put("aliveFeatures", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__DEAD_FEATURES));
		printCountingMap.put("deadFeatures", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("stage");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ID));
			if (o != null) {
				org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__ID), element));
			}
			printCountingMap.put("id", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("on");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("view");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("viewgroups");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassificationViewgroupsReferenceResolver().deResolve((org.feature.multi.perspective.model.viewmodel.AbstractGroup) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS)), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__VIEWGROUPS), element));
			}
			printCountingMap.put("viewgroups", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("classifiedFeatures");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__CLASSIFIED_FEATURES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("classifiedFeatures", 0);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_org_feature_multi_perspective_classification_Classification_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_org_feature_multi_perspective_classification_Classification_0(org.feature.multi.perspective.classification.Classification element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print("   ");
		// DEFINITION PART BEGINS (CsString)
		out.print("autocomplete");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("autoCompleteFeatures");
		if (count > 0) {
			java.util.List<?> list = (java.util.List<?>)element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFICATION__AUTO_COMPLETE_FEATURES));
			int index  = list.size() - count;
			if (index < 0) {
				index = 0;
			}
			java.util.ListIterator<?> it  = list.listIterator(index);
			while (it.hasNext()) {
				Object o = it.next();
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("autoCompleteFeatures", 0);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print("   ");
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	
	public void print_org_feature_multi_perspective_classification_ClassifiedFeature(org.feature.multi.perspective.classification.ClassifiedFeature element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED));
		printCountingMap.put("classified", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_org_feature_multi_perspective_classification_ClassifiedFeature_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_org_feature_multi_perspective_classification_ClassifiedFeature_0(org.feature.multi.perspective.classification.ClassifiedFeature element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print("   ");
		// DEFINITION PART BEGINS (CsString)
		out.print("feature");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__FEATURE));
			if (o != null) {
				org.feature.multi.perspective.classification.resource.clt.ICltTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getClassifiedFeatureFeatureReferenceResolver().deResolve((org.featuremapper.models.feature.Feature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__FEATURE)), element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__FEATURE), element));
			}
			printCountingMap.put("feature", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("classified");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.classification.ClassificationPackage.CLASSIFIED_FEATURE__CLASSIFIED));
			if (o != null) {
			}
			printCountingMap.put("classified", count - 1);
		}
	}
	
	
}
