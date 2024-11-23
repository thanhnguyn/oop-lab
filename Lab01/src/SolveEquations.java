import java.util.Scanner;

public class SolveEquations {

    public static void solveLinearEquation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a * x + b = 0");
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinite solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution to the equation is: x = " + x);
        }
    }

    public static void solveLinearEquationSystem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a1 * x + b1 * y = c1" +
                "\na2 * x + b2 * y2 = c2");
        System.out.print("Enter coefficient a1: ");
        double a1 = scanner.nextDouble();

        System.out.print("Enter coefficient b1: ");
        double b1 = scanner.nextDouble();

        System.out.print("Enter constant c1: ");
        double c1 = scanner.nextDouble();

        System.out.print("Enter coefficient a2: ");
        double a2 = scanner.nextDouble();

        System.out.print("Enter coefficient b2: ");
        double b2 = scanner.nextDouble();

        System.out.print("Enter constant c2: ");
        double c2 = scanner.nextDouble();

        double D = a1 * b2 - a2 * b1;
        double Dx = c1 * b2 - c2 * b1;
        double Dy = a1 * c2 - a2 * c1;

        if (D != 0) {
            double x = Dx / D;
            double y = Dy / D;
            System.out.println("The system has a unique solution:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        } else {
            if (Dx == 0 && Dy == 0) {
                System.out.println("The system has infinite solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        }
    }

    public static void solveQuadraticEquation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a * x ^ 2 + b * x + c = 0");
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("This is not a quadratic equation.");
            return;
        }

        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("The equation has two distinct roots:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("The equation has one double root:");
            System.out.println("x = " + x);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }


    public static void main(String[] args) {
        double i;
        do {
            System.out.println("\nChoose the type of equation you want to solve:" +
                    "\n1: The first-degree equation (linear equation) with one variable" +
                    "\n2: The system of first-degree equations (linear system) with two variables" +
                    "\n3: The second-degree equation with one variable" +
                    "\n0: Exit the program");
            Scanner scanner = new Scanner(System.in);
            i = scanner.nextDouble();
            if (i==1) {
                solveLinearEquation();
            }
            if (i==2) {
                solveLinearEquationSystem();
            }
            if (i==3) {
                solveQuadraticEquation();
            }
        }
        while (i != 0);
    }
}
