/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.EspaceSanteBienEtre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import Utils.AnimationGenerator;
import Utils.ImageEditor;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class DashboardViewController implements Initializable {

    private Label menuBar;
    @FXML
    private Label currentUser;
    @FXML
    private VBox leftMenu;
    @FXML
    private Label managerUsers;
   
    @FXML
    private Label about;
    @FXML
    private AnchorPane content;
    
    boolean menuClosed = false;
    AnimationGenerator animationGenerator;
    ImageEditor imageEditor;
    @FXML
    private Label statistique;
    @FXML
    private Label test;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        animationGenerator = new AnimationGenerator();
        imageEditor = new ImageEditor();
        
    }    

    private void menuBarClick(MouseEvent event) {
         if (menuClosed) {
            animationGenerator.applyTranslateAnimationOn(leftMenu, 500, -500, 0);
            animationGenerator.applyTranslateAnimationOn(content, 500, -leftMenu.getWidth(), 0);

            menuClosed = false;
        } else {
            animationGenerator.applyTranslateAnimationOn(leftMenu, 500, 0, -500);
            animationGenerator.applyTranslateAnimationOn(content, 500, 0, -leftMenu.getWidth());
            menuClosed = true;
        }
        animationGenerator.applyRotationOn(menuBar, 500, 180f, 1);
    }

    @FXML
    private void logout(MouseEvent event) {
                FXMain .logout();

    }

    @FXML
    public void openManageUsers() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ManageUser.fxml"));
        parent.setStyle("-fx-box-border: transparent;");
        content.getChildren().clear();
        content.getChildren().add(parent);
        AnchorPane.setTopAnchor(parent, 0d);
        AnchorPane.setRightAnchor(parent, 0d);
        AnchorPane.setBottomAnchor(parent, 0d);
        AnchorPane.setLeftAnchor(parent, 0d);
    }
    
    

    

    
 @FXML
    private void about(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About!");
        alert.setContentText("Said Hmidi 3A3 ESPRIT!");
        alert.showAndWait();
    }
    
   public void VerifyQuestion()
        {
                        try {
                           
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VerifyQuestionAdmin.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));  
        stage.show();
        FXMain.stg.close();
        FXMain.stg = stage;
        } catch (Exception e) {
       System.out.println(e);
                    }
        }

   
@FXML
 private void statistique(MouseEvent event)throws IOException {
 
        Parent parent = FXMLLoader.load(getClass().getResource("FXMLstat.fxml"));
 
        content.getChildren().clear();
        content.getChildren().add(parent);
        AnchorPane.setTopAnchor(parent, 0d);
        AnchorPane.setRightAnchor(parent, 0d);
        AnchorPane.setBottomAnchor(parent, 0d);
        AnchorPane.setLeftAnchor(parent, 0d);
 
 }
}
