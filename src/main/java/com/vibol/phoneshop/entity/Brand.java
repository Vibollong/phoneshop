package com.vibol.phoneshop.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "brands")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// Id for put id in Entity 
	// GeneratedValue = put auto for id 
	@Column(name = "brand_id")
	private Integer id;
	
	@Column(name ="brand_name")
	private String name;
	
}