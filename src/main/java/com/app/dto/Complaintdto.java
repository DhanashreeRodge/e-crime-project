package com.app.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.app.enums.Category;
import com.app.enums.Status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Complaintdto {

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
    private Status status;  // Use Status enum

    @NotNull
    private Category category;  // Use Category enum

    @Size(max = 255)
    private String location;

    @NotNull
    private Long userId;  // ID of the user making the complaint
	
}
