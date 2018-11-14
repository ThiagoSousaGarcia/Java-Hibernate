package br.ufc.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
	@SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "venda_produto", joinColumns = {
	@JoinColumn(name = "codigo_venda") },
	inverseJoinColumns = { @JoinColumn(name = "codigo_produto") }) 
	private List<Produto> produtos = new LinkedList<Produto>();
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="codigo_funcionario")
	private Funcionario funcionario = new Funcionario(); 
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setDataHora(Date data) {
		this.dataHora = data;
	}
	
	public Date getDataHora() {
		return this.dataHora;
	}
	
	public void setProdutos(List<Produto> produtos){
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos(){
		return this.produtos;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Funcionario getFuncionario() {
		return this.funcionario;
	}
}
