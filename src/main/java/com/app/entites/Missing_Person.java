package com.app.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.app.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="missing_persons")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Missing_Person extends BaseEntity {
	
	private String firstName;
	
	private String lastName;
	
	private Gender gender;
	
	private LocalDate missingSince;
	
	private String lastKnownlocation;
	
	private String imageUrl;
	
	private String contactNo;
	
	private int age;
	
//	@ManyToOne
//    @NotNull
//    private Complaint complaint; // Added relationship to Complaint
//    
//	

}
