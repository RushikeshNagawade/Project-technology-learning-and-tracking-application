package technology.learning.and.tracking.application.service;

import technology.learning.and.tracking.application.model.TraineeCourseEntity;

public interface TraineeCourseServiceInterface {


	public abstract TraineeCourseEntity traineeCourseRegisterService(TraineeCourseEntity md);

	public abstract int deleteAssignedCourse(int tcid);


}
