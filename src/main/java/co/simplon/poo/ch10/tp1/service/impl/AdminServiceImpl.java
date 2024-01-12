package co.simplon.poo.ch10.tp1.service.impl;


import java.util.List;
import co.simplon.poo.ch10.tp1.model.User;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.repository.impl.UserRepositoryJson;
import co.simplon.poo.ch10.tp1.service.AdminService;
import co.simplon.poo.ch10.tp1.utils.communication.FakeMailUtil;

public class AdminServiceImpl extends FakeMailUtil implements AdminService {
	
	private final UserRepository users;

	public AdminServiceImpl(UserRepository users) {
		this.users = users;
	}
	
	@Override
	public List<User> findAllUsers(UserRepository userRepository) {
		if (userRepository instanceof UserRepositoryJson) { //si userRepo est une instance de UserRepoJson 
			UserRepositoryJson userRepositoryJson = (UserRepositoryJson) userRepository; //alors cest pr qu'il devienne une liste
			List<User> userList = userRepositoryJson.retrieve(); //maintenant transformée (userRepoJson), userList va pvr stocker la liste de userRepoJson
			return userList;
		}else {
			return null;
		}
	}
	
	@Override
	public void resetAndSendNewPassword(String userId, String NewPassword) throws Exception {
		User targetAdminUser = users.getById(userId);

		targetAdminUser.setPassword(NewPassword);
			users.update(targetAdminUser, userId);
				
	}

	@Override
	public void disableUser(String userId) throws Exception {
		User targetUser2 = users.getById(userId);
		if (targetUser2.isEnable()) {
			targetUser2.setEnable(false);
		}else {
			System.out.println("pas bon");
		}		
	}

	@Override
	public void enableUser(String userId) throws Exception {
		User targetUser3 = users.getById(userId);
		if (!targetUser3.isEnable()) {
			targetUser3.setEnable(true);
		}else {
			System.out.println("pas bon");
		}
		
	}	
	
}
