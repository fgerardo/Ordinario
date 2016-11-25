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

@Entity(name="titles")
public class Title implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTitle;
	@Column (name="emp_no")
	private int empNo;
	@Column (length=50)
	private String name;
	@Temporal(TemporalType.DATE)
	@Column (name="from_date")
	private Date fromDate;
	@Temporal(TemporalType.DATE)
	@Column (name="to_date")
	private Date toDate;
	
	public Title(int empNo, String name, Date fromDate, Date toDate) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public Title() {
		this(0,"",new Date(), new Date());
	}
	public int getIdTitle() {
		return idTitle;
	}
	public void setIdTitle(int idTitle) {
		this.idTitle = idTitle;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "Title [idTitle=" + idTitle + ", empNo=" + empNo + ", name=" + name + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
	
	
	
}

