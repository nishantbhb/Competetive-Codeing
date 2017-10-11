#include<stdlib.h>

using namespace std;

int main()
{
    int arr[] =  {1, 2, 1, 3, 4, 2, 3};
    int k = 4;
    hash_map<int,int> hM;
    int dist_count=0;
    for (int i = 0; i < k; i++)
        {
            if (hM.get(arr[i]) == null)
            {
                hM.put(arr[i], 1);
                dist_count++;
            }
            else
            {
               int count = hM.get(arr[i]);
               hM.put(arr[i], count+1);
            }
        }

    for(int i=k;i<arr.size();i++)
    {
        //if(hM.get(arr[i])==)
    }

}
