package dao;

import entity.User;

public interface UserDao {
	public int adduser(User user);
    public boolean QueryUser(String username);
   public boolean QueryUserByUser(User user);
}
