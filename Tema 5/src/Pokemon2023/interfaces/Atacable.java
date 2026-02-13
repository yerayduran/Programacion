package Pokemon2023.interfaces;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;

public interface Atacable {

   /**
    * Creamos un método dentro de la interfaz Atacable para que un pokemon pueda recibir daño
    * de otro Pokémon
    *
    *
    * @param tiempo al usar este parámetro nos ayuda si nuestro Pokémon recibe más o menos daño dependiendo
    *               que tiempo meteorologico hace en batalla.
    * @param puntosAtaque es el daño recibido por dichas condiciones metereologicas para recibir más o
    *                     menos daño
    * @param atacador y dependiendo que Pokémon te ataca podra hacerte más o menos daño
    * @throws MuerteException hace que si este Pokémon tenga de vida actual 0 muestre por pantalla que este derrotado
    */
   public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException;
}
