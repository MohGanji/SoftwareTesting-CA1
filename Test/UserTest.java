

//withdrawMoney_ThrowsException_IfAccountIsInvalid
//MethodName_ExpectedBehavior_StateUnderTest

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserTest {

    private User u1;
    private User u2;
    private User u3;
    private User u4;

    @Before
    public void initilize(){
        u1 = new User("gholi", "gholizadeh");
        u2 = new User("saeed", "saeedi");
        u3 = new User("gholam", "gholami");
        u4 = new User("forever", "alone");
        u1.addFriend(u2);
        u2.addFriend(u1);
        u3.addFriend(u1);
    }

    @Test
    public void addFriend_u1Addsu4AsFriend(){
        u1.addFriend(u4);
        assertTrue("u1 should now be friends with u4", u1.isFriendsWith(u4));
    }

    @Test
    public void isFriendsWith_u1IsFriendsWithu2(){
        assertTrue("u1 should be friends with u2", u1.isFriendsWith(u2));
    }

    @Test
    public void removeFriends_u3isNoLongerFriendsWithu1(){
        u3.removeFriend(u1);
        assertFalse("u3 should not be friends with u1 anymore", u3.isFriendsWith(u1));
    }

    @Test
    public void isFriendsWith_mutualFriendship(){
        assertTrue(u3.isFriendsWith(u1));
        assertFalse(u1.isFriendsWith(u3));
    }

    @Test
    public void addFriend_happyScenario_addSomeFriends() {
        User user = new User("ali", "alizadeh");
        User user2 = new User("gholi", "gholizadeh");
        User user3 = new User("gholam", "gholizadeh");
        user.addFriend(user2);
        user.addFriend(user3);
        assertTrue("ali is friends with gholi", user.isFriendsWith(user2));
        assertTrue("ali is friends with gholam", user.isFriendsWith(user3));
        assertFalse("but gholi is not friends with ali", user2.isFriendsWith(user));
    }

    @Test
    public void removeFriend_happyScenario_removeSomeOldFriends() {
        User user = new User("ali", "alizadeh");
        User user2 = new User("gholi", "gholizadeh");
        User user3 = new User("gholam", "gholizadeh");
        user.addFriend(user2);
        user.addFriend(user3);
        user.removeFriend(user2);
        user.removeFriend(user3);
        assertFalse("ali is no longer friends with gholi", user.isFriendsWith(user2));
        assertFalse("ali is no longer friends with gholam", user.isFriendsWith(user3));
    }

    @Test
    public void addFriend_NotFriends_IfAddFriendTwiceAndRemove(){
        u1.addFriend(u4);
        u1.addFriend(u4);
        u1.removeFriend(u2);
        assertFalse("gholi should not be a friend of forever anymore", u1.isFriendsWith(u4));
    }

    @Test
    public void addFriend_MutualFriendship_ThereIsNoMutualFriendship(){
        User user1 = new User("gholam", "gholami");
        User user2 = new User("saeed", "saeedi");
        user1.addFriend(user2);
        assertFalse("gholam should not be a friend of saeed!", user2.isFriendsWith(user1));
    }

    @Test
    public void removeFriend_MutualFriendship_RemoveFriendship(){
        User user1 = new User("gholam", "gholami");
        User user2 = new User("saeed", "saeedi");
        user1.addFriend(user2);
        user2.addFriend(user1);
        user1.removeFriend(user2);
        assertTrue("gholam should not be a friend of saeed!", user2.isFriendsWith(user1));
    }

    @Test
    public void addFriend_NotFriends_CheckFriendshipWithHimself() {
        assertFalse("gholi should not be a friend of himself!", u1.isFriendsWith(u1));
    }

    @Test
    public void addFriend_NotFriends_TwoPeopleWithSameName(){
        User user2 = new User("saeed", "saeedi");
        User user3 = new User("saeed", "saeedi");
        u1.addFriend(user2);
        u1.addFriend(user3);
        u1.removeFriend(user3);
        assertTrue("user2 should be a friend of gholi", u1.isFriendsWith(user2));
    }

    @Test(expected = NullPointerException.class)
    public void Constructor_Exception_NullName(){
        new User(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Constructor_IllegalArgumentException_EmptyName(){
        new User("", "gholami");
    }


    @Test(expected = NoSuchElementException.class)
    public void removeFriend_notFriendsException(){
        u4.removeFriend(u2);
    }



}
