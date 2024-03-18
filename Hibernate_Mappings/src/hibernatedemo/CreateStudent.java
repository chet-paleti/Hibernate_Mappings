package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateStudent {

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
			
			int course_id = 16;
			Student tmpstudent = new Student("Learned","Pandit","pandit@testmail.com");
			Course tmpcourse = session.get(Course.class, course_id);
			tmpstudent.addCourse(tmpcourse);
			
			session.save(tmpstudent);
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
