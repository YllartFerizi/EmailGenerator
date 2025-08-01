package org.ylliferizi;
import org.ylliferizi.email.Email;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String filename = args[0];
        if(!filename.isEmpty()){
            EmailReader emailReader = new EmailReader(filename);
            for (Email listOfEmail : emailReader.getListOfEmails()) {
                listOfEmail.printEmail();
            }
            EmailWriter.writeToTxt(emailReader.getListOfEmails());
        }

    }
}