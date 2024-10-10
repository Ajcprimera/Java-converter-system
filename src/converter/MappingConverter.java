package converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 *
 * @author Albert Carruido and Santiago Pinto
 */
public abstract class MappingConverter implements Converter {
    
    public HashMap<String, BigDecimal> strToValueMap;
    public String[] unitNames;
    public BigDecimal[] unitValues;
    
    public String[] getUnitNames() {
        return unitNames;
    }

    public BigDecimal convert(String from, String to, BigDecimal value) {
        BigDecimal fromValue = strToValueMap.get(from);
        BigDecimal toValue = strToValueMap.get(to);
        return value.multiply(fromValue).divide(toValue//, 8, RoundingMode.HALF_UP);
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
