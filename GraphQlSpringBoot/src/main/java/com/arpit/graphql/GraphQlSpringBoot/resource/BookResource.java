package com.arpit.graphql.GraphQlSpringBoot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.graphql.GraphQlSpringBoot.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("rest/books")
public class BookResource {
	
	@Autowired
	private GraphQLService graphQLService;
	
	@PostMapping
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
		ExecutionResult exceute =
				graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<Object>(exceute, HttpStatus.OK);
	}
}
