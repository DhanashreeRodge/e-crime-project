package com.app.services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.Complaintdto;
import com.app.dto.Feedbackdto;
import com.app.dto.Logindto;
import com.app.dto.MissingPersondto;
import com.app.dto.Userdto;
import com.app.entites.Address;
import com.app.entites.Complaint;
import com.app.entites.Feedback;
import com.app.entites.Missing_Person;
import com.app.entites.User;
import com.app.enums.Category;
import com.app.enums.Gender;
import com.app.enums.Role;
import com.app.enums.Status;
import com.app.exception.InvalidCredentialsException;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.IComplaintRepository;
import com.app.repository.IFeedbackRepository;
import com.app.repository.IMissingPersonRepository;
import com.app.repository.IUserRepository;

@Service
@Transactional
public class UserServices implements IUserServices {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IComplaintRepository complaintRepository;
	
	@Autowired
	private IFeedbackRepository feedbackRepository;
	
	@Autowired
	private IMissingPersonRepository missingPersonRepository;
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public User addUser(Userdto userdto) {
		// TODO Auto-generated method stub
		
		if(userRepository.findByEmailId(userdto.getEmailId()).isPresent()) {
			throw new IllegalArgumentException("Email ID is already exist");
		}
		
		validatePassword(userdto.getPassword());

		User users = new User();
		users.setFirstName(userdto.getFirstName());
		users.setLastName(userdto.getLastName());
		// users.setAddress(userdto.getAddress());
		users.setContactNo(userdto.getContactNo());
		users.setDob(userdto.getDob());
		users.setEmailId(userdto.getEmailId());
		users.setPassword(userdto.getPassword());
		users.setGender(Gender.valueOf(userdto.getGender()));
		users.setRole(Role.valueOf(userdto.getRole()));

		if (userdto.getAddress() != null) {
			Address address = new Address();
			address.setAdrLine1(userdto.getAddress().getAdrLine1());
			address.setCity(userdto.getAddress().getCity());
			address.setState(userdto.getAddress().getState());
			address.setCountry(userdto.getAddress().getCountry());
			// address.setZipCode(userdto.getAddress().getZipCode());
			address.setZipCode(userdto.getAddress().getZipCode());
		
			users.setAddress(address);
		}

		return userRepository.save(users);

	}
	
	private void validatePassword(String password) {
		if(password == null || password.length() < 8 || !password.matches(".*\\d.*")) {
			throw new IllegalArgumentException("Password must be at least 8 characters long and contain at least one digit.");
		}
	}

	@Override
	public Complaint addComplaint(Complaintdto complaintdto) {

		Complaint complaints = new Complaint();
		complaints.setComplaintTitle(complaintdto.getComplaintTitle());
		complaints.setComplaintDescription(complaintdto.getComplaintDescription());
		complaints.setComplaintDate(complaintdto.getComplaintDate());
		complaints.setLocation(complaintdto.getLocation());
//		complaints.setCategory(Category.valueOf(complaintdto.getCategory()));
//		//complaints.setCategory(Category.valueOf(complaintdto.getCategory()));
//		complaints.setStatus(Status.valueOf(complaintdto.getStatus()));
//		return  complaintRepository.save(complaints);
		//complaints.setUserId(complaintdto.getUser().getId());
		complaints.setCategory((complaintdto.getCategory()));
		complaints.setStatus((complaintdto.getStatus()));

		User user = userRepository.findById(complaintdto.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));
		complaints.setUser(user);

		Complaint savedComplaint = complaintRepository.save(complaints);
		
		return savedComplaint;
		// Save the complaint entity
		//return complaintRepository.save(complaints);
	}

//	@Override
//	public Feedback addFeedback(Feedbackdto feedbackdto) {
//		
//		User feedback = userRepository.findById(feedbackdto.getUserId())
//				.orElseThrow(()->
//				new ResourceNotFoundException("Invalid Id"));
//		
//		
//		Feedback feed=modelmapper.map(feedbackdto, Feedback.class);
//		feed.setUser(feedback);
//		return feedbackRepository.save(feed);
//				
//			}
//
	@Override
	public Feedback addFeedback(Feedbackdto feedbackdto) {
	    // Fetch the User entity based on userId from the Feedbackdto
	    User user = userRepository.findById(feedbackdto.getUserId())
	            .orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));

	    // Map Feedbackdto to Feedback entity
	    Feedback feedback = modelmapper.map(feedbackdto, Feedback.class);

	    // Set the fetched User entity in the Feedback entity
	    feedback.setUser(user);

	    // Save the Feedback entity in the repository
	    return feedbackRepository.save(feedback);
	}

	@Override
	public Missing_Person addMissingPerson(MissingPersondto missingdto) {
		
		Complaint complaints=complaintRepository.findById(missingdto.getComplaintId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Complaint Id"));
		
		Missing_Person ms=modelmapper.map(missingdto, Missing_Person.class);
		
		ms.setComplaint(complaints);
		
		
		return missingPersonRepository.save(ms);
	}

	@Override
	public User editUser(Long id,Userdto userdto) {
		
		User existingUser=userRepository.findById(id)
				.orElseThrow(() ->new RuntimeException("Invalid User Id"));
		
		modelmapper.map(userdto, existingUser);
		
		
		return userRepository.save(existingUser);
	}

	@Override
	public Complaint editComplaint(Long id, Complaintdto cdto) {

		Complaint existingComplaint=complaintRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Invalid Complaint Id"));
		
		modelmapper.map(cdto,existingComplaint);
		return complaintRepository.save(existingComplaint);
	}

	@Override
	public Missing_Person editMissingPerson(Long id, MissingPersondto cdto) {

		Missing_Person ms=missingPersonRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Invalid Missing Person Id"));
		modelmapper.map(cdto,ms);
		return missingPersonRepository.save(ms);
	}

	@Override
	public Userdto getAllDetails(Long id) {
		
		User users=userRepository.findById(id)
				.orElseThrow(() ->new RuntimeException ("Invalid User Id"));
		return modelmapper.map(users,Userdto.class);
		
		//return userRepository.findAllById(users);
	}

	@Override
	public Userdto signIn(Userdto logindto) {
		
		System.out.println(logindto.getEmailId()+ " "+logindto.getPassword());
		User users=userRepository.findByEmailIdAndPassword(logindto.getEmailId(), logindto.getPassword())
				.orElseThrow(()-> new InvalidCredentialsException("Invalid Email And Password"));
		return modelmapper.map(users,Userdto.class );
	}
	
	

}
