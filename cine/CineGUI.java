package cine;

import javax.swing.*;
import java.awt.*;

public class CineGUI {

    // Componentes de la Interfaz
    static JButton[] botonesAsientos = new JButton[20];
    static JTextArea logArea;
    static JLabel lblSinAsiento;
    static JButton btnIniciar;

    // Acciones de la Interfaz 
    static void log(String msg) {
        SwingUtilities.invokeLater(() -> logArea.append(msg + "\n"));
    }

    static void pintarAsiento(int idx, String label, Color color) {
        SwingUtilities.invokeLater(() -> {
            botonesAsientos[idx].setText("A" + (idx + 1) + " " + label);
            botonesAsientos[idx].setBackground(color);
            botonesAsientos[idx].setEnabled(false);
        });
    }

    static void actualizarSinAsiento() {
        SwingUtilities.invokeLater(() ->
                lblSinAsiento.setText("Sin asiento: " + CineEstado.sinAsientoCount)
        );
    }

    // Ventana de resumen final
    static void mostrarResumen() {
        SwingUtilities.invokeLater(() -> {

            JDialog dialog = new JDialog((JFrame) null, "Resumen de la simulación", true);
            dialog.setLayout(new BorderLayout(10, 10));
            dialog.getContentPane().setBackground(new Color(30, 30, 30));

            JLabel titulo = new JLabel("  Resultado final", SwingConstants.LEFT);
            titulo.setFont(new Font("Monospaced", Font.BOLD, 16));
            titulo.setForeground(new Color(200, 255, 200));
            titulo.setBorder(BorderFactory.createEmptyBorder(12, 12, 4, 12));
            dialog.add(titulo, BorderLayout.NORTH);

            JTextArea tabla = new JTextArea();
            tabla.setEditable(false);
            tabla.setBackground(new Color(20, 20, 20));
            tabla.setForeground(new Color(200, 255, 200));
            tabla.setFont(new Font("Monospaced", Font.PLAIN, 13));

            StringBuilder sb = new StringBuilder();
            sb.append("─────────────────────────────\n");
            int ocupados = 0;
            for (int i = 0; i < CineEstado.asientos.length; i++) {
                String estado;
                if (CineEstado.asientos[i] == null) {
                    estado = "libre";
                } else {
                    ocupados++;  // cuenta automáticos Y manuales
                    if (CineEstado.asientos[i] == 99) {
                        estado = "TÚ (manual)";
                    } else {
                        estado = "Usuario " + CineEstado.asientos[i];
                    }
                }
                sb.append(String.format("  Asiento %2d :  %s%n", (i + 1), estado));
            }
            sb.append("─────────────────────────────\n");
            sb.append(String.format("  Ocupados    :  %d / 20%n", ocupados));
            sb.append(String.format("  Sin asiento :  %d usuarios%n", CineEstado.sinAsientoCount));
            tabla.setText(sb.toString());

            JScrollPane scroll = new JScrollPane(tabla);
            scroll.setBorder(BorderFactory.createEmptyBorder(4, 12, 4, 12));
            dialog.add(scroll, BorderLayout.CENTER);

            JButton btnCerrar = new JButton("Cerrar");
            btnCerrar.addActionListener(e -> dialog.dispose());
            JPanel panelBtn = new JPanel();
            panelBtn.setBackground(new Color(30, 30, 30));
            panelBtn.add(btnCerrar);
            dialog.add(panelBtn, BorderLayout.SOUTH);

            dialog.setSize(320, 520);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        });
    }

    // Reiniciar estado y GUI
    private static void reiniciar() {
        synchronized (CineEstado.lock) {
            for (int i = 0; i < 20; i++) {
                CineEstado.asientos[i] = null;
                final int idx = i;
                SwingUtilities.invokeLater(() -> {
                    botonesAsientos[idx].setText("A" + (idx + 1));
                    botonesAsientos[idx].setBackground(new Color(144, 238, 144));
                    botonesAsientos[idx].setEnabled(true);
                });
            }
            CineEstado.sinAsientoCount = 0;
        }
        SwingUtilities.invokeLater(() -> {
            logArea.setText("");
            lblSinAsiento.setText("Sin asiento: 0");
            btnIniciar.setEnabled(true);
        });
        log("--- Reiniciado ---");
    }

    // Ventana principal y main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Reserva de Asientos - Cine");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout(8, 8));
            frame.getContentPane().setBackground(new Color(30, 30, 30));

            // Panel de asientos
            JPanel panelAsientos = new JPanel(new GridLayout(4, 5, 5, 5));
            panelAsientos.setBackground(new Color(30, 30, 30));
            panelAsientos.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.GRAY),
                    "  Asientos  (verde=libre | rosa=automático | celeste=tú)  ",
                    0, 0, null, Color.LIGHT_GRAY));

            for (int i = 0; i < 20; i++) {
                final int idx = i;
                botonesAsientos[i] = new JButton("A" + (i + 1));
                botonesAsientos[i].setBackground(new Color(144, 238, 144));
                botonesAsientos[i].setForeground(Color.BLACK);
                botonesAsientos[i].setFont(new Font("Monospaced", Font.BOLD, 12));
                botonesAsientos[i].setOpaque(true);
                botonesAsientos[i].setPreferredSize(new Dimension(90, 45));
                botonesAsientos[i].addActionListener(e ->
                        new CineEstado.CompraManualThread(idx).start()
                );
                panelAsientos.add(botonesAsientos[i]);
            }

            // Área de log
            logArea = new JTextArea(14, 52);
            logArea.setEditable(false);
            logArea.setBackground(new Color(20, 20, 20));
            logArea.setForeground(new Color(200, 255, 200));
            logArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            JScrollPane scroll = new JScrollPane(logArea);
            scroll.setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.GRAY),
                    "  Registro  ", 0, 0, null, Color.LIGHT_GRAY));

            // Controles
            btnIniciar = new JButton("Iniciar simulación");
            JButton btnReiniciar = new JButton("Reiniciar");
            lblSinAsiento = new JLabel("Sin asiento: 0");
            lblSinAsiento.setForeground(Color.ORANGE);
            lblSinAsiento.setFont(new Font("Monospaced", Font.BOLD, 13));

            btnIniciar.addActionListener(e -> {
                btnIniciar.setEnabled(false);
                new CineEstado.SimulacionThread().start();
            });
            btnReiniciar.addActionListener(e -> reiniciar());

            JPanel controles = new JPanel();
            controles.setBackground(new Color(30, 30, 30));
            controles.add(btnIniciar);
            controles.add(btnReiniciar);
            controles.add(lblSinAsiento);

            frame.add(panelAsientos, BorderLayout.NORTH);
            frame.add(scroll, BorderLayout.CENTER);
            frame.add(controles, BorderLayout.SOUTH);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}