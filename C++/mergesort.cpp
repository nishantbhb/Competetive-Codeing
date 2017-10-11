#include<iostream>
#include<stdio.h>

using namespace std;

void merge(int[],int,int,int);


void mergesort(int A[],int l,int r)
{
    if(l<r)
    {
        int m=l+(r-l)/2;
        mergesort(A,l,m);
        mergesort(A,m+1,r);
        merge(A,l,m,r);
    }
}
void merge(int A[],int l,int m,int r)
{
    int n1=m-l+1;
    int n2=r-m;
    int one[n1];
    int two[n2];
    int i;
    for(i=0;i<n1;i++)
        one[i]=A[l+i];
    for(i=0;i<n2;i++)
        two[i]=A[m+i+1];
        int j=0,k=l;
        i=0;

    while(i<n1 && j<n2)
    {
        if(one[i]<=two[j])
        {
            A[k]=one[i];
            i++;k++;
        }
        else
        {
            A[k]=two[j];
            j++;k++;
        }
    }
    while(i<n1)
        A[k++]=one[i++];
    while(j<n2)
        A[k++]=two[j++];
}
int main()
{
    int Arr[]={1,4,2,3,5,36,74,78,79,80,8,10};
    int size1= sizeof(Arr)/sizeof(Arr[0]);
    cout<<size1<<"\n";
    for(int i=0;i<size1;i++)
        cout<<Arr[i]<<" ";
    cout<<"\n";
    mergesort(Arr,0,size1-1);
    for(int i=0;i<size1;i++)
        cout<<Arr[i]<<" ";
}
