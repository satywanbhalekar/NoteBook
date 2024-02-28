package NoteBook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import NoteBook.entity.NoteBook;



@Repository
public interface NoteBookRepository extends JpaRepository<NoteBook, Integer> {
    // Custom method to fetch books by user's email
   
    List<NoteBook> findByUserId(int userId);
	
   
}

