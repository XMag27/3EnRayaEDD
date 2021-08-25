/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;

import GUI.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    public String empieza;
    protected void mostrarAlerta(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(mensaje);
        alert.show();
    }

    
    public void jugar(String turno, String empieza){
        Stage s = new Stage();
        s.setTitle("PARTIDA");
        Scene sc = new Scene(new TableroGUI(turno, empieza).getRoot(), 600,600);
        s.setScene(sc);
        s.show();
    }
    public void jugar2(String turno, String empieza){
        Stage s = new Stage();
        s.setTitle("PARTIDA");
        Scene sc = new Scene(new TableroGUI2J(turno, empieza).getRoot(), 600,600);
        s.setScene(sc);
        s.show();
    }
    @Override
    public void start(Stage primaryStage) {
        
        Button btn2 = new Button();
        Button btn = new Button();
        
        ComboBox signo = new ComboBox();
        ComboBox quienEmpieza = new ComboBox();
        quienEmpieza.getItems().addAll("X","O");       
        signo.getItems().addAll("X","O");
        btn.setText("JUGAR VS P2");
        btn.setOnAction(i -> {
            if(signo.getValue()==null){
                mostrarAlerta("NO SE ESCOGIO SIGNO PARA EL JUGADOR 1");
            }else{                
                empieza = (String) quienEmpieza.getValue();
                jugar2((String)signo.getValue(), empieza);
            }
            
            
        });
        btn2.setOnAction(i -> {
            if(signo.getValue()==null){
                mostrarAlerta("NO SE ESCOGIO SIGNO PARA EL JUGADOR 1");
            }else{
                empieza = (String) quienEmpieza.getValue();
                jugar((String)signo.getValue(), empieza);
                
            }
            
        });
        
        btn2.setText("JUGAR VS IA");
        VBox root = new VBox();
        btn.setStyle("-fx-text-fill: white;\n" +
"    -fx-font-family: \"Arial Narrow\";\n" +
"    -fx-font-weight: bold;\n" +
"    /*-fx-background-color: linear-gradient(#61a2b1, #2A5058);*/\n" +
"    -fx-background-color: #00008B;\n" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
        btn2.setStyle("-fx-text-fill: white;\n" +
"    -fx-font-family: \"Arial Narrow\";\n" +
"    -fx-font-weight: bold;" +
"    /*-fx-background-color: linear-gradient(#61a2b1, #2A5058);*/\n" +
"    -fx-background-color: #00008B;" +
"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
        root.setStyle("-fx-background-color: #d7f0f7;");
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        Label j = new Label("Elija el signo para el jugador 1");
        Label e = new Label("Elija el signo que empieza");
        j.setStyle("-fx-font-weight: bold;" +
"    -fx-font-family: \"Arial Narrow\";");
        e.setStyle("-fx-font-weight: bold;" +
"    -fx-font-family: \"Arial Narrow\";");
        root.getChildren().addAll(btn, btn2,j,signo,e, quienEmpieza);
        
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
