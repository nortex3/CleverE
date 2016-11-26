/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
/**
 *
 * @author Alexandre Mirra
 */
import GUI.Login;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

public class UserData {
    
    Login login = new Login();
    private FacebookClient fbclient = new DefaultFacebookClient();
    private User user;
    
    

    public UserData(FacebookClient fbclient) {
        this.fbclient = fbclient;
        this.user = fbclient.fetchObject("me",User.class);
    }
    

    public FacebookClient getFbclient() {
        return fbclient;
    }

    public void setFbclient(FacebookClient fbclient) {
        this.fbclient = fbclient;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
    
}
