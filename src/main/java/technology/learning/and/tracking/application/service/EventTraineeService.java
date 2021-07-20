package technology.learning.and.tracking.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technology.learning.and.tracking.application.model.EventTraineeEntity;
import technology.learning.and.tracking.application.model.TraineeCourseEntity;
import technology.learning.and.tracking.application.repository.EventTraineeDAOInterface;
import technology.learning.and.tracking.application.repository.TraineeCourseDAOInterface;

@Service
public class EventTraineeService implements EventTraineeServiceInterface{
	private static final Logger LOG = LoggerFactory.getLogger(EventTraineeService.class);
	
	@Autowired
	private EventTraineeDAOInterface tc;
	
    public boolean isLoggedIn = false;
    
    @Override
	public EventTraineeEntity eventTraineeRegisterService(EventTraineeEntity et) {
		LOG.info("event assigned success");
			return tc.save(et);
		}
    
  //admin and moderator
  	 @Override
  	 public int deleteAssignedEvent(int etid) {
  		 LOG.warn("deleteAssignedEvent");
  		 tc.deleteByEtid(etid);
  		 return etid;
  	 }
}

