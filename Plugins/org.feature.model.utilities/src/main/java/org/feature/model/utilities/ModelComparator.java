package org.feature.model.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;

/**
 * compare to models
 * 
 * 
 * @author Ingo Reimund
 * 
 */
public class ModelComparator {

	/**
	 * use MatchService and DiffModel to compare to model
	 * 
	 * @param object1
	 *            first object to compare
	 * @param object2
	 *            second object to compare
	 * @return true if both object equals else false
	 * @throws InterruptedException
	 */
	public boolean diff(EObject object1, EObject object2) throws InterruptedException {
		MatchModel match = MatchService.doMatch(object1, object2, new HashMap<String, Object>());
		DiffModel diff = DiffService.doDiff(match);
		return diff.getDifferences().isEmpty();
	}
	
	/**
	 * use MatchService and DiffModel to compare to model
	 * 
	 * @param object1
	 *            first object to compare
	 * @param object2
	 *            second object to compare
	 * @return true if both object equals else false
	 * @throws InterruptedException
	 */
	public boolean unorderdDiff(EObject object1, EObject object2) throws InterruptedException {
		MatchModel match = MatchService.doMatch(object1, object2, new HashMap<String, Object>());
		List<UnmatchElement> remaining = new ArrayList<>(match.getUnmatchedElements());
		while (!remaining.isEmpty() && remaining.size() % 2 == 0) {
			UnmatchElement toFind = remaining.remove(0);
			for (UnmatchElement element : remaining) {
				if (element.getElement().toString().equals(toFind.getElement().toString())) {
					remaining.remove(element);
					break;
				}

			}
		}
		return match.getUnmatchedElements().isEmpty();
	}
}