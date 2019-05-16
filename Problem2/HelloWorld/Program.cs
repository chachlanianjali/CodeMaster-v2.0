using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelloWorld
{
    class Program
    {
        //static readonly string rootFolder = @"C:\Users\A705227\Desktop\GitHub\test\";
        static readonly string textFile = @"C:\Users\A705227\Desktop\sample.txt";
       // static string outputfile =@"C:\Users\A705227\Desktop\GitHub\test\Output.txt";
        static void Main(string[] args)
        {
            
            long[] families = new long[9999999];

            if (File.Exists(textFile))
            {
                // ---------------------- READ THE FILE--------------------------------------------
                using (StreamReader file = new StreamReader(textFile))
                {
                    int counter = 0;
                    string ln;
                    long s;
                    int[] spfc = new int[3];
                    while ((ln = file.ReadLine()) != null)
                    {

                        //-------------------- LOGIC ----------------------------------------
                        if (counter == 0)
                        {
                            s = Convert.ToInt64(ln);
                           
                        }
                        if (counter%2 == 1)
                        {
                          
                            var line = ln;
                            var numbers = line.Split(' ');
                            int j = 0;
                            
                            foreach (var number in numbers)
                            {
                                int num;
                                if (Int32.TryParse(number, out num))
                                {
                                    //Console.WriteLine(num);
                                    spfc[j] = num;
                                    j++;
                                   // Console.WriteLine(num);
                                    // num is your number as integer
                                }

                            }

                        }

                        if (counter%2 == 0 && counter != 0)
                        {
                          
                            var line = ln;
                            var numbers = line.Split(' ');
                            int j = 0;
                            foreach (var number in numbers)
                            {
                                int num;
                                if (Int32.TryParse(number, out num))
                                {
                                    //Console.WriteLine(num);
                                    families[j] = num;
                                    j++;
                                    // num is your number as integer
                                }
                                
                            }
                            Program obj = new Program();
                           long output = obj.Rupees(spfc[0],spfc[1],spfc[2],families );
                            // Console.WriteLine(output );
                            using (StreamWriter sw = new StreamWriter(@"C:\Users\A705227\Desktop\GitHub\test\O1.txt", true))
                            {

                                sw.WriteLine("Theater-{0}:{1}", counter, output);

                            }

                        }







                        //----------------------------WRITE INTO FILE-------------------------------------

                       
                        counter++;
                    }

                   

                    file.Close();
                   // Console.WriteLine($"File has {counter} lines.");
                    Console.ReadLine();

                    
                    
                }
            }



        }

        public long Rupees(long s, long p, long fc,long [] families)
        {
            long strorep = p;
            long ret=p;
            int count = 0;
            long output=0;
            for (long i = 0; i < s; i++)
            {
                
                for (; ; count++)
                {
                    
                    if (p >= families[count])
                    {
                        p = p - families[count];
                        if (p == 0)
                        {
                            ret = strorep ;
                            break;
                        }
                        else
                        {
                            ret -= p;
                        }
                      
                        families[fc+count] = families[count];
                    }
                    else
                    {
                        break;
                    }
                   
                }
                if (ret > p)
                {
                    output += strorep;
                    ret = strorep;
                    p = strorep;
                }
                else
                {
                    output += ret;
                    ret = strorep;
                    p = strorep;
                }
                
            }
            
            return output * 10;
        }

    }
}
