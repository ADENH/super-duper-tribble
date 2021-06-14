package com.enhaa.protobuf;

import java.util.ArrayList;
import java.util.List;

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
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(fortuner);
		cars.add(avanza);
		
		Person person = Person.newBuilder()
				.setAddress(address)
				.addAllCar(cars)
				.setAge(26)
				.setName("Enhaa")
				.build();
		
		System.out.println(person);
	}
}
