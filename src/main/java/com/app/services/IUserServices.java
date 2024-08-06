package com.app.services;

import com.app.dto.Complaintdto;
import com.app.dto.Feedbackdto;
import com.app.dto.Userdto;
import com.app.entites.Complaint;
import com.app.entites.Feedback;
import com.app.entites.User;


public interface IUserServices {
	
	public User addUser(Userdto userdto);
	
	public Complaint addComplaint(Complaintdto complaintdto);
	
	public Feedback addFeedback(Feedbackdto feedbackdto);

}
