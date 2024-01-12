
package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;
import co.simplon.poo.ch10.tp1.service.UserService;
import co.simplon.poo.ch10.tp1.service.impl.UserServiceImpl;

public class TestUserService {	
	
	private UserRepositoryJson users = new UserRepositoryJson("data/json/users.json"); //creer le document vierge user.json ds data
	private UserService userService = new UserServiceImpl(users); //creation objet userService

	@BeforeEach
	void beforeEachTest() throws IOException { //methode d'initialisation lancé à chq phase de test pour mettre les elements au propre
		users.deleteAll();
	}

	@Test
	void testChangeMyPassword() throws Exception {
		
		// boucle qui vient creer 10 users à mon fichier user.json
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
		
		// je récupère le user1
		User user1 = users.getByLogin("user1");

		//je change le mot de passe du user1
		userService.changeMyPassword(user1.getId(), user1.getPassword(), "newpassworduser1");
		
		//verifie si le nouveau mot de passe est bien pris en compte
		assertEquals("newpassworduser1", users.getByLogin("user1").getPassword());		
		
	}
	
	@Test
	void testEmail() throws Exception { // test de l'implementation de la methode qui n'était pas implementé au debut du projet
		
		for (int i = 1; i < 10; i++) {
			users.create(new User("user" + i, "passworduser" + i, "user" + i + "@gmail.com", true));
		}
		
		User user1 = users.getByLogin("user1"); //recup user1

		userService.changeMyEmail(user1.getId(), user1.getEmail(), "newEmailuser1"); //je lui donne une nvl adresse mail
		
		assertEquals("newEmailuser1", users.getByLogin("user1").getEmail()); // verifie si le nvo mail est pris en compte	
		
	}
}
