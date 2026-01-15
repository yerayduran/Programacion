package Pokemon2023.interfaces;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;

public interface Atacable {

   public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException;
}
