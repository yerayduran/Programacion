package Pokemon2023.interfaces;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;

public interface Atacador {

    void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException;
}
