using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Numerics;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace Clapper
{
    class Program
    {
        public static void Main()
        {
            string path = Path.Combine(Environment.CurrentDirectory, @"input_2.txt");
            var inputs = File.ReadAllLines(path);
            Theatre th = new Theatre();
            var details = new TheareDetails();
            List<string> output = new List<string>();

            for (int i = 0; i < inputs.Length; i++)
            {
                if (i == 0)
                    th.TheatreCount = Convert.ToInt32(inputs[i]);
                else
                {
                    if (i % 2 != 0)
                    {
                        details = new TheareDetails();
                        var t_details = inputs[i].Split(' ');
                        details.Shows = Convert.ToInt32(t_details[0]);
                        details.Capacity = Convert.ToInt32(t_details[1]);
                        details.FamilyCount = Convert.ToInt32(t_details[2]);
                    }
                    else
                    {
                        var fDetails = new List<FamilyDetail>();
                        var f_details = inputs[i].Split(' ');
                        foreach (var item in f_details)
                            fDetails.Add(new FamilyDetail { People = Convert.ToInt32(item) });
                        details.FamilyDetail = fDetails;
                        th.TheareDetails.Add(details);
                    }
                }
            }

            var Totalsum = decimal.Zero;
            var tIndex = 0;
            for (int thIndex = 0; thIndex < th.TheareDetails.Count; thIndex++)
            {
                tIndex++;
                Totalsum = 0;
                var currentIndex = 0;
                for (int showIndex = 0; showIndex < th.TheareDetails[thIndex].Shows; showIndex++)
                {
                    var familyCount = 0;

                    for (int fIndex = currentIndex; fIndex < th.TheareDetails[thIndex].FamilyDetail.Count; fIndex++)
                    {
                        if ((familyCount + th.TheareDetails[thIndex].FamilyDetail[fIndex].People) > th.TheareDetails[thIndex].Capacity)
                            break;

                        familyCount += th.TheareDetails[thIndex].FamilyDetail[fIndex].People;

                        if (fIndex == th.TheareDetails[thIndex].FamilyDetail.Count - 1)
                        {
                            fIndex = -1;
                            currentIndex = 0;
                        }
                        else
                            currentIndex = fIndex + 1;
                    }

                    Totalsum += familyCount * 10;
                }

                output.Add("Theater-" + tIndex + ":" + Totalsum);
            }

            string oPath = Path.Combine(Environment.CurrentDirectory, @"output.txt");
            StreamWriter sw = new StreamWriter(oPath, false);
            foreach (var item in output)
            {
                sw.WriteLine(item);
            }
            sw.Close();            
        }
    }

    public class Theatre
    {
        public Theatre()
        {
            TheareDetails = new List<TheareDetails>();
        }
        public int TheatreCount { get; set; }
        public List<TheareDetails> TheareDetails { get; set; }
    }

    public class TheareDetails
    {
        public TheareDetails()
        {
            FamilyDetail = new List<FamilyDetail>();
        }
        public int Shows { get; set; }
        public int Capacity { get; set; }
        public int FamilyCount { get; set; }
        public List<FamilyDetail> FamilyDetail { get; set; }
    }

    public class FamilyDetail
    {
        public int People { get; set; }
    }
}
