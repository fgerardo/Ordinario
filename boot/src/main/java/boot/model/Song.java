package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="songs")
public class Song implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int duration;
	@Column(length=50)
	private String title;
	@Column(length=25)
	private String artist;
	@Temporal(TemporalType.DATE)
	@Column (name="creation_date")
	private Date creationDate;
	public Song(int duration, String title, String artist, Date creationDate) {
		super();
		this.duration = duration;
		this.title = title;
		this.artist = artist;
		this.creationDate = creationDate;
	}
	
	public Song(){
		this(0,"","",new Date());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", duration=" + duration + ", title=" + title + ", artist=" + artist
				+ ", creationDate=" + creationDate + "]";
	}
	
	
}
