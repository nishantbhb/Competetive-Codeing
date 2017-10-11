#include<stdio.h>
#include<malloc.h>
#include<iostream>

using namespace std;

struct node
{
    int data;
    struct node *left;
    struct node *right;
};

struct node* newNode(int data)
{
    struct node* node = (struct node*)malloc(sizeof(struct node));

    node->data = data;
    node->left = NULL;
    node->right = NULL;
    return(node);
}


int main()
{
    struct node *root = newNode(1);

    root->left        = newNode(2);
    root->right       = newNode(3);

    root->left->left  = newNode(4);

    cout<<root->data;
    cout<<" "<<root->left->data;
    cout<<" "<<root->right->data;


    getchar();
    return 0;
}
