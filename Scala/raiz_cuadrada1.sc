/**
 * Se utiliza los principios de la programación funcional para implementar el método de Newton-Raphson,
 * para calcular la raíz cuadrada de un número entero positivo mayor que cero
 */

// Función principal, raíz cuadrada con el método de aproxmaciones sucesivas Newton-Raphson
def raiz_cuadrada(n: Int): Double = {

  // Función cuadrática x^2 - n
  def f (x: Double): Double = Math.pow(x, 2) - n

  // Derivada de la función cuadrática, 2x
  def dx (x: Double): Double = 2 * x

  // Función de evaluación con exactitud de dos decimales (0.001)
  def suficiente (x:Double): Boolean = Math.abs(x * x - n) / n < 0.001

  // Función que devuelve nueva aproximación a la solución, mejora la aproximación
  def mejorar (x: Double): Double = x - f(x) / dx(x)

  // Función que contiene la lógica para mejorar la solución
  def calcular (x:Double): Double = if (suficiente(x)) x else calcular(mejorar(x))

  calcular(1.0) // Punto de partida, valor inicial

}

raiz_cuadrada(10)
