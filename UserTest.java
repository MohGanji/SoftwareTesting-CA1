import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class UserTest {
    @Test
    public void evaluatesExpression() {
        User user = new User("foo", "bar");
        User user2 = new User("spa", "zzz");
        user.addFriend(user2);
        assertEquals(true, user.isFriendsWith(user2));
    }
}
