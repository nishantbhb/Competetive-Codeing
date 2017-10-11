#include<iostream>
using namespace std;

int main()
{
    int a[]={1,2,3,4,6,7,8,9};

    int n=sizeof(a)/sizeof(a[0]);
    int sum=(n+1)*(n+2)/2;
    for(int i=0;i<n;i++)
        sum-=a[i];
    cout<<"Missing number: "<<sum;
}
