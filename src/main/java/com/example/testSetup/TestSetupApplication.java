package com.example.testSetup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSetupApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSetupApplication.class, args);
	}

}

//find the pairs of empoyee which works in same department;
//name1 dept_id
//name2  dept_id
//		name3 dpet_id
//
//				name1 name2  dept1
//				name2 name3 dept1
//
//
//select  dept_id from employee group by dept_id;
//
//
//select e1.name , e2.name e1.deptId from(
//select e1.name , e2,name, e1.dept_id,e1.emoId+""+e2_emp_id as indetifier from employee e1 inner join employee e2 on  e1.dept_id = e2.dept_id where  e1.empid != e2.emp.id
//as newTable) group by indetifier
//
//
//
//
//select department_id,avg(salary) from employee group by deprtmenmt_id;
//
//
//
//
//
//class Person {
//	String name;
//}
//
//public class Test {
//	static void modify(Person obj) {
//		obj.name = "Rahul";
//		obj = new Person();
//		obj.name = "Amit";
//	}
//
//	public static void main(String[] args) {
//		Person p = new Person();
//		p.name = "Sumit";
//
//		modify(p);
//
//		System.out.println(p.name);
//	}
//}











