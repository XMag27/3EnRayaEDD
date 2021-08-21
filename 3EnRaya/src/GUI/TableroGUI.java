/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.MinimaxClass;
import model.Tablero;


/**
 *
 * @author Xavier
 */
public class TableroGUI {
    
    public Tablero tablero;
    Pane root;

    public TableroGUI(String t) {
        this.root = crear(t);
    }
    
    protected void mostrarAlerta(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(mensaje);
        alert.show();
    }
    private Pane crear(String t){
        tablero = new Tablero(t);
        Pane raiz = new Pane();
        raiz.setPrefSize(600, 600);
        actualizarTablero(raiz);
        return raiz;
    }
    public Pane getRoot() {
        return root;
    }
    
    public void actualizarTablero(Pane p){
        for(int i =0; i<3; i++){
            for(int j = 0; j < 3; j++){
                Rayas raya = new Rayas(i,j);
                raya.setTranslateX(j*200);
                raya.setTranslateY(i*200);
                p.getChildren().add(raya);                
                raya.getJugador().setText(tablero.getCasillas()[i][j]);
                raya.setOnMouseClicked(e -> {                    
                    tablero = tablero.getMove(raya.getPosx(), raya.getPosy());
                    actualizarTablero(p);
                    System.out.println("aaa");
                    tablero.updateWinner();
                    if(tablero.getWinner() != null && tablero.getWinner() != "empate"){
                        mostrarAlerta(tablero.getWinner() +" "+ "ha Ganado");
                    }if(tablero.getWinner() == "empate"){
                        mostrarAlerta("EMPATARON");
                    }                                        
//                  Hasta Aquí
                    for(int a = 0; a < 3; a++){
                        for(int b = 0; b < 3; b++){
                            System.out.println(tablero.getCasillas()[a][b] + " " + a + b);
                        }  
                    }
                    
                    MinimaxClass minmax = new MinimaxClass(tablero);
                    tablero = minmax.minimax();
                    actualizarTablero(p);
                    tablero.updateWinner();
                    if(tablero.getWinner() != null && tablero.getWinner() != "empate"){
                        mostrarAlerta(tablero.getWinner() +" "+ "ha Ganado");
                    }if(tablero.getWinner() == "empate"){
                        mostrarAlerta("EMPATARON");
                    }                                        
//                  Hasta Aquí
                    for(int a = 0; a < 3; a++){
                        for(int b = 0; b < 3; b++){
                            System.out.println(tablero.getCasillas()[a][b] + " " + a + b);
                        }  
                    }
                    
                    
                    
                });
            }
        }
        
        
    }
    
    
    }