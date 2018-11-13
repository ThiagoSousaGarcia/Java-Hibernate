package br.ufc;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {
	
	@Id
	private long id;
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId(){
		return this.id;
	}
}

