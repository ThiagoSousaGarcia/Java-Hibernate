package br.ufc;

import java.util.Date;

public class Venda {
	private int codigo;
	private Date dataHora;
	
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
}
