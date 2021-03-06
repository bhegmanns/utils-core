package de.hegmanns.it.utils.core;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Realisierung einer Referenz.
 * 
 * <h1>Wofuer um Himmels Willen wird eine "Referenz" benoetigt?</h1>
 * <p>
 * 	Methodenaufrufe in JAVA werden immer "byValue" aufgerufen. Das bedeutet, dass
 *  die Parameter einer Methode von der aufgerufenen Methode nicht neu gesetzt
 *  werden koennen.<br>
 *  Bitte beachten Sie, dass diese Eigenschaft NICHT gleichzusetzen ist mit
 *  "die Paramter koennen nicht geaendert werden".<br>
 * </p>
 * 
 * @author B. Hegmanns
 *
 * @param <T>
 */
public class Ref<T extends Serializable> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private T value;

	public Ref(T value)
	{
		this.value = value;
	}
	
	public Ref()
	{
		// banaler Standard-Konstruktor
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(value).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return new EqualsBuilder().append(this, obj).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append(value).toString();
	}
	
}
