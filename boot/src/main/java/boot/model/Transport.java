package boot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="transports")
public class Transport implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTransport;
	@Column(name="people_nu")
	private int peopleNu;
	@Column(length=50)
	private String destination;
	@Column(name="price")
	private int price;
	private boolean existingQuota;
	public Transport(int peopleNu, String destination, int price, boolean existingQuota) {
		super();
		this.peopleNu = peopleNu;
		this.destination = destination;
		this.price = price;
		this.existingQuota = existingQuota;
	}
	
	public Transport() {
		this(0,"",0,false);
	}
	public int getIdTransport() {
		return idTransport;
	}
	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}
	public int getPeopleNu() {
		return peopleNu;
	}
	public void setPeopleNu(int peopleNu) {
		this.peopleNu = peopleNu;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isExistingQuota() {
		return existingQuota;
	}
	public void setExistingQuota(boolean existingQuota) {
		this.existingQuota = existingQuota;
	}
	@Override
	public String toString() {
		return "Transport [idTransport=" + idTransport + ", peopleNu=" + peopleNu + ", destination=" + destination
				+ ", price=" + price + ", existingQuota=" + existingQuota + "]";
	}
	
	
}
