package com.gitmaven;

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
		List<Employee> employeeList =new ArrayList<>();
		employeeList.add(new Employee(1,"arun45",45));
		employeeList.add(new Employee(19,"arun",32));
		employeeList.add(new Employee(12,"venkat",30));
		List<Employee> employeeStream=employeeList
				.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
				.collect(Collectors.toList());
		List<Employee> employeeComparing=employeeList
				.stream()
				.sorted((o1,o2) -> o1.getSalary()- o2.getSalary()
				)
				.collect(Collectors.toList());
		employeeStream.forEach(System.out::println);
		employeeComparing.forEach(System.out::println);


		Function< Employee, ?> employee = (Function<Employee, Object>) employee1 -> employee1;
		Map empMap= employeeList.stream().collect(Collectors.toMap(Employee::getId,employee));

		System.out.println("map"+empMap);

		List<? super Number> loweBounds=new ArrayList<>();
		loweBounds.add(4);
	}

}
