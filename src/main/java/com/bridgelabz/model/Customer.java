package com.bridgelabz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="customer") 
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "CUSTOMER_NAME")
	private String name;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	@Column(name = "PIN_CODE")
	private Long pinCode;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CITY")
	private String city;
	@Column(name = "ADDRESS_TYPE")
	private String addressType;
	
    @OneToMany
    private List<Book>cartBook = new ArrayList();
    
//    @OneToMany
//    private int orderId;
	
}
