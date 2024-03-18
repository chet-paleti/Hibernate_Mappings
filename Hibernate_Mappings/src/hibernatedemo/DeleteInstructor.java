package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			int tmp_instructor = 4;
						
			session.beginTransaction();
			
			Instructor myinstructor = session.get(Instructor.class, tmp_instructor);
			InstructorDetail myinstructor_det = session.get(InstructorDetail.class, tmp_instructor);
		    
			//Deleting both Instructor and Instructor Detail in a uni relationship
			
			/*session.delete(myinstructor);*/
			
			//Doing this per se does not delete Instructor Detail
			/*myinstructor.setInstructorDetail(null);*/
			
			//Deleting Instructor from Instructor Detail ... since relationship is now Bi
			/*session.delete(myinstructor_det);*/
			
			//And this part deletes from Instructor Detail without deleting Instructor in a Bi relationship.However cascade type needs to be changed in Instructor Detail
				myinstructor_det.getInstructor().setInstructorDetail(null);
				session.delete(myinstructor_det);
				
			session.getTransaction().commit();
		} finally {
			factory.close();
		}


	}

}
