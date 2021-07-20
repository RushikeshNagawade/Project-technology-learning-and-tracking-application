package technology.learning.and.tracking.application.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import technology.learning.and.tracking.application.Exception.EmailNotFoundException;
import technology.learning.and.tracking.application.Exception.IdNotFoundException;
import technology.learning.and.tracking.application.Exception.InvalidUserLoginException;
import technology.learning.and.tracking.application.model.AdminEntity;
import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.ModeratorEntity;
import technology.learning.and.tracking.application.service.AdminServiceInterface;
import technology.learning.and.tracking.application.service.ModeratorServiceInterface;



import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;





@RestController
public class ModeratorController {
	
private static final Logger LOG = LoggerFactory.getLogger(TraineeController.class);
	
	@Autowired
	private ModeratorServiceInterface mi;
	
	@Autowired
	AdminServiceInterface adminService;
	
	//MOD
	@PostMapping("/moderatorcreate")
	public ModeratorEntity createProfileByModerator(@RequestBody ModeratorEntity md) {
		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
			return mi.moderatorRegisterService(md);
		throw new InvalidUserLoginException();
	}
	


	// search moderator my mid
	@GetMapping("/searchmod/{id}")
	public ResponseEntity<ModeratorEntity> searchModeratorMidByModerator(@PathVariable("id") int mid) {
		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		{
			ModeratorEntity coe =  mi.findModeratorByMid(mid);
			if(coe != null) {
				return new ResponseEntity<ModeratorEntity>(coe, HttpStatus.OK);
			}
			else {
				 throw new IdNotFoundException();
			}
		}
		throw new InvalidUserLoginException();
	}
	
	
	// search moderator my mid
		@GetMapping("/searchmodemail/{memail}")
		public ResponseEntity<ModeratorEntity> searchModeratorMemailByModeratorAdmin(@PathVariable("memail") String memail) {
			if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
					(adminService.loginStatus().getRole().toString().equals("ADMIN")))
			{
				ModeratorEntity coe =  mi.findModeratorByMemail(memail);
				if(coe != null) {
					return new ResponseEntity<ModeratorEntity>(coe, HttpStatus.OK);
				}
				else {
					 throw new EmailNotFoundException();
				}
			}
			throw new InvalidUserLoginException();
		}
	
	//MOD
	@PutMapping("/updatemoderator")
	public ModeratorEntity updateModeratorByModerator(@RequestBody ModeratorEntity mo) {
		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		     return mi.modUpdateService(mo);
		throw new InvalidUserLoginException();
	}
	
	// MOD
	@Transactional
	@DeleteMapping("deletemoderator/{mid}")
	public int deleteModeratorByModerator(@PathVariable("mid") int mid) {
		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN")))
		    return mi.deleteModerator(mid);
		throw new InvalidUserLoginException();
	}
	
	//ADMIN, TRAINEE, MOD
	@GetMapping("/getallmoderator")
	public List<ModeratorEntity> getAllModerator() {
		if ((adminService.loginStatus().getRole().toString().equals("MODERATOR")) ||
				(adminService.loginStatus().getRole().toString().equals("ADMIN"))
				||(adminService.loginStatus().getRole().toString().equals("TRAINEE")))
			return mi.getAllModerator();
		throw new InvalidUserLoginException();
		    
		
	}

}
