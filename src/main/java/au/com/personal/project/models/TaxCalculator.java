package au.com.personal.project.models;

public class TaxCalculator {

    /**
     * AU Income brackets
     * 0-18200       - 0%
     * 18201-45000   - 19c per dollar
     * 45001-120000  - $5,092 plus 32.5c per dollar
     * 120001-180000 - $29,467 plus 37c
     * 180001+       - $51,667 plus 45c
     */

    double hundredTwentyThousandIncome;
    double hundredTwentyThousandTax;
    double hundredEightyThousandIncome;
    double hundredEightyThousandTax;
    double overHundredEightyThousandIncome;
    double overHundredEightyThousandTax;

    public String calculateTax(double income) {

        double paidTaxAlreadyFirst = 5092;
        double paidTaxAlreadySecond = (5092 + 24375);
        double paidTaxAlreadyThird = (5092 + 24375 + 22200);
        double incomeTax120 = ((income-45001)*0.325);
        double incomeTax180 = ((income-120000)*0.37);
        double incomeTaxOver180 = ((income-180000)*0.45);
        double medicareIvey = (income*0.02);


        if (income < 18200) {
            System.out.println(income);
        } else if (income < 45000) {
            double firstTax = income - 18200;
            double taxed = firstTax * 0.19;
            double remainder = firstTax * 0.81;
            return "Your tax is " + taxed + ". Your income is: " + (18200 + remainder);

        } else if (income < 120000) {
            hundredTwentyThousandIncome = income - paidTaxAlreadyFirst - incomeTax120 - medicareIvey;
            hundredTwentyThousandTax = income - hundredTwentyThousandIncome;
            String taxed = String.format("%.3f",hundredTwentyThousandTax);

            return "Your tax is " + taxed + ". Your income is: " + hundredTwentyThousandIncome;

        } else if (income < 180000) {
            hundredEightyThousandIncome = income - paidTaxAlreadySecond - incomeTax180 - medicareIvey;
            hundredEightyThousandTax = income - hundredEightyThousandIncome;
            String taxed = String.format("%.3f",hundredEightyThousandTax);

            return "Your tax is " + taxed + ". Your income is: " + hundredEightyThousandIncome;

        } else {
            overHundredEightyThousandIncome = income - paidTaxAlreadyThird - incomeTaxOver180 - medicareIvey;
            overHundredEightyThousandTax = income - overHundredEightyThousandIncome;
            String taxed = String.format("%.3f",overHundredEightyThousandTax);

            return "Your tax is " + taxed + ". Your income is: " + overHundredEightyThousandIncome;
        }
        return null;
    }
}
