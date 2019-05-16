#include<bits/stdc++.h>
using namespace std;

int main()
{
    freopen("input.txt", "r",stdin);
    freopen("output.txt", "w",stdout);
    unsigned int T; cin>>T;
    unsigned int s, p, fr, val;
    vector<unsigned int>v;
    vector<unsigned int>MovieSeen;
    unsigned long long cost = 0;
    const int cCost = 10;  
    unsigned int rem_cap = 0;
    while(T--)
    {
        cost = 0;
        v.clear();
        MovieSeen.clear();
        s = p = fr = 0;
        cin>>s>>p>>fr;
        v.reserve(fr);
        
        while(fr--)
        {
            val = 0;
            cin>>val;
            v.emplace_back(val);
        }

        for (unsigned int show_cnt = 0; show_cnt < s; ++show_cnt) 
        {
            rem_cap = p;    
            for (unsigned int pCnt = v[0]; v.size() > 0 && v[0] <= rem_cap;) {
                pCnt = v[0];
                rem_cap -= pCnt;
                v.erase(v.begin());
                MovieSeen.emplace_back(pCnt);
            }
            unsigned int size = MovieSeen.size();
            for(unsigned int i = 0 ; i<size; ++i)
            {
                v.emplace_back(MovieSeen[i]);
            }
            MovieSeen.clear();
            cost = cost + ((p - rem_cap) * cCost);
        }
        cout<<cost<<"\n";
    }
}
