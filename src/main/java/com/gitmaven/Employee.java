package com.gitmaven;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@ToString
public class Employee {

int id;

String name;

int salary;

    public Employee(int i, String hi, int i1) {
        this.id=i;
        this.name=hi;
        this.salary=i1;
    }
}
