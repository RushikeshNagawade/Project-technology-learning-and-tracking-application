package technology.learning.and.tracking.application.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import technology.learning.and.tracking.application.Exception.CourseNotFoundException;
import technology.learning.and.tracking.application.Exception.IdNotFoundException;
import technology.learning.and.tracking.application.Exception.InvalidUserLoginException;
import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.service.AdminServiceInterface;
import technology.learning.and.tracking.application.service.CourseServiceInterface;

@RestController
public class CourseController {

	private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	private CourseServiceInterface ci;
	
	@Autowired
	AdminServiceInterface adminService;
	
	@PostMapping("/coursecreate")
	public CourseEntity createCourseByModerator(@RequestBody CourseEntity md) {
		if (adminService.loginStatus().getRole().toString().equals("MODERATOR"))
		     return ci.courseRegisterService(md);
		throw new InvalidUserLoginException();
	}

	@GetMapping("/coursebyid/{cid}")
	public ResponseEntity<CourseEntity> searchCourseByModeratorTrainee(@PathVariable("cid") int cid) {
//		CourseEntity coe = ci.findCourseByCid(cid);
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
				(adminService.loginStatus().getRole().toString().equals("MODERATOR"))) 
		{
			CourseEntity coe = ci.findCourseByCid(cid);
		    if(coe != null) {
			      return new ResponseEntity<CourseEntity>(coe, HttpStatus.OK);
		     } 
		     else {
			      throw new IdNotFoundException();
		      }
		  //  throw new UsernamePasswordInvalidException();
	     }
		throw new InvalidUserLoginException();
	}
		
		
//		if (adminService.loginStatus().getRole().toString().equals("TRAINEE") ||
//				adminService.loginStatus().getRole().toString().equals("MODERATOR")	)
//		      return ci.findCourseByCid(cid);
//		return null;    	  
		
	
	
	
	
	@GetMapping("/searchcoursebyname/{cname}")
	public ResponseEntity<List<CourseEntity>> searchCourseCnameByModeratorTrainee(@PathVariable("cname") String cname)
	{
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
				(adminService.loginStatus().getRole().toString().equals("MODERATOR"))) 
		{
			List<CourseEntity> coe2 =  ci.findCourseByCname(cname);
		    if(coe2 != null) {
			      return new ResponseEntity<List<CourseEntity>>(coe2, HttpStatus.OK);
		     } 
		     else {
			      throw new  CourseNotFoundException();
		      }
	     }
		
			throw new InvalidUserLoginException();
	}
	
	
	
	
	@PutMapping("/updatecourse")
	public CourseEntity updateCourseByModerator(@RequestBody CourseEntity co) {
		if (adminService.loginStatus().getRole().toString().equals("MODERATOR"))
			return ci.courseUpdateService(co);
		throw new InvalidUserLoginException();
//		LOG.info("updateCourse");
//		return ci.courseUpdateService(co);
	}
	
	//MODERATOR
	@Transactional
	@DeleteMapping("deletecourse/{cid}")
	public int deleteCourseByModerator(@PathVariable("cid") int cid) {
		if (adminService.loginStatus().getRole().toString().equals("MODERATOR"))
		    return ci.deleteCourse(cid);
		throw new InvalidUserLoginException();
	}
	
	//MOD TRAINEE
	@GetMapping("/getallcourses")
	public ResponseEntity<List<CourseEntity>> getAllCourses() {
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
				(adminService.loginStatus().getRole().toString().equals("MODERATOR")))
		{
			List<CourseEntity> coe2 =  ci.getAllCourses();
		    if(coe2 != null) {
			      return new ResponseEntity<List<CourseEntity>>(coe2, HttpStatus.OK);
		     } 
		     else {
			      throw new  CourseNotFoundException();
		     }
	     }
		
			throw new InvalidUserLoginException();  	
	    }

}
	
	

