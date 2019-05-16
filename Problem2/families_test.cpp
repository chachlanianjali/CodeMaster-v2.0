//============================================================================
// Name        : test_project.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <bits/stdc++.h>
#include <iostream>
#include <stdio.h>
#include <cstdio>
#include <cstdlib>

using namespace std;


void rotatearray(int a[10], int familystopindex, int);
void arrayprint(int a[10], int s);

int main()
{
   freopen("Problem2_input.txt", "r", stdin);
   freopen("output.txt", "w", stdout);
   int tests;
   int families = 0;
   int shows = 0;
   int capacity = 0;
   int familyIndex[1000];
   int i;

   int np=0, familystopindex, sum;

      cin>>tests;
      for(int m=0;m<tests;m++)
      {
         cin>>shows>>capacity>>families;
         np = 0;
         for (int j = 0; j<= families-1; j++)
         {
            cin>>familyIndex[j];
         }
         for(int j=0; j<=shows-1;j++)
             {
                 sum = 0;
                 for(i=0; i<=families-1;i++)
                 {
                     if(sum+familyIndex[i] <= capacity)
                     {
                         sum = sum + familyIndex[i];
                         np = np + familyIndex[i];
                     }
                     else
                     {
                        break;
                     }
                 }
                 familystopindex = i;
                 rotatearray(familyIndex, familystopindex, families);
             }
         cout<<"Theater-"<<m+1<<": "<<np*10<<endl;
      }
   return 0;
}

void rotatearray(int a[10], int familystopindex,  int families)
{
   for(int j=0; j<=familystopindex-1;j++)
   {
     int temp = a[0];
      for(int i=1; i<=families-1;i++)
          {
              a[i-1] = a[i];
          }
          a[families-1] = temp;
   }

}
