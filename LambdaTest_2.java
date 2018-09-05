package com.lov.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.lov.entity.Employee;
import com.lov.other.MyFunction;
import com.lov.other.Myfunction2;

public class LambdaTest_2 {

	List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99),
			new Employee("李四", 38, 5555.99),
			new Employee("王五", 50, 6666.66),
			new Employee("赵六", 16, 3333.33),
			new Employee("田七", 8, 7777.77)	
			);
	
	@Test
	public void test1(){
		
		Collections.sort(employees, (e1,e2)->{
			if(e1.getAge() == e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	//处理字符串
	@Test
	public void test2(){
		
		String tString = strHandler("\t\t\t hello lambda", str->str.trim());
		System.out.println(tString);
		
	}
	
	public String strHandler(String str,MyFunction mf){
		return mf.getValue(str);
	}
	
	
	//对任意两个类型数据进行处理
	@Test
	public void test3(){
		
		op(100L, 200L, (x1, x2)->x1*x2);
		
	}
	
	public void op(long l1, long l2,Myfunction2<Long, Long> mf){
		System.out.println(mf.getValue(l1, l2));
	}
	
	
}
