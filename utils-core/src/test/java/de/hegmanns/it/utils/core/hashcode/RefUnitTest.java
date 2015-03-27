package de.hegmanns.it.utils.core.hashcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.hegmanns.it.utils.core.Ref;

@RunWith(MockitoJUnitRunner.class)
public class RefUnitTest {
	
	@Mock
	private Serializable objekt;

	@Test
	public void neueReferenzEnthaeltNull(){
		Ref<Serializable> ref = new Ref<>();
		assertThat(ref.getValue(), nullValue());
	}
	
	@Test
	public void ueberKonstruktorBefuellteReferenz()
	{
		Ref<Serializable> ref = new Ref<Serializable>(objekt);
		assertThat(ref.getValue(), is(objekt));
	}
	
	@Test
	public void ueberSetterBefuellterReferenz()
	{
		Ref<Serializable> ref = new Ref<>();
		ref.setValue(objekt);
		assertThat(ref.getValue(), is(objekt));
	}
	
	@Test
	public void objektUeberschreiben(){
		Ref<Serializable> ref = new Ref<Serializable>(objekt);
		Serializable neuesObjekt = mock(Serializable.class);
		ref.setValue(neuesObjekt);
		assertThat(ref.getValue(), is(neuesObjekt));
	}
}
