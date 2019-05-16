using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;

namespace SmartCodersConsoleApp
{
    class Program
    {
        //Default file. MAKE SURE TO CHANGE THIS LOCATION AND FILE PATH TO YOUR FILE 
        //static readonly string inputTextFile = @"C:\Deepesh\CodeMaster-v2.0\SmartCodersConsoleApp\SmartCodersConsoleApp\Input\input.txt";
        static string directory = Directory.GetParent(Directory.GetParent(Directory.GetCurrentDirectory()).ToString()).ToString();
        static readonly string inputTextFile = directory +  @"\Input\input.txt";
        static readonly string outputTextFile = directory +  @"\Output\\output.txt";

        static void Main(string[] args)
        {

            int theatre = 0;
            int show = 0, capacity = 0, noOFfamily = 0;
            string[] familyMembers = null;

            StringBuilder sb = new StringBuilder();

            if (File.Exists(inputTextFile))
            {
                // Read file using StreamReader. Reads file line by line
                using (StreamReader file = new StreamReader(inputTextFile))
                {
                    int counter = 0;
                    string ln;

                    int ctheatre = 1;

                    while ((ln = file.ReadLine()) != null)
                    {
                       
                        if (counter%2 == 1)
                        {
                            string[] i1 = ln.Split(' ');

                            show = Convert.ToInt32(i1[0]);
                            capacity = Convert.ToInt32(i1[1]);
                            noOFfamily = Convert.ToInt32(i1[2]);
                        }

                        if (counter %2 == 0 && counter > 0)
                        {
                            familyMembers = ln.Split(' ');
                            
                            int cost = 0;

                            Queue<int> queue = new Queue<int>();

                            foreach (string item in familyMembers)
                            {
                                queue.Enqueue(Convert.ToInt32(item));
                            }

                            for (int j = 0; j < show; j++)
                            {
                                int occupied = 0;
                                for (int i = 0; i < queue.Count; i++)
                                {
                                    int need = queue.ElementAt(0);

                                    if (capacity - occupied >= need)
                                    {
                                        occupied += need;
                                        int topElement = queue.Dequeue();
                                        queue.Enqueue(topElement);
                                    }
                                    else
                                    {
                                        break;
                                    }
                                }
                                cost += occupied * 10;
                            }

                           
                            sb.AppendLine("Theater-" + ctheatre + ": " + cost);                                
                                                         
                          
                            ctheatre++;
                        }                        

                        counter++;
                    }
                    file.Close();
                }
            }


            using (StreamWriter file2 = new StreamWriter(outputTextFile))
            {
                file2.WriteLine(sb);                
            }

        }

    }


}
