package org.feature.model.sat.solver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.GateTranslator;

/**
 * Test junit solver factory
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
	}

	@Test
	public void testOptionalHalfOr() throws ContradictionException,
			TimeoutException {
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
	}

	@Test
	public void testOr() throws ContradictionException, TimeoutException {
		solver.gateTrue(1);

		// 1 -> 2 v 3
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
		bound.push(-3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		bound.push(-3);
		assertFalse(solver.isSatisfiable(bound));
	}

	@Test
	public void testOrHalfOr() throws ContradictionException, TimeoutException {
		solver.gateTrue(1);

		// 1 -> 2 v 3
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
		bound.push(-3);
		assertTrue(solver.isSatisfiable(bound));

		bound = new VecInt();
		bound.push(-2);
		bound.push(-3);
		assertFalse(solver.isSatisfiable(bound));
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
	public void testAlternativeHalfOr() throws ContradictionException,
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
		solver.gateTrue(1);

		// 2 -> 1
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
		assertFalse(solver.isSatisfiable(bound));
	}

	@Test
	public void testMandatoryAnd() throws ContradictionException,
			TimeoutException {
		solver.gateTrue(1);

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
		assertFalse(solver.isSatisfiable(bound));
	}

	@Test
	public void testSimplePhoneSATSmall() throws ContradictionException,
			TimeoutException {
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
		
		// MP3 (5) Camera (6)
		clause = new VecInt();
		clause.push(5);
		clause.push(6);
		solver.halfOr(4, clause);
		clause.push(-4);
		solver.addAtLeast(clause, 1);
		
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
	}
	
	@Test
	public void testSimplePhoneSATSmallPlusRedundantClauseToRoot() throws ContradictionException,
			TimeoutException {
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
	}
}