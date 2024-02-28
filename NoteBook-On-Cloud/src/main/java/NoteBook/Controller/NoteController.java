package NoteBook.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import NoteBook.LoginEntity.User;
import NoteBook.Service.NoteBookService;
import NoteBook.entity.NoteBook;

import java.security.Principal;
import java.util.*;

@Controller
public class NoteController {
	
	@Autowired
	private NoteBookService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/user")
	public String profile() {
		return "profile";
	}
	
	@GetMapping("/user/add_note")
	public String NoteRegister() {
		return "addnote";
	}
	
	
	@GetMapping("/home")
	public String Notehome() {
		return "home";
	}
	

	@GetMapping("/user/my_notes")
	public String getAllNote(Model model, Principal principal) {
	    if (principal != null) {
	        // Retrieve the currently logged-in user
	        String username = principal.getName();
	        User user = service.findByEmail(username);
	        

	        // Check if the user exists
	        if (user != null) {
	            // Retrieve books associated with the user's ID
	            List<NoteBook> Notes = service.getNotesByUserId(user.getId());
	            System.out.println(Notes);
	            model.addAttribute("Note", Notes);
	            return "noteList";
	        } else {
	            // Handle the case where the user does not exist (optional)
	            return "redirect:/login";
	        }
	    } else {
	        // Handle the case where the user is not authenticated
	        return "redirect:/login";
	    }
	}




	
	@PostMapping("/user/save")
	public String addNote(@ModelAttribute NoteBook b, Principal principal) {
	    // Retrieve the currently logged-in user
	    String username = principal.getName();
	    User user = service.findByEmail(username); // Assuming you have a method to find a user by email

	    // Set the user for the book
	    b.setUser(user);

	    // Save the book
	    service.save(b);

	    // Redirect to the available books page
	    return "redirect:/user/my_notes";
	}

	

	
	
	
	@GetMapping("/user/editnote/{id}")
	public String editNote(@PathVariable int id,Model model) {
		NoteBook b=service.getNotesById(id);
		model.addAttribute("Note",b);
		return "noteEdit";
	}
	
	
	@GetMapping("/user/deletenote/{id}")
	public String deleteNote(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/user/my_notes";
	}
	

}
