package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernatedemo.Instructor;
import hibernatedemo.InstructorDetail;

public class AddCourseStudent {

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
			
			//int instructor_id=3;
			//Instructor tmp_inst = session.get(Instructor.class, instructor_id);
			//Course course_1 = new Course("Test Course");
			//tmp_inst.addCourse(course_1);
			
			int course_id = 17;
			Course course_1 = session.get(Course.class, course_id);
			course_1.addReview(new Review("Thak ... Dina Din Thak !!"));
			//course_1.addReview(new Review("Sure to get u into show business !!!"));
						
			session.save(course_1);
						
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
