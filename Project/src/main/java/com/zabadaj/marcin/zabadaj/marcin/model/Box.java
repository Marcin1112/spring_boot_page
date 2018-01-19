package com.zabadaj.marcin.zabadaj.marcin.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "box")
public class Box {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "box_id")
	private int id;

	@Column(name = "name")
	private String name;

	public Box() {
	}

	public Box(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
