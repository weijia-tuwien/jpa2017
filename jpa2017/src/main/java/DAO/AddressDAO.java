package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import model.Address;

public class AddressDAO {

	EntityManager em;

	public AddressDAO(EntityManager em) {
		super();
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAll() {
		return em.unwrap(org.hibernate.Session.class).createCriteria(Address.class).list();
	}

}
