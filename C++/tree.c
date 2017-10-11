#include<stdio.h>
#include<stdlib.h>

typedef struct Node{
int item;
struct node* left;
struct node* right;
}node;

Node* newNode(int item){
node *temp= (Node*)malloc(sizeof(Node);
temp->item = item;
temp->left= NULL;
temp->right=NULL;
return temp;
}

int main(){
     node *root  = newNode(1);
     root->left             = newNode(2);
     root->right           = newNode(3);
     root->left->left     = newNode(4);
     root->left->right   = newNode(5);

      printf("%d ", node->item);
      return 0;
}
