package com.test;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;


public class CinemaHall
{
    public static void main(String arg[])
    {
        try
        {
            Scanner scanner = new Scanner(new File("C:\\Saurabh\\git_repositories\\CodeMaster-v2.0\\Problem2\\Problem2_input.txt"));
            String total_theater = scanner.nextLine();
            for (int i = 0; i <= Integer.valueOf(total_theater); i++)
            {
                while (scanner.hasNextLine())
                {
                    String[] details = scanner.nextLine().split(" ");
                    System.out.println("Shows per day " + details[0] + " Capacity " + details[1] + " Total Families " + details[2]);

                    Integer shows_per_day = Integer.valueOf(details[0]);
                    Integer capaity = Integer.valueOf(details[1]);

                    String[] arr = scanner.nextLine().split(" ");

                    int size = arr.length;
                    Integer[] each_family_members_count = new Integer[size];
                    for (int temp = 0; temp < size; temp++)
                    {
                        each_family_members_count[temp] = Integer.parseInt(arr[temp]);
                    }

                    Deque<Integer> queue = new ConcurrentLinkedDeque<Integer>(Arrays.asList(each_family_members_count));

                    Deque<Integer> innerQueue = new ConcurrentLinkedDeque<Integer>(Arrays.asList(each_family_members_count));

                    for (Integer val : queue)
                    {
                        innerQueue.add(val);
                    }

                    int total_amount = 0;

                    for (int j = 0; j < shows_per_day; j++)
                    {

                        Iterator<Integer> itr = queue.iterator();
                        while (itr.hasNext())
                        {
                            Integer value = (Integer) itr.next();
                            if (capaity == value)
                            {
                                total_amount = value * 10;
                                queue.removeFirst();
                                queue.addLast(value);
                            }
                            else
                            {
                                int familyCount = 0;
                                while (familyCount <= capaity)
                                {
                                    Iterator<Integer> itr2 = innerQueue.iterator();
                                    while (itr2.hasNext() && familyCount <= capaity)
                                    {
                                        Integer value2 = (Integer) itr2.next();
                                        familyCount = familyCount + value2;
                                        total_amount = total_amount + (value2 * 10);
                                        innerQueue.removeFirst();
                                        innerQueue.addLast(value2);
                                    }
                                }
                                innerQueue.clear();
                                for (Integer val : queue)
                                {
                                    innerQueue.add(val);
                                }
                            }

                        }

                    }

                    System.out.println(total_amount);

                }

            }

            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
