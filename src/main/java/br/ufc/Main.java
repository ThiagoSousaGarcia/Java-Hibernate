package br.ufc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.ufc.model.Funcionario;
import br.ufc.model.Produto;
import br.ufc.model.Venda;

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
		f.setCargo("Gerente");
		f.setNome("Tirulipa");
		
		Funcionario f1 = new Funcionario();
		f1.setCargo("Vendedor");
		f1.setNome("Ricardo");
		
		Funcionario f2 = new Funcionario();
		f2.setCargo("Auxiliar de Vendas");
		f2.setNome("Gabriel");
		
		em.persist(f);
		em.persist(f1);
		em.persist(f2);
		
		Produto p = new Produto();
		p.setNome("Água");
		p.setPreco(2.00);
		
		Produto p1 = new Produto();
		p1.setNome("Trufas");
		p1.setPreco(1.00);
		
		Produto p2 = new Produto();
		p2.setNome("Dindins");
		p2.setPreco(1.50);
		
		Venda v = new Venda();
		List<Produto> produtos = new LinkedList<Produto>();
		produtos.add(p);
		produtos.add(p1);
		v.setFuncionario(f1);
		Calendar cal = Calendar.getInstance();
		v.setDataHora(cal.getTime());
		v.setProdutos(produtos);
		
		Venda v1 = new Venda();
		List<Produto> produtos1 = new LinkedList<Produto>();
		produtos1.add(p2);
		produtos1.add(p1);
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
		
		/*Consultas SQL*/
		Query consultaproduto = em.createQuery("Select (p.nome)"+ "from Produto p " + "where p.codigo = :codigo ").setParameter("codigo",p1.getCodigo());
		List<String> nomes_produtos = consultaproduto.getResultList();
		
		for(String produto:nomes_produtos) {
			System.out.println("O nome do produto é "+ produto);
		}
		
		em.close();
		emf.close();
	}
}
