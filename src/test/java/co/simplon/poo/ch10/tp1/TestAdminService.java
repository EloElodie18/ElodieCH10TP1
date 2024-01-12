package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;
import co.simplon.poo.ch10.tp1.service.impl.AdminServiceImpl;

public class TestAdminService {

	private UserRepositoryJson users = new UserRepositoryJson("data/json/users.json");
	private AdminServiceImpl adminService = new AdminServiceImpl(users);
	
	@BeforeEach
	void beforeEachTest() throws IOException { //methode d'initialisation lancé à chq phase de test pour mettre les elements au propre
		users.deleteAll();
	}
	
	@Test
	void testChangeMyPassword() throws Exception {

		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
		User user1 = users.getByLogin("user1");
		adminService.resetAndSendNewPassword(user1.getId(), "newPassword");
		assertEquals("newPassword", users.getByLogin("user1").getPassword());
		adminService.sendFakeEmail("user1", "admin", "newPassword");
	}
		
	@Test
	void testDesable() throws Exception {
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
		User user3 = users.getByLogin("user3");
		adminService.disableUser(user3.getId());
		assertEquals(false, user3.isEnable());
	}
	
	@Test
	void testEnable() throws Exception {
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", false));
		}
		User user4 = users.getByLogin("user3");
		adminService.enableUser(user4.getId());
		assertEquals(true, user4.isEnable());
	}
	
	@Test
	void testListAllUser() throws Exception {
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
			}
		
		List<User> allUsers = adminService.findAllUsers(users);
		
		System.out.println(allUsers);
		assertEquals(9, allUsers.size());
		
	}
	
	
	
	
	
	
}
