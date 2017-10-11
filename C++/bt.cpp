#include<iostream>
#include<stdlib.h>
using namespace std;

typedef struct Node
{
    int data;
    Node *left;
    Node *right;
};

Node *newNode(int x)
{
    Node *node=(Node *)malloc(sizeof(Node));
    node->data=x;
    node->left=NULL;
    node->right=NULL;
    return node;
}
int main()
{
   Node *root=newNode(1);
   root->left=newNode(2);
   root->right=newNode(3);
   cout<<root->data;
   cout<<root->left->data;
   cout<<root->right->data;
}
