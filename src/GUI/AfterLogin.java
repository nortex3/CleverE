/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Agents.Eventos;
import Agents.Interface;
import Business.UserData;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Event;
import com.restfb.types.User;
import jade.gui.GuiEvent;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author pedro/alexandre
 */
public class  AfterLogin extends javax.swing.JFrame {
    
    private UserData userdata;
    //private String[] s = null;
     private Connection<Event> eventList;
     private List<Event> MyeventList;
     private Interface myAgent;
     public static FacebookClient fbClient;
     User user;
  
     //public JFrame frame;
     //private Interface interfa;

    /**
     * Creates new form AfterLogin
     */
    public AfterLogin() {
        initComponents();
        setIcon();
        //this.textArea2.setEnabled(false);
    }
    
    public AfterLogin(UserData ud,Interface i){
    initComponents();
    setIcon();
    this.userdata = ud;
    this.myAgent = i;
    
    this.jButton1.setEnabled(false);
    this.jButton2.setEnabled(false);
    this.jButton3.setEnabled(false);
    this.textField.setEnabled(false);
    this.jComboBox1.setEnabled(false);
    this.jComboBox2.setEnabled(false);
    this.jComboBox3.setEnabled(false);
    this.jLabel3.setEnabled(false);
    this.jLabel4.setEnabled(false);
    this.jLabel7.setEnabled(false);
    this.jLabel11.setEnabled(false);
    
   
    //this.mostraAgentes(null);
    }
    
     public AfterLogin(Interface a){
        initComponents();
        setIcon();
        myAgent = a;
        
        this.jButton1.setEnabled(false);
        this.jButton2.setEnabled(false);
        this.jButton3.setEnabled(false);
        this.textField.setEnabled(false);
        this.jComboBox1.setEnabled(false);
        this.jComboBox2.setEnabled(false);
        this.jComboBox3.setEnabled(false);
        this.jLabel3.setEnabled(false);
        this.jLabel4.setEnabled(false);
        this.jLabel7.setEnabled(false);
        this.jLabel11.setEnabled(false);
        
        //this.mostraAgentes(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CleverE - Eventos da Cidade de Braga");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome to CleverE Eventos de Braga");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(320, 10, 500, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/clever-logo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 290, 230);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(530, 80, 190, 30);
        getContentPane().add(textField);
        textField.setBounds(20, 300, 270, 40);

        jButton1.setText("Search events");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(770, 90, 140, 40);

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(800, 490, 130, 30);

        jButton3.setText("My Events");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 350, 130, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Aceita Chuva?");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(310, 170, 110, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Temperatura Mínima");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(450, 170, 130, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Temperatura Máxima");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(600, 170, 150, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(310, 210, 80, 20);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-5", "0", "5", "10", "15", "20" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(450, 210, 80, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "15", "20", "25", "30", "35", "40", "45" }));
        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(600, 210, 80, 20);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Utilizador");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(310, 80, 200, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/facebook-icon.png"))); // NOI18N
        jButton4.setText("Login");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(390, 430, 160, 70);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/smart_city_blur.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 950, 540);

        setSize(new java.awt.Dimension(961, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       String parametro = textField.getText();
       eventList = userdata.getEventList(parametro);
        //DefaultListModel dlm = (DefaultListModel)this.jList1.getModel();
        DefaultListModel list = new DefaultListModel();
     
        for(List<Event> s : eventList){
            s.forEach((e) -> {
                list.addElement(e.getName());
           });
        }
        //this.jList1 = new JList(list);
        //this.jList1.setModel(list);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String mensagem=textField.getText();
        //GuiEvent ge;
       // ge = new GuiEvent(mensagem,1);
       // myAgent.postGuiEvent(ge);
       
        GuiEvent ge = new GuiEvent(mensagem,1);
        System.out.println("criei o guievent");
        if(myAgent==null){
            System.out.println("agente esta nulo");
        }
        myAgent.postGuiEvent(ge);
        System.out.println("ola");
       
       
        
        userdata = new UserData(getFbclient());
        

        MyeventList = userdata.getMyEventList();
        //DefaultListModel dlm = (DefaultListModel)this.jList1.getModel();
        DefaultListModel list;
        list = new DefaultListModel();
      
     
        MyeventList.forEach((e) -> {
            
            list.addElement(e.getName());
          
        });
        //this.jList1 = new JList(list);
        //this.jList1.setModel(list);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    /*
    private void mostraEventoCompleto(String item){
        
        MyeventList = userdata.getMyEventList();
        //DefaultListModel dlm = (DefaultListModel)this.jList1.getModel();
        //DefaultListModel list = new DefaultListModel();
        MyeventList.stream().filter((e) -> (e.getName().equals(item))).forEachOrdered((e) -> {
            textArea.setText(e.getDescription());
        }); //ist.addElement(e.getName());
        }*/
        
    
    
    public void mostraOptionPane(){
        JOptionPane.showMessageDialog(null,"Not UnderStood");
        //textArea2.setText("NOT UNDERSTOOD");
    }
    /*
    public void mostra(){
        this.textArea2.setText("Eventos, Tempo e Trânsito");
    }
    */
    public void mostraAgentes(List<String> agt){
        //DefaultListModel l = new DefaultListModel();
        System.out.println("ESTOU NULO");
        System.out.println(agt.size());
        DefaultListModel list = new DefaultListModel();
        
        for(String ss: agt){
            System.out.println(ss);
            
            list.addElement(ss);
            //textArea2.setEnabled(true);
            //this.textArea2.setText(ss);
        }
        //this.jList1 = new JList(list);
        //this.jList1.setModel(list);
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         String domain = "http://google.com";
        String appId = "1716266622025825";
        
        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId+"&redirect_uri="+domain+"&scope=user_about_me,"
                + "user_actions.books,user_actions.fitness,user_actions.music,user_actions.news,user_actions.video,user_birthday,user_education_history,"
                + "user_events,user_photos,user_friends,user_games_activity,user_hometown,user_likes,user_location,user_photos,user_relationship_details,"
                + "user_relationships,user_religion_politics,user_status,user_tagged_places,user_videos,user_website,user_work_history,ads_management,ads_read,email,"
                + "manage_pages,publish_actions,read_insights,read_page_mailboxes,rsvp_event";
        
        System.setProperty("webdirver.chrome.driver", "chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        String accessToken;
        while(true){
        
            if(!driver.getCurrentUrl().contains("facebook.com")){
            String url = driver.getCurrentUrl();
            accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");
            
            driver.quit();
            
            fbClient = new DefaultFacebookClient(accessToken);
               
                
     try{
            // Obtem os dados do utilizador
            UserData userdata = new UserData(fbClient);
            user = userdata.getUser("me");
            Interface it = new Interface();
            
            //Obtem os eventos do utilizador
             //Connection<Event> eventList =  getFbclient().fetchConnection("search", Event.class,
            // Parameter.with("q", "braga"), Parameter.with("type", "event"));
            //AfterLogin al = new AfterLogin(userdata,it);
            //al.setName(user.getName());
            
            
            //al.setVisible(true);
            
            this.jButton1.setEnabled(true);
            this.jButton2.setEnabled(true);
            this.jButton3.setEnabled(true);
            this.textField.setEnabled(true);
            this.jComboBox1.setEnabled(true);
            this.jComboBox2.setEnabled(true);
            this.jComboBox3.setEnabled(true);
            this.jLabel3.setEnabled(true);
            this.jLabel4.setEnabled(true);
            this.jLabel7.setEnabled(true);
            this.jLabel11.setEnabled(true);
            
            this.jButton4.setEnabled(false);
            this.setName(user.getName());
            //this.textArea2.setText("OLA");
            
            //this.dispose();
            
          
            
        }catch(Exception e){
            e.printStackTrace();
        }
     
     
            }
       
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AfterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Interface interfac = new Interface();
                new AfterLogin(interfac).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("clever_icon.png")));
 }

public void setName(String name){
        jLabel5.setText(name);
    }

public void setFbclient(FacebookClient client){
    this.fbClient = client;
}

public static FacebookClient getFbclient(){
    return fbClient;
}



}


