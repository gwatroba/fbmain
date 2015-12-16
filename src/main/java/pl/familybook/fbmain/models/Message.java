package pl.familybook.fbmain.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Message {
	
	@Id
	@Column(insertable = false, columnDefinition = "SERIAL")
	private long id;
	@Column(columnDefinition = "TEXT NOT NULL")
	private String text;
	@Column(nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date created;

	public long getId() {
		return id;
	}

//	public void setId(long id) {
//		this.id = id;
//	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreated() {
		return created;
	}

//	public void setCreated(Date created) {
//		this.created = created;
//	}

}
