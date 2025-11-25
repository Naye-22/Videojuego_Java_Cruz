import java.util.ArrayList;
import java.util.List;
/**
 * PARTE 1: Clase PersonajeJugador
 * Archivo: PersonajeJugador.java
 *
 * Esta es la primera clase de nuestro videojuego "Legends of Aether"
 * Un personaje jugador tiene características básicas como nombre, vida y nivel
 */

public class PersonajeJugador {

    // ============================================
    // PASO 1: DECLARAR ATRIBUTOS PRIVADOS
    // ============================================

    // Atributos de identidad
    private String nombre;
    private int nivel;

    // Atributos de combate
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int defensa;

    // Atributos de progresión
    private int experiencia;


    // ============================================
    // PASO 2: CREAR EL CONSTRUCTOR
    // ============================================

    /**
     * Constructor: Se ejecuta cuando creamos un nuevo personaje
     * Ejemplo de uso: PersonajeJugador heroe = new PersonajeJugador("Arthas");
     *
     * @param nombre El nombre del personaje
     */
    public PersonajeJugador(String nombre) {
        // Inicializar atributos básicos
        this.nombre = nombre;
        this.nivel = 1;
        this.vidaMaxima = 100;
        this.vida = 100;  // Inicia con vida completa
        this.ataque = 15;
        this.defensa = 10;
        this.experiencia = 0;

        // Mostrar mensaje de creación
        System.out.println("¡Personaje creado exitosamente!");
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + vida + "/" + vidaMaxima);
    }


    // ============================================
    // PASO 3: MÉTODOS GETTER (Para leer información)
    // ============================================

    /**
     * Obtiene el nombre del personaje
     * @return El nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el nivel actual
     * @return El nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Obtiene la vida actual
     * @return La vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * Obtiene la vida máxima
     * @return La vida máxima
     */
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    /**
     * Obtiene el ataque
     * @return El ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Obtiene la defensa
     * @return La defensa
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * Obtiene la experiencia
     * @return La experiencia
     */
    public int getExperiencia() {
        return experiencia;
    }


    // ============================================
    // PASO 4: MÉTODOS SETTER (Para modificar información)
    // ============================================

    /**
     * Modifica el nombre del personaje
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
        System.out.println("Nombre cambiado a: " + nombre);
    }

    /**
     * Modifica la vida de forma controlada
     * No permite que la vida sea negativa o supere el máximo
     * @param vida La nueva cantidad de vida
     */
    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
        } else if (vida > vidaMaxima) {
            this.vida = vidaMaxima;
        } else {
            this.vida = vida;
        }
    }


    // ============================================
    // PASO 5: MÉTODOS DE COMPORTAMIENTO
    // ============================================

    /**
     * COMPORTAMIENTO: Mostrar el estado del personaje
     * Imprime toda la información del personaje en consola
     */
    public void mostrarEstado() {
        System.out.println("\n========== ESTADO DEL PERSONAJE ==========");
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Vida: " + vida + "/" + vidaMaxima);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("==========================================\n");
    }

    /**
     * COMPORTAMIENTO: Atacar
     * Descripción narrativa: El héroe lanza un ataque básico
     */
    public void atacar() {
        System.out.println(nombre + " realiza un ataque poderoso!");
        System.out.println("Daño causado: " + ataque + " puntos");
    }

    /**
     * COMPORTAMIENTO: Recibir daño
     * El personaje recibe daño, se aplica la defensa
     * @param danio Cantidad de daño recibido
     */
    public void recibirDanio(int danio) {
        // La defensa reduce el daño recibido
        int danioReal = danio - (defensa / 2);
        if (danioReal < 1) {
            danioReal = 1; // Siempre recibe al menos 1 de daño
        }

        vida = vida - danioReal;
        if (vida < 0) {
            vida = 0;
        }

        System.out.println(nombre + " recibe " + danioReal + " puntos de daño!");
        System.out.println("Vida restante: " + vida + "/" + vidaMaxima);

        if (vida == 0) {
            System.out.println("¡" + nombre + " ha caído en combate!");
        }
    }

    /**
     * COMPORTAMIENTO: Ganar experiencia
     * El personaje gana experiencia de batallas
     * @param exp Cantidad de experiencia ganada
     */
    public void ganarExperiencia(int exp) {
        experiencia = experiencia + exp;
        System.out.println(nombre + " gana " + exp + " puntos de experiencia");
        System.out.println("Experiencia total: " + experiencia);

        // Si llega a 100 exp, sube de nivel
        if (experiencia >= 100) {
            subirNivel();
        }
    }

    /**
     * COMPORTAMIENTO: Subir de nivel
     * El personaje mejora sus estadísticas
     */
    private void subirNivel() {
        nivel++;
        experiencia = 0; // Reinicia experiencia

        // Aumentar estadísticas
        vidaMaxima = vidaMaxima + 20;
        vida = vidaMaxima; // Restaura vida al máximo
        ataque = ataque + 5;
        defensa = defensa + 3;

        System.out.println("\n¡¡¡ NIVEL SUPERIOR !!!");
        System.out.println(nombre + " sube al nivel " + nivel);
        System.out.println("Vida máxima: +" + 20);
        System.out.println("Ataque: +" + 5);
        System.out.println("Defensa: +" + 3);
        System.out.println("¡Vida restaurada completamente!\n");
    }

    /**
     * COMPORTAMIENTO: Curar
     * El personaje recupera vida
     * @param cantidad Cantidad de vida a recuperar
     */
    public void curar(int cantidad) {
        vida = vida + cantidad;
        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }

        System.out.println(nombre + " se cura " + cantidad + " puntos de vida");
        System.out.println("Vida actual: " + vida + "/" + vidaMaxima);
    }

    /**
     * Verifica si el personaje está vivo
     * @return true si está vivo, false si está muerto
     */
    public boolean estaVivo() {
        return vida > 0;
    }
}
