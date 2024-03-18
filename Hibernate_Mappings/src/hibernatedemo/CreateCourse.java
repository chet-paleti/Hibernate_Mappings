package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernatedemo.Instructor;
import hibernatedemo.InstructorDetail;

public class CreateCourse {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int instructor_id=5;
			//int student_1 = 2;
			//int student_2 = 3;
			Instructor tmp_inst = session.get(Instructor.class, instructor_id);
			//Student stud_1 = session.get(Student.class, student_1);
			//Student stud_2 = session.get(Student.class, student_2);
			
			Course course_1 = new Course("Bollywood Dancing");
			
			tmp_inst.addCourse(course_1);
			//course_1.addStudent(stud_1);
			//course_1.addStudent(stud_2);
					
			session.save(course_1);
			
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
