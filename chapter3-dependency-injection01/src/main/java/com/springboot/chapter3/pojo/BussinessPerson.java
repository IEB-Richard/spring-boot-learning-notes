package com.springboot.chapter3.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.chapter3.pojo.definition.Animal;
import com.springboot.chapter3.pojo.definition.Person;

@Component
public class BussinessPerson implements Person {
	
	private Animal animal = null;

	@Override
	public void service() {
		this.animal.use();
	}

	@Override
	@Autowired
	public void setAnimal(Animal animal) {
		System.out.println("延迟依赖注入");
		this.animal = animal;
	}

}
