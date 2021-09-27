import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        float principal = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Monthly Interest Rate: ");
        float r = scanner.nextFloat() / 100 / 12;
        scanner.nextLine();
        System.out.print("Period (years): ");
        float n = scanner.nextFloat() * 12;

        float numerator = (float) (r * Math.pow((1 + r), n));
        float denomenator = (float) ((Math.pow((1 + r), n)) - 1 );
        float monthlyPayment = principal * (numerator / denomenator);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("Mortgage: " + mortgageFormatted);


    }
}
