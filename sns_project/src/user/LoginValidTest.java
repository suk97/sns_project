package user;

public class LoginValidTest {
	public static User loginTest(String id, String pw) {
		return userDAO.getUser(id, pw);
	}
}
