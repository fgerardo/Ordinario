package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "cars")
public class Car implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String model;
	@Column(length = 25)
	private String type;
	@Column(length = 50)
	private String description;
	private boolean existing;

	public Car(String model, String type, String description, boolean existing) {
		super();

		this.model = model;
		this.type = type;
		this.description = description;
		this.existing = existing;
	}
	public Car(){
		this( "","","",false);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isExisting() {
		return existing;
	}

	public void setExisting(boolean existing) {
		this.existing = existing;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", type=" + type + ", description=" + description + ", existing="
				+ existing + "]";
	}
	
	
}
