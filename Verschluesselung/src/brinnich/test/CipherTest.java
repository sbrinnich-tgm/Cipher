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
		if(cipher.getSecretAlphabet() == null){
			throw new RuntimeException("Set/Get Test failed!");
		}
	}

	@Test
	public void testEncryptDecrypt(){
		String secA = "ßüöäzyxwvutsrqponmlkjihgfedcba";
		SubstitutionCipher cipher = new SubstitutionCipher(secA);
		
		if(!cipher.encrypt("Test1").equals("kzlk1")){
			throw new RuntimeException("Encrypt/Decrypt Test failed!");
		}
		
		if(!cipher.decrypt("Kzlk1").equals("test1")){
			throw new RuntimeException("Encrypt/Decrypt Test failed!");
		}

		
		cipher = new SubstitutionCipher(null);
		if(!cipher.encrypt("Test2").equals("test2")){
			throw new RuntimeException("Encrypt/Decrypt Test failed!");
		}
		
		if(!cipher.decrypt("Kzlk2").equals("kzlk2")){
			throw new RuntimeException("Encrypt/Decrypt Test failed!");
		}
		
		
		cipher.setSecretAlphabet("ßüöäzyxwvutsrqponmlkjihgfedcba!.-");
		if(!cipher.encrypt("Test3").equals("kzlk3")){
			throw new RuntimeException("Encrypt/Decrypt Test failed!");
		}
		
		if(!cipher.decrypt("Kzlk3").equals("test3")){
			throw new RuntimeException("Encrypt/Decrypt Test failed!");
		}
		
		
		cipher = new SubstitutionCipher("zyxwvutsrqponmlkjihgfedcba");
		if(!cipher.encrypt("Test4").equals("gvhg4")){
			throw new RuntimeException("Encrypt/Decrypt Test failed!");
		}
		
		if(!cipher.decrypt("Gvhg4").equals("test4")){
			throw new RuntimeException("Encrypt/Decrypt Test failed!");
		}
	}
}
