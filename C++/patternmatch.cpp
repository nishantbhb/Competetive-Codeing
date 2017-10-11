#include<iostream>
#include<string.h>
#include<stdlib.h>

using namespace std;

int main()
{
    char *txt = "ABABDABACDABABCABAB";
    char *pat = "ABABCABAB";

    int m = strlen(txt);
    int n = strlen(pat);
    //cout<<m<<" "<<n;
    if(m==0 || n==0)
    {
        cout<<"Empty string";
        return 0;
    }
    int i,j=0;

    for(i=0;i<m;i++)
    {
        if(txt[i]==pat[j])
            j++;
        else
            j=0;
        if(j==n)
            break;
    }

    if(j==n)
    {
        int pos=i-j+1;
        cout<<"Pattern matched at "<<pos;
    }
    else
        cout<<"Pattern did not match";

    return 0;


}
