package com.enhaa.protobuf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.protobuf.models.Person;

/**
 * Created by Spring Tool Suite.
 * @author Ade Hidayat
 * Date: Jun 12, 2021
 * Time: 9:27:34 AM
 */
public class PersonDemo {

	public static void main(String[] args) throws IOException {

//		Person enhaa = Person.newBuilder().setName("Enhaa").setAge(25).build();
		
		Path path =  Paths.get("enhaa.ser"); 
//		Files.write(path, enhaa.toByteArray());
		
		byte[] bytes = Files.readAllBytes(path);
		Person newEnhaa = Person.parseFrom(bytes);
//		System.out.println(enhaa.toString());
		System.out.println(newEnhaa.toString());
	}

}
