package NoteBook.LoginController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import NoteBook.LoginEntity.User;
import NoteBook.LoginRepo.UserRepo;
import NoteBook.LoginService.UserService;
import jakarta.servlet.http.HttpSession;


@Controller

public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if (p != null) {
			String email = p.getName();
			User user = userRepo.findByEmail(email);
			m.addAttribute("user", user);
		}

	}

	

//	@GetMapping("/register")
//	public String register() {
//		return "register";
//	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/user/profile")
	public String profile(Principal p, Model m) {
//		String email = p.getName();
//		User user = userRepo.findByEmail(email);
//		m.addAttribute("user", user);
		return "profile";
	}

	@GetMapping("/user/home")
	public String home() {
		return "home";
	}
	


	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, HttpSession session) {

		// System.out.println(user);

		
		boolean f = userService.checkEmail(user.getEmail());

		if (f) {
			session.setAttribute("msg", "Email Id alreday exists");
			
		}
		else {
			User u = userService.saveUser(user);
			if (u != null) {
				// System.out.println("save success");
				session.setAttribute("msg", "Register successfully");

			} else {
				// System.out.println("error in server");
				session.setAttribute("msg", "Something wrong server");
			}
		}

		
		return "redirect:/register";
	}
	
//	 @PutMapping("/employees/{id}")
//	    @CrossOrigin(origins = "http://127.0.0.1:5500")
//	    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
//	        Employee updatedEmployee = employeeService.updateEmployee(employee, id);
//	        if (updatedEmployee != null) {
//	            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
//	        } else {
//	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	        }
//	    }
	
	
	@PostMapping("/UpdateUser/{id}")
	public String update(@PathVariable int id,@ModelAttribute User user) {
		userService.updateEmployee(user, id);
		return "update";
	}
	

	@GetMapping("/UpdateUser")
	public String updateuser() {
		return "update";
	}

}
