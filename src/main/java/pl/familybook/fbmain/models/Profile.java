package pl.familybook.fbmain.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Profile {

	@Id
	@Column(insertable = false, columnDefinition = "SERIAL")
	//@SequenceGenerator(name = "SERIAL", sequenceName = "profile_id_seq", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERIAL") 	// incrementing by 2 :/
	private long id;
	@Column(length = 25, nullable = false, unique = true)
	private String login;
	@Column(length = 25, nullable = false)
	private String firstName;
	@Column(length = 25, nullable = false)
	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@Column(nullable = false, insertable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date created;
	// sequence for fk is made :?
	@OneToOne
	@JoinColumn(name = "profileId")
	private List<Message> messages;
	
	// ad date of birth and date of name, city, family

	public Profile() {

	}

	public Profile(long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getId() {
		return id;
	}

//	public void setId(long id) {
//		this.id = id;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		return created;
	}

//	public void setCreated(Date date) {
//		this.created = date;
//	}

}
