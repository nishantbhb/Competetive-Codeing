#include<iostream>
using namespace std;

int binary_search(int a[],int l,int r,int key)
{
    int mid= l+(r-l)/2;
    if(a[mid]==key)
        return mid;
    if(a[mid]>key)
        binary_search(a,l,mid-1,key);
    else
        binary_search(a,mid+1,r,key);
}
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

int pivot(int ar[],int n,int key)
{
    int p=binarypivot(ar,0,n);
    cout<<"Pivot: "<<p<<"\n";
    if(key==ar[p])
        return p;
    if(key<=ar[p-1] && key>=ar[0])
        return binary_search(ar,0,p-1,key);
    else
        return binary_search(ar,p+1,n,key);

}
int main()
{
  int arr[]={3,4,5,6,7,8,9,1,2};
  int n=9;
  int key=6;
  int x=pivot(arr,n,key);
  cout<<"Key index:"<<x;
}
