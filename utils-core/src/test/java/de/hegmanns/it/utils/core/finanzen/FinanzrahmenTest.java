package de.hegmanns.it.utils.core.finanzen;

import java.math.BigDecimal;

import org.junit.Test;

import de.hegmanns.it.utils.core.finanzen.Kurs;
import de.hegmanns.it.utils.core.finanzen.KursProvider;
import de.hegmanns.it.utils.core.finanzen.Waehrung;

public class FinanzrahmenTest {

	@Test
	public void foo()
	{
		KursProvider kursprovider = null;
		Kurs kurs = kursprovider.getKurs(Waehrung.EUR, Waehrung.EUR);
		
		
	}
}
