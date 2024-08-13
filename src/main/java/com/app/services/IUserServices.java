package com.app.services;

import com.app.dto.Complaintdto;
import com.app.dto.Feedbackdto;
import com.app.dto.Logindto;
import com.app.dto.MissingPersondto;
import com.app.dto.Userdto;
import com.app.entites.Complaint;
import com.app.entites.Feedback;
import com.app.entites.Missing_Person;
import com.app.entites.User;


public interface IUserServices {
	
	public User addUser(Userdto userdto);
	
	public Complaint addComplaint(Complaintdto complaintdto);
	
	public Feedback addFeedback(Feedbackdto feedbackdto);
	
	public Missing_Person addMissingPerson(MissingPersondto missingdto);
	
	public User editUser(Long id,Userdto userdto);
	
	public Complaint editComplaint(Long id, Complaintdto cdto);
	
	public Missing_Person editMissingPerson(Long id, MissingPersondto cdto);
	
	public Userdto getAllDetails(Long id);
	
	public Userdto signIn(Userdto logindto);

}
