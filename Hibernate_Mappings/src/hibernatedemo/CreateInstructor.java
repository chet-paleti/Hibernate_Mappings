package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernatedemo.Instructor;
import hibernatedemo.InstructorDetail;

public class CreateInstructor {

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
			Instructor instructor = new Instructor("IF5","IL5","i5@testmail.com");
			InstructorDetail instructor_det = new InstructorDetail("Test Channel","Bollywood");
			instructor.setInstructorDetail(instructor_det);
			System.out.println(instructor);
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
