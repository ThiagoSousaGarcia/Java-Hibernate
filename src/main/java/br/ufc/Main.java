package br.ufc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Pessoa p = new Pessoa();
		Pessoa p1 = new Pessoa();
		
		p.setId(200);
		em.persist(p);
		p1.setId(10);
		em.persist(p1);
		
		
		
		tx.commit();
		em.close();
		emf.close();
	}
}
