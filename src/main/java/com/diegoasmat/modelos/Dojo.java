package com.diegoasmat.modelos;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "dojos")
public class Dojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El nombre no puede estar vacío")
	@Column(unique = true)
	@Size(min = 5, max = 255, message = "El nombre debe tener como mínimo 5 caracteres")
	private String name;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createdAt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date updatedAt;
	
	@OneToMany(mappedBy = "dojo",fetch = FetchType.LAZY)
	private List<Ninja> ninjas;
	
	public Dojo() {
		
	}

	public Dojo(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	
	@PrePersist //Ejecuta antes de crear el objeto
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate //Ejecuta cuando hay modificaciones
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
}
