package pab.pab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pab.pab.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

}
