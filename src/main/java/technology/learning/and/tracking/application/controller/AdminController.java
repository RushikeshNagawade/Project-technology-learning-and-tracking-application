package technology.learning.and.tracking.application.controller;




import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import technology.learning.and.tracking.application.Exception.InvalidUserLoginException;
import technology.learning.and.tracking.application.Exception.UsernamePasswordInvalidException;
import technology.learning.and.tracking.application.model.AdminEntity;
import technology.learning.and.tracking.application.service.AdminService;
import technology.learning.and.tracking.application.service.AdminServiceInterface;

@RestController
public class AdminController {

	private final Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminServiceInterface adminService;

	@PostMapping("/register")
	public AdminEntity register(@RequestBody AdminEntity adminEntity) {
		log.info("registerController");
		return adminService.register(adminEntity);
	}

//	@PostMapping("/login2")
//	public AppUser login2(@RequestBody AppUser appUser) {
//		log.info("loginController");
//		log.info(appUser.getUsername());
//		log.info(appUser.getPassword());
//		return userService.login(appUser);
//	}

	@PostMapping("/login")
	public AdminEntity login(@RequestBody AdminEntity adminEntity) {
		log.info("loginController");
		log.info(adminEntity.getUsername());
		log.info(adminEntity.getPassword());

		AdminEntity adminEntity2 = adminService.login(adminEntity);
		if (adminEntity.getUsername().equals(adminEntity2.getUsername())
				&& (adminEntity.getPassword().equals(adminEntity2.getPassword()))) {
			return adminEntity2;
		}
		else {
			throw new UsernamePasswordInvalidException();		
		}
	}

	@GetMapping("/logout")
	public String logout() {
		log.info("logoutController");
		return adminService.logout();
	}
	
	
	@PutMapping("/updatedatabyadmin")
	public AdminEntity updateAdmin(@RequestBody AdminEntity ad) {
		if (adminService.loginStatus().getRole().toString().equals("ADMIN"))
		      return adminService.adminUpdateService(ad);
		throw new InvalidUserLoginException();
		

	}

		@Transactional
		@DeleteMapping("deletedatabyadmin/{id}")
		public int deleteDataByAdmin(@PathVariable("id") int id) {
			if (adminService.loginStatus().getRole().toString().equals("ADMIN"))
			    return adminService.deleteAdmin(id);
			throw new InvalidUserLoginException();
		}
	
}
