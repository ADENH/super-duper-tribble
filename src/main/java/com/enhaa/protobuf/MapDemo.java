package com.enhaa.protobuf;

import com.protobuf.models.BodyStyle;
import com.protobuf.models.Car;
import com.protobuf.models.Dealer;

public class MapDemo {

	public static void main(String[] args) {
		
		Car fortuner = Car.newBuilder()
				.setMake("TOYOTA")
				.setModel("FORTUNER")
				.setYear(2020)
				.setBodyStyle(BodyStyle.SUV)
				.build();
		
		Car avanza = Car.newBuilder()
				.setMake("TOYOTA")
				.setModel("Avanza")
				.setYear(2021)
				.build();
		
		Dealer dealer = Dealer.newBuilder()
				.putModel(2021, avanza)
				.putModel(2020, fortuner)
				.build();
		
		System.out.println(
		dealer.getModelOrThrow(2020).getBodyStyle()
				);
	}
}
