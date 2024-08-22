package com.app.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@Column
	private String criminalName;

	
	@Column
	private String criminalAddress; 
	
	
	
	

}
