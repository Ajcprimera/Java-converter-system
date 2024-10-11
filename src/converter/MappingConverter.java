package converter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.Locale;

/**
 *
 * @author Albert Carruido and Santiago Pinto
 */
public abstract class MappingConverter implements Converter {
    
    public HashMap<String, BigDecimal> strToValueMap;
    public String[] unitNames;
    public BigDecimal[] unitValues;
    public MathContext contexto = new MathContext(8, RoundingMode.HALF_UP);
    
    public String[] getUnitNames() {
        return unitNames;
    }

    public String getFormula(String from, String to) {
        return String.format(Locale.US, "Fórmula: multiplica el valor por %g", convert(from, to, BigDecimal.ONE));
    }

    public BigDecimal convert(String from, String to, BigDecimal value) {
        BigDecimal fromValue = strToValueMap.get(from);
        BigDecimal toValue = strToValueMap.get(to);
        return value.multiply(fromValue).divide(toValue, contexto//, 8, RoundingMode.HALF_UP);
        );
    }
    
    protected void fillMap() {
        Arrays.stream(unitNames).forEachOrdered(new Consumer<String>() {
            private int i = 0;
            
            public void accept(String name) {
                strToValueMap.put(name, unitValues[i]);
                ++i;
            }
        });
    }
    
}
