#include<iostream>
#include<stdio.h>

using namespace std;
int main()
{
    int a[]= {1,3,5};
    int Min[3];
    Min[1]=Min[2]=99999;
    Min[0]=0;
    int s=11;
    for(int i=1;i<=s;i++)
        for(int j=0;j<3;j++)
        if(a[j]<=i && Min[i-a[j]]+1<Min[i])
            Min[i]=Min[i-a[j]]+1;
    cout<<Min[s];
return 0;
}

