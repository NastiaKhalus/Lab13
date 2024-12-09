package ua.edu.ucu.apps.task1;

public class MessageSender {

    public void send(User user, String text){
        System.out.println("Sent message to: " + user);
        System.out.println("Message content: " + text);
    }
    
}
