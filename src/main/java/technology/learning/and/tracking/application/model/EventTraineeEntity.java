package technology.learning.and.tracking.application.model;

import javax.persistence.*;


@Entity
@Table(name = "events_trainee")
public class EventTraineeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int etid;
	
	@Column
	private int eid;
	
	@Column
	private int tid;

	public EventTraineeEntity() {
		super();
	}

	public EventTraineeEntity(int eid, int tid) {
		super();
		this.eid = eid;
		this.tid = tid;
	}

	public EventTraineeEntity(int etid, int eid, int tid) {
		super();
		this.etid = etid;
		this.eid = eid;
		this.tid = tid;
	}

	public int getEtid() {
		return etid;
	}

	public void setEtid(int etid) {
		this.etid = etid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "EventTraineeEntity [etid=" + etid + ", eid=" + eid + ", tid=" + tid + "]";
	}
	
	
	
}
