package technology.learning.and.tracking.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import technology.learning.and.tracking.application.model.AdminEntity;

@Repository
public interface AdminDAOInterface extends JpaRepository <AdminEntity, Integer> {
	//Optional<AdministratorEntity> findByEmail(String email);
	
	public abstract AdminEntity findByUsername(String username);
	//public abstract List<AdminEntity> findAdminByEmail(String email);
    
	public abstract void deleteById(int id);
	
}