package technology.learning.and.tracking.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import technology.learning.and.tracking.application.model.EventEntity;

@Repository
public interface EventDAOInterface extends JpaRepository <EventEntity, Long>{

	public abstract EventEntity findEventByEid(int eid);

	public abstract void deleteByEid(int eid);

}
