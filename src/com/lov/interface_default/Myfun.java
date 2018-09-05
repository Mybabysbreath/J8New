package com.lov.interface_default;

public interface Myfun {

	static void show(){
		
		System.out.println("show");
	}
	
	default String getName(){
		return "aaa";
	}
	
}
