/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {




    public static void main(String args[] ) throws Exception {

        URL path = TestClass.class.getResource("Problem1_input.txt");
        File f = new File(path.getFile());
        FileWriter geek_file;
        geek_file = new FileWriter("outputSample.txt");
        // Initialing BufferedWriter
        BufferedWriter geekwrite = new BufferedWriter(geek_file);
        try (BufferedReader br = Files.newBufferedReader(Paths.get(f.getAbsolutePath()))) {
            int NoOfTestCases = Integer.parseInt(br.readLine());
            int testCaseNumber= 0;
            while(NoOfTestCases-- > 0){
                testCaseNumber++;
                String[] iPArr=br.readLine().split(" ");
                int mXLetter=Integer.parseInt( iPArr[0]);
                int totalNoOfKey=Integer.parseInt( iPArr[1]);
                int lettersCount=Integer.parseInt( iPArr[2]);
                int[] sortedOccurancesArray=  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

                //  int[] sortedOccurancesArray =Arrays.sort(tempArr,Collections.reverseOrder());
                int totalKeyPressed = 0;
                int placedLetterNumber = 0;
                int indexOfSOA=0;

                while(true){
                    if(indexOfSOA >= lettersCount-1){
                        break;
                    }
                    placedLetterNumber ++;
                    int NOK=totalNoOfKey;
                    while (NOK -- >0){
                        totalKeyPressed+= placedLetterNumber * sortedOccurancesArray[(lettersCount-1 )- indexOfSOA];
                        indexOfSOA++;
                    }
                }
                geekwrite.write("Message-"+testCaseNumber+": "+ totalKeyPressed);

                geekwrite.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        geekwrite.close();

    }

}

