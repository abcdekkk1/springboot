package com.dns.springboot3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productLines")
public class ProductLines {

	@Id
	@GeneratedValue
	@Column(name="productLine", length = 50, nullable = false)
	private String productLine;
	@Column(name="textDescription", length = 4000)
	private String textDescription = null;
	@Column(name="htmlDescription", columnDefinition = "mediumtext")
	private String htmlDescription;
	@Column(name="image", columnDefinition = "mediumblob")
	private String image;
	
	
}
