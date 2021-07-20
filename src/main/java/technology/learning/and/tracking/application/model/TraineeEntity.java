 package technology.learning.and.tracking.application.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "trainee")
public class TraineeEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;
	
	@Column
	private String fname;
	
	@Column
	private String lname;
	
	@Column
	private String temail;

	
	@Column
	private String status;
	
	 //mapping trainee with course
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(
            joinColumns = @JoinColumn(name = "tid"),		
            inverseJoinColumns = @JoinColumn(name = "cid")
    )
	private List<CourseEntity> course;

	
	public TraineeEntity() {
		super();
	}



	


	public TraineeEntity(String fname, String lname, String temail, String status, List<CourseEntity> course) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.temail = temail;
		this.status = status;
		this.course = course;
	}


	public TraineeEntity(int tid, String fname, String lname, String temail, String status) {
		super();
		this.tid = tid;
		this.fname = fname;
		this.lname = lname;
		this.temail = temail;
		this.status = status;
	}


	public TraineeEntity(int tid, String fname, String lname, String temail, String status, List<CourseEntity> course) {
	super();
	this.tid = tid;
	this.fname = fname;
	this.lname = lname;
	this.temail = temail;
	this.status = status;
	this.course = course;
}


	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getTemail() {
		return temail;
	}


	public void setTemail(String temail) {
		this.temail = temail;
	}

	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<CourseEntity> getCourse() {
		return course;
	}


	public void setCourse(List<CourseEntity> course) {
		this.course = course;
	}


	
	@Override
	public String toString() {
		return "TraineeEntity [tid=" + tid + ", fname=" + fname + ", lname=" + lname + ", temail=" + temail
				+ ", status=" + status + ", course=" + course + "]";
	}

	

}
	
		

