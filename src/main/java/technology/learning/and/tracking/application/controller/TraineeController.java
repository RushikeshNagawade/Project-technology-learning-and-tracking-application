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

import technology.learning.and.tracking.application.Exception.EmailNotFoundException;
import technology.learning.and.tracking.application.Exception.IdNotFoundException;
import technology.learning.and.tracking.application.Exception.InvalidUserLoginException;
import technology.learning.and.tracking.application.model.ModeratorEntity;
import technology.learning.and.tracking.application.model.TraineeEntity;
import technology.learning.and.tracking.application.service.AdminServiceInterface;
import technology.learning.and.tracking.application.service.TraineeServiceInterface;

@RestController
public class TraineeController {

	private static final Logger LOG = LoggerFactory.getLogger(TraineeController.class);

	@Autowired
	private TraineeServiceInterface ui;
	
	@Autowired
	AdminServiceInterface adminService;
	
	
	//TRAINEE
	@PostMapping("/usercreate")
	public TraineeEntity createProfileByTrainee(@RequestBody TraineeEntity us) {
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
		    (adminService.loginStatus().getRole().toString().equals("ADMIN")))
		     return ui.userRegisterService(us);
		throw new InvalidUserLoginException();
	}
	
	//ADMIN
//	@GetMapping("/usersearch/{temail}")
//	public List<TraineeEntity> userSearchByAdminTrainee(@PathVariable("temail") String temail) {
//		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
//				   (adminService.loginStatus().getRole().toString().equals("ADMIN")))
//		    return ui.usersearchService(temail);
//		throw new InvalidUserLoginException();
//	}
	
	// search moderator my mid
	@GetMapping("/usersearch/{temail}")
	public ResponseEntity<List<TraineeEntity>> userSearchByAdminTrainee(@PathVariable("temail") String temail) {
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
				   (adminService.loginStatus().getRole().toString().equals("ADMIN")))
				{
			       List<TraineeEntity> toe =  ui.usersearchService(temail);
					if(toe != null) {
						return new ResponseEntity<List<TraineeEntity>>(toe, HttpStatus.OK);
					}
					else {
						 throw new EmailNotFoundException();
					}
				}
		throw new InvalidUserLoginException();
	}
	

	//TRAINEE
	@PutMapping("/updateuser")
	public TraineeEntity updateUserByTrainee(@RequestBody TraineeEntity us) {
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
				   (adminService.loginStatus().getRole().toString().equals("ADMIN")))
		     return ui.userUpdateService(us);
		throw new InvalidUserLoginException();
	}
	
	//ADMIN, USER
	@Transactional
	@DeleteMapping("deleteuserbyemail/{temail}")
	public String deleteTraineeByAdminTrainee(@PathVariable("temail") String temail) {
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
		   (adminService.loginStatus().getRole().toString().equals("ADMIN")))
		    return ui.deleteTrainee(temail);
		throw new InvalidUserLoginException();
	}
	
	
	
	
	//ADMIN, USER
	@GetMapping("/searchuserbyid/{tid}")
	public ResponseEntity<TraineeEntity> searchTraineeTidByAdminTrainee(@PathVariable("tid") int tid) {
		
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
				   (adminService.loginStatus().getRole().toString().equals("ADMIN")))
		{
			TraineeEntity coe = ui.findTraineeByTid(tid);
			if(coe != null) {
				return new ResponseEntity<TraineeEntity>(coe, HttpStatus.OK);
			}
			else {
				 throw new IdNotFoundException();
			}
		}
		
		throw new InvalidUserLoginException();
	}
	
	//ADMIN, USER
	@Transactional
	@DeleteMapping("deleteuser/{tid}")
	public int deleteTraineeByAdminTrainee(@PathVariable("tid") int tid) {
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
				   (adminService.loginStatus().getRole().toString().equals("ADMIN")))
		     return ui.deleteTrainee(tid);
		throw new InvalidUserLoginException();
	}
	
	//ADMIN, USER
	@GetMapping("/getalltrainees")
	public List<TraineeEntity> getAllTraineesByAdminTrainee() {
		if ((adminService.loginStatus().getRole().toString().equals("TRAINEE")) ||
				   (adminService.loginStatus().getRole().toString().equals("ADMIN")))
	            return ui.getAllTrainees();
	    throw new InvalidUserLoginException();        
	}
	
	//ADMIN
		@GetMapping("/usersearchstatus/{status}")
		public List<TraineeEntity> userSearchStatusByAdmin(@PathVariable("status") String status) {
			if (adminService.loginStatus().getRole().toString().equals("ADMIN"))
			    return ui.usersearchbystatusService(status);
			throw new InvalidUserLoginException();
		}
	
}