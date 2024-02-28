package NoteBook.LoginService;

import NoteBook.LoginEntity.User;

public interface UserService {

	public User saveUser(User user);

	public void removeSessionMessage();
	
	public boolean checkEmail(String email);

	User updateEmployee(User user, int id);

	
}
