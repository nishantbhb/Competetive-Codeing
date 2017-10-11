#include <bits/stdc++.h>

using namespace std;

int main()
{
    string abc="0100";
    string ones="",twos="";

    int i;
    for(i=0;i<abc.length();i++)
    {
        if(abc[i]=='0')
            ones+='1';
        else
            ones+='0';
    }
    twos=ones;
    for(i=twos.length()-1;i>=0;i--)
     {
        if(twos[i]=='0')
           {
               twos[i]='1';
               break;
           }
        else
            twos[i]='0';
     }
    if (i == -1)
        twos = '1' + twos;
    cout<<"Ones: "<<ones;
    cout<<"\nTwos: "<<twos;
    return 0;
}
