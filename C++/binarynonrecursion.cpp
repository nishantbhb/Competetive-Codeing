#include<iostream>
#include<stdlib.h>
#include<stack>

using namespace std;

typedef struct Node
{
    int data;
    Node *left,*right;

};
Node *newNode(int x)
{
    Node *node=(Node *)malloc(sizeof(Node));
    node->data=x;
    node->left=NULL;
    node->right=NULL;
    return node;
}

void inorder(Node *root)
{
    if(root==NULL)
        return;
    if(root->left==NULL && root->right==NULL)
        cout<<root->data;
    Node *curr=root;
    stack<Node *> s;
    s.push(curr);
    while(s.size()!=0)
    {
        while(curr->left!=NULL)
        {
            curr=curr->left;
            s.push(curr);
        }
        curr=s.top();
        cout<<curr->data<<" ";
        s.pop();
        if(curr->right!=NULL)
         {
             s.push(curr->right);
             curr=curr->right;
         }

    }
}
int main()
{

  /* Constructed binary tree is
            1
          /   \
        2      3
      /  \
    4     5
  */
  Node *root = newNode(1);
  root->left        = newNode(2);
  root->right       = newNode(3);
  root->left->left  = newNode(4);
  root->left->right = newNode(5);

  inorder(root);
  return 0;
}
