package au.com.personal.project;

import au.com.personal.project.models.TaxCalculator;

import java.util.Objects;
import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        TaxCalculator tc = new TaxCalculator();

        String income;

        while (true) {
            System.out.println("Enter:");
            income = sc.nextLine();

            if (Objects.equals(income, "q")) {
                break;
            }

            String result = tc.calculateTax(income);

            System.out.println(result);
        }
    }
}
