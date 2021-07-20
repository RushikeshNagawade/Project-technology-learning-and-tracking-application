package technology.learning.and.tracking.application.service;

import java.util.List;


import technology.learning.and.tracking.application.model.TraineeEntity;

public interface TraineeServiceInterface {

public abstract TraineeEntity userRegisterService(TraineeEntity us);
    
	public abstract List<TraineeEntity> usersearchService(String temail);
	
	public abstract List<TraineeEntity> usersearchbystatusService(String status);
	
	public abstract TraineeEntity userUpdateService(TraineeEntity us);

	public abstract String deleteTrainee(String temail);

	public abstract TraineeEntity findTraineeByTid(int tid);

	public abstract int deleteTrainee(int tid);

	public abstract List<TraineeEntity> getAllTrainees();


	
	//public abstract UserEntity searchUserService(int user_id);
//	public abstract List<UserEntity> searchUserService(String fname);
}
