package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import model.Account;

public class AccountDAO {
	EntityManager em;

	public AccountDAO(EntityManager em) {
		super();
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAll() {
		return em.unwrap(org.hibernate.Session.class).createCriteria(Account.class).list();

	}

}
