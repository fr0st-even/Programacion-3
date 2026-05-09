package cine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Iosef Canchán
 */
public class ExMutuaCine {
    
    // 20 asientos, null = libre
    private static final Integer[] asientos = new Integer[20];

    // Lock para exclusión mutua
    private static final Object asientosLock = new Object();

    // Lista thread-safe para usuarios sin asiento
    private static final List<Integer> usuariosSinAsiento =
            Collections.synchronizedList(new ArrayList<>());

    public static void reservarAsiento(int usuarioId) {
        Random random = new Random();
        int intentos = 0;

        while (true) {
            intentos++;

            // Selecciona aleatoriamente un asiento entre 0 y 19
            int asientoDeseado = random.nextInt(20);

            // Bloque de exclusión mutua
            synchronized (asientosLock) {
                // Cuenta asientos libres
                int asientosLibres = 0;
                for (Integer a : asientos) {
                    if (a == null) asientosLibres++;
                }

                if (asientosLibres == 0) {
                    System.out.println("Usuario " + usuarioId +
                            " no pudo reservar: todos los asientos estan ocupados.");
                    usuariosSinAsiento.add(usuarioId);
                    break;
                }

                if (asientos[asientoDeseado] == null) {
                    asientos[asientoDeseado] = usuarioId;
                    System.out.println(" Usuario " + usuarioId +
                            " reservo el asiento " + (asientoDeseado + 1) +
                            " (intento #" + intentos + ")");
                    break;
                } else {
                    System.out.println(" Usuario " + usuarioId +
                            " intento reservar asiento " + (asientoDeseado + 1) +
                            ", pero ya esta ocupado");
                }
            }

            // Espera antes de reintentar
            try {
                Thread.sleep((long) (100 + random.nextInt(200)));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int numUsuarios = 25;
        List<Thread> usuarios = new ArrayList<>();

        // Crear y lanzar un hilo por cada usuario (lambda)
        for (int i = 1; i <= numUsuarios; i++) {
            final int id = i;
            Thread t = new Thread(() -> reservarAsiento(id));
            usuarios.add(t);
            t.start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread t : usuarios) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Estado final de los asientos
        System.out.println("\nEstado final de los asientos:");
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i] != null) {
                System.out.println("Asiento " + (i + 1) +
                        ": Reservado por usuario " + asientos[i]);
            } else {
                System.out.println("Asiento " + (i + 1) + ": Libre");
            }
        }

        // Usuarios sin asiento
        System.out.println("\nTotal de usuarios sin asiento: " +
                usuariosSinAsiento.size());
        if (!usuariosSinAsiento.isEmpty()) {
            StringBuilder sb = new StringBuilder("Usuarios sin asiento: ");
            for (int i = 0; i < usuariosSinAsiento.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(usuariosSinAsiento.get(i));
            }
            System.out.println(sb.toString());
        }
    }
}
