public interface Norm {
    double calculateNorm();
    double calculateModule();
}
public class Complex implements Norm {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public double calculateNorm() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    @Override
    public double calculateModule() {
        return calculateNorm();
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}
public class Vector3D implements Norm {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double calculateNorm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double calculateModule() {
        return calculateNorm();
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
public class Main {
    public static void main(String[] args) {
        Complex complexNumber = new Complex(3, 4);
        System.out.println("Complex Number: " + complexNumber);
        System.out.println("Norm: " + complexNumber.calculateNorm());
        System.out.println("Module: " + complexNumber.calculateModule());

        Vector3D vector = new Vector3D(1, 2, 2);
        System.out.println("Vector: " + vector);
        System.out.println("Norm: " + vector.calculateNorm());
        System.out.println("Module: " + vector.calculateModule());
    }
}
