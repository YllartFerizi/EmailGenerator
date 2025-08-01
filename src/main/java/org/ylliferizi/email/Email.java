package org.ylliferizi.email;

import org.ylliferizi.password.PasswordUtil;

public class Email {
    private String firstName;
    private String lastName;
    private EMAILTYPE emailType = EMAILTYPE.STUDENT;
    private String email;
    private String password;
    private String schoolName = "ibcmitrovica";

    public Email(String firstName , String lastName , EMAILTYPE emailType){
        this(firstName,lastName);
        this.emailType = emailType;
        this.email = generateEmail();
    }
    public Email(String firstName , String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = generateEmail();
        this.password = PasswordUtil.generateRandomPassword(10);
    }

    private String generateEmail(){
        String email = null;
        switch (emailType){
            case STUDENT -> email = String.format("%s.%s@%s.eu",
                    firstName.toLowerCase(), lastName.toLowerCase(), schoolName);
            case ADMINISTRATE -> email = String.format("%s.%s@%s.eu",
                    firstName.toLowerCase().charAt(0), lastName.toLowerCase(), schoolName);
        }
        return  email;
    }
    public String getEmail(){ return this.email; }
    public String printEmail(){
        return "Email: " + this.email+ "\n"+
        "Password: " + this.password + "\n";
    }
}
