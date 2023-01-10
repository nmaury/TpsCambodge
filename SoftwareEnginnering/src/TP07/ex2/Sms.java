package TP07.ex2;

public class Sms {
    int id;
    String subject;
    String senderNumber;
    String receiverNumber;
    Type type;
    String content;
    Status status;
    static int smsNumber =0;
    public Sms(String subject, String senderNumber, String receiverNumber, Type type, String content) {
        this.subject = subject;
        this.senderNumber = senderNumber;
        this.receiverNumber = receiverNumber;
        this.type = type;
        this.content = content;
        this.status = Status.NEW;
        this.id=++smsNumber;
    }

    public Sms(String content, String title) {
        this.senderNumber = "not set";
        this.receiverNumber = "not set";
        this.status = Status.NEW;
        this.content = content;
        this.type = Type.TEXT;
        this.subject = title;
        this.id=++smsNumber;
    }

    public Sms(String content) {
        this.status = Status.NEW;
        this.content = content;
        this.type = Type.TEXT;
        this.subject = "new message";
        this.senderNumber = "not set";
        this.receiverNumber = "not set";
        this.id=++smsNumber;
    }
public void setAsRead(){
        this.status = Status.READ;
}

    @Override
    public String toString() {
        return this.id+": \n from: "+this.senderNumber+
                "\n to: "+this.receiverNumber+
                "\n subject: "+this.subject+
                "\n type: "+this.type+
                "\n status: "+this.status+
                "\n content: "+this.content;
    }
    public String toStringDecrypt() {
        return this.id+": \n from: "+this.senderNumber+
                "\n to: "+this.receiverNumber+
                "\n subject: "+this.subject+
                "\n type: "+this.type+
                "\n status: "+this.status+
                "\n content: "+AES.decrypt(this.content)+"\n";
    }
    public int getId() {
        return id;
    }
    public String getMessage(){
        return content;
    }
    public boolean isReadable(){
        return this.status.equals(Status.NEW);
    }
}

enum Status{
    NEW,READ
}
