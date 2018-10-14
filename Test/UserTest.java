

//withdrawMoney_ThrowsException_IfAccountIsInvalid
//MethodName_ExpectedBehavior_StateUnderTest

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserTest {
    @Test
    public void addFriend_NotFriends_IfAddFriendTwoTimesAndRemove(){
        User user1 = new User("gholam", "gholami");
        User user2 = new User("saeed", "saeedi");
        user1.addFriend(user2);
        user1.addFriend(user2);
        user1.removeFriend(user2);
        assertFalse("saeed should not be a friend of gholam!", user1.isFriendsWith(user2));
    }

    @Test
    public void addFriend_MutualFriendship_CheckMutualFriendship(){
        User user1 = new User("gholam", "gholami");
        User user2 = new User("saeed", "saeedi");
        user1.addFriend(user2);
        assertTrue("gholam should be a friend of saeed!", user2.isFriendsWith(user1));
    }

    @Test
    public void addFriend_NotFriends_CheckFriendshipWithHimself() {
        User user1 = new User("gholam", "gholami");
        user1.addFriend(user1);
        user1.removeFriend(user1);
        assertFalse("gholam should not be a friend of gholam!", user1.isFriendsWith(user1));
    }

    @Test
    public void addFriend_NotFriends_TwoPeopleWithSameName(){
        User user1 = new User("gholam", "gholami");
        User user2 = new User("saeed", "saeedi");
        User user3 = new User("saeed", "saeedi");
        user1.addFriend(user2);
        user1.addFriend(user3);
        user1.removeFriend(user3);
        assertTrue("user2 should be a friend of gholam", user1.isFriendsWith(user2));
    }

    @Test(expected = NullPointerException.class)
    public void Constructor_Exception_NullName(){
        new User(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidEmail_IllegalArgumentException_EmptyName(){
        new User("", "gholami");
    }
}
