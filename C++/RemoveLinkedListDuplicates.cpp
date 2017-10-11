#include<iostream.h>
#include<stdio.h>
#include<memory.h>



//incomplete, solve uding hashmap

using namespace std;

typedef struct Node{
int item;
Node* next;
}*node;

Node* newNode(int item){
Node* temp= (Node*)malloc(sizeof(Node));
temp->item=item;
temp->next=null;
return temp;
}

void push(Node* head_ref, int new_data)
{
    /* allocate node */
    Node* new_node =
            (struct Node*) malloc(sizeof(struct Node));

    /* put in the data  */
    new_node->data  = new_data;

    /* link the old list off the new node */
    new_node->next = (*head_ref);

    /* move the head to point to the new node */
    (*head_ref)    = new_node;
}



int main(){

return 0;
}
