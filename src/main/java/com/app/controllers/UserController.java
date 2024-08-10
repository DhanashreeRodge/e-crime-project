//package com.app.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.app.dto.Userdto;
//import com.app.services.IUserServices;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//	
//	@Autowired
//	private IUserServices userServices;
//	
//	public UserController () {
//		System.out.println("In Controller"+getClass());
//	}
//	
//	@PostMapping("/register")
//	public Userdto addUser(@RequestBody Userdto user) 
//	{
//		System.out.println("In controller add user");
//		userServices.addUser(user);
//		return user;
//		
//	}
//
//}

package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Complaintdto;
import com.app.dto.Feedbackdto;
import com.app.dto.MissingPersondto;
import com.app.dto.Userdto;
import com.app.services.IUserServices;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserServices userServices;

    @PostMapping("/register")
    public Userdto addUser(@RequestBody Userdto user) {
        System.out.println("In controller add user");
        
        
        userServices.addUser(user);
        return user;
    }
    
    @PostMapping("/complaints")
    public Complaintdto addComplaint(@RequestBody Complaintdto complaintdto)
    {
    	System.out.println("In controller add complaint");
    	userServices.addComplaint(complaintdto);
		return complaintdto;
    	
    }
    
    @PostMapping("/feedback")
    public Feedbackdto addFeedback(@RequestBody Feedbackdto feedbackdto)
    {
    	System.out.println("In controller add feedback");
    	
    	userServices.addFeedback(feedbackdto);
		return feedbackdto;
    	
    }
    
    @PostMapping("/missing")
    public MissingPersondto addMissingPerson(@RequestBody MissingPersondto missingdto)
    {
    	System.out.println("In controller add Missing");
    	
    	userServices.addMissingPerson(missingdto);
		return missingdto;
    	
    }
    
    @PutMapping("/updateUser/{id}")
    public Userdto editUser(@PathVariable Long id, @RequestBody Userdto userdto)
    {
    	System.out.println("In controller update user");
    	userServices.editUser(id, userdto);
		return userdto;
    	
    }
    
    @PutMapping("/updateComplaint/{id}")
    public Complaintdto editComplaint(@PathVariable Long id, @RequestBody Complaintdto cdto)
    {
    	System.out.println("In controller update complaint");
    	userServices.editComplaint(id, cdto);
    	return cdto;
    }
    
    @PutMapping("/updateMissing/{id}")
    public MissingPersondto editMissingPerson(@PathVariable Long id, @RequestBody MissingPersondto cdto)
    {
    	System.out.println("In Controller update missing person");
    	userServices.editMissingPerson(id, cdto);
    	
    	return cdto;
    }
}
