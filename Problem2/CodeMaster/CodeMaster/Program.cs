using System;
using System.Collections.Generic;
using System.IO;

namespace CodeMaster
{

    class Data
    {
        public int show,capacity,familiesCount;
        public Queue<int> qt = new Queue<int>();

        
    }
    class Theatre
    {
        static void Main(string[] args)
        {
            decimal Income_Th=0;
            Queue<int> qt = new Queue<int>();
            string textFile = @"C:\CodeMaster\CodeMaster-v2.0\Problem2\Problem2_input.txt";
            
            List<Data> dta= FileRead(textFile);

            int count = 1;
            foreach (Data item in dta)
            {
                Income_Th = GetCost(item.show, item.capacity, item.familiesCount, item.qt);
            
                using (StreamWriter sw = new StreamWriter(@"C:\CodeMaster\CodeMaster-v2.0\Problem2\Output.txt", true))
                {
                    sw.WriteLine("Theater-{0}:{1}",count,Income_Th);
                    sw.Close();
                }
                count++;
                
            }
        }

        private static decimal GetCost(int show, int capacity, int families, Queue<int> qt)
        {
            decimal Income = 0;

            for (int i = 0; i <= show-1; i++)
            {
                int total = 0;
                for (int j = 0; j <= families-1; j++)
                {
                    int element = qt.Peek();
                    total += element;
                    if (total <= capacity)
                    {                       
                        Income += element * 10;
                        qt.Enqueue(qt.Dequeue());
                    }
                    else
                    {
                        total = 0;
                        break;

                    }                    
                }
            }



            return Income;
        }

        private static List<Data> FileRead(string filename)
        {
            List<Data> obj1 = new List<Data>();
            if (File.Exists(filename))
            {
                //    // ---------------------- READ THE FILE--------------------------------------------
                using (StreamReader file = new StreamReader(filename))
                {
                    int counter = 0;
                    string ln;
                    int Theaters = Convert.ToInt32(file.ReadLine());
                    

                    while ((ln = file.ReadLine()) != null)
                    {
                        Data obj = new Data();
                        string[] ar = ln.Split(" ");
                        obj.show = Convert.ToInt32(ar[0]);
                        obj.capacity = Convert.ToInt32(ar[1]);
                        obj.familiesCount = Convert.ToInt32(ar[2]);
                        ln = file.ReadLine();
                        ar = ln.Split(" ");
                        Queue<int> qt = new Queue<int>();
                        for (int i=0;i<ar.Length;i++)
                        {
                            qt.Enqueue(Convert.ToInt32(ar[i]));
                        }
                        obj.qt = qt;
                        obj1.Add(obj);
                    }
                    counter++;
                }
            }
            return obj1;
        }

    }

}
