#include<iostream>
#include<stdlib.h>
#include<stack>

using namespace std;

typedef struct Node
{
    int data;
    Node *left,*right,*next;

};
Node *newNode(int x)
{
    Node *node=(Node *)malloc(sizeof(Node));
    node->data=x;
    node->left=NULL;
    node->right=NULL;
    return node;
}
void connect(Node *root)
{
  if(root==NULL)
    return;
  root->next=NULL;
  //connectRec(root);

}
void connectRec(Node *node)
{
    if(node==NULL)
        return;
    if(node->next!=NULL)
        connectRec(node->next);
    if(node->left)
    {
        if(node->right)
        {
            node->left->next=node->right;

        }
        else
            node->left->next=getNext(node->next);

        connectRec(node->left);
    }
    else if(node->right)
    {
        node->right->next=getNext(node->next);
        connectRec(node->right);
    }
    else
        connectRec(getNext(node->next));

}
void getNext(Node *node)
{
    if(node->left)
        return node->left;
    if(node->right)
        return(node->right);
    if(node->next)
        getNext(node->next);
    else
        return NULL;
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

  connect(root);
  return 0;
}
