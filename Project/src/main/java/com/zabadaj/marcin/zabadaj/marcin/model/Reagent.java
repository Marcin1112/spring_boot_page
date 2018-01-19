package com.zabadaj.marcin.zabadaj.marcin.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "reagent")
public class Reagent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reagent_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "purity")
	private String purity;

	@Column(name = "amount")
	private String amount;

	@Column(name = "volume")
	private String volume;

	@Column(name = "comment")
	private String comment;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "box_id")
	private Box box;

	public Reagent() {
	}

	public Reagent(int id, String name, String manufacturer, String purity, String amount, String volume,
			String comment, Box box) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.purity = purity;
		this.amount = amount;
		this.volume = volume;
		this.comment = comment;
		this.box = box;
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

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getPurity() {
		return purity;
	}

	public void setPurity(String purity) {
		this.purity = purity;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}
}
