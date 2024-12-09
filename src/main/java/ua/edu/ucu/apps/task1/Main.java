package ua.edu.ucu.apps.task1;

import java.time.LocalDateTime;

public class Main {
    public static void main (String[] args){
        AuthMethod authMethod = AuthMethod.FACEBOOK;
        User user = null;
        switch (authMethod){
            case FACEBOOK:
                FacebookUser facebookUser = new FacebookUser(
                    "facebook_email", 
                    "Ukraine", 
                    LocalDateTime.now().toString());

                user = new FacebookUserAdapter(facebookUser);
                break;


            case TWITTER:
            TwitterUser twitterUser = new TwitterUser(
                "twitter_email",
                "USA", 
                LocalDateTime.now().minusDays(1).toString());

            user = new TwitterUserAdapter(twitterUser);
            break;

            default:
                break;
        }

        MessageSender messageSender = new MessageSender();
        messageSender.send(user,"Hello!");
    }
    
}
