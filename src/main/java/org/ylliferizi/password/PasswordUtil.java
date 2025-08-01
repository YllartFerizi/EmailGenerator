package org.ylliferizi.password;

import java.util.*;
import java.util.regex.Pattern;

public class PasswordUtil {
    public static String generateRandomPassword(int passwordLength){
        StringBuilder password = new StringBuilder();
        List<Character> arrOfCharacters = createArrCharacters();
        Random random = new Random();
        boolean validPass = false;
        while (!validPass){
            //clear if password is not empty
            if(!password.isEmpty()){
                password = new StringBuilder();
            }


            for(int i = 0; i<passwordLength;i++){
                int randIndex = random.nextInt(0 , arrOfCharacters.size() - 1);
                password.append(String.valueOf(arrOfCharacters.get(randIndex)));
            }
            validPass = isPasswordValid(password.toString());

        }

        return password.toString();

    }

    public static boolean isPasswordValid(String password){
        return Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&.*-]).{8,}$")
                .matcher(password)
                .find();
    }

    private static List<Character> createArrCharacters(){
        List<Character> characters = new ArrayList<>();

        //ad all lowerCase English Characters
        characters.addAll(createLowerCaseList());

        // Add uppercase English characters
        characters.addAll(createUpperCaseList());

        //add numbers
        characters.addAll(createNumberList());


        //add specialCharacters
        characters.addAll(createSpecialCharList());

        return characters;
    }

    private static List<Character> createLowerCaseList(){
        List<Character> lowerCaseList= new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            lowerCaseList.add(c);
        }
        return lowerCaseList;
    }
    private static List<Character> createUpperCaseList(){
        List<Character> upperCaseList= new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            upperCaseList.add(c);
        }
        return upperCaseList;
    }
    private static List<Character> createNumberList(){
        List<Character> numberList= new ArrayList<>();
        for(int i = 0; i<=9;i++){
            numberList.add(Integer.toString(i).charAt(0));
        }
        return numberList;
    }
    private static List<Character> createSpecialCharList(){
        String specialCharacters = "!@#$%^&*<>,.";
        List<Character> specialCharList= new ArrayList<>();
        for(int i = 0; i<specialCharacters.length();i++){
            specialCharList.add(specialCharacters.charAt(i));
        }
        return specialCharList;
    }

}
