package br.com.buzzpage.dozer;

import java.io.Serializable;

public class PersonDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonDomain [name=" + name + ", age=" + age + "]";
	}
}