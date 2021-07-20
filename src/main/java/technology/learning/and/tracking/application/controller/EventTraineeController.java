package technology.learning.and.tracking.application.controller;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import technology.learning.and.tracking.application.Exception.InvalidUserLoginException;
import technology.learning.and.tracking.application.model.EventTraineeEntity;
import technology.learning.and.tracking.application.model.TraineeCourseEntity;
import technology.learning.and.tracking.application.service.AdminServiceInterface;
import technology.learning.and.tracking.application.service.EventTraineeServiceInterface;
import technology.learning.and.tracking.application.service.TraineeCourseServiceInterface;

@RestController
public class EventTraineeController {
	private static final Logger LOG = LoggerFactory.getLogger(EventTraineeController.class);
	
	@Autowired
	private EventTraineeServiceInterface eti;
	
	@Autowired
	AdminServiceInterface adminService;
	
	@PostMapping("/assignevent")
	public EventTraineeEntity assignEvent(@RequestBody EventTraineeEntity md) {
		if ((adminService.loginStatus().getRole().toString().equals("ADMIN")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		     return eti.eventTraineeRegisterService(md);
		throw new InvalidUserLoginException();
	}
	
	@Transactional
	@DeleteMapping("deleteassignedevent/{etid}")
	public int deleteAssignedEvent(@PathVariable("etid") int etid) {
		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		    return eti.deleteAssignedEvent(etid);
		throw new InvalidUserLoginException();
	}
}
