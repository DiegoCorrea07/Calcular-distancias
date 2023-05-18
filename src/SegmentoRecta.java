import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.DecimalFormat;

class SegmentoRecta {
    private List<Punto> puntos;
    private double distanciaMaxima;
    private double distanciaMinima;
    private Punto puntoInicialLargo;
    private Punto puntoFinalLargo;
    private Punto puntoInicialCorto;
    private Punto puntoFinalCorto;
    private DecimalFormat decimalFormat;

    public SegmentoRecta() {
        puntos = new ArrayList<>();
        distanciaMaxima = 0;
        distanciaMinima = Double.MAX_VALUE;
        puntoInicialLargo = null;
        puntoFinalLargo = null;
        puntoInicialCorto = null;
        puntoFinalCorto = null;
        decimalFormat = new DecimalFormat("#.##");
    }

    public void ingresarPuntos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("****Bienvenido al calculo del semegto de recta mayor y menor de n puntos****\n");
        System.out.print("Ingrese la cantidad de puntos: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Ingrese la coordenada x del punto " + i + ": ");
            double x = scanner.nextDouble();
            System.out.print("Ingrese la coordenada y del punto " + i + ": ");
            double y = scanner.nextDouble();
            puntos.add(new Punto(x, y));
        }
    }

    public void encontrarSegmentos() {
        for (int i = 0; i < puntos.size() - 1; i++) {
            Punto p1 = puntos.get(i);

            for (int j = i + 1; j < puntos.size(); j++) {
                Punto p2 = puntos.get(j);

                double distancia = calcularDistancia(p1, p2);

                if (distancia > distanciaMaxima) {
                    distanciaMaxima = distancia;
                    puntoInicialLargo = p1;
                    puntoFinalLargo = p2;
                }

                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    puntoInicialCorto = p1;
                    puntoFinalCorto = p2;
                }
            }
        }
    }

    public void mostrarSegmentoLargo() {
        System.out.println("El segmento de recta más largo es entre los puntos (" + puntoInicialLargo.getX() + ", " +
                puntoInicialLargo.getY() + ") y (" + puntoFinalLargo.getX() + ", " + puntoFinalLargo.getY() + ")");
        System.out.println("La distancia del segmento más largo es: " + decimalFormat.format(distanciaMaxima));
    }

    public void mostrarSegmentoCorto() {
        System.out.println("El segmento de recta más corto es entre los puntos (" + puntoInicialCorto.getX() + ", " +
                puntoInicialCorto.getY() + ") y (" + puntoFinalCorto.getX() + ", " + puntoFinalCorto.getY() + ")");
        System.out.println("La distancia del segmento más corto es: " + decimalFormat.format(distanciaMinima));
    }

    private double calcularDistancia(Punto p1, Punto p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}


