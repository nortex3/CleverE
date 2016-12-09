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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


//  DADOS DO UTILIZADOR
public class UserData {
    
  
    public static FacebookClient fbclient = new DefaultFacebookClient();
    private User user;
    private Connection<Event> EventList;
    private Connection<Event> MyEventList;
     
     
    
    // ESTE CONSTRUTOR NAO DA; ASSSIM E NECESSARIO PASSA O FBCLIENT:
    public UserData() {
        
        this.user = fbclient.fetchObject("me",User.class);
    }
    

    public UserData(FacebookClient fbclient) {
        this.fbclient = fbclient;
    }
    

    public static FacebookClient getFbclient() {
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
    
    public List<Event> getMyEventList() {
        MyEventList = fbclient.fetchConnection("me/events/attending", Event.class);
        List<Event> BragaList = new ArrayList<Event>();
        for(List<Event> s : MyEventList){
              s.forEach((Event e) -> {
                  if(e.getPlace()!= null){
                      if (e.getPlace().getLocation() != null){
                          if("Braga".equals(e.getPlace().getLocation().getCity()))
                              BragaList.add(e);
                      }
                  }
              });
        }
        
        return BragaList;
        
                
       }
  

    public void setEventList(Connection<Event> EventList) {
        this.EventList = EventList;
    }
    
     public void setMyEventList(Connection<Event> MyEventList) {
        this.MyEventList = MyEventList;
    }
    
    
    
    
    
    
    
}
