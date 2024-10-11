package converter;

import java.math.BigDecimal;

/**
 *
 * @author Albert Carruido and Santiago Pinto
 */
public interface Converter {
    BigDecimal convert(String from, String to, BigDecimal value);
    
    String[] getUnitNames();

    String getFormula(String from, String to);
}
