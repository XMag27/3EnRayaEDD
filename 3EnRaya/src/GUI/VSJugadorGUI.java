/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Tablero;

/**
 *
 * @author Xavier
 */
public class VSJugadorGUI {

    public Tablero tablero;
    Pane root;

    public VSJugadorGUI(String jugador, String quienEmpieza) {
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
        Pane raiz = new Pane();
        raiz.setPrefSize(600, 600);
        actualizarTablero(raiz);
        if (!jugador.equals(quienEmpieza)) {
            tablero.setTurno(tablero.getOtherPlayer(jugador));
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
                casilla.getContenido().setText(tablero.getCasillas()[i][j]);
                casilla.setOnMouseClicked(e -> {

                    if (casilla.getContenido().getText().equals("")) {
                        casilla.setDisable(true);
                        tablero = tablero.getMove(casilla.getPosx(), casilla.getPosy());
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
