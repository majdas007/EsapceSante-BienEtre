/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.FXMLmembreViewController;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 *
 * @author TAQWA
 */
public class Share {
   String t = FXMLmembreViewController.t ;
   String c = FXMLmembreViewController.c ;
   String d = FXMLmembreViewController.d;
   String sujet = FXMLmembreViewController.sujet ;
   


      
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
public void shre(){

        
     

        String accessToken = "EAACEdEose0cBAPKaTXqsvTvfAv2idnaul6l1cKZAlMUhZB1w2svpWvrmdN5IF4MepLUKT8Fl3qSHmwloY6jdQDeLeWN1KTTU8xGetzXqMFVI9CSOEWVoQOJqZB4PXpZBZAESDbb5ZBM0VquuYye9pp5nMdBHq6cf5AbLEwm1u1ylWyfIZANpzrGclYGRb230ZBL6Sl5SxRcj8wZDZD";
        // TODO code application logic here
      
        FacebookClient fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_2_5);
      //  User me = fbClient.fetchObject("me", User.class);
        //System.out.println(me.getName());
       // System.out.println(me.getLanguages());
       
     // FacebookType response =  fbClient.publish("me/feed", FacebookType.class,com.restfb.Parameter.with("message", "JAVA Graph API Test"));
      FacebookType response = fbClient.publish("me/feed",FacebookType.class,com.restfb.Parameter.with("message", t +"\n \n "+"Sujet : "+
              sujet+"\n \n"+c+"\n \n"+"Publier le  "+d+"  Par Espace Santé et bien etre"));
        System.out.println("fb.com/"+response.getId());

    }
    
}
