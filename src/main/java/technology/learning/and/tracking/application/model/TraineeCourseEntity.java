package technology.learning.and.tracking.application.model;

import javax.persistence.*;

@Entity
@Table(name = "trainee_course")
public class TraineeCourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tcid;
	
	@Column
	private int tid;
	
	@Column
	private int cid;
	

	public TraineeCourseEntity() {
		super();
	}

	public TraineeCourseEntity(int tid, int cid) {
		super();
		this.tid = tid;
		this.cid = cid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "TraineeCourseEntity [tid=" + tid + ", cid=" + cid + "]";
	}
	
//	

}
