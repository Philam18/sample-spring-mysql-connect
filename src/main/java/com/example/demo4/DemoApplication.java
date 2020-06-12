package com.example.demo4;

import com.example.demo4.dao.*;
import com.example.demo4.model.Circle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource("com/example/demo4/spring.xml")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		CircleDAO db = (CircleDAO) context.getBean("CircleDAO", CircleDAO.class);
		System.out.println(db.getCircleCount());

		Circle circle = null;



		System.out.println("CREATING CIRCLE TABLE");
		System.out.println(db.createCircleTable());

		for (Circle someCircle : db.getAllCircles()) {
			System.out.println(someCircle.getId() + " : " + someCircle.getName());
		}


		circle = new Circle(2, "I am the second circle okay? hehehe");
		System.out.println(db.insertCircle(circle));


		circle = new Circle(3, "Third circle!!!");
		System.out.println(db.insertCircle(circle));

		circle = db.getCircle(3);
		System.out.println(circle.getName());


	}

}
