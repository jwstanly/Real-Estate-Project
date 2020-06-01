import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

	public static String generateHash(String input) {
		
		//Creates string builder to add chars to
		StringBuilder newHash = new StringBuilder();

		try {
			//Creates instance of the Secure Hash Algorithm 1
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			
			//Computes bytes from the input string using the SHA-1 hash function
			byte[] hashedBytes = sha1.digest(input.getBytes());
			
			//Translates hashed bytes into append'able chars
			char[] possibleChars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
			for (int x=0;x<hashedBytes.length;++x) {
				byte b = hashedBytes[x];
				newHash.append(possibleChars[(b & 0xf0) >> 4]);
				newHash.append(possibleChars[b & 0x0f]);
			}
		}
		catch (NoSuchAlgorithmException e) {
			//catches possible exception
			System.out.println("ERROR IN GENERATING HASH FOR STRING: \" "+input+" \" ");
			e.printStackTrace();
		}

		return newHash.toString();
	}
}



