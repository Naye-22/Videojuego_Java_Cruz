/**
 * Clase Principal para Probar PersonajeJugador
 * Archivo: PruebaPersonaje.java
 *
 * Esta clase contiene el método main() y sirve para ejecutar el programa
 * Aquí probaremos todas las funcionalidades del PersonajeJugador
 */

public class PruebaPersonaje {

    /**
     * Método main - Punto de entrada del programa
     * Este método se ejecuta cuando iniciamos el programa
     */
    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("    LEGENDS OF AETHER - DEMO CONSOLA");
        System.out.println("==============================================\n");


        // ============================================
        // PARTE 1: CREAR UN PERSONAJE
        // ============================================
        System.out.println("--- CREANDO PERSONAJE ---");
        PersonajeJugador heroe = new PersonajeJugador("Arthas");


        // ============================================
        // PARTE 2: MOSTRAR ESTADO INICIAL
        // ============================================
        heroe.mostrarEstado();


        // ============================================
        // PARTE 3: SIMULAR COMBATE
        // ============================================
        System.out.println("--- SIMULANDO COMBATE ---");
        System.out.println("¡Un enemigo aparece!\n");

        // El héroe ataca
        heroe.atacar();
        System.out.println();

        // El héroe recibe daño
        System.out.println("El enemigo contraataca...");
        heroe.recibirDanio(25);
        System.out.println();

        // El héroe ataca de nuevo
        heroe.atacar();
        System.out.println();


        // ============================================
        // PARTE 4: GANAR EXPERIENCIA
        // ============================================
        System.out.println("--- GANANDO EXPERIENCIA ---");
        System.out.println("¡Enemigo derrotado!\n");
        heroe.ganarExperiencia(50);
        System.out.println();


        // ============================================
        // PARTE 5: CURARSE
        // ============================================
        System.out.println("--- USANDO POCIÓN DE CURACIÓN ---");
        heroe.curar(30);
        System.out.println();


        // ============================================
        // PARTE 6: MÁS EXPERIENCIA PARA SUBIR NIVEL
        // ============================================
        System.out.println("--- SEGUNDO COMBATE ---");
        System.out.println("¡Otro enemigo aparece!");
        heroe.atacar();
        heroe.ganarExperiencia(60); // Esto debería hacerlo subir de nivel
        System.out.println();


        // ============================================
        // PARTE 7: ESTADO FINAL
        // ============================================
        System.out.println("--- ESTADO FINAL DEL PERSONAJE ---");
        heroe.mostrarEstado();


        // ============================================
        // PARTE 8: PROBAR GETTERS
        // ============================================
        System.out.println("--- USANDO GETTERS ---");
        System.out.println("Nombre obtenido: " + heroe.getNombre());
        System.out.println("Nivel obtenido: " + heroe.getNivel());
        System.out.println("Vida obtenida: " + heroe.getVida());
        System.out.println("¿Está vivo?: " + (heroe.estaVivo() ? "Sí" : "No"));
        System.out.println();


        // ============================================
        // PARTE 9: CAMBIAR NOMBRE
        // ============================================
        System.out.println("--- CAMBIANDO NOMBRE ---");
        heroe.setNombre("Arthas el Valiente");
        heroe.mostrarEstado();


        System.out.println("==============================================");
        System.out.println("         FIN DE LA DEMOSTRACIÓN");
        System.out.println("==============================================");
    }
}
