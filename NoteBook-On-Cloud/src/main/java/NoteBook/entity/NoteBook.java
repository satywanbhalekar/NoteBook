package NoteBook.entity;




import NoteBook.LoginEntity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class NoteBook {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String subjectname;
	    private String note;
	    private String date;
	    
	    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	    @JoinColumn(name = "user_id")
	    private User user;

		public NoteBook(int id, String subjectname, String note, String date, User user) {
			super();
			this.id = id;
			this.subjectname = subjectname;
			this.note = note;
			this.date = date;
			this.user = user;
		}

		public NoteBook() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getSubjectname() {
			return subjectname;
		}

		public void setSubjectname(String subjectname) {
			this.subjectname = subjectname;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "NoteBook [id=" + id + ", subjectname=" + subjectname + ", note=" + note + ", date=" + date + ", user="
					+ user + "]";
		}

	   
	
	

}
