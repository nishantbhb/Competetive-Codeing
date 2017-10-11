#include<bits/stdc++.h>

using namespace std;

int main()
{
    unordered_set<int> s;
    int arr[] =  {1, 9, 3, 10, 4, 20, 2};
    int n = sizeof(arr)/ sizeof(arr[0]);
    int max_length=0;

    for(int i=0;i<n;i++)
        s.insert(arr[i]);
    for(int i=0;i<n;i++)
    {
        if(s.find(arr[i]-1)==s.end())
        {
            int j=arr[i];
            while(s.find(j)!=s.end())
                j++;
            if(j-arr[i]>max_length)
                max_length=j-arr[i];
        }
    }
    cout<<max_length;
    return 0;
}
