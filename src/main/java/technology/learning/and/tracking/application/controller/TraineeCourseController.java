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
import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.TraineeCourseEntity;
import technology.learning.and.tracking.application.service.AdminServiceInterface;
import technology.learning.and.tracking.application.service.TraineeCourseServiceInterface;

@RestController
public class TraineeCourseController {
	private static final Logger LOG = LoggerFactory.getLogger(TraineeController.class);
	
	@Autowired
	private TraineeCourseServiceInterface tci;
	
	@Autowired
	AdminServiceInterface adminService;
	
	@PostMapping("/assigncourse")
	public TraineeCourseEntity assignCourse(@RequestBody TraineeCourseEntity md) {
		if (adminService.loginStatus().getRole().toString().equals("ADMIN"))
		     return tci.traineeCourseRegisterService(md);
		throw new InvalidUserLoginException();
	}
	
	@Transactional
	@DeleteMapping("deleteassignedcourse/{tcid}")
	public int deleteAssignedCourse(@PathVariable("tcid") int tcid) {
		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		    return tci.deleteAssignedCourse(tcid);
		throw new InvalidUserLoginException();
	}
}
