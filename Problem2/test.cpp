//============================================================================
// Name        : test.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;


int main()
{

	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	unsigned int Theaters = 0;

	cin>>Theaters;

	for(unsigned int i = 1; i <=Theaters; i++)
	{
		unsigned int NoOfShows = 0;
		unsigned int Capacity = 0;
		unsigned int FamilyCnt = 0;

		cin>>NoOfShows>>Capacity>>FamilyCnt;

		unsigned int * ptr = new unsigned int[FamilyCnt];
		unsigned int * tptr = new unsigned int[FamilyCnt];

		for(unsigned int j = 0; j < FamilyCnt; j++)
		{
			cin>>ptr[j];
		}
		//cout<<endl;
		unsigned int sum = ptr[0];
		unsigned total_sum = 0;

		unsigned int tNoOfShows = 1;

		while(tNoOfShows <= NoOfShows)
		{
			sum = ptr[0];

			while(sum <= Capacity)
			{
				for(unsigned int m = 0; m < FamilyCnt; m++)
				{
					tptr[m] = ptr[m];
				}

				unsigned int t = ptr[0];

				for(unsigned int m = 0; m < FamilyCnt-1; m++)
				{
					ptr[m] = ptr[m+1];
				}
				ptr[FamilyCnt-1] = t;

				if(sum + tptr[1] > Capacity)
					break;

				sum += ptr[0];

			}

			total_sum += sum;

			tNoOfShows++;
		}
		cout<<"Theater-"<<i<<":"<<" "<<total_sum*10<<endl;

		delete [] ptr;
		delete [] tptr;
	}

	return 0;
}
