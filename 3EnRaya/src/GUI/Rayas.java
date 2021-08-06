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
    private int posx;
    private int posy;
    private Text jugador = new Text();
    public Rayas(int posx,int posy){
        this.posx = posx;
        this.posy = posy;
        Rectangle borde = new Rectangle(200, 200);
        borde.setFill(null);
        borde.setStroke(Color.BLACK);
        jugador.setFont(Font.font(72));
        
        setAlignment(Pos.CENTER);
        boolean addAll = getChildren().addAll(borde, jugador);
        setOnMouseClicked(e -> {
            dibujarO();
        });
    }
    
    private void dibujarX(){
        jugador.setText("X");
        
    }
    private void dibujarO(){
        jugador.setText("O");
    }

    public Text getJugador() {
        return jugador;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
    
}
