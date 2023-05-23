package com.gitmaven;

import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class GitmavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitmavenApplication.class, args);
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "arun45", 45));
		employeeList.add(new Employee(19, "arun", 55));
		employeeList.add(new Employee(12, "venkat", 30));
		List<Employee> employeeStream = employeeList
				.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary))
				.collect(Collectors.toList());
		List<Employee> employeeComparing = employeeList
				.stream()
				.sorted((o1, o2) -> o1.getSalary() - o2.getSalary())
				.collect(Collectors.toList());
		employeeStream.forEach(System.out::println);
		employeeComparing.forEach(System.out::println);


		//Function< Employee, ?> employee = (Function<Employee, Object>) employee1 -> employee1;
		Function<? super Employee, ?> employee = new Function<Employee, Object>() {
			@Override
			public Object apply(Employee employee) {
				return employee;
			}
		};
		Map empMap = employeeList.stream().collect(Collectors.toMap(Employee::getId, employee));

		System.out.println("map" + empMap);

		List<? super Number> loweBounds = new ArrayList<>();
		loweBounds.add(4);

		//3 apple, 2 banana, others 1
		val items =
				Arrays.asList("apple", "apple", "banana",
						"apple", "orange", "banana", "papaya");

		val result =
				items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.printf("Results " + result);


	}
}
