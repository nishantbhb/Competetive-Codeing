/* Program to check children sum property */
#include <iostream>
#include <stdlib.h>

using namespace std;
/* A binary tree node has data, left child and right child */
typedef struct Node
{
    int data;
    Node* left;
    Node* right;
};

int isSumProperty(Node *node)
{
    int left=0,right=0;
    if(node==NULL || (node->left==NULL && node->right==NULL) )
        return 1;
    if(node->left!=NULL)
        left=node->left->data;
    if(node->right!=NULL)
        right=node->right->data;
    if ((node->data == left+right) && isSumProperty(node->left) && isSumProperty(node->right))
        return 1;
    else
        return 0;

}

Node* newNode(int data)
{
  Node* node =
      (Node*)malloc(sizeof(node));
  node->data = data;
  node->left = NULL;
  node->right = NULL;
  return(node);
}
int main()
{
  Node *root  = newNode(10);
  root->left         = newNode(8);
  root->right        = newNode(2);
  root->left->left   = newNode(3);
  root->left->right  = newNode(5);
  root->right->right = newNode(2);
  if(isSumProperty(root))
    cout<<"The given tree satisfies the children sum property ";
  else
    cout<<"The given tree does not satisfy the children sum property ";

  return 0;
}
