package com.arpit.graphql.GraphQlSpringBoot.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arpit.graphql.GraphQlSpringBoot.model.Book;
import com.arpit.graphql.GraphQlSpringBoot.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.apachecommons.CommonsLog;

@Component
public class AllBooksdatfetcher implements DataFetcher<List<Book>>{
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment){
		return bookRepository.findAll();
	}
	

}
