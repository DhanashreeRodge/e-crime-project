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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
