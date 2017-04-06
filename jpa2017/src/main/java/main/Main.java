package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import model.User;

public class Main {
	public static void main(String[] args) {
		Logger logger = Logger.getRootLogger();
		logger.debug("hallo world");

		User u1 = new User("jordan2");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-data");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(u1);
		em.getTransaction().commit();
		em.close();

		emf.close();

	}

}
