package com.pradeep.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pradeep.mybatis.model.Student;

public class MyBatisInsertTest {

	public static void main(String args[]) throws IOException{
	      
	      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	      SqlSession session = sqlSessionFactory.openSession();
	      
	      //Create a new student object
	      Student student = new Student("Mohammad","It", 80, 984803322, "Mohammad@gmail.com" ); 
	      Student shiv = new Student("Shiv", "EC", 95, 945585858, "shiv@gmail.com");
	            
	      //Insert student data      
	      session.insert("Student.insert", student);
	      session.insert("Student.insert", shiv);
	      System.out.println("record inserted successfully");
	      session.commit();
	      session.close();
				
	   }
}
