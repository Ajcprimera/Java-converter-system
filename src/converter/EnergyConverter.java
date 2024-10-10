package converter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 *
 * @author Albert Carruido and Santiago Pinto
 */
public class EnergyConverter extends MappingConverter {
    
    public EnergyConverter() {
        unitNames = new String[]{
            "Julio", "Kilojulio",
            "Caloría-gramo", "Kilocaloría",
            "Vatio-hora", "Kilovatio-hora",
            "Electronvoltio",
            "Unidad térmica británica", "Termia estadounidense", "Pie-libra fuerza"
        };
        // In Kilocalories
        unitValues = new BigDecimal[]{
            BigDecimal.valueOf(1 / 4184.0), BigDecimal.valueOf(1 / 4.184),
            BigDecimal.valueOf(1 / 1000.0), BigDecimal.ONE,
            BigDecimal.valueOf(860.4 / 1000), BigDecimal.valueOf(860.4),
            BigDecimal.valueOf(1 / (2.611 * Math.pow(10, 22))),
            BigDecimal.valueOf(1 / 3.966), BigDecimal.valueOf(25210.0), BigDecimal.valueOf(1 / 3086.0)
        };
        strToValueMap = new HashMap<String, BigDecimal>(unitNames.length + 1, 1);
        
        fillMap();
    }
    
}
