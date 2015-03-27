package de.hegmanns.it.utis.core.commonobject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Before;
import org.junit.Test;

import de.hegmanns.it.utils.core.commonobject.AbstractCommonObject;
import de.hegmanns.it.utils.core.commonobject.EqualsRepresentationField;
import de.hegmanns.it.utils.core.commonobject.ToStringRepresentation;

/**
 * Ein Smoketest fuer {@link AbstractCommonObject}.
 * 
 * @author B. Hegmanns
 *
 */
public class EqualsRepresentationFuerAbstractCommonObjectUnitTest {

	
	
	private Testklasse testInstanz = new Testklasse();
	
	@Before
	public void beforeAnyTest(){
		testInstanz.setEqualsUndToStringRelevant("EqualsUndToStringRelevant");
		testInstanz.setNichtRelevant("NichtRelevant");
		testInstanz.setNurEqualsRelevant("NurEqualsRelevant");
		testInstanz.setNurToStringRelevant("NurToStringRelevant");
	}
	
	@Test
	public void toStringListetNurStringRelevanteAttribute()
	{
		String toStringAusgabe = testInstanz.toString();
		System.out.println(">>> '" + toStringAusgabe + "'");
		assertThat(toStringAusgabe, containsString("nurToStringRelevant=NurToStringRelevant"));
		assertThat(toStringAusgabe, containsString("equalsUndToStringRelevant=EqualsUndToStringRelevant"));
		assertThat(toStringAusgabe, not(containsString("nichtRelevant=NichtRelevant")));
		assertThat(toStringAusgabe, not(containsString("nurEqualsRelevant=NurEqualsRelevant")));
	}
	
	@Test
	public void toStringFunktioniertAuchBeiFalschenNamenInDefinition()
	{
		TestklasseMitFalschDeklariertemToStringRepresenationNamen instanz = new TestklasseMitFalschDeklariertemToStringRepresenationNamen();
		instanz.setEqualsUndToStringRelevant("EqualsUndToStringRelevant");
		instanz.setNichtRelevant("NichtRelevant");
		instanz.setNurEqualsRelevant("NurEqualsRelevant");
		instanz.setNurToStringRelevant("NurToStringRelevant");
		
		String toStringAusgabe = instanz.toString();
		System.out.println(">>> '" + toStringAusgabe + "'");
		assertThat(toStringAusgabe, containsString("nurToStringRelevant=NurToStringRelevant"));
		assertThat(toStringAusgabe, not(containsString("equalsUndToStringRelevant=EqualsUndToStringRelevant")));
		assertThat(toStringAusgabe, not(containsString("nichtRelevant=NichtRelevant")));
		assertThat(toStringAusgabe, not(containsString("nurEqualsRelevant=NurEqualsRelevant")));
		assertThat(toStringAusgabe, not(containsString("existiertNicht")));
	}
	
	@Test
	public void equalsFunktioniert() throws CloneNotSupportedException{
		Testklasse neueTestInstanz = (Testklasse) testInstanz.clone();
		neueTestInstanz.setNichtRelevant(null);
		neueTestInstanz.setNurToStringRelevant(null);
		
		assertThat(neueTestInstanz==testInstanz, is(false));
		assertThat(neueTestInstanz, equalTo(testInstanz));
	}
	
	@Test
	public void equalsFunktioniert1() throws CloneNotSupportedException{
		Testklasse neueTestInstanz = (Testklasse) testInstanz.clone();
		neueTestInstanz.setNichtRelevant(null);
		neueTestInstanz.setNurToStringRelevant(null);
		neueTestInstanz.setEqualsUndToStringRelevant("A");
	
		assertThat(neueTestInstanz==testInstanz, is(false));
		assertThat(neueTestInstanz, not(equalTo(testInstanz)));
	}
	
	@Test
	public void equalsFunktioniert2() throws CloneNotSupportedException{
		Testklasse neueTestInstanz = (Testklasse) testInstanz.clone();
		neueTestInstanz.setNichtRelevant(null);
		neueTestInstanz.setNurToStringRelevant(null);
		neueTestInstanz.setNurEqualsRelevant("A");
	
		assertThat(neueTestInstanz==testInstanz, is(false));
		assertThat(neueTestInstanz, not(equalTo(testInstanz)));
	}
	
	@Test
	public void equalsFunktioniert3() throws CloneNotSupportedException{
		Testklasse neueTestInstanz = (Testklasse) testInstanz.clone();
		neueTestInstanz.setNichtRelevant(null);
		neueTestInstanz.setNurToStringRelevant(null);
		neueTestInstanz.setEqualsUndToStringRelevant("A");
		neueTestInstanz.setNurEqualsRelevant("A");
	
		assertThat(neueTestInstanz==testInstanz, is(false));
		assertThat(neueTestInstanz, not(equalTo(testInstanz)));
	}
	
	@Test
	public void hashCodeFunktioniert(){
		
	}
	
	
}

