package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
//import org.springframework.hateoas.Resource;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository	userRepository;
	
	@Autowired
	private PostRepository postRepository;
	//GET /Users
	//retrieveAllUsers 
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();  
	}
	 	
	//retrieveUsers(int id)
	
   @GetMapping("/jpa/users/{id}") 
   public EntityModel<User> retrieveUsers(@PathVariable int id) 
   { 
	   Optional<User> user=userRepository.findById(id);
	  // User user=user1.get();
	if(!user.isPresent()) { 
		throw new UserNotFoundException("id-"+id); 
		}
	//HAETOAS 
	  //"all-users",SERVER_PATH+"/users" 
	 EntityModel<User> model = new EntityModel<User>(user.get()); 
	 WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
	  model.add(linkTo.withRel("all-users")); 
	
	 return model;
	 
   }
	
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUsers(@PathVariable int id) {
		userRepository.deleteById(id);
		
		//return user;
	}
	//input - details of User
	//output - CREATED & Return the Created URI
	@PostMapping("/jpa/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		//Created
		// /user/4
		URI location=ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id){
		Optional<User> userOptional=userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
			
		return userOptional.get().getPost() ;
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@RequestBody Post post) {
		
		Optional<User> userOptional=userRepository.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}		
		User user = userOptional.get();		
		post.setUser(user);		
		postRepository.save(post);
		//Created
		// /user/4
		URI location=ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
