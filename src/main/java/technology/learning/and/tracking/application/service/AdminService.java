package technology.learning.and.tracking.application.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired(required=true);
import org.springframework.stereotype.Service;


import technology.learning.and.tracking.application.Exception.UsernamePasswordInvalidException;
import technology.learning.and.tracking.application.model.AdminEntity;
import technology.learning.and.tracking.application.repository.AdminDAOInterface;
@Service
public class AdminService implements AdminServiceInterface {
	
	
  private static final Logger log = LoggerFactory.getLogger(AdminService.class);

    @Autowired
	private AdminDAOInterface ai;
	
    

	private AdminEntity currentAdminEntity; // access control to APIs

	
//	public Employee findEmployeeById(int eid) {
//		LOG.info("findEmployeeById");
//		Optional<Employee> optEmp = repository.findById(eid);
//		if (optEmp.isEmpty())
//			throw new EmployeeNotFoundException();
//		else
//			return optEmp.get();
//	}
//	
	public AdminEntity login(AdminEntity appUser) {
		        log.info("loginService");
				currentAdminEntity = ai.findByUsername(appUser.getUsername());
				return currentAdminEntity;
		
	}

	public AdminEntity register(AdminEntity appUser) {
		log.info("registerService");
		return ai.save(appUser);
	}

	public String logout() {
		log.info("logoutService");
		currentAdminEntity = null;
		return "User logged out successfully";
	}
	

	public AdminEntity loginStatus() {
		log.info("loginStatusService");
		return currentAdminEntity;
	}

	@Override
	  public AdminEntity adminUpdateService(AdminEntity ad) {
			log.info("updateAdminSuccess");
			return ai.save(ad);
		}
	
	@Override
	 public int deleteAdmin(int id) {
		 log.warn("deleteAdminSuccess");
		 ai.deleteById(id);
		 return id;
	 }
}