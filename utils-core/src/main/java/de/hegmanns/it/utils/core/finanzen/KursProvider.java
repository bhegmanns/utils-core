package de.hegmanns.it.utils.core.finanzen;

public interface KursProvider {

	public Kurs getKurs(Waehrung quellwaehrung, Waehrung zielwaehrung);
}
