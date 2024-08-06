package com.app.entites;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.app.enums.Gender;
import com.app.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "user")
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity {

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@NotNull
	@Positive
	private double contactNo;

	@NotNull
	@Past
	private LocalDate dob;

	@NotNull
	@Email
	@Size(max = 100)
	private String emailId;

	@NotBlank
	@Size(min = 2, max = 50)
	private String firstName;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Size(min = 2, max = 50)
	private String lastName;

	@NotBlank
	@Size(min = 8, max = 20)
	private String password;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Complaint> complaints;

//    @OneToMany(mappedBy = "user")
//    private Set<Feedback> feedbacks;

	@OneToOne(/* mappedBy = "user", */ cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Feedback feedback;

	public User(Address address, @NotNull @Positive double contactNo, @NotNull @Past LocalDate dob,
			@NotNull @Email @Size(max = 100) String emailId, @NotBlank @Size(min = 2, max = 50) String firstName,
			@NotNull Gender gender, @Size(min = 2, max = 50) String lastName,
			@NotBlank @Size(min = 8, max = 20) String password, Set<Complaint> complaints, Feedback feedback) {
		super();
		this.address = address;
		this.contactNo = contactNo;
		this.dob = dob;
		this.emailId = emailId;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.password = password;
		this.complaints = complaints;
		this.feedback = feedback;
	}

	public User() {
		this.role = Role.ROLE_USER;
	}

}
