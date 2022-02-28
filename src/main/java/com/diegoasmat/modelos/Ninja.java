package com.diegoasmat.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ninjas")
public class Ninja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El nombre no puede estar en blanco")
	@Size(min = 2,message = "El nombre debe tener como minimo 2 caracteres")
	private String firstName;
	
	@NotBlank(message = "El apellido no puede estar en blanco")
	@Size(min = 2,message = "El apellido debe tener como minimo 2 caracteres")
	private String lastName;
	
	@NotNull
	@Min(value = 15,message = "El Ninja debe tener almenos 15 años")
	private Integer age;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createdAt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dojo_id")
	private Dojo dojo;
	
	
	public Ninja() {
		
	}


	public Ninja(String firstName,String lastName,Integer age, Dojo dojo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dojo = dojo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Date getCreatedAt() {
		return createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}


	public Dojo getDojo() {
		return dojo;
	}


	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
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
