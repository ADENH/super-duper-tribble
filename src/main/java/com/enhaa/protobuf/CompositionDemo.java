package com.enhaa.protobuf;

import com.protobuf.models.Address;
import com.protobuf.models.Car;
import com.protobuf.models.Person;

public class CompositionDemo {

	public static void main(String[] args) {
		
		Address address =  Address.newBuilder()
				.setPostbox(123)
				.setCity("Jakarta")
				.setStreet("jl Hasym Asari")
				.build();
		
		Car fortuner = Car.newBuilder()
				.setMake("TOYOTA")
				.setModel("FORTUNER")
				.setYear(2021)
				.build();
		
		Car avanza = Car.newBuilder()
				.setMake("TOYOTA")
				.setModel("Avanza")
				.setYear(2021)
				.build();
		
		Person person = Person.newBuilder()
				.setAddress(address)
				.addCar(avanza)
				.addCar(fortuner)
				.setAge(26)
				.setName("Enhaa")
				.build();
		
		System.out.println(person);
	}
}
