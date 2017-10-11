#include<iostream>

using namespace std;
int main()
{
    int a[]={1,2,3,72,6,54,3,8,12};
    int flag;
    int j;
    for(int i=0;i<8;i++)
      {
        flag=1;
        for(j=i+1;j<9;j++)
          {
               if(a[i]<a[j])
               {
                   flag=0;
                   break;
               }
          }
          if(flag==1)
          cout<<a[i]<<" ";
}
    cout<<a[8];
}
