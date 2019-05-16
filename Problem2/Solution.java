import java.util.Scanner;

public class Solution {


    private static decimal GetCost(int s, int p, int f, Queue<int> fm)
    {
        decimal Income = 0;

        for (int i = 0; i <= s-1; i++)
        {
            int total = 0;
            for (int j = 0; j <= f-1; j++)
            {
                int element = fm.Peek();
                //fm.Enqueue(element)
                total += element;
                if (total <= p)
                {

                    Income += element * 10;
                    fm.Enqueue(fm.Dequeue());
                }
                else
                {
                    total = 0;
                    break;

                }

            }
        }

        return Income;

        System.out.println("Total Rate: "+Income);
    }
}