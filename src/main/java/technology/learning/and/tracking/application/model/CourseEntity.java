package technology.learning.and.tracking.application.model;


import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "course")
public class CourseEntity {
	
	@Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
 	
	@Column
	private String cname;
	
	@Column(name= "course_details")
	private String courseDetails;

	@Column
	private double cfee;
	
	
	public CourseEntity() {
		super();
	}


	public CourseEntity(String cname, String courseDetails, double cfee) {
		super();
		this.cname = cname;
		this.courseDetails = courseDetails;
		this.cfee = cfee;
	}


	public CourseEntity(int cid, String cname, String courseDetails, double cfee) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.courseDetails = courseDetails;
		this.cfee = cfee;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCourseDetails() {
		return courseDetails;
	}


	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}


	public double getCfee() {
		return cfee;
	}


	public void setCfee(double cfee) {
		this.cfee = cfee;
	}


	@Override
	public String toString() {
		return "CourseEntity [cid=" + cid + ", cname=" + cname + ", courseDetails=" + courseDetails + ", cfee=" + cfee
				+ "]";
	}


	
}
