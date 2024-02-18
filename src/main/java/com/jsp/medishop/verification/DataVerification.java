package com.jsp.medishop.verification;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * @author Atul
 */
@Component
public class DataVerification {

	public String verifyEmail(String email) {
		boolean alpha = Pattern.compile("^[a-z]+").matcher(email).find();
		boolean number = Pattern.compile("[0-9]+").matcher(email).find();
		boolean spec = Pattern
				.compile("[^~!@#$%&*()_+{}|:\"?><`/.,;'\\]\\[^]+[@]{1,1}(gmail|yahoo){1}[.]{1}?(in|com|co|org)")
				.matcher(email).find();
		if (alpha && number && spec) {
			return email;
		} else if (alpha && spec) {
			return email;
		} else {
			return null;
		}
	}

	public String verifyPassword(String password) {
		boolean alpha = Pattern.compile("[a-zA-Z]+").matcher(password).find();
		boolean number = Pattern.compile("[0-9]+").matcher(password).find();
		boolean spec = Pattern.compile("[!@#$%^&*]+").matcher(password).find();
		if (alpha && spec && number) {
			return password;
		} else if (alpha && number) {
			return password;
		} else {
			return null;
		}

	}
}
