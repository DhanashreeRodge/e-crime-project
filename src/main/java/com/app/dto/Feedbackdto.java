package com.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Feedbackdto {
	
	    @NotBlank
	    @Size(min = 10, max = 1000)
	    private String content;
	    
	    private Long userId;


}
