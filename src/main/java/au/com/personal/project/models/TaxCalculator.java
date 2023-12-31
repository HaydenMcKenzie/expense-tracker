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

    double fourtyThousandIncome;
    double fourtyThousandTax;
    double hundredTwentyThousandIncome;
    double hundredTwentyThousandTax;
    double hundredEightyThousandIncome;
    double hundredEightyThousandTax;
    double overHundredEightyThousandIncome;
    double overHundredEightyThousandTax;

    public String calculateTax(String userInput) {

        if (isStringDouble(userInput)) {

            double income = Double.parseDouble(userInput);
            double paidTaxAlreadyFirst = 5092;
            double paidTaxAlreadySecond = (5092 + 24375);
            double paidTaxAlreadyThird = (5092 + 24375 + 22200);
            double incomeTax45 = ((income - 18201) * 0.19);
            double incomeTax120 = ((income - 45001) * 0.325);
            double incomeTax180 = ((income - 120000) * 0.37);
            double incomeTaxOver180 = ((income - 180000) * 0.45);
            double medicareIvey = (income * 0.02);

            if (income < 18200) {
                return String.valueOf(income);
            } else if (income < 45000) {
                fourtyThousandIncome = income - incomeTax45 - medicareIvey;
                fourtyThousandTax = income - fourtyThousandIncome;
                String taxed = String.format("%.3f", fourtyThousandTax);

                return "Your tax is " + taxed + ". Your income is: " + fourtyThousandIncome;

            } else if (income < 120000) {
                hundredTwentyThousandIncome = income - paidTaxAlreadyFirst - incomeTax120 - medicareIvey;
                hundredTwentyThousandTax = income - hundredTwentyThousandIncome;
                String taxed = String.format("%.3f", hundredTwentyThousandTax);

                return "Your tax is " + taxed + ". Your income is: " + hundredTwentyThousandIncome;

            } else if (income < 180000) {
                hundredEightyThousandIncome = income - paidTaxAlreadySecond - incomeTax180 - medicareIvey;
                hundredEightyThousandTax = income - hundredEightyThousandIncome;
                String taxed = String.format("%.3f", hundredEightyThousandTax);

                return "Your tax is " + taxed + ". Your income is: " + hundredEightyThousandIncome;

            } else {
                overHundredEightyThousandIncome = income - paidTaxAlreadyThird - incomeTaxOver180 - medicareIvey;
                overHundredEightyThousandTax = income - overHundredEightyThousandIncome;
                String taxed = String.format("%.3f", overHundredEightyThousandTax);

                return "Your tax is " + taxed + ". Your income is: " + overHundredEightyThousandIncome;
            }
        } else {
            return "Not a number";
        }
    }

    public boolean isStringDouble(String income) {
        try {
            Double.parseDouble(income);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
