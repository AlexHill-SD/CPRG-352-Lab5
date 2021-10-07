/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

/**
 *
 * @author BritishWaldo
 */
public class User
{
    private String username;
        private String password;
        
        public User()
        {
            
        }
        
        public User(String inputUsername, String inputPassword)
        {
            this.username = inputUsername;
            this.password = inputPassword;
        }

        public String getUsername()
        {
            return username;
        }

        public String getPassword()
        {
            return password;
        }

        public void setUsername(String username)
        {
            this.username = username;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }

        @Override
        public String toString()
        {
            return this.username + " | " + this.password;
        }
}
