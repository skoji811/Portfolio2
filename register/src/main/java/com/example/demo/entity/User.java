package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "jan")
	private Long jan;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "expiration")
	private Long expiration;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@Column(name = "create_date")
	private Date createDate;
	

	
	
}
