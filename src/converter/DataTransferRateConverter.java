package converter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 *
 * @author Albert Carruido and Santiago Pinto
 */
public class DataTransferRateConverter extends MappingConverter {
    
    public DataTransferRateConverter() {
        unitNames = new String[]{
            "Bit por segundo",
            "Kilobit por segundo", "Kilobyte por segundo", "Kibibit por segundo", "Kibibyte por segundo",
            "Megabit por segundo", "Megabyte por segundo", "Mebibit por segundo", "Mebibyte por segundo",
            "Gigabit por segundo", "Gigabyte por segundo", "Gibibit por segundo", "Gibibyte por segundo",
            "Terabit por segundo", "Terabyte por segundo", "Tebibit por segundo", "Tebibyte por segundo"
        };
        unitValues = new BigDecimal[]{
            BigDecimal.ONE,
            BigDecimal.valueOf(1000), BigDecimal.valueOf(8000), BigDecimal.valueOf(1024), BigDecimal.valueOf(8192),
            BigDecimal.valueOf(1000000), BigDecimal.valueOf(8000000), BigDecimal.valueOf(1048576), BigDecimal.valueOf(8388608),
            BigDecimal.valueOf(1000000000L), BigDecimal.valueOf(8000000000L), BigDecimal.valueOf(1073741824L), BigDecimal.valueOf(8589934592L),
            BigDecimal.valueOf(1000000000000L), BigDecimal.valueOf(8000000000000L), BigDecimal.valueOf(1099511627776L), BigDecimal.valueOf(8796093022208L)
        };
        strToValueMap = new HashMap<String, BigDecimal>(unitNames.length + 1, 1);
        
        fillMap();
    }
    
}
