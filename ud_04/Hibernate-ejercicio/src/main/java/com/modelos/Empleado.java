package com.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="sueldo")
	private double sueldo;
	
	@Column(name="departamento")
	private int departamento;
		
	
	//Constructor	
	public Empleado(){}
	
	public Empleado(String nombre, double sueldo, int departamento) {
		
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}
	
	//Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", sueldo=" + sueldo + ", departamento=" + departamento
				+ "]";
	}
	
}
