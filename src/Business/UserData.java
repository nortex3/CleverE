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
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Event;
import com.restfb.types.User;


//  DADOS DO UTILIZADOR
public class UserData {
    
    Login login = new Login();
    private FacebookClient fbclient = new DefaultFacebookClient();
    private User user;
    private Connection<Event> EventList;
     private Connection<Event> MyEventList;
    
    // ESTE CONSTRUTOR NAO DA; ASSSIM E NECESSARIO PASSA O FBCLIENT:
    public UserData() {
        this.fbclient = login.getFbclient();
        this.user = fbclient.fetchObject("me",User.class);
    }
    

    public UserData(FacebookClient fbclient) {
        this.fbclient = fbclient;
    }
    

    public FacebookClient getFbclient() {
        return fbclient;
    }

    public void setFbclient(FacebookClient fbclient) {
        this.fbclient = fbclient;
    }

    public User getUser(String parametro) {
        return fbclient.fetchObject(parametro,User.class);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Connection<Event> getEventList(String parametro) {
        return fbclient.fetchConnection("search", Event.class,Parameter.with("q",parametro), Parameter.with("type", "event"), Parameter.with("location", "braga") );
    }
    
    public Connection<Event> getMyEventList() {
        return fbclient.fetchConnection("me/events", Event.class,Parameter.with("type","attending"));
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setEventList(Connection<Event> EventList) {
        this.EventList = EventList;
    }
    
     public void setMyEventList(Connection<Event> MyEventList) {
        this.MyEventList = MyEventList;
    }
    
    
    
    
    
    
    
}
