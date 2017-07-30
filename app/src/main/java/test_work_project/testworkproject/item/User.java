package test_work_project.testworkproject.item;


public class User {
    private String name;
    private String message;
    private String messageTime;
    private int waitingMessage;
    private int position;

    public User(String name, String message, String messageTime, int waitingMessage, int position) {
        this.name = name;
        this.message = message;
        this.messageTime = messageTime;
        this.waitingMessage = waitingMessage;
        this.position = position;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public int getWaitingMessage() {
        return waitingMessage;
    }

    public void setWaitingMessage(int waitingMessage) {
        this.waitingMessage = waitingMessage;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
