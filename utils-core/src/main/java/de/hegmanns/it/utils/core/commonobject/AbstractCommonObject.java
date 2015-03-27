package de.hegmanns.it.utils.core.commonobject;


import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class AbstractCommonObject {
	private static Map<Class<?>, Collection<String>> equalsMap = new HashMap<>();
	private static Map<Class<?>, Boolean> collectedMap = new HashMap<>();
	private static Map<Class<?>, List<Field>> toStringFieldMap = new HashMap<>();
	
	private void collectStringRepresentationFields(Field[] felderDerKlasse)
	{
		if (this.getClass().isAnnotationPresent(ToStringRepresentation.class))
		{
			ToStringRepresentation toStringRepresentation = this.getClass().getAnnotation(ToStringRepresentation.class);
			List<Field> fieldList = new ArrayList<>();
			for (String feldname : toStringRepresentation.fieldNames())
			{
				try {
					fieldList.add(this.getClass().getDeclaredField(feldname));
				} catch (NoSuchFieldException e) {
					System.out.println("Deklariertes toStringRepresentationField '" + feldname + "' existiert nicht.");
				} catch (SecurityException e) {
					System.out.println("Deklariertes toStringRepresentationField '" + feldname + "' kann nicht aufgeloest werden");
				}
			}
			toStringFieldMap.put(this.getClass(), fieldList);
		}
	}
	
	private void collectEqualsRepresentationFields()
	{
		
		if (!collectedMap.containsKey(this.getClass()))
		{
			List<String> feldliste = new ArrayList<>();
			
			Field[] felder = this.getClass().getDeclaredFields();
			AccessibleObject.setAccessible(felder, true);
			collectStringRepresentationFields(felder);
			int fieldsWithoutEqualsRepresentationFieldAnnotation = 0;
			for(Field feld : felder)
			{
				if (feld.isAnnotationPresent(EqualsRepresentationField.class))
				{
					EqualsRepresentationField annotation = feld.getAnnotation(EqualsRepresentationField.class);
					if (!annotation.represented())
					{
						feldliste.add(feld.getName());
					}
				}
				else
				{
					feldliste.add(feld.getName());
					fieldsWithoutEqualsRepresentationFieldAnnotation++;
				}
			}
			if (fieldsWithoutEqualsRepresentationFieldAnnotation != felder.length)
			{
			equalsMap.put(this.getClass(), feldliste);
			}
		}
		collectedMap.put(this.getClass(), Boolean.TRUE);
	}

	@Override
	public int hashCode() {
		collectEqualsRepresentationFields();
		if (equalsMap.containsKey(this.getClass()))
		{
			return HashCodeBuilder.reflectionHashCode(this, equalsMap.get(getClass()));
		}
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public boolean equals(Object obj) {
		collectEqualsRepresentationFields();
		if (equalsMap.containsKey(this.getClass()))
		{
			return EqualsBuilder.reflectionEquals(this, obj, equalsMap.get(getClass()));
		}
		else
		{
			return EqualsBuilder.reflectionEquals(this, obj, false);
		}
	}

	@Override
	public String toString() {
		collectEqualsRepresentationFields();
		ToStringBuilder toStringBuilder = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
		
		for (Field field : toStringFieldMap.get(this.getClass()))
		{
			toStringBuilder.append(field.getName(), feldValue(field));
		}
		
		return toStringBuilder.toString();
	}
	
	private Object feldValue(Field field)
	{
		try {
			AccessibleObject.setAccessible(new Field[]{field}, true);
			return field.get(this);
		} catch (IllegalAccessException e) {
			System.out.println("Auf Feld '" + field.getName() + "' kann nicht zugegriffen werden");
		} catch (SecurityException e) {
			System.out.println("Auf Feld '" + field.getName() + "' kann nicht zugegriffen werden");
		}
		return null;
	}

}