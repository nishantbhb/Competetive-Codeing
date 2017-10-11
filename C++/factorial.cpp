#include<stdio.h>
#include<iostream>

using namespace std;

int multiply(int arr[],int x,int res);
void factorial(int n)
{
    int arr[500];
    arr[0]=1;
    int res=1;
    for(int i=2;i<=n;i++)
    {
        res=multiply(arr,i,res);
    }



    for(int i=res-1;i>=0;i--)
        cout<<arr[i];

}
int multiply(int arr[],int x,int res)
{
    int carry=0;
    for(int i=0;i<res;i++)
    {
        int prod=arr[i]*x+carry;
        arr[i]=prod%10;
        carry=prod/10;

    }
    while(carry!=0)
    {
        arr[res]=carry%10;
        carry=carry/10;
        res++;
    }
    return res;


}
int main()
{
    int n;
    cout<<"Enter number:";
    cin>>n;
    cout<<"\nFactorial of "<<n<<" is: ";
    factorial(n);
    return 0;
}
