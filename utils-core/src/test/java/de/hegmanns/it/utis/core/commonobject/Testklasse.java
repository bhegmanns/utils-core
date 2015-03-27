package de.hegmanns.it.utis.core.commonobject;

import de.hegmanns.it.utils.core.commonobject.AbstractCommonObject;
import de.hegmanns.it.utils.core.commonobject.EqualsRepresentationField;
import de.hegmanns.it.utils.core.commonobject.ToStringRepresentation;

@ToStringRepresentation(fieldNames = {"equalsUndToStringRelevant", "nurToStringRelevant"})
public class Testklasse extends AbstractCommonObject implements Cloneable{
	@EqualsRepresentationField
	private String nurEqualsRelevant;
	
	private String nurToStringRelevant;

	@EqualsRepresentationField
	private String equalsUndToStringRelevant;
	
	private String nichtRelevant;

	public String getNurEqualsRelevant() {
		return nurEqualsRelevant;
	}

	public void setNurEqualsRelevant(String nurEqualsRelevant) {
		this.nurEqualsRelevant = nurEqualsRelevant;
	}

	public String getNurToStringRelevant() {
		return nurToStringRelevant;
	}

	public void setNurToStringRelevant(String nurToStringRelevant) {
		this.nurToStringRelevant = nurToStringRelevant;
	}

	public String getEqualsUndToStringRelevant() {
		return equalsUndToStringRelevant;
	}

	public void setEqualsUndToStringRelevant(String equalsUndToStringRelevant) {
		this.equalsUndToStringRelevant = equalsUndToStringRelevant;
	}

	public String getNichtRelevant() {
		return nichtRelevant;
	}

	public void setNichtRelevant(String nichtRelevant) {
		this.nichtRelevant = nichtRelevant;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
