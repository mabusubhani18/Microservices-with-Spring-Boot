package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
//import org.springframework.hateoas.Resource;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService service;
	
	//GET /Users
	//retrieveAllUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();  
	}
	 	
	//retrieveUsers(int id)
	/*
	 * @GetMapping("/users/{id}") public EntityModel<User>
	 * retrieveUsers(@PathVariable int id) { User user=service.findOne(id);
	 * if(user==null) { throw new UserNotFoundException("id-"+id); }
	 * //"all-users",SERVER_PATH+"/users" //retrievelAllUsers EntityModel<User>
	 * model = new EntityModel<>(user); WebMvcLinkBuilder linkTo =
	 * linkTo(methodOn(this.getClass()).retrieveAllUsers());
	 * model.add(linkTo.withRel("all-users"));
	 * 
	 * //HAETOAS return model; }
	 */
	
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id) {
		User user=service.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
		
		//return user;
	}
	//input - details of User
	//output - CREATED & Return the Created URI
	@PostMapping("/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		//Created
		// /user/4
		URI location=ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
}
