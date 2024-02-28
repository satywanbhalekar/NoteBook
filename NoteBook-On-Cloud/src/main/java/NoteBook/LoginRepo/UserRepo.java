package NoteBook.LoginRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import NoteBook.LoginEntity.User;





public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	public boolean existsByEmail(String email);

}
