package hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int tmp_student = 5;
						
			session.beginTransaction();
			
			Student mystudent = session.get(Student.class, tmp_student);
			mystudent.setFirstName("Uncle");
			mystudent.setLastName("Scrooge");
			mystudent.setEmail("scrooge@testmail.com");
			
			session.createQuery("update Student set first_name='Minnie', email='minnie@testmail.com'"
					+ " where id=3").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}


	}

}
