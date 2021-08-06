/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Xavier
 */
public class Rayas extends StackPane{
    private Text jugador = new Text();
    public Rayas(){
        Rectangle borde = new Rectangle(200, 200);
        borde.setFill(null);
        borde.setStroke(Color.BLACK);
        jugador.setFont(Font.font(72));
        
        setAlignment(Pos.CENTER);
        boolean addAll = getChildren().addAll(borde, jugador);
        setOnMouseClicked(e -> {
            dibujar0();
        });
    }
    
    private void dibujarX(){
        jugador.setText("X");
    }
    private void dibujar0(){
        jugador.setText("0");
    }
}
