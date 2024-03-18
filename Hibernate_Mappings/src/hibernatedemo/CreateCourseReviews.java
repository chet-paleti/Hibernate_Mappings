package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernatedemo.Instructor;
import hibernatedemo.InstructorDetail;

public class CreateCourseReviews {

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
			
				
			int student_id = 3;
			int course_id = 17;
			Course mycourse = session.get(Course.class, course_id);
			Student stud = session.get(Student.class, student_id);
			
			//stud.addCourse(mycourse);
			//session.save(stud);
			
			mycourse.addStudent(stud);
			session.save(mycourse);
			
						
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
