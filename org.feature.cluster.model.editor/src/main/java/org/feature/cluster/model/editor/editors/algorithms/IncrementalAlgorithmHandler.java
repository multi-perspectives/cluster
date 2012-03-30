/**
 * 
 */
package org.feature.cluster.model.editor.editors.algorithms;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.feature.cluster.model.cluster.GroupModel;
import org.feature.cluster.model.editor.editors.MultiPageEditor;
import org.feature.cluster.model.editor.editors.View;
import org.feature.cluster.model.editor.editors.ViewCreater;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.featuremapping.FeatureMappingModel;
import org.featuremapper.models.featuremapping.Mapping;
import org.featuremapper.models.featuremapping.SolutionModelRef;

/**
 * Handler of the Incremental Algorithm
 * @author Tim Winkelmann
 *
 */
public class IncrementalAlgorithmHandler extends AbstractHandler{
	public static MultiPageEditor multiPageEditor;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EList<EObject> contents = multiPageEditor.getMappingResource().getContents();
		FeatureMappingModel featureMappingModel = null;
		for (EObject eObject : contents) {
			if (eObject instanceof FeatureMappingModel) {
				featureMappingModel = (FeatureMappingModel) eObject;
				break;
			}
		}
		EList<SolutionModelRef> solutionModels = featureMappingModel.getSolutionModels();
		GroupModel groupModel = null;
		for (SolutionModelRef solutionModelRef : solutionModels) {
			EObject value = solutionModelRef.getValue();
			if (value instanceof GroupModel) {
				groupModel = (GroupModel) value;
				break;
			}
		}
		EList<Feature> allFeatures = featureMappingModel.getFeatureModel().getValue().getAllFeatures();
		EList<Mapping> mappings = featureMappingModel.getMappings();
		
		List<View> views = new ViewCreater(allFeatures, mappings, groupModel.getCoreGroup(),featureMappingModel.getFeatureModel().getValue()).getViews();
		new IncrementalAlgorithm(views, groupModel,featureMappingModel.getFeatureModel().getValue());
		return null; // No return value needed.
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		boolean a = super.isEnabled() ;
		boolean b = multiPageEditor != null && multiPageEditor.getMappingResource() != null;
		return a & b;
	}
}
