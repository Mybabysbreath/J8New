package com.lov.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 
 * Java8 内置的核心函数式接口
 * 
 *Consumer<T> :消费型接口
 *		void accept(T t);
 *
 *Supplier<T> :供给型嗟阔
 *		T get();
 *
 *Function<T,R>:函数型接口
 *		R apply(T t);
 *
 *Predicate<T> :断言型接口
 *		boolean test(T t);
 * @author Administrator
 *
 */
public class LambdaTest_3 {

	//Consumer<T>
	@Test
	public void test1(){
		
		happy(1000, System.out::println);
		
	}
	
	public void happy(double d , Consumer<Double> consumer){
		consumer.accept(d);
	}
	
	
	//Supplier<T>
	@Test
	public void test2(){
		
		List<Integer> list = getNumList(10, ()->(int)(Math.random()*100));
		System.out.println(list);
	}
	
	public List<Integer> getNumList(int num, Supplier<Integer> supplier){
	
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			Integer nInteger = supplier.get();
			list.add(nInteger);
		}
		return list;
	}
	
	//Function<T,R>
	@Test
	public void test3(){
		
		String string = strHandler("\t\t\t hello lambda", t->t.toUpperCase());
		System.out.println(string);
		
	}
	
	public String strHandler(String str,Function<String, String> function){
	
		return function.apply(str);
	}
	
	//	Predicate<T>
	@Test
	public void test4(){
		List<String> list = Arrays.asList("hello","world","lambda");
		List<String> strlist = filterStr(list, s->s.length()>2);
		
		for (String string : strlist) {
			System.out.println(string);
		}
		
	}
	
	public List<String> filterStr(List<String> list,Predicate<String> pre){
		
		List<String> strList = new ArrayList<>();
		
		for (String string : list) {
			if (pre.test(string)) {
				strList.add(string);
			}
		}
		
		return strList;
	}
}
