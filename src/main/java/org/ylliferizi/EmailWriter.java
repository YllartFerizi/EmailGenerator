package org.ylliferizi;

import org.ylliferizi.email.Email;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class EmailWriter {
    public static void writeToTxt(List<Email> emailList){
        Date date = new Date();
        String filename = "emailOutPut" +
                date.toString();
        try{
            FileWriter fileWriter = new FileWriter(filename);
            emailList.forEach(f-> {
                try{
                    fileWriter.write(f.printEmail());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            fileWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
