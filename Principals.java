import java.util.Scanner;

public class Principals {

    public static void main(String[] args) {

        // Creamos un objeto Scanner para la entrada de datos.
        Scanner scanner = new Scanner(System.in);

        // Entrada de datos para el Rectángulo A
        System.out.println("Ingresa las coordenadas de la primera esquina para el Rectángulo A (x1, y1):");
        double x1A = scanner.nextDouble(); // Coordenada X de la primera esquina
        double y1A = scanner.nextDouble(); // Coordenada Y de la primera esquina
        System.out.println("Ingresa las coordenadas de la segunda esquina para el Rectángulo A (x2, y2):");
        double x2A = scanner.nextDouble(); // Coordenada X de la segunda esquina
        double y2A = scanner.nextDouble(); // Coordenada Y de la segunda esquina

        // Creamos las coordenadas de las esquinas de Rectángulo A
        Coordenada esquina1A = new Coordenada(x1A, y1A);
        Coordenada esquina2A = new Coordenada(x2A, y2A);

        // Creamos el Rectángulo A
        Rectangulo rectanguloA = new Rectangulo(esquina1A, esquina2A);

        // Entrada de datos para el Rectángulo B
        System.out.println("Ingresa las coordenadas de la primera esquina para el Rectángulo B (x1, y1):");
        double x1B = scanner.nextDouble(); // Coordenada X de la primera esquina
        double y1B = scanner.nextDouble(); // Coordenada Y de la primera esquina
        System.out.println("Ingresa las coordenadas de la segunda esquina para el Rectángulo B (x2, y2):");
        double x2B = scanner.nextDouble(); // Coordenada X de la segunda esquina
        double y2B = scanner.nextDouble(); // Coordenada Y de la segunda esquina

        // Creamos las coordenadas de las esquinas de Rectángulo B
        Coordenada esquina1B = new Coordenada(x1B, y1B);
        Coordenada esquina2B = new Coordenada(x2B, y2B);

        // Creamos el Rectángulo B
        Rectangulo rectanguloB = new Rectangulo(esquina1B, esquina2B);

        // Mostrar la información de los dos rectángulos
        mostrarRectangulo(rectanguloA, "A");
        mostrarRectangulo(rectanguloB, "B");

        // Determinamos la relación entre los rectángulos A y B
        if (Verificador.seSuperponen(rectanguloA, rectanguloB)) {
            System.out.println("Rectangulos A y B se sobreponen.");
            // Calculamos el rectángulo de sobreposición entre A y B
            Rectangulo sobreposicion = rectanguloSobre(rectanguloA, rectanguloB);
            System.out.println("Área de sobreposición = " + sobreposicion.calculoArea());
        } else if (Verificador.estanJuntos(rectanguloA, rectanguloB)) {
            System.out.println("Rectángulos A y B se juntan.");
        } else if (Verificador.sonDisjuntos(rectanguloA, rectanguloB)) {
            System.out.println("Rectángulos A y B son disjuntos.");
        }

        // Cerramos el objeto Scanner
        scanner.close();
    }

    // Método para mostrar la información de un rectángulo
    public static void mostrarRectangulo(Rectangulo rect, String nombre) {
        // Imprime la representación en cadena del rectángulo
        System.out.println("Rectángulo " + nombre + " = " + rect.toString());
    }

    // Método para calcular el rectángulo de sobreposición
    public static Rectangulo rectanguloSobre(Rectangulo rectA, Rectangulo rectB) {
        // Calculamos las coordenadas del rectángulo de sobreposición
        double x1 = Math.max(rectA.x1, rectB.x1);
        double y1 = Math.max(rectA.y1, rectB.y1);
        double x2 = Math.min(rectA.x2, rectB.x2);
        double y2 = Math.min(rectA.y2, rectB.y2);

        // Devolvemos el rectángulo que representa la intersección
        return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
    }
}

// Clase para representar las coordenadas en el plano cartesiano
class Coordenada {

    private double x; // Coordenada X
    private double y; // Coordenada Y

    // Constructor por defecto (inicializa en 0,0)
    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor que recibe las coordenadas X e Y
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor que copia las coordenadas de otro objeto Coordenada
    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    // Métodos para establecer y obtener las coordenadas
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    // Método para calcular la distancia entre dos coordenadas
    public double distancia(Coordenada c) {
        double dx = this.x - c.x;
        double dy = this.y - c.y;
        return Math.sqrt(dx * dx + dy * dy); // Usamos el teorema de Pitágoras
    }

    // Método estático para calcular la distancia entre dos coordenadas
    public static double distancia(Coordenada c1, Coordenada c2) {
        double dx = c1.x - c2.x;
        double dy = c1.y - c2.y;
        return Math.sqrt(dx * dx + dy * dy); // Usamos el teorema de Pitágoras
    }

    // Método para representar la coordenada como una cadena
    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
}

// Clase para representar un rectángulo en el plano cartesiano
class Rectangulo {

    double x1, y1, x2, y2; // Coordenadas de las esquinas del rectángulo

    // Constructor que recibe dos objetos Coordenada para las esquinas
    public Rectangulo(Coordenada esquina1, Coordenada esquina2) {
        // Asignamos las coordenadas mínimas y máximas para garantizar un rectángulo válido
        x1 = Math.min(esquina1.getX(), esquina2.getX());
        y1 = Math.min(esquina1.getY(), esquina2.getY());
        x2 = Math.max(esquina1.getX(), esquina2.getX());
        y2 = Math.max(esquina1.getY(), esquina2.getY());
    }

    // Método para calcular el área del rectángulo
    public double calculoArea() {
        return Math.abs((x2 - x1) * (y2 - y1)); // Área = base * altura
    }

    // Método para representar el rectángulo como una cadena
    @Override
    public String toString() {
        return "[" + y1 + ", " + x1 + "], [" + y2 + ", " + x2 + "]";
    }
}

// Clase para verificar las relaciones entre rectángulos
class Verificador {

    // Método para verificar si dos rectángulos se superponen
    public static boolean seSuperponen(Rectangulo rectA, Rectangulo rectB) {
        // Verificamos si hay intersección en los ejes X y Y
        return rectA.x1 < rectB.x2 && rectA.x2 > rectB.x1 && rectA.y1 < rectB.y2 && rectA.y2 > rectB.y1;
    }

    // Método para verificar si dos rectángulos están juntos (sin superponerse)
    public static boolean estanJuntos(Rectangulo rectA, Rectangulo rectB) {
        // Verificamos si comparten un lado sin superponerse
        if (rectA.x1 == rectB.x2 && rectA.y1 < rectB.y2 && rectA.y2 > rectB.y1) {
            return true;
        }
        if (rectA.x2 == rectB.x1 && rectA.y1 < rectB.y2 && rectA.y2 > rectB.y1) {
            return true;
        }
        if (rectA.y1 == rectB.y2 && rectA.x1 < rectB.x2 && rectA.x2 > rectB.x1) {
            return true;
        }
        if (rectA.y2 == rectB.y1 && rectA.x1 < rectB.x2 && rectA.x2 > rectB.x1) {
            return true;
        }
        return false; // No están juntos
    }

    // Método para verificar si dos rectángulos son disjuntos (no se superponen ni están juntos)
    public static boolean sonDisjuntos(Rectangulo rectA, Rectangulo rectB) {
        return !seSuperponen(rectA, rectB) && !estanJuntos(rectA, rectB);
    }
}
