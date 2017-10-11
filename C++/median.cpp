#include<iostream>
using namespace std;


float median(int a[],int b[],int m,int n)
{
    int count=0;
    int i=0;
    int j=0;
    int k=0;
    int mid=(m+n)/2;
    float s=0;
    while(i<m && j<n)
    {
        if(a[i]<b[j])
        {
            count++;
            if(count==mid)
                s+=a[i];
            if(count==mid+1)
               {
                   s+=a[i];
                   return s/2;
               }
            i++;
            k++;
        }
        else
        {
            count++;
            if(count==mid)
                s+=b[j];
            if(count==mid+1)
               {
                   s+=b[j];
                   return s/2;
               }
            j++;
            k++;
        }

    }
    while(i<m)
    {
        count++;
            if(count==mid)
                s+=a[i];
            if(count==mid+1)
               {
                   s+=a[i];
                   return s/2;
               }
            i++;
            k++;
    }
    while(j<n)
    {

      count++;
            if(count==mid)
                s+=b[j];
            if(count==mid+1)
               {
                   s+=b[j];
                   return s/2;
               }
            b++;
            k++;
    }
}
int main()
{
    int a[]={1,2,4,4,5};
    int b[]={3,7,8,9,10};
    float x=median(a,b,5,5);
    cout<<"Median: "<<x;
}
