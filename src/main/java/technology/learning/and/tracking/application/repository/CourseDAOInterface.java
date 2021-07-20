package technology.learning.and.tracking.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.ModeratorEntity;

@Repository
public interface CourseDAOInterface extends JpaRepository <CourseEntity, Long> {
	//Optional<AdministratorEntity> findByEmail(String email);
	
	

	public abstract CourseEntity findCourseByCid(int cid);

	public abstract List<CourseEntity> findCourseByCname(String cname);
	
	public abstract void deleteByCid(int cid);
	
}