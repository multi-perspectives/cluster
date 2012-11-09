/**
 */
package org.feature.multi.perspective.classification;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Classifier</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.feature.multi.perspective.classification.ClassificationPackage#getClassifier()
 * @model
 * @generated
 */
public enum Classifier implements Enumerator {
   /**
	 * The '<em><b>Unclassified</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #UNCLASSIFIED_VALUE
	 * @generated
	 * @ordered
	 */
   UNCLASSIFIED(0, "Unclassified", "Unclassified"),

   /**
	 * The '<em><b>Unbound</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #UNBOUND_VALUE
	 * @generated
	 * @ordered
	 */
   UNBOUND(1, "Unbound", "Unbound"),

   /**
	 * The '<em><b>Alive</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #ALIVE_VALUE
	 * @generated
	 * @ordered
	 */
   ALIVE(2, "Alive", "Alive"),

   /**
	 * The '<em><b>Dead</b></em>' literal object.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #DEAD_VALUE
	 * @generated
	 * @ordered
	 */
   DEAD(3, "Dead", "Dead");

   /**
	 * The '<em><b>Unclassified</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Unclassified</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #UNCLASSIFIED
	 * @model name="Unclassified"
	 * @generated
	 * @ordered
	 */
   public static final int UNCLASSIFIED_VALUE = 0;

   /**
	 * The '<em><b>Unbound</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Unbound</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #UNBOUND
	 * @model name="Unbound"
	 * @generated
	 * @ordered
	 */
   public static final int UNBOUND_VALUE = 1;

   /**
	 * The '<em><b>Alive</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Alive</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #ALIVE
	 * @model name="Alive"
	 * @generated
	 * @ordered
	 */
   public static final int ALIVE_VALUE = 2;

   /**
	 * The '<em><b>Dead</b></em>' literal value.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of '<em><b>Dead</b></em>' literal object isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @see #DEAD
	 * @model name="Dead"
	 * @generated
	 * @ordered
	 */
   public static final int DEAD_VALUE = 3;

   /**
	 * An array of all the '<em><b>Classifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private static final Classifier[] VALUES_ARRAY =
      new Classifier[] {
			UNCLASSIFIED,
			UNBOUND,
			ALIVE,
			DEAD,
		};

   /**
	 * A public read-only list of all the '<em><b>Classifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static final List<Classifier> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

   /**
	 * Returns the '<em><b>Classifier</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static Classifier get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Classifier result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

   /**
	 * Returns the '<em><b>Classifier</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static Classifier getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Classifier result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

   /**
	 * Returns the '<em><b>Classifier</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static Classifier get(int value) {
		switch (value) {
			case UNCLASSIFIED_VALUE: return UNCLASSIFIED;
			case UNBOUND_VALUE: return UNBOUND;
			case ALIVE_VALUE: return ALIVE;
			case DEAD_VALUE: return DEAD;
		}
		return null;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private final int value;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private final String name;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private final String literal;

   /**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private Classifier(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public int getValue() {
	  return value;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String getName() {
	  return name;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String getLiteral() {
	  return literal;
	}

   /**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public String toString() {
		return literal;
	}
   
} //Classifier
