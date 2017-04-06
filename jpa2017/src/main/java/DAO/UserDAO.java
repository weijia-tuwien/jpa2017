package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import model.User;

public class UserDAO {

	EntityManager em;

	public UserDAO(EntityManager em) {
		super();
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return em.unwrap(org.hibernate.Session.class).createCriteria(User.class).list();
	}

}
