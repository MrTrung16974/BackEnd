package com.example.storebook.repository;

import com.example.storebook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //    @Modifying
    //    @Transactional
    //@Query(value = "SELECT * from book b WHERE b.name LIKE %:keyword%", nativeQuery = true)
    //List<Book> searchBook(@Param("keyword") String keyword);

    List<Book> findByNameContaining(String name);
}