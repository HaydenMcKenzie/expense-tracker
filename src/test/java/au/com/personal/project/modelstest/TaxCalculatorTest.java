package au.com.personal.project.modelstest;

import au.com.personal.project.models.TaxCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxCalculatorTest {
    TaxCalculator tc;
    String firstIncome;
    String secondIncome;
    String thirdIncome;
    String fourthIncome;
    String fifthIncome;


    @BeforeEach
    public void setup() {
        tc = new TaxCalculator();
        firstIncome = "16000";
        secondIncome = "32000";
        thirdIncome = "64000";
        fourthIncome = "128000";
        fifthIncome = "256000";
    }

    @Test
    public void testFirstTaxCalculator() {
        String result = tc.calculateTax(firstIncome);
        assertEquals(result, "16000.0");
    }
    @Test
    public void testSecondTaxCalculator() {
        String result = tc.calculateTax(secondIncome);
        assertEquals(result, "Your tax is 3261.810. Your income is: 28738.19");
    }
    @Test
    public void testThirdTaxCalculator() {
        String result = tc.calculateTax(thirdIncome);
        assertEquals(result, "Your tax is 12546.675. Your income is: 51453.325");
    }
    @Test
    public void testFourthTaxCalculator() {
        String result = tc.calculateTax(fourthIncome);
        assertEquals(result, "Your tax is 34987.000. Your income is: 93013.0");
    }
    @Test
    public void testFifthTaxCalculator() {
        String result = tc.calculateTax(fifthIncome);
        assertEquals(result, "Your tax is 90987.000. Your income is: 165013.0");
    }
}