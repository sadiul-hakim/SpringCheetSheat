package com.hakim.springJDBC;

import com.hakim.springJDBC.dao.student.StudentRepository;
import com.hakim.springJDBC.dao.student.StudentRepositoryImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 


/**
 *
 * @author Hakim
 */
public class Main {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcConfig.xml");
//        StudentRepository repository=context.getBean("sri",StudentRepositoryImp.class);
//
//       
////        repository.saveStudent(new StudentDTO("Sadiul","Kushtia"));
////        repository.saveStudent(new StudentDTO("SH","Kushtia"));
////        repository.deleteStudent(2);
////            System.out.println(repository.getStudent(1));
//
//        
////        bean.update(query,"Hakim","Dhaka");
//        
//        System.out.println(repository.getStudents());
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        StudentRepository sr=context.getBean("repository",StudentRepositoryImp.class);
        
        System.out.println(sr.getStudent(1));
        
    }
}
