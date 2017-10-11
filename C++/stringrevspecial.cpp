#include<iostream>
#include<stdlib.h>

using namespace std;

int main()
{
    char str[]="Hello,World$$";
    cout<<str<<endl;
    int i=0;
    int j=sizeof(str)-1;
    while(i<j)
    {
        if(!((str[i] >= 'A' &&  str[i] <= 'Z') || (str[i] >= 'a' &&  str[i] <= 'z') ))
            i++;
        if(!((str[j] >= 'A' &&  str[j] <= 'Z') || (str[j] >= 'a' &&  str[j] <= 'z') ))
            j--;

         if(((str[i] >= 'A' &&  str[i] <= 'Z') || (str[i] >= 'a' &&  str[i] <= 'z') ) &&
            ((str[j] >= 'A' &&  str[j] <= 'Z') || (str[j] >= 'a' &&  str[j] <= 'z') ))
        {
            char tmp=str[i];
            str[i]=str[j];
            str[j]=tmp;
            i++;
            j++;
        }

    }
    cout<<str;
}
