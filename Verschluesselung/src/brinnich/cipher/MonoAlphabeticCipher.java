package brinnich.cipher;

public class MonoAlphabeticCipher implements Cipher{
	
	private String secretAlphabet;
	
	/**
	 * Konstruktor, der das Geheimalphabet auf 'abcdefghijklmnopqrstuvwxyz����' setzt
	 */
	public MonoAlphabeticCipher(){
		secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
	}
	
	/**
	 * Gibt das gespeicherte Geheimalphabet, nach dem ver- bzw. entschl�sselt wird, in Form eines Strings zur�ck
	 * @return das Geheimalphabet
	 */
	public String getSecretAlphabet(){
		return secretAlphabet;
	}
	
	/**
	 * Setzt das Geheimalphabet auf den �bergebenen String
	 * @param secretAlphabet das neue Geheimalphabet
	 */
	protected void setSecretAlphabet(String secretAlphabet){
		this.secretAlphabet = secretAlphabet;
	}

	@Override
	/**
	 * Verschl�sselt einen �bergebenen Text mithilfe des gespeicherten Geheimalphabets. Dabei wird jeder Buchstabe des
	 * Standard-Alphabets 'abcdefghijklmnopqrstuvwxyz����' im Text gegen den entsprechenden Buchstaben im gespeicherten
	 * Geheimalphabet ersetzt.
	 * @param text Der Text, der verschl�sselt werden soll
	 * @return den fertig verschl�sselten Text
	 */
	public String encrypt(String text) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz����";
		
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
	 * Entschl�sselt einen �bergebenen Text mithilfe des gespeicherten Geheimalphabets. Dabei wird jeder Buchstabe des
	 * Geheimalphabets im Text gegen den entsprechenden Buchstaben im Standard-Alphabet 'abcdefghijklmnopqrstuvwxyz����'
	 * ersetzt.
	 * @param text Der Text, der entschl�sselt werden soll
	 * @return den fertig entschl�sselten Text
	 */
	public String decrypt(String text) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz����";
		
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
