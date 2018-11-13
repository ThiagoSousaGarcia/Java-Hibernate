package br.ufc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Funcionario f = new Funcionario();
		f.setCodigo(1);
		f.setCargo("Gerente");
		f.setNome("Tirulipa");
		
		Funcionario f1 = new Funcionario();
		f1.setCodigo(2);
		f1.setCargo("Vendedor");
		f1.setNome("Ricardo");
		
		Funcionario f2 = new Funcionario();
		f2.setCodigo(3);
		f2.setCargo("Auxiliar de Vendas");
		f2.setNome("Gabriel");
		
		em.persist(f);
		em.persist(f1);
		em.persist(f2);
		
		Produto p = new Produto();
		p.setCodigo(1);
		p.setNome("Água");
		p.setPreco(2.00);
		
		Produto p1 = new Produto();
		p1.setCodigo(2);
		p1.setNome("Trufas");
		p1.setPreco(1.00);
		
		Produto p2 = new Produto();
		p2.setCodigo(3);
		p2.setNome("Dindins");
		p2.setPreco(1.50);
		
		Venda v = new Venda();
		List<Produto> produtos = new LinkedList<Produto>();
		produtos.add(p);
		produtos.add(p1);
		v.setCodigo(1);
		v.setFuncionario(f1);
		Calendar cal = Calendar.getInstance();
		v.setDataHora(cal.getTime());
		v.setProdutos(produtos);
		
		Venda v1 = new Venda();
		List<Produto> produtos1 = new LinkedList<Produto>();
		produtos1.add(p2);
		produtos1.add(p1);
		v1.setCodigo(2);
		v1.setFuncionario(f);
		v1.setDataHora(cal.getTime());
		v1.setProdutos(produtos1);
		
		List<Venda> vendas = new LinkedList<Venda>();
		vendas.add(v);
		vendas.add(v1);
		p.setVendas(vendas);
		p1.setVendas(vendas);
		p2.setVendas(vendas);
		
		em.persist(p);
		em.persist(p1);
		em.persist(p2);
		em.persist(v);
		em.persist(v1);
		
		tx.commit();
		em.close();
		emf.close();
	}
}
