package technology.learning.and.tracking.application.service;

import java.util.List;

import technology.learning.and.tracking.application.model.AdminEntity;
import technology.learning.and.tracking.application.model.CourseEntity;
import technology.learning.and.tracking.application.model.ModeratorEntity;


public interface CourseServiceInterface {

	
    public abstract CourseEntity courseRegisterService(CourseEntity cr);


    public abstract CourseEntity findCourseByCid(int cid);


     public abstract List<CourseEntity> findCourseByCname(String cname);


     public abstract CourseEntity courseUpdateService(CourseEntity co);


     public abstract int deleteCourse(int cid);


     public abstract List<CourseEntity> getAllCourses();

}