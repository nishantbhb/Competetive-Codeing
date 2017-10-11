#include<iostream>
#include<stdlib.h>

using namespace std;

typedef struct Node
{
    int data;
    Node* left;
    Node* right;
};

Node* newNode(int data)
{
  Node* node=(Node*)malloc(sizeof(node));
  node->data = data;
  node->left = NULL;
  node->right = NULL;

  return(node);
}

int size(Node *root)
{
 if(root==NULL)
    return 0;
 return (size(root->left)+1+size(root->right));
}
int main()
{
  Node *root = newNode(1);
  root->left        = newNode(2);
  root->right       = newNode(3);
  root->left->left  = newNode(4);
  root->left->right = newNode(5);

  cout<<"Size of the tree is: "<<size(root);

  return 0;
}


