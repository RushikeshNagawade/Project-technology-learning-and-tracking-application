package technology.learning.and.tracking.application.service;

import java.util.List;

import technology.learning.and.tracking.application.model.AdminEntity;
import technology.learning.and.tracking.application.model.CourseEntity;

public interface AdminServiceInterface {

	
	public abstract AdminEntity login(AdminEntity ad);
	public abstract AdminEntity register(AdminEntity ad);
	public abstract String logout();
	public abstract AdminEntity loginStatus();

	public abstract AdminEntity adminUpdateService(AdminEntity ad);

	//public abstract int deleteAdmin(int id);
	public abstract int deleteAdmin(int id);

}