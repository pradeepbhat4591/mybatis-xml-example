package com.pradeep.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pradeep.mybatis.model.Student;

public class MyBatisUpdateTest {
	public static void main(String args[]) throws IOException {

		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		// select a particular student using id
		Student student = (Student) session.selectOne("Student.getById", 17);
		System.out.println("Current details of the student are");
		System.out.println(student.toString());

		student.setEmail("mohamad123@yahoo.com");
		student.setPhone(90000000);

		// Update the student record
		session.flushStatements();
		System.out.println("Record updated successfully");
		session.commit();
		session.close();
		session = sqlSessionFactory.openSession();
		// verifying the record
		Student std = (Student) session.selectOne("Student.getById", 17);
		System.out.println("Details of the student after update operation");
		System.out.println(std.toString());
		session.commit();
		session.close();
	}
}
