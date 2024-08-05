package com.app.entites;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.app.enums.Category;
import com.app.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="complaints")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Complaint extends BaseEntity {
	    @NotNull
	    @Size(min = 5, max = 100)
	    private String complaintTitle;

	    @NotNull
	    @Size(min = 10, max = 1000)
	    private String complaintDescription;

	    @NotNull
	    @PastOrPresent
	    private LocalDate complaintDate;

	    @NotNull
	    private Status status;
	    
	    @NotNull
	    private Category category;

	    @Size(max = 255)
	    private String location;

//	    //@ManyToOne
//	    //@NotNull
//	    private User user;
//	    
//	    @ManyToOne(cascade = CascadeType.ALL)
//	    @NotNull
//	    private PoliceStation policeStation; // Added relationship to PoliceStation
	    
	    @OneToOne
	    @NotNull
	    private Feedback complaint_feedback;
	    
	    @OneToMany(/*mappedBy = "complaint", */cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Missing_Person> missingPersons; // Added relationship to Missing_Person
	    
	    
	    
}
