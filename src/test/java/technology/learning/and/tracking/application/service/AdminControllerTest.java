package technology.learning.and.tracking.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import technology.learning.and.tracking.application.model.AdminEntity;
import technology.learning.and.tracking.application.repository.AdminDAOInterface;

@SpringBootTest
public class AdminControllerTest {
	
	@InjectMocks
	private AdminService adminService;
	
	@Mock
	private AdminDAOInterface userRepository;
	
	
	@Test
	public void register() {
		
	AdminEntity user = new AdminEntity(1,"admin3","admin3",null);
	Mockito.when(userRepository.save(user)).thenReturn(user);	
	AdminEntity userActual1 = adminService.register(user);		
		assertEquals( user.getId(), userActual1.getId());
	}
	
	

	// Negative test case-Find only approved advertise 
			@Test
			public void  login()  {
				//LOG.info("login");
				AdminEntity obj= new AdminEntity("admin3","admin3");
				Mockito.when(adminService.login(obj)).thenReturn(obj); // actual
				AdminEntity userActual1 = adminService.login(obj);
				assertEquals( obj.getUsername(), userActual1.getUsername());
				
			}

	
	@Test
	public void updateAdmin() {
		
		AdminEntity user = new AdminEntity(5,"trainee5","trainee",null);	
		Mockito.when(userRepository.save(user)).thenReturn(user);
		AdminEntity userActual1 = adminService.adminUpdateService(user);
		assertEquals( user.getId(), userActual1.getId());
	}
	
	
	@Test
	public void deleteDataByAdmin() throws Exception{
		
		AdminEntity user = new AdminEntity(1,"admin3","admin3", null);	
		userRepository.deleteById(user.getId());
		verify(userRepository, times(1)).deleteById(user.getId());
	}
	
	

}