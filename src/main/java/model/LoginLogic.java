package model;

public class LoginLogic {
	public boolean execute(User user) {
		if (user.getEmail().equals("1234@hoge")&user.getPass().equals("1234")) { return true; }
		return false;
	}

}
