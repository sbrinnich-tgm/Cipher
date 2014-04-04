package brinnich.test;

import org.junit.Test;

import brinnich.cipher.SubstitutionCipher;

public class CipherTest {
	
	@Test
	public void testSetGetSecretAlphabet(){
		String secA = "ßüöäzyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher cipher = new SubstitutionCipher("");
		
		cipher.setSecretAlphabet(secA);
		if(!cipher.getSecretAlphabet().equals(secA)){
			throw new RuntimeException("Set/Get Test failed!");
		}
		
		cipher.setSecretAlphabet(null);
		if(cipher.getSecretAlphabet() != null){
			throw new RuntimeException("Set/Get Test failed!");
		}
	}

}
