package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int tmp_course=16;
						
			session.beginTransaction();
			
			Course mycourse = session.get(Course.class, tmp_course);
		   
		    session.delete(mycourse);
				
			session.getTransaction().commit();
		} finally {
			factory.close();
		}


	}

}
