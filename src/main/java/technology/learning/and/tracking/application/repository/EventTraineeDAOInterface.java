package technology.learning.and.tracking.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import technology.learning.and.tracking.application.model.EventTraineeEntity;
import technology.learning.and.tracking.application.model.TraineeCourseEntity;

@Repository
public interface EventTraineeDAOInterface extends JpaRepository <EventTraineeEntity, Long>{

	void deleteByEtid(int etid);


}

