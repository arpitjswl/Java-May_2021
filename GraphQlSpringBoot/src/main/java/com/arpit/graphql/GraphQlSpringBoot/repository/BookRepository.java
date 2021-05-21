package com.arpit.graphql.GraphQlSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arpit.graphql.GraphQlSpringBoot.model.Book;

public interface BookRepository extends JpaRepository<Book, String>{

}
