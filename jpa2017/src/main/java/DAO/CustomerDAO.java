package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import model.Customer;

public class CustomerDAO {
	EntityManager em;

	public CustomerDAO(EntityManager em) {
		super();
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		return em.unwrap(org.hibernate.Session.class).createCriteria(Customer.class).list();
	}

}
