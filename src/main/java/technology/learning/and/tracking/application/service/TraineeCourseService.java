package technology.learning.and.tracking.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technology.learning.and.tracking.application.model.TraineeCourseEntity;
import technology.learning.and.tracking.application.repository.TraineeCourseDAOInterface;

@Service
public class TraineeCourseService implements TraineeCourseServiceInterface{
	private static final Logger LOG = LoggerFactory.getLogger(CourseService.class);
	
	@Autowired
	private TraineeCourseDAOInterface tc;
	
    public boolean isLoggedIn = false;
    
    @Override
	public TraineeCourseEntity traineeCourseRegisterService(TraineeCourseEntity cr) {
		LOG.info("course assigned success");
			return tc.save(cr);
		}
    
  //admin and moderator
	 @Override
	 public int deleteAssignedCourse(int tcid) {
		 LOG.warn("deleteAssignedCourse");
		 tc.deleteByTcid(tcid);
		 return tcid;
	 }


}

