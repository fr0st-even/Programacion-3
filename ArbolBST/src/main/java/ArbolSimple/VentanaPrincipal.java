/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolSimple;

/**
 *
 * @author Iosef Canchán
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class VentanaPrincipal extends JFrame {

    ArbolBinario arbol;
    PanelArbol panelArbol;
    JTextArea areaResultados;
    JTextField campoValor;

    public VentanaPrincipal() {
        arbol = new ArbolBinario();

        setTitle("Arbol Binario de Busqueda");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // -------- PANEL SUPERIOR: campo de texto y botones --------
        JPanel panelSuperior = new JPanel();

        JLabel etiqueta = new JLabel("Valor:");
        campoValor = new JTextField(8);

        JButton btnInsertar = new JButton("Insertar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnBuscar   = new JButton("Buscar");

        JButton btnInOrden   = new JButton("In-Orden");
        JButton btnPreOrden  = new JButton("Pre-Orden");
        JButton btnPostOrden = new JButton("Post-Orden");
        JButton btnAltura    = new JButton("Altura del arbol");

        JButton btnCargar  = new JButton("Cargar archivo");
        JButton btnGuardar = new JButton("Guardar resultados");
        JButton btnLimpiar = new JButton("Limpiar arbol");

        panelSuperior.add(etiqueta);
        panelSuperior.add(campoValor);
        panelSuperior.add(btnInsertar);
        panelSuperior.add(btnEliminar);
        panelSuperior.add(btnBuscar);
        panelSuperior.add(new JSeparator(SwingConstants.VERTICAL));
        panelSuperior.add(btnInOrden);
        panelSuperior.add(btnPreOrden);
        panelSuperior.add(btnPostOrden);
        panelSuperior.add(btnAltura);
        panelSuperior.add(new JSeparator(SwingConstants.VERTICAL));
        panelSuperior.add(btnCargar);
        panelSuperior.add(btnGuardar);
        panelSuperior.add(btnLimpiar);

        // -------- PANEL CENTRAL: visualizacion del arbol --------
        panelArbol = new PanelArbol(arbol);
        panelArbol.setPreferredSize(new Dimension(900, 400));
        panelArbol.setBorder(BorderFactory.createTitledBorder("Arbol"));

        // -------- PANEL INFERIOR: consola de resultados --------
        areaResultados = new JTextArea(5, 80);
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Consolas", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(areaResultados);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultados"));

        // -------- AGREGAR PANELES A LA VENTANA --------
        add(panelSuperior, BorderLayout.NORTH);
        add(panelArbol,    BorderLayout.CENTER);
        add(scroll,        BorderLayout.SOUTH);

        // -------- ACCIONES DE BOTONES --------
        btnInsertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int val = Integer.parseInt(campoValor.getText().trim());
                    boolean insertado = arbol.insertar(val);
                    if (!insertado) {
                        areaResultados.append("Error: el valor " + val + " ya existe en el arbol (duplicado).\n");
                    } else {
                        panelArbol.nodoResaltado = -999;
                        panelArbol.repaint();
                        areaResultados.append("Insertado: " + val + "\n");
                    }
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    areaResultados.append("Error: ingrese un numero entero.\n");
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int val = Integer.parseInt(campoValor.getText().trim());
                    arbol.eliminar(val);
                    panelArbol.nodoResaltado = -999;
                    panelArbol.repaint();
                    areaResultados.append("Eliminado: " + val + "\n");
                    campoValor.setText("");
                } catch (NumberFormatException ex) {
                    areaResultados.append("Error: ingrese un numero entero.\n");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int val = Integer.parseInt(campoValor.getText().trim());
                    int nivel = arbol.buscarNivel(val);
                    if (nivel == -1) {
                        areaResultados.append("Busqueda: " + val + " NO encontrado.\n");
                        panelArbol.nodoResaltado = -999;
                    } else {
                        areaResultados.append("Busqueda: " + val + " encontrado en nivel " + nivel + ".\n");
                        panelArbol.nodoResaltado = val;
                    }
                    panelArbol.repaint();
                } catch (NumberFormatException ex) {
                    areaResultados.append("Error: ingrese un numero entero.\n");
                }
            }
        });

        btnInOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaResultados.append("In-Orden: ");
                imprimirInOrden(arbol.raiz);
                areaResultados.append("\n");
            }
        });

        btnPreOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaResultados.append("Pre-Orden: ");
                imprimirPreOrden(arbol.raiz);
                areaResultados.append("\n");
            }
        });

        btnPostOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaResultados.append("Post-Orden: ");
                imprimirPostOrden(arbol.raiz);
                areaResultados.append("\n");
            }
        });

        btnAltura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int altura = arbol.altura();
                if (altura == -1) {
                    areaResultados.append("Altura del arbol: El arbol esta vacio.\n");
                } else {
                    areaResultados.append("Altura del arbol: " + altura + "\n");
                }
            }
        });

        btnCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser selector = new JFileChooser();
                int resultado = selector.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivo = selector.getSelectedFile();
                    try {
                        Scanner sc = new Scanner(archivo);
                        String linea = sc.nextLine();
                        String[] valores = linea.split(",");
                        for (String v : valores) {
                            arbol.insertar(Integer.parseInt(v.trim()));
                        }
                        sc.close();
                        panelArbol.repaint();
                        areaResultados.append("Archivo cargado: " + archivo.getName() + "\n");
                    } catch (Exception ex) {
                        areaResultados.append("Error al leer el archivo.\n");
                    }
                }
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser selector = new JFileChooser();
                selector.setSelectedFile(new File("resultados.txt"));
                int resultado = selector.showSaveDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivo = selector.getSelectedFile();
                    try {
                        PrintWriter pw = new PrintWriter(new FileWriter(archivo));
                        pw.println("=== Resultados del Arbol Binario de Busqueda ===");
                        pw.println();
                        pw.print("In-Orden: ");
                        guardarInOrden(arbol.raiz, pw);
                        pw.println();
                        pw.print("Pre-Orden: ");
                        guardarPreOrden(arbol.raiz, pw);
                        pw.println();
                        pw.print("Post-Orden: ");
                        guardarPostOrden(arbol.raiz, pw);
                        pw.println();
                        pw.println();
                        pw.print("Altura del arbol: ");
                        int altura = arbol.altura();
                        if (altura == -1) {
                            pw.println("El arbol esta vacio.");
                        } else {
                            pw.println(altura);
                        }
                        pw.close();
                        areaResultados.append("Resultados guardados en: " + archivo.getName() + "\n");
                    } catch (Exception ex) {
                        areaResultados.append("Error al guardar el archivo.\n");
                    }
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                arbol = new ArbolBinario();
                panelArbol.arbol = arbol;
                panelArbol.nodoResaltado = -999;
                panelArbol.repaint();
                areaResultados.append("Arbol limpiado.\n");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Metodos para imprimir recorridos en el area de resultados
    void imprimirInOrden(Nodo nodo) {
        if (nodo != null) {
            imprimirInOrden(nodo.izquierdo);
            areaResultados.append(nodo.valor + " ");
            imprimirInOrden(nodo.derecho);
        }
    }

    void imprimirPreOrden(Nodo nodo) {
        if (nodo != null) {
            areaResultados.append(nodo.valor + " ");
            imprimirPreOrden(nodo.izquierdo);
            imprimirPreOrden(nodo.derecho);
        }
    }

    void imprimirPostOrden(Nodo nodo) {
        if (nodo != null) {
            imprimirPostOrden(nodo.izquierdo);
            imprimirPostOrden(nodo.derecho);
            areaResultados.append(nodo.valor + " ");
        }
    }

    // Metodos para guardar recorridos en archivo
    void guardarInOrden(Nodo nodo, PrintWriter pw) {
        if (nodo != null) {
            guardarInOrden(nodo.izquierdo, pw);
            pw.print(nodo.valor + " ");
            guardarInOrden(nodo.derecho, pw);
        }
    }

    void guardarPreOrden(Nodo nodo, PrintWriter pw) {
        if (nodo != null) {
            pw.print(nodo.valor + " ");
            guardarPreOrden(nodo.izquierdo, pw);
            guardarPreOrden(nodo.derecho, pw);
        }
    }

    void guardarPostOrden(Nodo nodo, PrintWriter pw) {
        if (nodo != null) {
            guardarPostOrden(nodo.izquierdo, pw);
            guardarPostOrden(nodo.derecho, pw);
            pw.print(nodo.valor + " ");
        }
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}