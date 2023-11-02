package au.com.personal.project;



import au.com.personal.project.models.TaxCalculator;

import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        TaxCalculator tc = new TaxCalculator();

        System.out.println("Enter:");
        double income = Double.parseDouble(sc.nextLine());
        String result = tc.calculateTax(income);

        System.out.println(result);
    }
}
