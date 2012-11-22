package org.feature.model.sat.solver;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.sat4j.core.Vec;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.GateTranslator;

/**
 * Test sat4j solver factory
 * 
 * @author Ingo Reimund
 * 
 */
public class SolverFactoryTest {

	private GateTranslator solver;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		solver = new GateTranslator(SolverFactory.newDefault());
	}

	@Test
	public void testRoot() throws ContradictionException, TimeoutException {
		solver.gateTrue(1);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(1);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-1);
		assertFalse(solver.isSatisfiable(bound));
	}

	@Test
	public void testOptional() throws ContradictionException, TimeoutException {
		solver.gateTrue(1);

		// 2 -> 1
		VecInt clause = new VecInt();
		clause.push(1);
		clause.push(-2);
		solver.addClause(clause);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		assertTrue(solver.isSatisfiable(bound));

		Set<Integer> satisfiedModel = new HashSet<>();
		for (int i : solver.model()) {
			satisfiedModel.add(new Integer(i));
		}
		CNFConverter converter = new CNFConverter();
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(1)));
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(-2)));
	}

	@Test
	public void testOptional2() throws ContradictionException, TimeoutException {
		solver.gateTrue(1);
		// 2 -> 1
		VecInt clause = new VecInt();
		clause.push(2);
		solver.halfOr(1, clause);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		assertTrue(solver.isSatisfiable(bound));

		Set<Integer> satisfiedModel = new HashSet<>();
		for (int i : solver.model()) {
			satisfiedModel.add(new Integer(i));
		}
		CNFConverter converter = new CNFConverter();
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(1)));
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(-2)));
	}

	@Test
	public void testOptionalWithOr() throws ContradictionException,
			TimeoutException {
		solver.gateTrue(1);
		// 1 <- 2
		VecInt clause = new VecInt();
		clause.push(2);
		solver.halfOr(1, clause);

		// 1 2 v 3
		clause = new VecInt();
		clause.push(3);
		clause.push(4);
		solver.halfOr(2, clause);
		clause.push(-2);
		solver.addAtLeast(clause, 1);

		VecInt bound = new VecInt();
		bound.push(3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-3);
		bound.push(-4);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(4);
		assertTrue(solver.isSatisfiable(bound));

		Set<Integer> satisfiedModel = new HashSet<>();
		for (int i : solver.model()) {
			satisfiedModel.add(new Integer(i));
		}
		CNFConverter converter = new CNFConverter();
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(4)));
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(1)));
	}

	@Test
	public void testMandatoryAndOptionalWithOr() throws ContradictionException,
			TimeoutException {
		solver.gateTrue(1);

		// 2 <-> 1
		VecInt clause = new VecInt();
		clause.push(2);
		solver.and(1, clause);

		// 1 <- 2
		clause = new VecInt();
		clause.push(3);
		solver.halfOr(1, clause);

		// 1 2 v 3
		clause = new VecInt();
		clause.push(4);
		clause.push(5);
		solver.halfOr(3, clause);
		clause.push(-3);
		solver.addAtLeast(clause, 1);

		VecInt bound = new VecInt();
		bound.push(4);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-4);
		bound.push(-5);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(4);
		assertTrue(solver.isSatisfiable(bound));

		Set<Integer> satisfiedModel = new HashSet<>();
		for (int i : solver.model()) {
			satisfiedModel.add(new Integer(i));
		}
		CNFConverter converter = new CNFConverter();
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(4)));
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(1)));
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(2)));
	}

	@Test
	public void testOr() throws ContradictionException, TimeoutException {
		solver.gateTrue(1);

		// 1 <- 2 v 3
		VecInt clause = new VecInt();
		clause.push(1);
		clause.push(-2);
		solver.addClause(clause);
		clause = new VecInt();
		clause.push(1);
		clause.push(-3);
		solver.addClause(clause);

		clause = new VecInt();
		clause.push(2);
		clause.push(3);
		clause.push(-1);
		solver.addClause(clause);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		bound.push(-3);
		assertFalse(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-3);
		assertTrue(solver.isSatisfiable(bound));

		Set<Integer> satisfiedModel = new HashSet<>();
		for (int i : solver.model()) {
			satisfiedModel.add(new Integer(i));
		}
		CNFConverter converter = new CNFConverter();
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(1)));
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(2)));
	}

	@Test
	public void testOr2() throws ContradictionException, TimeoutException {
		solver.gateTrue(1);

		// 1 <- 2 v 3
		VecInt clause = new VecInt();
		clause.push(2);
		clause.push(3);
		solver.halfOr(1, clause);
		clause.push(-1);
		solver.addAtLeast(clause, 1);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		bound.push(-3);
		assertFalse(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-3);
		assertTrue(solver.isSatisfiable(bound));

		Set<Integer> satisfiedModel = new HashSet<>();
		for (int i : solver.model()) {
			satisfiedModel.add(new Integer(i));
		}
		CNFConverter converter = new CNFConverter();
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(1)));
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(2)));
	}

	@Test
	public void testAlternative() throws ContradictionException,
			TimeoutException {
		solver.gateTrue(1);

		// Add Imply constraint to parent feature
		VecInt clause = new VecInt();
		clause.push(1);
		clause.push(-2);
		solver.addClause(clause);
		clause = new VecInt();
		clause.push(1);
		clause.push(-3);
		solver.addClause(clause);

		clause = new VecInt();
		clause.push(2);
		clause.push(3);
		clause.push(-1);
		solver.addAtLeast(clause, 1);
		solver.addAtMost(clause, 1);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		bound.push(-3);
		assertFalse(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(2);
		bound.push(3);
		assertFalse(solver.isSatisfiable(bound));
	}

	@Test
	public void testAlternative2() throws ContradictionException,
			TimeoutException {
		solver.gateTrue(1);

		// 1 ->
		VecInt clause = new VecInt();
		clause.push(2);
		clause.push(3);

		// Add Imply constraint to parent feature
		solver.halfOr(1, clause);

		clause.push(-1);
		solver.addAtLeast(clause, 1);
		solver.addAtMost(clause, 1);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		bound.push(-3);
		assertFalse(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(2);
		bound.push(3);
		assertFalse(solver.isSatisfiable(bound));
	}

	@Test
	public void testMandatory() throws ContradictionException, TimeoutException {
		// 2 <-> 1
		VecInt clause = new VecInt();
		clause.push(1);
		clause.push(-2);
		solver.addClause(clause);

		// 1 -> 2
		clause = new VecInt();
		clause.push(-1);
		clause.push(2);
		solver.addClause(clause);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		assertTrue(solver.isSatisfiable(bound));
	}

	@Test
	public void testMandatory2() throws ContradictionException,
			TimeoutException {
		// 2 <-> 1
		VecInt clause = new VecInt();
		clause.push(2);
		solver.and(1, clause);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(2);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		assertTrue(solver.isSatisfiable(bound));
	}

	/**
	 * test simple phone small
	 * 
	 * @throws ContradictionException
	 * @throws TimeoutException
	 */
	@Test
	public void testSimplePhoneSATSmall() throws ContradictionException,
			TimeoutException {
		Vec<IVecInt> conditions = new Vec<>();
		// SmallFeaturePhone (1)
		VecInt clause0 = new VecInt();
		clause0.push(1);
		conditions.push(clause0);
		solver.addClause(clause0);

		// Message (2)
		VecInt clause1 = new VecInt();
		clause1.push(1);
		clause1.push(-2);
		conditions.push(clause1);
		solver.addClause(clause1);

		VecInt clause2 = new VecInt();
		clause2.push(2);
		clause2.push(-1);
		conditions.push(clause2);
		solver.addClause(clause2);

		// SMS (3)
		VecInt clause3 = new VecInt();
		clause3.push(3);
		clause3.push(-2);
		conditions.push(clause3);
		solver.addClause(clause3);

		VecInt clause8 = new VecInt();
		clause8.push(2);
		clause8.push(-3);
		conditions.push(clause8);
		solver.addClause(clause8);

		// Extras (4)
		VecInt clause4 = new VecInt();
		clause4.push(-4);
		clause4.push(1);
		conditions.push(clause4);
		solver.addClause(clause4);

		// MP3 (5) v Camera (6)
		VecInt clause5 = new VecInt();
		clause5.push(-5);
		clause5.push(4);
		conditions.push(clause5);
		solver.addClause(clause5);

		VecInt clause6 = new VecInt();
		clause6.push(-6);
		clause6.push(4);
		conditions.push(clause6);
		solver.addClause(clause6);

		VecInt clause7 = new VecInt();
		clause7.push(5);
		clause7.push(6);
		clause7.push(-4);
		conditions.push(clause7);
		solver.addAtLeast(clause7, 1);

		assertTrue(solver.isSatisfiable());

		VecInt bound1 = new VecInt();
		bound1.push(3);
		assertNotNull(solver.findModel(bound1));

		VecInt bound2 = new VecInt();
		bound2.push(-3);
		assertNull(solver.findModel(bound2));

		VecInt bound3 = new VecInt();
		bound3.push(5);
		bound3.push(3);
		assertNotNull(solver.findModel(bound3));

		VecInt bound4 = new VecInt();
		bound4.push(5);
		bound4.push(-3);
		assertNull(solver.findModel(bound4));

		VecInt bound5 = new VecInt();
		bound5.push(4);
		bound5.push(-3);
		assertNull(solver.findModel(bound5));

		VecInt bound6 = new VecInt();
		bound6.push(4);
		bound6.push(3);
		assertNotNull(solver.findModel(bound6));

		VecInt bound7 = new VecInt();
		bound7.push(4);
		int[] model = solver.findModel(bound7);
		assertNotNull(model);

		Set<Integer> satisfiedModel = new HashSet<>();
		for (int i : model) {
			satisfiedModel.add(new Integer(i));
		}
		CNFConverter converter = new CNFConverter();
		assertTrue("Found model : " + converter.convertSATModelToString(model),
				satisfiedModel.contains(new Integer(4)));
		assertTrue("Found model : " + converter.convertSATModelToString(model),
				satisfiedModel.contains(new Integer(1)));
		assertTrue("Found model : " + converter.convertSATModelToString(model),
				satisfiedModel.contains(new Integer(2)));
	}

	/**
	 * test redundant clause to root
	 * 
	 * @throws ContradictionException
	 * @throws TimeoutException
	 */
	@Test
	public void testSimplePhoneSATSmallPlusRedundantClauseToRoot()
			throws ContradictionException, TimeoutException {
		// SmallFeaturePhone (1)
		solver.gateTrue(1);

		// Message (2)
		VecInt clause = new VecInt();
		clause.push(2);
		solver.and(1, clause);

		// SMS (3)
		clause = new VecInt();
		clause.push(3);
		solver.and(1, clause);

		// Extras (4)
		clause = new VecInt();
		clause.push(4);
		solver.halfOr(1, clause);
		clause = new VecInt();
		clause.push(-4);
		clause.push(1);
		solver.addClause(clause);

		// MP3 (5) Camera (6)
		clause = new VecInt();
		clause.push(5);
		clause.push(6);
		solver.halfOr(4, clause);
		clause.push(-4);
		solver.addAtLeast(clause, 1);
		clause = new VecInt();
		clause.push(-5);
		clause.push(1);
		solver.addClause(clause);
		clause = new VecInt();
		clause.push(-6);
		clause.push(1);
		solver.addClause(clause);

		assertTrue(solver.isSatisfiable());
		VecInt bound = new VecInt();
		bound.push(3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-3);
		assertFalse(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(5);
		bound.push(3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(5);
		bound.push(-3);
		assertFalse(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(4);
		bound.push(-3);
		assertFalse(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(4);
		bound.push(3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(4);
		assertTrue(solver.isSatisfiable(bound));

		Set<Integer> satisfiedModel = new HashSet<>();
		for (int i : solver.model()) {
			satisfiedModel.add(new Integer(i));
		}
		CNFConverter converter = new CNFConverter();
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(3)));
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(4)));
		assertTrue(
				"Found model : "
						+ converter.convertSATModelToString(solver.model()),
				satisfiedModel.contains(new Integer(2)));
	}
}