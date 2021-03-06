/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.AnnonceUser;
import Entite.Annonce;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Interface_afficher_offreController implements Initializable {

    @FXML
    private ListView<Annonce> listview;
    @FXML
    private Button retour;
    @FXML
    private TextField recherche;
    static String chtitre;
    static String chdescription;
    static String chtel;
    static String chdate;
    static String chimg;
    static String chadress;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Annonce> data = FXCollections.observableArrayList();

        List<Annonce> serviceOffre = AnnonceUser.selectAnnonce2();
        data.addAll(0, serviceOffre);
        listview.getItems().addAll(data);

        listview.setCellFactory((ListView<Annonce> param) -> new ListCell<Annonce>() {
            @Override
            protected void updateItem(Annonce item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {

                    ImageView img = new ImageView("/GUI/Images/majdpic.jpg");
                    img.setFitHeight(130);
                    img.setFitWidth(120);
                    Text text1 = new Text("Titre Offre d'emploi :     "+item.getTitre_annonce());
                    Text text2 = new Text("Titre Offre d'emploi :     "+item.getDate_annonce());
                    Text text3 = new Text(item.getAddr_annonce());
                    Text text4 = new Text(item.getDesc_annonce());
                    String val = Integer.toString(item.getTel_annonce());
                    Text text5 = new Text(val);

                    VBox vbox = new VBox(text1, text2);
                    vbox.setAlignment(Pos.CENTER);
                    vbox.setSpacing(20);
                    HBox h = new HBox(img, vbox);
                    h.setSpacing(100);
                    setGraphic(h);

                }
            }
        ;
        });
    
        listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Annonce>() {
            @Override
            public void changed(ObservableValue<? extends Annonce> observable, Annonce oldValue, Annonce newValue) {

                try {
                    chtitre = newValue.getTitre_annonce();
                    chdescription = newValue.getDesc_annonce();
                    chdate = newValue.getDate_annonce();
                    chadress = newValue.getAddr_annonce();
                    String val2 = Integer.toString(newValue.getTel_annonce());
                    chtel = val2;
                    chimg = newValue.getImg_annonce();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_detail_offre.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                      FXMain.stg.close();
             FXMain.stg = stage;
                    

                } catch (IOException ex) {
                    Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    @FXML
    private void retour(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("interface_membre.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            FXMain.stg.close();
                            FXMain.stg = stage;

        } catch (IOException ex) {
            Logger.getLogger(Interface_afficher_offreController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void rechercher(KeyEvent event) {
        
         try {
            listview.getItems().clear();
            listview.refresh();
            listview.getItems().addAll(AnnonceUser.rech(recherche.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(Interface_afficher_evenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
