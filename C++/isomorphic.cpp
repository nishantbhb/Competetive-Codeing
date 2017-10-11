#include<iostream>
#include<stdlib.h>

using namespace std;

int main()
{
    char a[]="bbc";
    char b[]="yyz";

    int m=sizeof(a)/sizeof(a[0]);
    int n=sizeof(b)/sizeof(b[0]);
    if (m!=n)
    {
        cout<<"Not Isomorphic";
        return 0;
    }
    bool visited[256];
    int map[256];
    for(int i=0;i<256;i++)
    {
        visited[i]=false;
        map[i]=-1;
    }
    for(int i=0;i<m;i++)
    {
      if(map[a[i]]==-1)
      {
          if(visited[b[i]]==true)
          {
              cout<<"Not Isomorphic";
              return 0;
          }
          else
          {
               visited[b[i]]=true;
               map[a[i]]=b[i];
          }
      }
      else if(map[a[i]]!=b[i])
      {
          cout<<"Not Isomorphic";
              return 0;
      }
    }
    cout<<"Isomorphic";
    return 0;


}
