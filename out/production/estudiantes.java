import java.util.Scanner;

public class estudiantes {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Registro de estudiante");
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine().trim();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(entrada.nextLine().trim());

        System.out.println("Ingresa las tres notas del estudiante:");
        System.out.print("Nota 1: ");
        double nota1 = Double.parseDouble(entrada.nextLine().trim());
        System.out.print("Nota 2: ");
        double nota2 = Double.parseDouble(entrada.nextLine().trim());
        System.out.print("Nota 3: ");
        double nota3 = Double.parseDouble(entrada.nextLine().trim());

        Estudiante estudiante = new Estudiante(nombre, edad, nota1, nota2, nota3);
        estudiante.calcularPromedio();

        System.out.println();
        System.out.println("--- Resultado ---");
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Edad: " + estudiante.getEdad());
        System.out.printf("Promedio: %.2f%n", estudiante.getPromedio());

        if (estudiante.estaEnRiesgoAcademico()) {
            System.out.println("El estudiante está en riesgo académico.");
        } else {
            System.out.println("El estudiante no está en riesgo académico.");
        }

        entrada.close();
    }
}

class Estudiante {
    private String nombre;
    private int edad;
    private double promedio;
    private double nota1;
    private double nota2;
    private double nota3;

    public Estudiante(String nombre, int edad, double nota1, double nota2, double nota3) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public void calcularPromedio() {
        this.promedio = (nota1 + nota2 + nota3) / 3.0;
    }

    public boolean estaEnRiesgoAcademico() {
        return promedio < 3.0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPromedio() {
        return promedio;
    }
}

