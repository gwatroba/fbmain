package pl.familybook.fbmain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Profile{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private long id;
	@Column(length=25, nullable = false)
	private String firstName;
	@Column(length=25, nullable = false)
	private String lastName;
	@Column(length=25, unique = true, nullable = false)
	private String email;
	
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

	public void setId(long id) {
		this.id = id;
	}

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
	
	
}
