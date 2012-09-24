package org.feature.model.slicer.formulaSlicer.formula.trimmer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Removes elements from a CNF that are already bound to a specific value
 * (1(ALIVE) or 0(DEAD)).
 * 
 * @author saller
 * 
 */
public class TrimSAT4JCNF {

	private List<List<String>> cnfTracker;

	public TrimSAT4JCNF() {
		cnfTracker = new ArrayList<List<String>>();
	}

	//TODO: really necessary?!
//	/**
//	 * Removes bound variables in the model via the CNF in a consistent manner
//	 * 
//	 * @param boundAlive
//	 *            set of bound alive feature names
//	 * @param boundDead
//	 *            set of bound dead feature names
//	 * @return true if cnf could be minimized
//	 * @throws ContradictionException
//	 */
//	public boolean trimCnf(Set<Feature> boundAlive, Set<Feature> boundDead)
//			throws ContradictionException {
//
//		SAT4JCNFFormulaFactory setFactory = new SAT4JCNFFormulaFactory();
//
//		String cnf = setFactory.createFormula(super.getBaseModel());
//		TrimSAT4JCNF trimCnf = new TrimSAT4JCNF();
//
//		Map<String, BoundedType> featureClassification = new HashMap<String, BoundedType>();
//
//		List<List<String>> trimedCnf = trimCnf.trimCnf(cnf,
//				featureClassification);
//
//		// initialize new solver and overwrite the old one
//		ISolver sf = SolverFactory.newDefault();
//		GateTranslator gt = new GateTranslator(sf);
//		problem.setGateTranslator(gt);
//
//		// Reduce the cnf and induce the new problem into the solver
//		for (List<String> andClause : trimedCnf) {
//			VecInt v = new VecInt();
//			for (String orClause : andClause) {
//				logger.debug("remove feature " + orClause + " from cnf solver");
//				if (orClause.startsWith("-")) {
//					String featureId = super.getBaseModel()
//							.getFeatureByName(orClause.replaceFirst("-", ""))
//							.getIdentifier();
//					v.push(-problem.getMapping(featureId));
//				} else {
//					String featureId = super.getBaseModel()
//							.getFeatureByName(orClause).getIdentifier();
//					v.push(problem.getMapping(featureId));
//				}
//			}
//			problem.getSolver().addClause(v);
//		}
//
//		// remove the dead and alive features from the remaining internal model
//		for (String aliveFeature : boundAlive) {
//			logger.debug("remove feature " + aliveFeature
//					+ " from internal model");
//			featureClassification.put(aliveFeature, BoundedType.ALIVE);
//			SCFeature toDelete = super.getBaseModel().getFeatureByName(
//					aliveFeature);
//			if (toDelete != null)
//				super.getBaseModel().remove(toDelete.getIdentifier());
//			problem.removeMapping(aliveFeature);
//		}
//
//		for (String deadFeature : boundDead) {
//			logger.debug("remove feature " + deadFeature
//					+ " from internal model");
//			featureClassification.put(deadFeature, BoundedType.DEAD);
//			SCFeature toDelete = super.getBaseModel().getFeatureByName(
//					deadFeature);
//			if (toDelete != null)
//				super.getBaseModel().remove(toDelete.getIdentifier());
//			problem.removeMapping(deadFeature);
//		}
//
//		return true;
//	}
	
	/**
	 * 
	 * @param cnf
	 *            Original CNF in a SAT4J compatible manner
	 * @param boundAlive features that are classified as bound alive
	 * @param boundDead features that are classified as bound dead
	 * @return Every element in a row in the Set-Matrix represents an
	 *         or-contraint, every row is concateneted with an and-constraint
	 */
	public List<List<String>> trimCnf(String cnf, Set<String> boundAlive, Set<String> boundDead) {

		String[] andExpressions = cnf.split(" 0\n");

		// parse all rows
		for (String and : andExpressions) {
			String[] orExpressions = and.split(" ");
			List<String> trimmedOr = new ArrayList<String>();
			
			//skip empty constraints
			if(orExpressions.length == 0)
				continue;
			
			//remove last line-break '0' from the given cnf-format
			if(orExpressions[orExpressions.length-1].equals("0"))
				orExpressions[orExpressions.length-1]="";

			// parse every entity in or-relation
			for (String or : orExpressions) {

				if(or.length() == 0)
					continue;
				
				String featureName = or.replaceFirst("^-", "");
				
				// if the feature is not classified, skip it
				if (!boundAlive.contains(featureName)
						&& !boundDead.contains(featureName)) {
					trimmedOr.add(or);
					continue;
				}

				// deal with negative entities
				if (or.startsWith("-")) {
					// negative alive-entity is removed from the equation
					if (boundAlive.contains(featureName)) {
						// Do nothing
					}
					// negative dead-entity, the whole or-relation is removed
					else if (boundDead.contains(featureName)) {
						trimmedOr.clear();
						break;
					} else {
						trimmedOr.add(or);
					}
				}
				// deal with positive entities
				else {
					// positive alive-entity, the whole equation is removed
					if (boundAlive.contains(featureName)) {
						trimmedOr.clear();
						break;
					}
					// positive dead-entity, entity is removed from or-relation
					else if (boundDead.contains(featureName)) {
						// Do nothing
					} else {
						trimmedOr.add(or);
					}
				}
			}

			
			// check for empty or redundant entries
			if (trimmedOr.size() > 0 && !cnfTracker.contains(trimmedOr))
				cnfTracker.add(trimmedOr);
		}

		return cnfTracker;
	}

	/**
	 * 
	 * @return CNF in a SAT4J compatible String
	 */
	public String getCnfString() {
		StringBuffer resultCnf = new StringBuffer();

		for (List<String> andClause : cnfTracker) {
			for (String orClause : andClause) {
				resultCnf.append(orClause).append(" ");
			}
			resultCnf.append("0\n");
		}
		return resultCnf.toString();
	}

}
