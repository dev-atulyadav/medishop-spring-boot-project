package com.jsp.medishop.verification;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * @author Atul
 */
@Component
public class DataVerification {

	public String verifyEmail(String email) {
		boolean alpha = Pattern.compile("[a-zA-Z]").matcher(email).find();
		boolean number = Pattern.compile("[0-9]").matcher(email).find();
		boolean spec = Pattern.compile("[@.]").matcher(email).find();

		if (alpha & spec) {
			if (number) {
				return email;
			} else {
				return email;
			}
		} else {
			return null;
		}
	}

	public String verifyPassword(String password) {
		boolean alpha = Pattern.compile("[a-zA-Z]").matcher(password).find();
		boolean number = Pattern.compile("[0-9]").matcher(password).find();
		boolean spec = Pattern.compile("[@.]").matcher(password).find();

		if (alpha & spec) {
			if (number) {
				return password;
			} else {
				return password;
			}
		} else {
			return null;
		}
	}
}
