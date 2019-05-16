#include<bits/stdc++.h>
using namespace std;

int main()
{
    freopen("input.txt", "r",stdin);
    freopen("output.txt", "w",stdout);
    unsigned int T; cin>>T;
    unsigned long s, p, fr, val;
    list<unsigned long>v;
    list<unsigned long>MovieSeen;
    unsigned long long cost = 0;
    const int cCost = 10;  
    unsigned long rem_cap = 0;
    while(T--)
    {
        cost = 0;
        v.clear();
        MovieSeen.clear();
        s = p = fr = 0;
        cin>>s>>p>>fr;
        // v.reserve(fr);
        
        while(fr--)
        {
            val = 0;
            cin>>val;
            v.emplace_back(val);
        }
		while(s--)
        {
            rem_cap = p;
            unsigned long vsize = v.size();
            for (unsigned long pCnt = v.front();  vsize > 0 && v.front() <= rem_cap;) {
                pCnt = v.front();
                rem_cap -= pCnt;
                v.pop_front();
                vsize--;
                MovieSeen.emplace_back(pCnt);
            }
            unsigned long size = MovieSeen.size();
            for(unsigned int i = 0 ; i<size; ++i)
            {
                v.emplace_back(MovieSeen.front());
                MovieSeen.pop_front();
            }
            MovieSeen.clear();
            cost = cost + ((p - rem_cap) * cCost);
        }
        cout<<cost<<"\n";
    }
}
