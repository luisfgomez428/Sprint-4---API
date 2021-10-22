package com.grupo3.historiasapi.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="estudiante")
public class Estudiante {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombres", nullable = false, length = 50)
	private String nombres;
	
	@Column(name="apellidos", nullable = false, length = 50)
	private String apellidos;
	
	@Column(name="grado", nullable = false, length = 20)
	private String grado;
	
	@Column(name="email", nullable = false, length = 100)
	private String email;
	
	@Column(name="celular")
	private Long celular;
	
	@Column(name="edad", nullable = false)
	private int edad;
	
	@Column(name="fechanacimiento")
	private Date fechanacimiento;
	
	@Column(name="sexo", nullable = false, length = 1)
	private String sexo;
	
	@Column(name="direccion", nullable = false, length = 200)
	private String direccion;
	
	private Estudiante() {
		
	}


}

