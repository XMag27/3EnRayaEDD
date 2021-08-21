/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;

import GUI.TableroGUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Xavier
 */
public class Main extends Application {
    public TextField jugador= new TextField();
    protected void mostrarAlerta(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(mensaje);
        alert.show();
    }

    
    public void jugar(String turno){
        Stage s = new Stage();
        s.setTitle("PARTIDA");
        Scene sc = new Scene(new TableroGUI(turno).getRoot(), 600,600);
        s.setScene(sc);
        s.show();
    }
    @Override
    public void start(Stage primaryStage) {
        Button btn2 = new Button();
        Button btn = new Button();
        ComboBox signo = new ComboBox();
        signo.getItems().addAll("X","O");
        btn.setText("JUGAR VS P2");
        btn.setOnAction(i -> {
            if(signo.getValue()==null){
                mostrarAlerta("NO SE ESCOGIO SIGNO PARA EL JUGADOR 1");
            }else{
                jugar((String)signo.getValue());
            }
            
        });
        btn2.setText("JUGAR VS IA");
        VBox root = new VBox();
        root.getChildren().addAll(btn, btn2,signo);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("3 en Raya");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
}
