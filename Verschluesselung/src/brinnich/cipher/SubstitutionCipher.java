package brinnich.cipher;

public class SubstitutionCipher extends MonoAlphabeticCipher{
	
	/**
	 * Konstruktor, der das Geheimalphabet setzt
	 * @param secretAlphabet der String, auf den das Geheimalphabet gesetzt werden soll
	 */
	public SubstitutionCipher(String secretAlphabet){
		this.setSecretAlphabet(secretAlphabet);
	}
	
	/**
	 * Setzt das Geheimalphabet auf einen bestimmten Wert
	 * @param secretAlphabet der String, auf den das Geheimalphabet gesetzt werden soll
	 */
	public void setSecretAlphabet(String secretAlphabet){
		super.setSecretAlphabet(secretAlphabet);
	}
	
}
