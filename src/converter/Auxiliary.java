package converter;

import java.util.function.Supplier;

/**
 *
 * @author Albert Carruido and Santiago Pinto
 */
public abstract class Auxiliary {
    public interface ThrowingSupplier<T> extends Supplier {
        T throwingGet() throws Exception;
        
        default T get() {
            try {
                return throwingGet();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static <T> T ifelse(boolean test, Supplier<T> ifFunction, Supplier<T> elseFunction) {
        return test ? ifFunction.get() : elseFunction.get();
    }
    
    /*
    public static <T> T throwingIfelse(boolean test, ThrowingSupplier<T> ifFunction, ThrowingSupplier<T> elseFunction) throws Exception {
        return test ? ifFunction.get() : elseFunction.get();
    }
    */
}
