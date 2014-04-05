package brinnich.cipher;

public class MonoAlphabeticCipher implements Cipher{
	
	private String secretAlphabet;
	
	/**
	 * Konstruktor, der das Geheimalphabet auf 'abcdefghijklmnopqrstuvwxyzäöüß' setzt
	 */
	public MonoAlphabeticCipher(){
		secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}
	
	/**
	 * Gibt das gespeicherte Geheimalphabet, nach dem ver- bzw. entschlüsselt wird, in Form eines Strings zurück
	 * @return das Geheimalphabet
	 */
	public String getSecretAlphabet(){
		return secretAlphabet;
	}
	
	/**
	 * Setzt das Geheimalphabet auf den übergebenen String
	 * @param secretAlphabet das neue Geheimalphabet
	 */
	protected void setSecretAlphabet(String secretAlphabet){
		this.secretAlphabet = secretAlphabet;
	}

	@Override
	/**
	 * Verschlüsselt einen übergebenen Text mithilfe des gespeicherten Geheimalphabets. Dabei wird jeder Buchstabe des
	 * Standard-Alphabets 'abcdefghijklmnopqrstuvwxyzäöüß' im Text gegen den entsprechenden Buchstaben im gespeicherten
	 * Geheimalphabet ersetzt.
	 * @param text Der Text, der verschlüsselt werden soll
	 * @return den fertig verschlüsselten Text
	 */
	public String encrypt(String text) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		
		text = text.toLowerCase();
		String txt = "";
		
		for(int i = 0; i < text.length(); i++){
			try{
				txt += secretAlphabet.charAt(alphabet.indexOf(text.charAt(i)));
			}catch(Exception e){
				txt += text.charAt(i);
			}
		}
		
		return txt;
	}

	@Override
	/**
	 * Entschlüsselt einen übergebenen Text mithilfe des gespeicherten Geheimalphabets. Dabei wird jeder Buchstabe des
	 * Geheimalphabets im Text gegen den entsprechenden Buchstaben im Standard-Alphabet 'abcdefghijklmnopqrstuvwxyzäöüß'
	 * ersetzt.
	 * @param text Der Text, der entschlüsselt werden soll
	 * @return den fertig entschlüsselten Text
	 */
	public String decrypt(String text) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		
		text = text.toLowerCase();
		String txt = "";
		
		for(int i = 0; i < text.length(); i++){
			try{
				txt += alphabet.charAt(secretAlphabet.indexOf(text.charAt(i)));
			}catch(Exception e){
				txt += text.charAt(i);
			}
		}
		
		return txt;
	}
	
}
