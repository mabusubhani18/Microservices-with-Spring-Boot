package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	//Basic Approch(URIs Versioning)
	@GetMapping("V1/person")
	public PersonV1 pesonV1() {
		return new PersonV1("Bob cha");
	}
	
	@GetMapping("V2/person")
	public PersonV2 pesonV2() {
		return new PersonV2(new Name("Bob","cha"));
	}
	
	//Param Approch (Params Versioning)
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Bob cha");
	}
	
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob","cha"));
	}
	
	//Header Approch(header Param)
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Bob cha");
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob","cha"));
	}
	
	//Produces Approch (Accept header versioning)
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Bob cha");
	}
		
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 prodecesV2() {
		return new PersonV2(new Name("Bob","cha"));
	}
}
