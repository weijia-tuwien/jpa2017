package jpa2017;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import DAO.AccountDAO;
import DAO.CustomerDAO;
import DAO.UserDAO;
import model.Account;
import model.Address;
import model.Customer;
import model.User;

public class TestAll {

	EntityManagerFactory emf;
	EntityManager em;
	Logger logger;

	@Before
	public void setupTest() {

		logger = Logger.getRootLogger();
		logger.debug("------------------- Setting up test data... -------------------");

		User u1 = new User("User1");
		User u2 = new User("User2");
		User u3 = new User("User3");

		Address a1 = new Address("city1", "zip1");
		Address a2 = new Address("city2", "zip2");
		Address a3 = new Address("city3", "zip3");

		Customer c1 = new Customer("User4");
		Customer c2 = new Customer("User5");
		Customer c3 = new Customer("User6");

		Account acc1 = new Account("account1");
		Account acc2 = new Account("account2");
		Account acc3 = new Account("account3");
		Account acc4 = new Account("account4");
		Account acc5 = new Account("account5");
		Account acc6 = new Account("account6");

		u1.setAddress(a1);
		u2.setAddress(a2);
		u3.setAddress(a3);

		c1.setAddress(a1);
		c2.setAddress(a2);
		c3.setAddress(a3);

		c1.addAccount(acc1);
		c1.addAccount(acc2);
		c1.addAccount(acc3);
		c2.addAccount(acc4);
		c2.addAccount(acc5);
		c3.addAccount(acc6);

		acc1.setCustomer(c1);
		acc2.setCustomer(c1);
		acc3.setCustomer(c1);
		acc4.setCustomer(c2);
		acc5.setCustomer(c2);
		acc6.setCustomer(c3);

		emf = Persistence.createEntityManagerFactory("jpa-data");
		em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(u1);
		em.persist(u2);
		em.persist(u3);

		em.persist(c1);
		em.persist(c2);
		em.persist(c3);

		em.persist(acc1);
		em.persist(acc2);
		em.persist(acc3);
		em.persist(acc4);
		em.persist(acc5);
		em.persist(acc6);

		em.getTransaction().commit();

	}

	@Test
	public void userTest() {

		UserDAO userDAO = new UserDAO(em);
		assertEquals(6, userDAO.getAll().size());

	}

	@Test
	public void addressTest() {
		UserDAO userDAO = new UserDAO(em);
		User user = userDAO.getAll().get(0);
		assertEquals("city1", user.getAddress().getCity());
	}

	@Test
	public void customerTest() {
		CustomerDAO customerDAO = new CustomerDAO(em);
		assertEquals(3, customerDAO.getAll().size());

	}

	@Test
	public void accountTest() {
		AccountDAO accountDAO = new AccountDAO(em);
		assertEquals(6, accountDAO.getAll().size());

	}

	@After
	public void afterTest() {
		em.close();
		emf.close();
	}

}
