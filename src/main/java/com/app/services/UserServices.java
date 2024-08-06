package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.Complaintdto;
import com.app.dto.Userdto;
import com.app.entites.Address;
import com.app.entites.Complaint;
import com.app.entites.User;
import com.app.enums.Category;
import com.app.enums.Gender;
import com.app.enums.Role;
import com.app.enums.Status;
import com.app.repository.IComplaintRepository;
import com.app.repository.IUserRepository;

@Service
@Transactional
public class UserServices implements IUserServices {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IComplaintRepository complaintRepository;

	@Override
	public User addUser(Userdto userdto) {
		// TODO Auto-generated method stub

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

}
