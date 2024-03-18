package hibernatedemo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructor {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int tmp_instructor_det = 3;
						
			session.beginTransaction();
			
			InstructorDetail myinstructor = session.get(InstructorDetail.class, tmp_instructor_det);
			System.out.println("Instructor Detail is :" + myinstructor);
			
			System.out.println("Associated Instructor is :" + myinstructor.getInstructor());
			
			System.out.println("Associated Courses :" + myinstructor.getInstructor().getCourses());
			
			List<Course> courses = myinstructor.getInstructor().getCourses() ;
			for (Course course : courses ) {
			System.out.println("Associated Reviews :" + course.getReviews());
			}
						
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
