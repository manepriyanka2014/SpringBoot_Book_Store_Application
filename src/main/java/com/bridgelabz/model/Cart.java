//package com.bridgelabz.model;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "Cart")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Cart {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int cartId;
//	
//	@OneToOne
//	private Customer customer;
//
//	@OneToMany
//	private List<CartBook> cartbook;
//	
//}
