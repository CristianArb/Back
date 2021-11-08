package application.reports;

/**
 * StatusReservas
 * Esta clase permite crear un objeto StatusReservas que almacena la
 * información del número de reservas completadas y canceladas
 * 
 * @since 2021-11-08
 * @version 1.0
 * @author Cristian Peña, Camilo Muñoz & Andres Bonilla
 */
public class StatusReservas {

    /**
     * Este atribito es el número de reservas completadas.
     */
    private int completed;
    
    /**
     * Este atributo es el número de reservas canceladas.
     */
    private int cancelled;

    /**
     * Constrictor de la clase StatusReservas
     * @param completed Número de reservas completadas
     * @param cancelled Número de reservas canceladas
     */
    public StatusReservas(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    /**
     * Método get que devuelve la cantidad de reservas completadas
     * @return Número de reservas completadas
     */
    public int getCompleted() {
        return completed;
    }

    /**
     * Método set que modifica la cantidad de reservas completadas
     * @param completed Las reservas completadas
     */
    public void setCompleted(int completed) {
        this.completed = completed;
    }

    /**
     * Método get que devuelve la cantidad de reservas canceladas
     * @return Número de reservas canceladas
     */
    public int getCancelled() {
        return cancelled;
    }

    /**
     * Método set que modifica la cantidad de reservas canceladas
     * @param cancelled Las reservas canceladas
     */
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

}
