/*
 * Class: CMSC203 
 * Instructor:Robert Alexander
 * Description:Write a Java program to encrypt and decrypt a phrase using 
               two similar approaches, each insecure by modern standards.
 * Due: 10/14/2021
 * Platform/compiler:Eclipse
 * @author: Xiaozi Wang
 * 
*/
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		int size = plainText.length();
		
		for (int i = 0; i < size; i++) {   //check that each character is whithin the allowed range
			if (plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND) {
				return false; //if the character is not within allowed range
			}
		}
		
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encrypted = ""; //initializes the encrypted string as empty
		key %= RANGE;
		int size = plainText.length();
		for (int i = 0; i < size; i++) {
			int c = (int)plainText.charAt(i) + key;
			while(c > UPPER_BOUND) { //if the key is too high, it will be subtracted until it does not exceed
				c -= RANGE; 
			}
			encrypted += (char)c; //turns c into a char variable
		}
		return encrypted;
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encrypted = "";
		int size = plainText.length();
		
		for (int i = 0; i < size; i++) {
			int b = bellasoStr.length();
			int c = plainText.charAt(i) + (int)bellasoStr.charAt(i % b);
			
			while(c > (int)UPPER_BOUND) {
				c -= RANGE;
			}
			encrypted += (char)c;//turns c into a char variable
		}
		return encrypted;
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decrypted = "";
		key %= RANGE;
		int size = encryptedText.length();
		for (int i = 0; i < size; i++) {
			int c = (char)(encryptedText.charAt(i) - key);
			while (c < LOWER_BOUND){
				c += RANGE;
			}
			decrypted  += (char)c;//turns c into a char variable
		}
		return decrypted;
		 
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decrypted = "";
		int size = encryptedText.length();
		
		for (int i = 0; i < size; i++) {
			int b = bellasoStr.length();
			int c = encryptedText.charAt(i) - (int)bellasoStr.charAt(i % b);
			
			while(c < (int)LOWER_BOUND) {
				c += RANGE;
			}
			decrypted  += (char)c;//turns c into a char variable
		}
		return decrypted;
	}
}
/**Work Cited
 * Example of code used by the professor to explain the course in class
 * https://learn-us-east-1-prod-fleet02-xythos.content.blackboardcdn.com/60952172d527a/
 *       12356409?X-Blackboard-Expiration=1634191200000&X-Blackboard-Signature=THPSKOS7zVzD9ckTvUDX2Gr
 *       luosLImpaNvokjcA4c%2Fg%3D&X-Blackboard-Client-Id=100432&response-cache-control=private%2C%20max-
 *       age%3D21600&response-content-disposition=inline%3B%20filename%2A%3DUTF-8%27%27zoom_0%252816%2529.mp4&response-
 *       content-type=video%2Fmp4&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20211014T000000Z&X-Amz-
 *       SignedHeaders=host&X-Amz-Expires=21600&X-Amz-Credential=AKIAZH6WM4PL5SJBSTP6%2F20211014%2Fus-east-
 *       1%2Fs3%2Faws4_request&X-Amz-Signature=e326a940d741a36e70addebd020dadc885e4d2ca383f8bc404d600e6fadf2ffb
 * https://stackoverflow.com/questions/1205135/how-to-encrypt-string-in-java
 * https://www.youtube.com/watch?v=8wlE6DgOWBs
 */
