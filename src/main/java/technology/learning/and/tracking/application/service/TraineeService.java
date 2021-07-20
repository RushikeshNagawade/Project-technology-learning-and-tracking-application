package technology.learning.and.tracking.application.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import technology.learning.and.tracking.application.model.ModeratorEntity;
import technology.learning.and.tracking.application.model.TraineeEntity;
import technology.learning.and.tracking.application.repository.TraineeDAOInterface;

@Service
public class TraineeService implements TraineeServiceInterface{


	private static final Logger LOG = LoggerFactory.getLogger(TraineeService.class);
	
	 @Autowired
		private TraineeDAOInterface ui;
	    
	    //all
	    @Override
		public TraineeEntity userRegisterService(TraineeEntity us) {
				return ui.save(us);
			}
	    
	    //all
	  @Override
		public List<TraineeEntity> usersearchService(String temail) { 
		  	LOG.info("userSearchSuccess");
			return ui.findTraineeByTemail(temail);
		}
	  
	  //all
	  @Override
	  public TraineeEntity userUpdateService(TraineeEntity us) {
			LOG.info("updateUser");
			return ui.save(us);
		}
	  
	  
//	@Override
//	public UserEntity searchUserService(int user_id) {
//		         return ui.findById(user_id);
//	}
	  
	  //admin and moderator
	  @Override
	  public String deleteTrainee(String temail) {
			LOG.info("deleteTrainee");
			ui.deleteByTemail(temail);
			return temail;
		}

	  //all
	  @Override
	  public TraineeEntity findTraineeByTid(int tid) {
			LOG.info("trainee search by id");
			return ui.findTraineeByTid(tid);
		}
	  
	  //admin and moderator
	@Override
	public int deleteTrainee(int tid) {
		LOG.info("deleteTrainee");
		ui.deleteByTid(tid);
		return tid;
	}
	
	//admin and moderator
	@Override
	public List<TraineeEntity> getAllTrainees() {
		LOG.info("getAllTraineesSuccess");
		return ui.findAll();
	}

	@Override
	public List<TraineeEntity> usersearchbystatusService(String status) {
		LOG.info("userSearchSuccess");
		return ui.findTraineeByStatus(status);
	}
		
}