import ua.edu.ucu.apps.task1.FacebookUser;
import ua.edu.ucu.apps.task1.FacebookUserAdapter;
import ua.edu.ucu.apps.task1.TwitterUser;
import ua.edu.ucu.apps.task1.TwitterUserAdapter;
import ua.edu.ucu.apps.task1.MessageSender;
import ua.edu.ucu.apps.task1.User;
import ua.edu.ucu.apps.task1.AuthMethod;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class Task1Tests {

    @Test
    public void testFacebookUserAdapter() {
        FacebookUser facebookUser = new FacebookUser(
                "test_facebook_email",
                "Ukraine",
                LocalDateTime.now().toString()
        );
        FacebookUserAdapter adapter = new FacebookUserAdapter(facebookUser);

        assertEquals("test_facebook_email", adapter.getMail());
        assertEquals("Ukraine", adapter.getCountry());
        assertNotNull(adapter.getActiveTime());
    }

    @Test
    public void testTwitterUserAdapter() {
        TwitterUser twitterUser = new TwitterUser(
                "test_twitter_email",
                "USA",
                LocalDateTime.now().minusDays(1).toString()
        );
        TwitterUserAdapter adapter = new TwitterUserAdapter(twitterUser);

        assertEquals("test_twitter_email", adapter.getMail());
        assertEquals("USA", adapter.getCountry());
        assertNotNull(adapter.getActiveTime());
    }

    @Test
    public void testMessageSenderWithFacebookUser() {
        FacebookUser facebookUser = new FacebookUser(
                "facebook_email",
                "Ukraine",
                LocalDateTime.now().toString()
        );
        User user = new FacebookUserAdapter(facebookUser);

        MessageSender sender = new MessageSender();
        sender.send(user, "Hello Facebook!");

        assertEquals("facebook_email", user.getMail());
        assertEquals("Ukraine", user.getCountry());
    }

    @Test
    public void testMessageSenderWithTwitterUser() {
        TwitterUser twitterUser = new TwitterUser(
                "twitter_email",
                "USA",
                LocalDateTime.now().minusDays(1).toString()
        );
        User user = new TwitterUserAdapter(twitterUser);

        MessageSender sender = new MessageSender();
        sender.send(user, "Hello Twitter!");

        assertEquals("twitter_email", user.getMail());
        assertEquals("USA", user.getCountry());
    }

    @Test
    public void testAuthMethod() {
        AuthMethod method = AuthMethod.FACEBOOK;
        assertEquals(AuthMethod.FACEBOOK, method);

        method = AuthMethod.TWITTER;
        assertEquals(AuthMethod.TWITTER, method);
    }

    @Test
    public void testMain() {
        AuthMethod authMethod = AuthMethod.FACEBOOK;

        User user = null;
        switch (authMethod) {
            case FACEBOOK:
                FacebookUser facebookUser = new FacebookUser(
                        "facebook_email",
                        "Ukraine",
                        LocalDateTime.now().toString()
                );
                user = new FacebookUserAdapter(facebookUser);
                break;
            case TWITTER:
                TwitterUser twitterUser = new TwitterUser(
                        "twitter_email",
                        "USA",
                        LocalDateTime.now().minusDays(1).toString()
                );
                user = new TwitterUserAdapter(twitterUser);
                break;
        }

        assertNotNull(user);
        assertEquals("facebook_email", user.getMail());
        assertEquals("Ukraine", user.getCountry());
    }
}

