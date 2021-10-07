/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.util.ArrayList;

/**
 *
 * @author BritishWaldo
 */
public class AccountService
{
    private ArrayList<User> users = new ArrayList<User>();
    
    public AccountService()
    {
        this.users.add(new User("abe", "password"));
        this.users.add(new User("barb", "password"));
    }
    
    public User login(String inputUsername, String inputPassword)
    {
        User tempUser = new User();
        
        for (User user : this.users)
        {
            if (inputUsername.equals(user.getUsername()) && inputPassword.equals(user.getPassword()))
            {
                tempUser = new User(user.getUsername(), null);
                break;
            }
            else
            {
                tempUser = null;
            }
        }
        
        return tempUser;
    }
}
