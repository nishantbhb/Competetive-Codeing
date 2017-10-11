#include<iostream>
#include<stdlib.h>

using namespace std;
int count=1;
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
 size(root->left);
 size(root->right);
 return count++;
}
int main()
{
  Node *root = newNode(1);
  root->left        = newNode(2);
  root->right       = newNode(3);
  root->left->left  = newNode(4);
  root->left->right = newNode(5);
  root->right->left = newNode(6);
  root->right->right = newNode(7);
  root->left->left->left  = newNode(8);
  cout<<"Size of the tree is: "<<size(root);

  return 0;
}


