package com.kacaz.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	private int id;
	private String message;
	private Activity belongsTo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "belongsTo")
	public Activity getBelongsTo() {
		return belongsTo;
	}
	public void setBelongsTo(Activity belongsTo) {
		this.belongsTo = belongsTo;
	}
	
}
