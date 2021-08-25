/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.MinimaxClass;
import model.Tablero;

/**
 *
 * @author Xavier
 */
public class VSComputadoraGUI {

    public Tablero tablero;
    public MinimaxClass miniMaxMove;
    Pane root;

    public VSComputadoraGUI(String jugador, String quienEmpieza) {
            this.root = crear(jugador, quienEmpieza);
    }

    protected void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(mensaje);
        alert.show();
    }

    private Pane crear(String jugador, String quienEmpieza) {
            tablero = new Tablero(jugador);
        
        
        miniMaxMove = new MinimaxClass(tablero);
        Pane raiz = new Pane();
        raiz.setStyle("-fx-background-color: #d7f0f7;");
        raiz.setPrefSize(600, 600);
        actualizarTablero(raiz);
        if (!quienEmpieza.equals(jugador)) {
            tablero.setTurno(quienEmpieza);
            tablero = miniMaxMove.minimax();
            actualizarTablero(raiz);
        }
        return raiz;
    }
    

    public Pane getRoot() {
        return root;
    }

    public void actualizarTablero(Pane p) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Casilla casilla = new Casilla(i, j);
                casilla.setTranslateX(j * 200);
                casilla.setTranslateY(i * 200);
                p.getChildren().add(casilla);

                if (casilla.getContenido().getText() != null) {
                    casilla.getContenido().setText(tablero.getCasillas()[i][j]);
                }

                casilla.setOnMouseClicked(e -> {
                    if (casilla.getContenido().getText().equals("")) {

                        casilla.setDisable(true);
                        tablero = tablero.getMove(casilla.getPosx(), casilla.getPosy());
                        actualizarTablero(p);
                        afterMove();

                        miniMaxMove = new MinimaxClass(tablero);
                        tablero = miniMaxMove.minimax();
                        actualizarTablero(p);
                        afterMove();

                    }

                });
            }
        }
    }

    public void afterMove() {
        tablero.updateWinner();
        if (tablero.getWinner() != null && tablero.getWinner() != "empate") {
            mostrarAlerta(tablero.getWinner() + " " + "ha Ganado");
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.close();
        }
        if (tablero.getWinner() == "empate") {
            mostrarAlerta("EMPATARON");
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.close();
        }
    }

}
