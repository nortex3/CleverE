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
    private List<Evento> listaEventos;
    
    public class Evento implements java.io.Serializable {
        private String nome;
        private String descricao;
        private String data;
        private String cidade;
        private String rua;
        private double lat;
        private double lon;

        public Evento(String nome, String descricao, String data, String cidade, String rua, double lat, double lon) {
            this.nome = nome;
            this.descricao = descricao;
            this.data = data;
            this.cidade = cidade;
            this.rua = rua;
            this.lat = lat;
            this.lon = lon;
        }
        public Evento(Event e) {
            this.nome = e.getName();
            this.descricao = e.getDescription();
            this.data = e.getEndTime().toString();
            this.cidade = e.getPlace().getLocation().getCity();
            this.rua = e.getPlace().getLocation().getStreet();
            this.lat = e.getPlace().getLocation().getLatitude();
            this.lon = e.getPlace().getLocation().getLongitude();
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getData() {
            return data;
        }

        public String getCidade() {
            return cidade;
        }

        public String getRua() {
            return rua;
        }

        public double getLat() {
            return lat;
        }

        public double getLon() {
            return lon;
        }
        
        
    }
     
     
    
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
  
    public List<Evento> getEventosList() {
        MyEventList = fbclient.fetchConnection("me/events/attending", Event.class);
        List<Evento> BragaList = new ArrayList();
        for(List<Event> s : MyEventList){
            s.forEach((Event e) -> {
                if(e.getPlace()!= null){
                    if (e.getPlace().getLocation() != null){
                        if("Braga".equals(e.getPlace().getLocation().getCity()))
                            BragaList.add(new Evento(e));                          
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
