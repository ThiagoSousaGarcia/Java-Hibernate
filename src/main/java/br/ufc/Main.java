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
		

		
		Funcionario f = new Funcionario();
		
		f.setCodigo(3);
		f.setCargo("Dono");
		f.setNome("Trufinha");
		
		em.persist(f);
		

		
		
		
		tx.commit();
		em.close();
		emf.close();
	}
}
