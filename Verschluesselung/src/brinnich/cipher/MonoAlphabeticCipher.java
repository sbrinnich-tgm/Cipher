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
		StringBuffer alphabet = new StringBuffer("abcdefghijklmnopqrstuvwxyz����");
		
		text = text.toLowerCase();
		StringBuffer txt = new StringBuffer(text);
		
		for(int i = 0; i < txt.length(); i++){
			for(int j = 0; j < alphabet.length(); j++){
				if(txt.charAt(i) == alphabet.charAt(j)){
					txt.replace(i, i, ""+secretAlphabet.charAt(j));
				}
			}
		}
		
		return txt.toString();
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
		StringBuffer alphabet = new StringBuffer("abcdefghijklmnopqrstuvwxyz����");
		
		text = text.toLowerCase();
		StringBuffer txt = new StringBuffer(text);
		
		for(int i = 0; i < txt.length(); i++){
			for(int j = 0; j < secretAlphabet.length(); j++){
				if(txt.charAt(i) == secretAlphabet.charAt(j)){
					txt.replace(i, i, ""+alphabet.charAt(j));
				}
			}
		}
		
		return txt.toString();
	}
	
}
