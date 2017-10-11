#include<iostream>
using namespace std;

int binarypivot(int a[],int l,int r)
{
    int mid= l+(r-l)/2;
    if (a[mid]>a[mid+1])
        return mid+1;
    if(a[l]<a[mid])
       binarypivot(a,mid+1,r);
    else
        binarypivot(a,l,mid);

}

int pivot(int a[],int n)
{
    return binarypivot(a,0,n);

}
int main()
{
  int arr[]={3,4,5,6,7,8,9,1,2};
  int n=9;
  int x=pivot(arr,n);
  cout<<"Pivot index:"<<x;
}
