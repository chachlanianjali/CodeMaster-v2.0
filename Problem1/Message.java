package com.quickstart;

import java.util.*;


public class Message {


    public int noOfLetter;
    public int noOfKeys;
    public int totalLetter;
    public String countLine;
    public Map<Integer, List<Integer>> listmap;

    public Message(String line1, String line2){

        String[] split = line1.split(" ");
        noOfLetter = Integer.parseInt(split[0]);
        noOfKeys = Integer.parseInt(split[1]);
        totalLetter = Integer.parseInt(split[2]);
        countLine = line2;
    }

    @Override
    public String toString() {
        return "Message{" +
                "noOfLetter=" + noOfLetter +
                ", noOfKeys=" + noOfKeys +
                ", totalLetter=" + totalLetter +
                ", countLine='" + countLine + '\'' +
                '}';
    }


    public void processMessage(){

      //  4 2 8
       // 5 2 5 2 4 1 3 6

            List<Integer> countSet = new ArrayList<Integer>();
            String[] data = countLine.split(" ");
            for(int j=0;j<data.length;j++){
                countSet.add(Integer.valueOf(data[j]));
            }
            Collections.sort(countSet,Collections.reverseOrder());

            //populate its map property
           listmap = new  HashMap<Integer, List<Integer>>();
           for(int i=0;i<noOfKeys;i++)  {
              List<Integer> list = new ArrayList<Integer>();
               listmap.put(i,list);
           }

           Iterator<Integer> iter = countSet.iterator();
           int i =0;
           while(iter.hasNext()) {
               int currentvalue = iter.next();
               List<Integer> list = listmap.get(i);
               int size = list.size();
               list.add(currentvalue * (size+1));
               listmap.put(i,list);
               i++;
               if(i== noOfKeys){
                   i=0;
               }
           }
    }

    public void printMap(int messageNumber){

        int count =1;
        int sum = 0;
        for (Map.Entry<Integer, List<Integer>> entry : listmap.entrySet()) {

            List<Integer> list = entry.getValue();

            for(int j=0;j<list.size();j++){
                sum = sum + list.get(j);
            }
            count++;
        }
        System.out.println("Message-" + messageNumber+":" + sum);

    }

}
