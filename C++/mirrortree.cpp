#include<iostream>
#include<queue>
#include<stdlib.h>

using namespace std;

typedef struct Node
{
    int data;
    Node *left,*right;
};

Node *newNode(int x)
{
    Node *node=new Node;
    node->data=x;
    node->left=NULL;
    node->right=NULL;
    return node;
}
void mirror(Node *node)
{
    if(node==NULL)
        return;
    if(node->left!=NULL)
        mirror(node->left);
    if(node->right!=NULL)
        mirror(node->right);
    Node *tmp=new Node;
    tmp=node->left;
    node->left=node->right;
    node->right=tmp;

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
      //cout<<nodeCount;
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
int main()
{

    Node *root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
    root->right->right = newNode(6);
    printLevelOrder(root);
    mirror(root);
    printLevelOrder(root);
    return 0;
}
