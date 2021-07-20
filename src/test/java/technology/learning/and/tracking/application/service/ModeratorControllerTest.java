package technology.learning.and.tracking.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import technology.learning.and.tracking.application.model.ModeratorEntity;
import technology.learning.and.tracking.application.repository.ModeratorDAOInterface;
import technology.learning.and.tracking.application.service.ModeratorService;

@SpringBootTest
public class ModeratorControllerTest {

	@InjectMocks
	private ModeratorService moderatorService;
	
	@Mock
	private ModeratorDAOInterface moderatorDAOInterface;
	
	@Test
	public void moderatorcreate() {
		
	ModeratorEntity md = new ModeratorEntity(1,"abc","abc@gmail.com");
	Mockito.when(moderatorDAOInterface.save(md)).thenReturn(md);	
	ModeratorEntity mdActual1 = moderatorService.moderatorRegisterService(md);		
		assertEquals( md.getMid(), mdActual1.getMid());
	}
	
	@Test
	public void findModeratorByMid() {
		
	ModeratorEntity md = new ModeratorEntity(202, "mina", "mina@gmail.com");
	Mockito.when(moderatorDAOInterface.save(md)).thenReturn(md);	
	ModeratorEntity mdActual1 = moderatorService.moderatorRegisterService(md);		
		assertEquals( md.getMid(), mdActual1.getMid());
	}
	
	@Test
	public void updatemoderator() {
		
	ModeratorEntity md = new ModeratorEntity(202, "mina", "mina@gmail.com");
	Mockito.when(moderatorDAOInterface.save(md)).thenReturn(md);	
	ModeratorEntity mdActual1 = moderatorService.moderatorRegisterService(md);		
		assertEquals( md.getMid(), mdActual1.getMid());
	}



	@Test
	public void deletemoderator() throws Exception{
		
		ModeratorEntity md = new ModeratorEntity(202, "mina", "mina@gmail.com");	
		moderatorDAOInterface.deleteModeratorByMid(md.getMid());
		verify(moderatorDAOInterface, times(1)).deleteModeratorByMid(md.getMid());
	}
	
	@Test
	public void getAllModerator() { 
		
		ModeratorEntity md = new ModeratorEntity(201, "mina", "mina@gmail.com");	
		ModeratorEntity md2 = new ModeratorEntity(202, "tina", "tina@gmail.com");
		
		List<ModeratorEntity> modlist = new ArrayList<>();
		modlist.add(md);
		modlist.add(md2);
		
		Mockito.when(moderatorDAOInterface.findAll()).thenReturn(modlist);
		List<ModeratorEntity> actualModeratorList = moderatorService.getAllModerator();
		assertEquals( modlist.size(), actualModeratorList.size());
		verify(moderatorDAOInterface,times(1)).findAll();
	}
			
}