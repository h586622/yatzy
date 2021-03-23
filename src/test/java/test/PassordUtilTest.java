package test;

import no.gruppe6.yatzy.util.PassordUtil;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;

public class PassordUtilTest {
	
	private static final String RIKTIG_PASSORD = "Abc de fgh";
	private static final String FEIL_PASSORD = "Java er kjedelig";
	private static final String FOR_KORT_PASSORD = "123456789";
	
//	private PassordUtilOld passordUtil = new PassordUtilOld();
	private PassordUtil passordUtil = new PassordUtil();

	@Test
	public void riktigPassordVirker() {
        String mittSaltPlussDigest = passordUtil.krypterPassord(RIKTIG_PASSORD);
        assertTrue(passordUtil.sjekkPassord(RIKTIG_PASSORD, mittSaltPlussDigest));
	}

	@Test
	public void feilPassordVirkerIkke() {
        String mittSaltPlussDigest = passordUtil.krypterPassord(RIKTIG_PASSORD);
        assertFalse(passordUtil.sjekkPassord(FEIL_PASSORD, mittSaltPlussDigest));
	}
	
	@Test
	public void tomKryptertVirkerIkke() {
        assertFalse(passordUtil.sjekkPassord(RIKTIG_PASSORD, ""));
	}
	
	@Test
	public void nullPassordKasterUnntak1() {
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.krypterPassord(null));
	}
	
	@Test
	public void nullPassordKasterUnntak2() {
        String mittSaltPlussDigest = passordUtil.krypterPassord(RIKTIG_PASSORD);
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.sjekkPassord(null, mittSaltPlussDigest));
	}
	
	@Test
	public void nullKryptertKasterUnntak() {
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.sjekkPassord(RIKTIG_PASSORD, null));
	}
	
	@Test
	public void kortPassordKasterUnntak1() {
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.krypterPassord(FOR_KORT_PASSORD));
	}
	
	@Test
	public void kortPassordKasterUnntak2() {
        String mittSaltPlussDigest = passordUtil.krypterPassord(RIKTIG_PASSORD);
        assertThrows(IllegalArgumentException.class, 
        		() -> passordUtil.sjekkPassord(FOR_KORT_PASSORD, mittSaltPlussDigest));
	}
	

}