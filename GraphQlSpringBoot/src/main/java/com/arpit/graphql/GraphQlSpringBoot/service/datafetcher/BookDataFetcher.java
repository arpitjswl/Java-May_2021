package com.arpit.graphql.GraphQlSpringBoot.service.datafetcher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.arpit.graphql.GraphQlSpringBoot.model.Book;
import com.arpit.graphql.GraphQlSpringBoot.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetcher implements DataFetcher<Book>{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
		

		String isn = dataFetchingEnvironment.getArgument("id");
		
		return bookRepository.findById(isn).get();
	}

}
