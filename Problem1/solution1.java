package com.quickstart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class solution1 {


    int numberOfMessages;



public static void main(String[] args){

    solution1 obj = new solution1();

    obj.process();


}
    public void process() {
        Formatter writein = null;
        Scanner dataScanner = null;

        try {
            File inputFile = new File("C:\\Codemaster\\CodeMaster-v2.0\\Problem1\\Problem1_input.txt");
            dataScanner = new Scanner(inputFile);
            writein = new Formatter("C:\\Codemaster\\CodeMaster-v2.0\\Problem1\\Problem1_output.txt");
        } catch (SecurityException se) {
            System.out.println("You do have access to this file");
            System.exit(1);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error in creating file");
            System.exit(1);
        }

        java.util.List<Message> messageList = new ArrayList<Message>();

        boolean fistLineNeedToBeOmmited = true;
        int messageNumber =1;

        while (dataScanner.hasNextLine()) {
            String firstLine =  dataScanner.nextLine();


            if(fistLineNeedToBeOmmited) {
                String[] data = firstLine.split(" ");
                numberOfMessages = Integer.valueOf(data[0]);
                fistLineNeedToBeOmmited = false;
            }else{
                if(dataScanner.hasNextLine()){
                    String secondLine =  dataScanner.nextLine();
                    Message message = new Message(firstLine, secondLine);
                    message.processMessage();
                    message.printMap(messageNumber);
                    messageList.add(message);
                    messageNumber++;
                }
            }
        }

       //System.out.println(numberOfMessages);
        //System.out.println(messageList);

    }

}
