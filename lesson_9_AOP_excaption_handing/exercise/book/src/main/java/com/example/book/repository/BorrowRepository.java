package com.example.book.repository;


import com.example.book.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
	List<Borrow> findByBorrowerId(long borrowerId);
	List<Borrow> findByBookId(long bookId);
}
