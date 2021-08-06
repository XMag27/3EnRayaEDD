/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.layout.Pane;

/**
 *
 * @author Xavier
 */
public class Tablero {
    Pane root = crear();
    private Pane crear(){
        Pane raiz = new Pane();
        raiz.setPrefSize(600, 600);
        for(int i =0; i<3; i++){
            for(int j = 0; j < 3; j++){
                Rayas raya = new Rayas();
                raya.setTranslateX(j*200);
                raya.setTranslateY(i*200);
                raiz.getChildren().add(raya);
            }
        }
        return raiz;
    }
    public Pane getRoot() {
        return root;
    }
    
}
