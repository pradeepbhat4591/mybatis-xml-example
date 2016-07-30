package com.pradeep.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pradeep.mybatis.model.Student;

public class MyBatisReadAllTest {
	public static void main(String args[]) throws IOException{

	      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	      SqlSession session = sqlSessionFactory.openSession();
	      
	      List<Student> student = session.selectList("Student.getAll");
	      
	    
	          
	      for(Student st : student ){    	  
	         System.out.println(st.getId());
	         System.out.println(st.getName());
	         System.out.println(st.getBranch());
	         System.out.println(st.getPercentage());         
	         System.out.println(st.getEmail());        
	         System.out.println(st.getPhone());   
	      }  
			
	      System.out.println("Records Read Successfully ");          
	      session.commit();   
	      session.close();			
	   }
}
