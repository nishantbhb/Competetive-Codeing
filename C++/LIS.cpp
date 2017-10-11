#include<iostream>

using namespace std;

int main()
{
    int a[]={3,4,-1,0,6,2,3};
    int n=sizeof(a)/sizeof(a[0]);

    int lis[n];
    for(int i=0;i<n;i++)
        lis[i]=1;

    for(int i=0;i<n;i++)
        for(int j=0;j<i;j++)
        {
            if(a[j]<a[i] && lis[i]<lis[j]+1)
                lis[i]=lis[j]+1;
        }

    for(int i=0;i<n;i++)
        cout<<lis[i]<<" ";
}
