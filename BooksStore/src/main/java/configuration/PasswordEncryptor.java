package configuration;

import java.security.MessageDigest;

public class PasswordEncryptor {
	 public static String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] hashBytes = md.digest(password.getBytes("UTF-8"));
	            StringBuilder sb = new StringBuilder();

	            for (byte b : hashBytes) {
	                sb.append(String.format("%02x", b)); // chuyển byte sang chuỗi hex
	            }

	            return sb.toString();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}	
