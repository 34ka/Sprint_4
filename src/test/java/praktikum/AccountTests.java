package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountTests {
    private String name;
    private boolean expectedBoolean;

    public AccountTests(String name, boolean expectedBoolean) {
        this.name = name;
        this.expectedBoolean = expectedBoolean;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                //2 символа
                {"ef", false},
                //3 символа с пробелом в середине
                {"1 4", true},
                //4 символа с пробелом в середине
                {"fh r", true},
                //18 символ с пробелом в середине
                {"fhgtghrtg flqergtb", true},
                //19 символ с пробелом в середине
                {"fhgtghrt rhklqergtb", true},
                // 20 символ с пробелом в середине
                {"fhgtg hrtghklqergtbd", false},
                // пробел в начале
                {" fhgtg", false},
                // пробел в конце
                {"fhgtg ", false},
                // 2 пробела в середине
                {"fh gf tg", false},
                //без пробела
                {"fhgtg", false},
        };
    }

    @Test
    public void accountValidationTest(){
        Account account = new Account(name);
        boolean actualBoolean = account.checkNameToEmboss();

        assertEquals(actualBoolean, expectedBoolean);
    }
}
