package com.pradeep.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pradeep.mybatis.model.Student;

public class MyBatisReadByIDTest {

	public static void main(String args[]) throws IOException {

		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		// select a particular student by id
		Student student = (Student) session.selectOne("Student.getById", 17);

		// Print the student details
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getBranch());
		System.out.println(student.getPercentage());
		System.out.println(student.getEmail());
		System.out.println(student.getPhone());

		student = (Student) session.selectOne("Student.getFirst");
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getBranch());
		System.out.println(student.getPercentage());
		System.out.println(student.getEmail());
		System.out.println(student.getPhone());

		/*HashMap<String, Object> results = (HashMap<String, Object>) session
				.selectMap("student.getAllMap", "1");

		*//**
		 * loop through each row returned each key will be the column_name each
		 * value will be the field value for that row and column
		 *//*
		for (HashMap<String, Object> row : results) {

			log.info("car id: " + row.get("car_id"));
			log.info("car model: " + row.get("car_model"));
			log.info("car color: " + row.get("car_color"));

		}*/

		session.commit();
		session.close();

	}

}
