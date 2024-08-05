package com.app.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="feedbacks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Feedback extends BaseEntity {
	
	 
	    @NotBlank
	    @Size(min = 10, max = 1000)
	    private String content;

	    @NotNull
	    @PastOrPresent
	    private LocalDate feedbackDate;

//	    @OneToOne
//	    @NotNull
//	    private User user;


}
