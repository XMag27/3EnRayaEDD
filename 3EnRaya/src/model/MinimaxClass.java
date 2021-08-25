/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Tree.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gel-2
 */
public class MinimaxClass {

    Tablero actual;

    public MinimaxClass(Tablero actual) {

        this.actual = actual;

    }

    public Tablero minimax() {

        int maxUtility = -10;
        Tablero jugada = null;

        Tree<Tablero> arbolDeEstados = new Tree(actual);
        arbolDeEstados.getRoot().setChildren(generarHijos(actual));

        for (Tree<Tablero> hijo : arbolDeEstados.getRoot().getChildren()) {
            if (childrenMinUtility(hijo) > maxUtility) {
                maxUtility = childrenMinUtility(hijo);
                jugada = hijo.getRoot().getContent();
            }
        }

        return jugada;

    }

    public int childrenMinUtility(Tree<Tablero> tablero) {

        int minUtility = 10;

        List<Tree<Tablero>> children = generarHijos(tablero.getRoot().getContent());

        tablero.getRoot().setChildren(children);

        for (Tree<Tablero> hijo : tablero.getRoot().getChildren()) {
            Tablero tableroHijo = hijo.getRoot().getContent();
            int humanPlayerUtility = tableroHijo.utility(tableroHijo.getTurno());
            if (humanPlayerUtility < minUtility) {
                minUtility = humanPlayerUtility;
            }
        }

        return minUtility;

    }

    public List<Tree<Tablero>> generarHijos(Tablero tableroActual) {

        List<Tree<Tablero>> posiblesJugadas = new ArrayList();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean isEmpty = tableroActual.getCasillas()[i][j].equals("");
                if (isEmpty) {
                    Tablero jugada = tableroActual.getMove(i, j);
                    Tree<Tablero> hijo = new Tree(jugada);
                    posiblesJugadas.add(hijo);
                }
            }
        }

        return posiblesJugadas;

    }

}
