package NoteBook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import NoteBook.LoginEntity.User;
import NoteBook.LoginRepo.UserRepo;
import NoteBook.entity.NoteBook;
import NoteBook.repository.NoteBookRepository;



@Service
public class NoteBookService {
    
    @Autowired
    private NoteBookRepository notebookRepository;
    @Autowired
    private UserRepo userRepository;
    
    
    public void save(NoteBook note) {
    	notebookRepository.save(note);
    }
    
   
    
    public NoteBook getNotesById(int id) {
        return notebookRepository.findById(id).orElse(null);
    }
    
    public void deleteById(int id) {
    	notebookRepository.deleteById(id);
    }





	public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
//	public List<NoteBook> getAllBooks() {
//        return notebookRepository.findAll(); // This will fetch all books with associated users
//    }
//	
	

	public List<NoteBook> getNotesByUserId(int userId) {
	    return notebookRepository.findByUserId(userId); // Assuming you have a method findByUserId in your repository
	}

   
 

}
