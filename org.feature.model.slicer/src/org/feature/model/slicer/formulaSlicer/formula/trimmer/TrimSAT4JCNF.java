package org.feature.model.slicer.formulaSlicer.formula.trimmer;

import java.util.HashSet;
import java.util.Set;

/**
 * Removes elements from a CNF that are already bound to a specific value
 * (1(ALIVE) or 0(DEAD)).
 * 
 * @author saller
 * 
 */
public class TrimSAT4JCNF {

	private Set<Set<String>> cnfTracker;

	public TrimSAT4JCNF() {
		cnfTracker = new HashSet<Set<String>>();
	}

	/**
	 * 
	 * @param cnf
	 *            Original CNF in a SAT4J compatible manner
	 * @param name
	 *            or od of the root feature, which will NOT be removed
	 * @param boundAlive
	 *            features that are classified as bound alive
	 * @param boundDead
	 *            features that are classified as bound dead
	 * @return Every element in a row in the Set-Matrix represents an
	 *         or-contraint, every row is concateneted with an and-constraint
	 */
	public Set<Set<String>> trimCnf(String cnf, String rootFeature,
			Set<String> boundAlive, Set<String> boundDead) {

		String[] andExpressions = cnf.split(" 0\n");

		// parse all rows
		for (String and : andExpressions) {
			String[] orExpressions = and.split(" ");
			Set<String> trimmedOr = new HashSet<String>();

			// skip empty constraints
			if (orExpressions.length == 0)
				continue;

			// remove last line-break '0' from the given cnf-format
			if (orExpressions[orExpressions.length - 1].equals("0"))
				orExpressions[orExpressions.length - 1] = "";

			// parse every entity in or-relation
			for (String or : orExpressions) {

				if (or.length() == 0)
					continue;

				if (or.equals(rootFeature) || or.equals("-" + rootFeature)) {
					trimmedOr.add(or);
					continue;
				}

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

		for (Set<String> andClause : cnfTracker) {
			for (String orClause : andClause) {
				resultCnf.append(orClause).append(" ");
			}
			resultCnf.append("0\n");
		}
		return resultCnf.toString();
	}

}
