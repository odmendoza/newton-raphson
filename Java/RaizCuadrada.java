import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Se utilizan los principios de la programación funcional para implementar el método de Newton-Raphson,
 * para calcular la raíz cuadrada de un número entero positivo mayor que cero
 */

public class RaizCuadrada {

    // Función cuadrática x^2 - n
    static BiFunction<Double, Integer, Double> f = (x, n) -> Math.pow(x,2) - n;

    // Derivada de la función cuadrática, 2x
    static Function<Double, Double> dx = (x) -> 2 * x;

    // Función de evaluación con exactitud de dos decimales (0.001)
    static BiFunction<Integer, Double, Boolean> suficiente = (n, x) -> Math.abs(x * x -n) / n < 0.001 ;

    // Función que devuelve nueva aproximación a la solución, mejora la aproximación
    static BiFunction<Integer, Double, Double> mejorar = (n, x) -> x - f.apply(x, n) / dx.apply(x) ;

    // Función que contiene la lógica para mejorar la solución
    static BiFunction<Integer, Double, Double> calcular  = null;
    static {
        calcular = (n, x) -> suficiente.apply(n, x) ? x : calcular.apply(n, mejorar.apply(n, x)) ;
    }

    // Función principal, raíz cuadrada con el método de aproxmaciones sucesivas Newton-Raphson
    static Function<Integer, Double> raiz_cuadrada = (n) -> calcular.apply(n, 1.0);

    // Método main()
    public static void main(String[] args) {
        System.out.println(raiz_cuadrada.apply(10));
    }
}
