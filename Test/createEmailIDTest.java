import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeNotNull;

@RunWith(Theories.class)
public class createEmailIDTest {
    @DataPoints
    public static String[] names(){
        return new String[]{
                "ali", "gholi", "saeed", "123", "!@#$%^&*()_+", null
        };
    }

    @Theory
    public void testCreateEmailID(String firstPart, String secondPart) throws Exception{
        System.out.println(String.format("Testing with %s and %s", firstPart, secondPart));
        assumeNotNull(firstPart, secondPart);
        String email = User.createEmailID(firstPart,secondPart);
        System.out.println(String.format("Created Email: %s \n", email));
        assertThat(email, (allOf(containsString(firstPart.substring(0, 1)), containsString(secondPart))));
    }
}
