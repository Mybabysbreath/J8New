package com.lov.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

import com.lov.entity.Employee;
import com.lov.other.FilterEmployeeByAge;
import com.lov.other.MyPredicate;

public class LambdaTest {

	//原来的匿名内部类
	@Test
	public void test1(){
		Comparator<Integer> com =  new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
			
		};
		TreeSet<Integer> ts = new TreeSet<>(com);
	}
	
	//Lambda 表达式
	@Test
	public void test2(){
		Comparator<Integer> com = (x,y)->Integer.compare(x, y);
		TreeSet<Integer> ts = new TreeSet<>(com);
		
	}
	
	List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 9999.99),
			new Employee("李四", 38, 5555.99),
			new Employee("王五", 50, 6666.66),
			new Employee("赵六", 16, 3333.33),
			new Employee("田七", 8, 7777.77)	
			);
	
	@Test
	public void test3(){
		List<Employee> list = filterEmployees(employees);
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	
	//需求：对某个条件进行过滤
	public List<Employee> filterEmployees(List<Employee> list){
		List<Employee> emps = new ArrayList<>();
		
		for (Employee emp : list) {
			//条件
			if (emp.getAge() >= 35) {
				emps.add(emp);
				
			}
			
		}
		return emps;
		
	}
	
	//当上面的需求需要条件多种时，再写方法会显得冗余，于是可以通过优化改善
	//优化方式-1：策略设计模式
	@Test
	public void test4(){
		List<Employee> list  =filterEmployee(employees, new FilterEmployeeByAge());
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
	
	public List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> mp){
		List<Employee> emps = new ArrayList<>();
		
		for (Employee employee : list) {
			if (mp.test(employee)) {
				emps.add(employee);
			}
		}
		return emps;
	}
	//优化方式-2:lambda
	@Test
	public void test5(){
		
		List<Employee> list = filterEmployee(employees, (e)->e.getAge()>=35);
		list.forEach(System.out::println);
	}
	//优化方式-3:streamAPI
	@Test
	public void test6(){
		employees.stream()
				 .filter((e)->e.getAge()>=35)
				 .limit(1)
				 .forEach(System.out::println);
	}
}
