package com.enhaa.protobuf;

import com.enhaa.json.JPerson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.protobuf.models.Person;

public class PerformanceTest {

	public static void main(String[] args) {
		
		//JSON
		JPerson person = new JPerson();
		person.setName("Enhaa");
		person.setAge(25);
		
		ObjectMapper mapper = new ObjectMapper();
		Runnable json = () -> {
			try {
				byte[] bytes = mapper.writeValueAsBytes(person);
				JPerson person1 = mapper.readValue(bytes,JPerson.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		
		// protobuf
		Person enhaa = Person.newBuilder()
				.setName("enhaa")
				.setAge(26)
				.build();
		
		Runnable proto = () -> {
			try {
				byte[] bytes = enhaa.toByteArray();
				Person enhaa1 = Person.parseFrom(bytes);
			} catch (InvalidProtocolBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		for(int i=0;i<5;i++) {
			runPerformanceTest(json,"JSON");
			runPerformanceTest(proto,"PROTO");
		}
		
		
		
	}

	private static void runPerformanceTest(Runnable runa, String string) {
		long before = System.currentTimeMillis();
		for(int i=0;i<5_000_000;i++) {
			runa.run();
		}
		long after = System.currentTimeMillis();
		System.out.println(string +" : "+(after-before)+" ms");
	}
}
