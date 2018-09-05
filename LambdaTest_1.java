package com.lov.lambda;

import java.util.function.Consumer;

import javax.security.auth.x500.X500Principal;

import org.junit.Test;

import com.lov.other.Myfun;

/**
 * 
 * Lambda:左侧： 表达式参数列表
 *        右侧：表达式所需执行的功能
 * 
 * 语法格式
 * 1.无参数，无返回值
 * 		()->System.out.println();
 * 2.有一个参数，无返回值
 * 		(x)->System.out.println(x);
 * 3.若只有一个参数，小括号可以省略
 * 4.有两个以上的参数，有返回值，并且lambda体内有多条语句，要用{}
 * 5.若lambda体内只有一条语句，return和{}都可以省略不写
 * 6.lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断数据类型，即“类型推断”
 * 
 * 
 * Lambda表达式需要“函数式接口”的支持
 * 函数式接口：接口中只有一个抽象方法。
 * 		可以使用@FunctionalInterface修饰，检查是否是函数接口
 * 
 * @author Administrator
 */
public class LambdaTest_1 {
	
	@Test
	public void test(){
		
		int num = 0 ;//jdk 1.7前必须是写final,其实底层还是final
		
		Runnable r1 = ()->System.out.println("hello lambda"+num);
		r1.run();
		
	}
	
	@Test
	public void test1(){
		Consumer<String> consumer = (X)->System.out.println(X);
		consumer.accept("hello");
	}
	
	@Test
	public void test2(){
		
		Integer num = operation(100, x-> x*x);
		System.out.println(num);
	}
	
	public Integer operation(Integer num,Myfun mf){
		return mf.getValue(num);
	}
	
	
	 
	
}
