package technology.learning.and.tracking.application.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "moderator")
public class ModeratorEntity {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mid;
	
	@Column(name = "mname")
	private String mname;
	
	@Column(name = "memail")
	private String memail;
	


//	@OneToMany(mappedBy = "course_id")
//	private CourseEntity courseEntity;
	
	@OneToMany(cascade = {CascadeType.ALL,CascadeType.DETACH, CascadeType.REFRESH})
	private List<CourseEntity> course;

	public List<CourseEntity> getCourse() {
		return course;
	}
	
	public void setCourse(List<CourseEntity> course) {
		this.course = course;
	}
	
	public ModeratorEntity() {
		super();
	}

	

	public ModeratorEntity(String mname, String memail) {
	super();
	this.mname = mname;
	this.memail = memail;
}



	public ModeratorEntity(int mid, String mname, String memail) {
	super();
	this.mid = mid;
	this.mname = mname;
	this.memail = memail;
}



	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "ModeratorEntity [mid=" + mid + ", mname=" + mname + ", memail=" + memail + ", course=" + course + "]";
	}



	
	
	
	
}
