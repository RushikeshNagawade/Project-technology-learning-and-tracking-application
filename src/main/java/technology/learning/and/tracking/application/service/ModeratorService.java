package technology.learning.and.tracking.application.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired(required=true);
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import technology.learning.and.tracking.application.model.AdminEntity;
import technology.learning.and.tracking.application.model.ModeratorEntity;
import technology.learning.and.tracking.application.repository.ModeratorDAOInterface;

@Service
public class ModeratorService implements ModeratorServiceInterface {

	private static final Logger LOG = LoggerFactory.getLogger(ModeratorService.class);

	@Autowired
	private ModeratorDAOInterface mi;

	public boolean isLoggedIn = false;

	@Override
	public ModeratorEntity moderatorRegisterService(ModeratorEntity md) {
		return mi.save(md);
	}


	@Override
	public ModeratorEntity findModeratorByMid(int mid) {
		LOG.info("moderator search");
		return mi.findModeratorByMid(mid);
	}
	
	@Override
	public ModeratorEntity findModeratorByMemail(String email) {
		LOG.info("moderator search");
		return mi.findModeratorByMemail(email);
	}
	//admin and moderator
		@Override
		  public ModeratorEntity modUpdateService(ModeratorEntity mo) {
				LOG.info("updateUser");
				return mi.save(mo);
			}
		
		//admin
		@Override
		  public int deleteModerator(int mid) {
				LOG.info("deleteModerator");
				mi.deleteModeratorByMid(mid);
				return mid;
			}
		
		//admin
		@Override
		 public List<ModeratorEntity> getAllModerator() {
				LOG.info("getAllModeratorSuccess");
				return mi.findAll();
			}

	
}