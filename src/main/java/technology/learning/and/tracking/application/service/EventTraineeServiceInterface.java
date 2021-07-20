package technology.learning.and.tracking.application.service;

import technology.learning.and.tracking.application.model.EventTraineeEntity;

public interface EventTraineeServiceInterface {

	public abstract EventTraineeEntity eventTraineeRegisterService(EventTraineeEntity md);

	public abstract int deleteAssignedEvent(int etid);


//	public abstract TraineeEntity traineeCourseRegisterService(TraineeCourseEntity md);


}
