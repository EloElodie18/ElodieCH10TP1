package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;

public class TestUserRepository {

	private UserRepositoryJson users = new UserRepositoryJson("data/json/users.json");
		
	@BeforeEach
	void beforeEachTest() throws IOException {
		users.deleteAll();
	}

	@Test
	void testCreateAndRetrieve() throws IOException {
		users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true)); //creation de deux users ds ma liste user.json
		users.create(new User("Mina", "p@$$w0rd", "mina@secudev.net", true));
		List<User> testList = users.retrieve(); // testList stock les valeurs retrouvées ds la liste de users!
		assertEquals(2, testList.size()); //test s'il y a bien 2 users
	}

	@Test
	void testUpdate() throws Exception {
		User stef = users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true)); //creation user avec ce mail
		assertEquals("stef@secudev.net", users.getByLogin("Stef").getEmail()); // test pr verifier si ce mail est ok
		stef.setEmail("stef@gmail.com"); // chgmt du mail
		users.update(stef, stef.getId()); //sauvagarde du chgmt de mail
		assertEquals("stef@gmail.com", users.getByLogin("Stef").getEmail()); //test si mail bien changé
	}

	@Test
	void testDelete() throws IOException {
		User stef = users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true));//creation d'un user
		assertEquals(1, users.count()); //test pr verifier s'il y a bien 1 user dans la liste

		try {
			users.delete(stef.getId()); //suppression du user
			assertEquals(0, users.count()); //test pr verifier si la liste est bien vide
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testFindByLogin() throws IOException { // test pr verifier un user par son login
		users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true));
		users.create(new User("Mina", "p@$$w0rd", "mina@secudev.net", true));

		assertNotNull(users.getByLogin("Stef"));
		assertNotNull(users.getByLogin("Mina"));
		assertNull(users.getByLogin("Steph")); //null car steph "ph" n'existe pas
		assertNull(users.getByLogin("mina"));// null car mina "m" n'existe pas
	}

	@Test
	void testFindById() throws IOException { //test pr verifier si l'user correspond à l'id
		String id = users.create(new User("Stef", "p@$$w0rd", "stef@secudev.net", true)).getId();
		assertEquals("Stef", users.getById(id).getLogin()); //test pr savoir si l'id correspond bien à stef
	}
}
