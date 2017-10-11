#include<iostream>
#include<stdio.h>

using namespace std;

int main()
{
    string str="GEEKSFORGEEKS";
    int n=3;
    string arr[n];
    int s=str.length();
    int j=0;
    bool down;
    for(int i=0;i<s;i++)
    {
        arr[j]+=str[i];
        for(int k=0;k<n;k++)
        {
            if(k==j)
                continue;
            arr[k]+=" ";
        }
        if(j==0)
            down=true;
        if(j==n-1)
            down=false;
        if(down)
            j++;
        else
            j--;

    }
    for(int i=0;i<n;i++)
        cout<<arr[i]<<endl;
}
