#include<iostream>

using namespace std;

int main()
{
    static int a=10;
    a++;
    cout<<a;
    {
        int a=10;
        cout<<endl<<a;
    }
    cout<<endl<<a;
    cout<<endl<<INT_MAX;
}
