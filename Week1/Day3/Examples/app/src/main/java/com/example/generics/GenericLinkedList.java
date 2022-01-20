package com.example.generics;

//The use of Generics here makes it possible for us to store any type of data in the linked list, however once we declare
//the type of data stored in our list, we cannot change it
public class GenericLinkedList<T> {

    //Linked lists we only need information about the head node, and the amount of nodes we have
    public int length;
    private Node<T> head;

    public GenericLinkedList(){
        this.length = 0;
        head = null;
    }

    //The most basic linked lists need these methods
    //add(data T), remove(int index), get(int index)

    public void add(T data){
        Node<T> node = new Node<T>(data);

        //We first want to check if the list is empty, if it is, we need to set the head to the node we just created
        if(this.head == null){
            this.head = node;
            return;
        } else {
            //Otherwise we want to loop through the list looking for the last node
            //The last node in the list wont have a "next" node, so when we see a node with the next value = null, we know we have made it
            Node<T> n = this.head;
            while(n.getNext() != null){
                n = n.getNext();
            }
            //To add the node to the list, we simply set the next variable of the last element to the element we created above
            n.setNext(node);
        }

        //Finally we want to keep track of the number of nodes currently stored
        length++;
    }

    public void remove(int index){
        //If the index is 0, just set the head to the next node in line
        if(index == 0){
            head = head.getNext();
            length--;
            //If the index is between 1 and n-1 where n is the last node in the list, we want to simply point the previous node at the node after the one we want to remove
            //So we want to start at the head and loop until one before the node we want to remove
            //When we get to the index before the one we want to remove, when need to store it in a variable
            //Then we need to move forward two nodes and save that node in a variable
            //Finally we need to point the node from above at the second node from above
            //If the node we want to remove is the final node, next will be equal to null, and we can check for that,
            //If it is the last node, we can just go backwards one node and set next to null
        } else {
            //Start at the head node
            Node<T> n = head;

            //Loop until index -1 and save it in a variable
            for(int i=0; i<index-1; i++){
                try{
                    n = n.getNext();
                    if(n.getNext()==null) throw new NullPointerException();
                } catch (NullPointerException e){
                    throw new IndexOutOfBoundsException();
                }
            }

            //Temporarily store the node before the one we are deleting
            Node<T> n1 = n;

            //Get the node after the node we want to delete
            Node<T> n2 = n.getNext().getNext();

            //Check to see if the node after the one we want to delete is null
            if(n2 == null){
                n1.setNext(null);
            }

            n1.setNext(n2);

            length--;

        }
    }

    public T get(int index){
        if(index == 0){
            return head.getData();
        } else {
            Node<T> n = head;
            for(int i=0; i<index; i++){
                try{
                    n = n.getNext();
                    if(n == null) throw new NullPointerException();
                } catch(NullPointerException e){
                    throw new IndexOutOfBoundsException();
                }
            }
            return n.getData();
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Linked List: {\n");
        Node<T> n = head;
        while(n != null){
            sb.append("\t" + n.getData() + ",\n");
            n = n.getNext();
        }
        sb.append("}");
        return sb.toString();
    }

}

class Node<T> {
    //Each node will store some information/data that we are using T as a placeholder
    //This node can hold any object type
    private T data;
    private Node<T> next;

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
