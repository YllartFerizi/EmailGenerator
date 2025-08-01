package org.ylliferizi;

import org.ylliferizi.email.Email;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class EmailReader {
    private final String basePath = System.getProperty("user.dir");
    private String path;
    private List<Email> listOfEmails;

    public List<Email> getListOfEmails() {
        return listOfEmails;
    }

    public EmailReader(String path) throws FileNotFoundException {
        this.path = path;
        this.listOfEmails = generateEmails();

    }

    private List<Email> generateEmails() throws FileNotFoundException {
        List<String> emailList = readEmails();
        List<Email> listOfEmails= new ArrayList<>();
        emailList.forEach(s -> {
            String[] nameAndSurname = s.split(",");
            if (nameAndSurname.length>=2){
                listOfEmails.add(new Email(nameAndSurname[0],nameAndSurname[1]));
            }
        });
        return listOfEmails;
    }




    private List<String> readEmails() throws FileNotFoundException {
        List<String> emailList = new ArrayList<>();
        try{
            File file = new File(this.basePath + File.separator + this.path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                emailList.add(scanner.nextLine());
            }
            scanner.close();

        }catch (FileNotFoundException f){
            System.out.println("File not found ");
        }
        return emailList;
    }
}
