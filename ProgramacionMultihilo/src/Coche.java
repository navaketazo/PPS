import java.util.Random;

class Coche implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private static final int DISTANCIA_META = 100;
    private static boolean ganadorAnunciado = false;

    public Coche(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (distanciaRecorrida < DISTANCIA_META && !ganadorAnunciado) {
            // El coche avanza en incrementos aleatorios (entre 1 y 10 unidades)
            int avance = random.nextInt(10) + 1;
            distanciaRecorrida += avance;
            System.out.println(nombre + " ha recorrido: " + distanciaRecorrida + " unidades");

            // Simulación de tiempo entre avances
            try {
                Thread.sleep(random.nextInt(500) + 500); // pausa aleatoria entre 500ms y 1000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Verificamos si el coche ha llegado a la meta
            if (distanciaRecorrida >= DISTANCIA_META && !ganadorAnunciado) {
                ganadorAnunciado = true;
                System.out.println(nombre + " ha ganado la carrera!");
            }
        }
    }
}

