

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.*;
import java.util.Arrays;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class isEmailValidTest {
    private String email;
    private boolean expected;

    public isEmailValidTest(String email, boolean expected) {
        this.email = email;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: isEmailValid({0})={1}")
    public static Iterable<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                        {"mohammad@test.ut.ac.ir", true},
                        {"mohammad.ganji@test.ut.ac.ir", true},
                        {"mohganji_1234@test.ut.ac.ir", true},
                        {"mohammad@testdotutdotacdotir", false},
                        {"mohammad_ganji@test", false},
                        {"test.ut.ac.ir", false},
                        {"mohammad_ganji@", false},
                        {"mohammad@ganji@test.ut.ac.ir", false},
                        {"mohammad@test.com", true},
                        {"mohammad@someothertest.com", true},
                        {"mohammad", false}
                }
        );
    }

    @Test
    public void isEmailValid_ThrowsException_ifEmailIsInvalid() throws Exception {
        boolean actualValue = User.isEmailValid(email);
        assertThat(actualValue, is(equalTo(expected)));
    }
}
