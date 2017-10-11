#include<iostream>
#include<queue>
#include<stdlib.h>

using namespace std;
int preindex=0;

typedef struct Node
{
    char data;
    Node *left,*right;
};

Node *newNode(char x)
{
    Node *node=new Node;
    node->data=x;
    node->left=NULL;
    node->right=NULL;
    return node;
}

void printLevelOrder(Node *root)
{
    if(root==NULL)
        return;
    queue<Node *> q;
    q.push(root);
    while(1)
    {
      int nodeCount=q.size();

      if(nodeCount==0)
        break;
      while(nodeCount>0)
      {
          Node *tmp=q.front();

          cout<<tmp->data<<" ";
           q.pop();
          if(tmp->left!=NULL)
            q.push(tmp->left);
          if(tmp->right!=NULL)
            q.push(tmp->right);
          nodeCount--;
      }
      cout<<endl;

    }
}
int search(char arr[], int strt, int end, char value)
{
  int i;
  for(i = strt; i <= end; i++)
  {
    if(arr[i] == value)
      return i;
  }
}
Node *buildTree(char in[],char pre[],int s, int e)
{
    if(s>e)
        return NULL;
    Node *node=newNode(pre[preindex++]);
    if(s==e)
        return node;
    int inindex = search(in, s, e, node->data);
    node->left=buildTree(in,pre,s,inindex-1);
    node->right=buildTree(in,pre,inindex+1,e);

    return node;

}
int main()
{

     char in[] = {'D', 'B', 'E', 'A', 'F', 'C'};
  char pre[] = {'A', 'B', 'D', 'E', 'C', 'F'};
  int len = sizeof(in)/sizeof(in[0]);
  Node *root = buildTree(in, pre, 0, len - 1);

  /* Let us test the built tree by printing Level order traversal */
  cout<<"Level order traversal of the constructed tree is \n";

    printLevelOrder(root);
    return 0;
}

