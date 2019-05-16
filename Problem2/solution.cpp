#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int main()
{
	string line;
	int no_of_theatres;
	int linecount = 0;
	int no_of_shows;
	int capacity;
	int no_of_families;
	vector<int> theatredetail;
	queue<int> familydetail;

   ifstream testfile ("Problem2_input.txt");
   if (testfile.is_open())
   {
	   while(getline(testfile,line))
	   {
		   linecount++;
		  // cout << line << endl;
		   if(linecount == 1)
		   {
			   stringstream ss(line);
			   ss >> no_of_theatres;
			   cout << no_of_theatres+5;
		   }
		   if (linecount == 2) //&& linecount%2 == 0)
		   {
			   stringstream ss(line);
			   int i1;
			   while(ss >> i1)
			   {
				     theatredetail.push_back(i1);

				        if (ss.peek() == ' ')
				            ss.ignore();
			   }
			   for (int i=0; i< theatredetail.size(); i++)
			           std::cout << theatredetail.at(i)<<std::endl;
		   }
		   if (linecount ==3)// && linecount%2 != 0)
		   {
			   stringstream ss(line);
			   int i1;
			   while(ss >> i1)
			   			   {
			   				     familydetail.push(i1);

			   				        if (ss.peek() == ' ')
			   				            ss.ignore();
			   			   }


		   }

		   int family;
		   int total_earning_by_theatre = 0;
		   int money= 0;
		   int a=0;
		   while(a++ < 4)
		   {
			   int sum = 0;

			   while(6>sum)
			   {

				  if (6<sum+familydetail.front())
				  {
					  break;
				  }
				  sum += familydetail.front();
			      family = familydetail.front();
			      //familydetail.pop();
			      //familydetail.push(family);
			   }

				   money = sum * 10;
				   cout << money << endl;
				   total_earning_by_theatre +=money;
				   cout << total_earning_by_theatre << endl;
			   }
		   }
	   }

   return 1;
}
