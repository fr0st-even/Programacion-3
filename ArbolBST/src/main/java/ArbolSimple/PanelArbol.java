/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolSimple;

/**
 *
 * @author Iosef Canchán
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class PanelArbol extends JPanel {

    ArbolBinario arbol;
    int nodoResaltado = -999; // valor del nodo encontrado al buscar

    public PanelArbol(ArbolBinario arbol) {
        this.arbol = arbol;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (arbol.raiz == null) {
            g.setColor(Color.GRAY);
            g.drawString("El arbol esta vacio", 20, 30);
            return;
        }

        dibujarNodo(g, arbol.raiz, getWidth() / 2, 40, getWidth() / 4);
    }

    private void dibujarNodo(Graphics g, Nodo nodo, int x, int y, int offset) {
        if (nodo == null) return;

        // Dibujar lineas hacia los hijos primero
        if (nodo.izquierdo != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x - offset, y + 70);
        }
        if (nodo.derecho != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x + offset, y + 70);
        }

        // Dibujar el circulo del nodo
        if (nodo.valor == nodoResaltado) {
            g.setColor(Color.ORANGE); // resaltado al buscar
        } else {
            g.setColor(new Color(100, 160, 220)); // azul normal
        }
        g.fillOval(x - 20, y - 20, 40, 40);

        // Borde del circulo
        g.setColor(Color.BLACK);
        g.drawOval(x - 20, y - 20, 40, 40);

        // Numero dentro del circulo
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        String texto = String.valueOf(nodo.valor);
        g.drawString(texto, x - (texto.length() * 4), y + 5);

        // Llamadas recursivas para hijos
        int nuevoOffset = Math.max(offset / 2, 30);
        dibujarNodo(g, nodo.izquierdo, x - offset, y + 70, nuevoOffset);
        dibujarNodo(g, nodo.derecho,   x + offset, y + 70, nuevoOffset);
    }
}
