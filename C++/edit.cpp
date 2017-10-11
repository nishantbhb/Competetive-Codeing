#include<iostream>
#include<stdlib.h>

using namespace std;

int main()
{
    string s1="geeks";
    string s2="geeks";
    int m=s1.length();
    int n=s2.length();
    if (abs(m - n) > 1)
    {
        cout<<"Not Possible";
    }
    else
    {
        int ctr=0;
        int i=0,j=0;
        while (i<m && j<n)
        {
            if(s1[i]!=s2[j])
            {
                ctr++;
                if(m>n)
                    i++;
                else if(n>m)
                    j++;
                else
                {
                    i++;
                    j++;
                }
            }
            else
            {
                i++;
                j++;
            }
        }

        if(ctr==1)
            cout<<"Edit Possible";
        else if (i < m || j < n)
            cout<<"Edit Possible";
        else
            cout<<"Not Possible";

    }


}
