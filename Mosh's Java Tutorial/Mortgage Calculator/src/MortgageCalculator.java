import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal ($1k - $1M): ");
        float principal = scanner.nextFloat();
        while (!(principal >= 1000) || !(principal <= 1_000_000)) {
            System.out.println("Enter a value between $1,000 and $1,000,000.");
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextFloat();
        }


        scanner.nextLine();

        System.out.print("Monthly Interest Rate: ");
        float r = scanner.nextFloat() ;
        while (!(r > 0) || !(r <= 30)) {
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
            System.out.print("Monthly Interest Rate: ");
            r = scanner.nextFloat();
        }

        r = r / 100 / 12;
        scanner.nextLine();

        System.out.print("Period (years): ");
        float n = scanner.nextFloat();
        while (!(n >= 1) || !(n <= 30)){
            System.out.println("Enter a value between 1 and 30.");
            System.out.print("Period (years): ");
            n = scanner.nextFloat();

        }


        n = n * 12;


        float numerator = (float) (r * Math.pow((1 + r), n));
        float denominator = (float) ((Math.pow((1 + r), n)) - 1 );
        float monthlyPayment = principal * (numerator / denominator);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("Mortgage: " + mortgageFormatted);


    }
}
