/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3enraya;

import GUI.Tablero;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Xavier
 */
public class Main extends Application {
    public void jugar(){
        Stage s = new Stage();
        s.setTitle("PARTIDA");
        Scene sc = new Scene(new Tablero().getRoot(), 600,600);
        s.setScene(sc);
        s.show();
    }
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("JUGAR");
        btn.setOnAction(i -> {
            jugar();
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
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
