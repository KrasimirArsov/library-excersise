package com.arsov.k.library_excersise.repositories;

import com.arsov.k.library_excersise.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {
}