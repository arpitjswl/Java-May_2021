package com.arpit.graphql.GraphQlSpringBoot.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.*;

import org.springframework.stereotype.Service;

import com.arpit.graphql.GraphQlSpringBoot.model.Book;
import com.arpit.graphql.GraphQlSpringBoot.repository.BookRepository;
import com.arpit.graphql.GraphQlSpringBoot.service.datafetcher.AllBooksdatfetcher;
import com.arpit.graphql.GraphQlSpringBoot.service.datafetcher.BookDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {
	
	@Value("classpath:books.graphql")
	org.springframework.core.io.Resource resource;
	
	
	private GraphQL graphQl;
	
	@Autowired
	private AllBooksdatfetcher allBooksDataFetcher;
	
	@Autowired
	private BookDataFetcher bookDataFetcher;
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostConstruct
	private void loadSchema() throws IOException{
		
		loadDataIntoHSQL();
		//get the schema
		File schemaFile = resource.getFile();
		
		//parse schema
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQl = GraphQL.newGraphQL(schema).build();
		
				
	}
	
	private void loadDataIntoHSQL() {
		Stream.of(
				new Book("123", "2 STATES", "Kindle Edition", new String[] {"cetan Bahagt", "12"}, "Nov 2017"),
				new Book("3213", "The Lady at Office", "Y Edition", new String[] {"JK Rowling ", "12"}, "Nov 2019")
				).forEach(book-> {
					bookRepository.save(book);
				});
		
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring-> typeWiring
						.dataFetcher("allBooks", allBooksDataFetcher)
						.dataFetcher("book", bookDataFetcher))
						.build();
		}
	
	
		public GraphQL getGraphQL() {
			return graphQl;
		}
	
	}

	
	
	

