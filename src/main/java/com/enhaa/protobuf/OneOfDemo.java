package com.enhaa.protobuf;

import com.protobuf.models.Credentials;
import com.protobuf.models.EmailCredentials;
import com.protobuf.models.PhoneCredentials;

public class OneOfDemo {

	public static void main(String[] args) {
		
		EmailCredentials emailLogin = EmailCredentials.newBuilder()
				.setEmail("enhaa@naps.com")
				.setPassword("admin")
				.build();
		
		PhoneCredentials phoneLogin =  PhoneCredentials.newBuilder()
				.setCode(123)
				.setNumber(18213721)
				.build();
		
		Credentials credentials = Credentials.newBuilder()
				.setEmailMode(emailLogin)
				.setPhoneMode(phoneLogin)
				.build();
		
		login(credentials);
	}

	private static void login(Credentials credentials) {

		switch (credentials.getModeCase()) {
		case EMAILMODE:
			System.out.println(credentials.getEmailMode());
			break;
		case PHONEMODE:
			System.out.println(credentials.getPhoneMode());
			break;
		}
		
	}
}
