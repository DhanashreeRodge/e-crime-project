package com.app.entites;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="policeConstables")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PoliceConstable extends BaseEntity {
	
	@NotBlank
    @Size( max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 5, max = 50)
    private String badgeNumber;

    @ManyToOne
    @NotNull
    private PoliceStation policeStation;

}
