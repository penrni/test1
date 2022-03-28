#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    int data;
    struct  Node *next;
} node;

//创建一个头节点
node * create_list(int x){
    node *p=(node *)malloc(sizeof(node));
    p->data=x;
    p->next=NULL;      
    return p;
}
node * init_list(int n){
    node *head=(node *)malloc(sizeof(node));  //创建头节点
     head->data=0;
     head->next=NULL;     
     node *p=head;          //声明一个指针指向头结点，用于遍历链表(这里是单个的节点)
    for (int i = 0; i < n; i++)
    {
        node *body=(node *)malloc(sizeof(node));
        body->data=i+1;
        p->next=body;
        p=p->next;      //指针后移，移动到下一个节点
    }
    return head;  //head为整个链表
}


//链表添加节点
void add_list(node *head,int x){
    if(!head)return;
    while (head->next)  
    {
        head=head->next; //当指针不为空时，表明不是最后的节点，向后移动
    }
    node *p=(node *)malloc(sizeof(node));  //创建一个新的节点
    p->data=x;
    p->next=NULL;
    head->next=p;  //关联链表
}
//查找节点
node * find_list(node *head,int x){
    while (head&&head->data!=x)
    {
        head=head->next;   //如果不是最后的节点或节点的值不相等，则指针后移
    }
    if (head)
        return head;
    return NULL;
}
//打印链表的值
void print_list(node *head){
    while (head)
    {
        printf("%d->",head->data);
        head=head->next;    //后移指针，完成切换
    }
    printf("null\n");
}

//向链表中插入值为n的元素
node * insert_list(node *head,int n,int i){
    int j=0;
    while (head&&j<i-1)
    {
        head=head->next;
        j++;
    }
    if (!head)
    {
          return NULL;      
    }
    node *p=(node *)malloc(sizeof(node));  //创建一个新的节点
    p->data=n;
    p->next=head->next;
    head->next=p;
    return p;
}

//头插法
node * head_insert(int n){
     node *head=(node *)malloc(sizeof(node));  //创建头节点
     head->data=0;
     head->next=NULL;     
   for (int i = 0; i < n; i++)
   {
         node *body=(node *)malloc(sizeof(node));  //创建一个新的节点
         body->data=i+1;
         body->next=head->next;
         head->next=body;
   }
   return head;
}

//删除根据索引位置删除链表的位置
void  delete_list(node *head,int i){
    int j=0;
    while (head&&j<i-1)
    {
        head=head->next;
        j++;
    }
    //head->next=head->next->next;
    node *p=(node *)malloc(sizeof(node)); 
    p=head->next;
    head->next=p->next;
    free(p);
}
//获取链表中的某一元素
node * get_elem(node *head,int i){
    int j=0;
    while (head&&j<i-1)
    {
        head=head->next;
        j++;
    }
    if (j!=i-1)
    {
       return NULL;
    }
    printf("%d->",head->data);
    return head;
}

//删除链表中所有的值为key的节点
void deleteAllKey_list(node *head,int key){
    node *p,*q;
    p=head;
    q=head->next;
    while (q!=NULL)
    {
        if (q->data==key)
        {
            p->next=q->next;
            free(q);
            q=p->next;
        }else
        {
            p=p->next;
            q=q->next;
        }
    }
}

void deleteAllSameKey_list(node *head){
    node *p=head->next,*q,*r;
    while (p!=NULL)
    {
        q=p;
        while (q->next)
        {
            if (q->next->data==p->data)
            {
                r=q->next;
                q->next=r->next;
                free(r);
            }else
            {
                q=q->next;
            }
        }
        p=p->next;
    }
    
}

void main(){
//     node *head =create_list(1);
//     add_list(head,5);
//     add_list(head,3);
//     add_list(head,7);
//     add_list(head,8);
//     insert_list(head,8,2);
//     add_list(head,7);
//     print_list(head);
//    // deleteAllKey_list(head,7);
//    deleteAllSameKey_list(head);
//     print_list(head);

     node *list=init_list(5);
    // node *list=head_insert(5);
     print_list(list);
    
}