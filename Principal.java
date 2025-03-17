
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContainerRect container = new ContainerRect(5);

        for (int i = 0; i < 3; i++) {
            Rectangulo rect = crearRectangulo(scanner, (i + 1) + "°");
            container.addRectangulo(rect);
        }
        System.out.println(container);
        scanner.close();
    }

    private static Rectangulo crearRectangulo(Scanner scanner, String num) {
        System.out.println("Ingrese una esquina del " + num + " rectángulo (x y):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.println("Ingrese la esquina opuesta del " + num + " rectángulo (x y):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        return new Rectangulo(new Coordenada(Math.min(x1, x2), Math.min(y1, y2)),
                new Coordenada(Math.max(x1, x2), Math.max(y2, y1)));
    }
}