package com.app.entites;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="criminals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Criminal extends BaseEntity {
	
	private String criminalName;

	@OneToOne(cascade =CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address criminalAddress; 
	
	
	
	

}
