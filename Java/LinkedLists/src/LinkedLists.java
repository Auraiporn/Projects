/**
 * An Implementation of a Singly Linked Lists which performs different operations in a singly linked list. For example,
 * A method to remove or retrieve a middle element of a linked list.
 * A method to add a new node to a list at the beginning, the end, or a specified location of a linked list.
 * A method to remove a node from a linked list; a node can be removed by passing a node or a data as a parameter to the functions.
 * A method that displays a linked list.
 * A method to check whether a linked list is a palindrome.
 * A method to reverse a linked list. 
 * */

import java.util.HashSet;
import java.util.Stack;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

class Node {
    Node next;
    int data;
    Node (int data){
        next = null;
        this.data = data;
    }
}
public class LinkedLists {
    Node head;
    /**
     * This function finds the middle element of a linked list.
     * It is O(n) time complexity since we traverse since we pass through the entire linked list
     * */
    public int getMiddleElement(){
        Node fastPointer = head;
        Node slowPointer = head;
        while(fastPointer.next !=null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer.data;
    }
    public void removeMiddleElement(){
        Node fastPointer = head;
        Node slowPointer = head;
        Node previous = null;
        while(fastPointer.next !=null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            previous = slowPointer;
            slowPointer = slowPointer.next;
        }
        previous.next = slowPointer.next;
    }
    public void addAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addNodeAfterSpecifiedNode(Node previousNode, int newData) {
        if(previousNode == null) System.out.println("Invalid! The specified node cannot be null.");
        Node newNode = new Node(newData);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
    }

    public void addAtTheEnd(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = new Node(newData);
        }
        newNode.next = null;
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void removeNode(Node node){
        if(node.next == null){
            node = null;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public void removeNodeByData(int data) {
        Node currentNode = head, previous = null;
        // if a head node contains data that we want to delete
        if (currentNode != null && currentNode.data == data) {
            head = currentNode.next; // Update the head node
        }
        // Traverse through a list to find a data to be removed
        while (currentNode != null && currentNode.data != data) {
            previous = currentNode;
            currentNode = currentNode.next;
        }
        // Disconnect the node from the list
        previous.next = currentNode.next;
    }

    // remove duplicates in a linked list
    public void removeDuplicates(){
        Node currentNode = head;
        while(currentNode!=null && currentNode.next!=null){
            if(currentNode.data == currentNode.next.data){
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
    }
    public void removeDuplicateByUsingHashMap(){
        HashSet<Integer> memo = new HashSet<Integer>();
        Node node = head, previous = null;
        while(node!=null) {
            if(memo.contains(node.data)){
                previous.next = node.next;
            } else {
                memo.add(node.data);
                previous = node;
            }
            node = node.next;
        }
    }
    // check whether a linked list is a palindrome
    public boolean isPalindrome(){
        Node slowPointer = head;
        Node fastPointer = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(fastPointer!=null && fastPointer.next!=null){
            fastPointer= fastPointer.next.next; // Fast Pointer moving at 2x speed
            slowPointer = slowPointer.next;
            stack.push(slowPointer.data);
        }
        if(fastPointer!=null){
            slowPointer = slowPointer.next;
        }
        while (slowPointer!=null){
            int pop = stack.pop();
            if(pop!=slowPointer.data){
                return false;
            }
            slowPointer = slowPointer.next;
        }
        return true;
    }


    public void displayLinkedLists(){
        Node node = head;
        while (node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    public void reverseLinkedList(){
        Node currentNode, previousNode, nextNode;
        currentNode = head;
        previousNode = null;
        while(currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }

    public static void main(String[] args){
        LinkedLists linkedLists = new LinkedLists();

        linkedLists.head = new Node(1);
        Node secondNode = new Node(2);
        Node thridNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);


        linkedLists.head.next = secondNode;
        secondNode.next = thridNode;
        thridNode.next = fourthNode;
        fourthNode.next = fifthNode;

        System.out.println("The orginal linked list is: ");
        linkedLists.displayLinkedLists();

        linkedLists.addNodeAfterSpecifiedNode(linkedLists.head.next, 6);
        System.out.println("\nAfter adding a node at a specified position: ");
        linkedLists.displayLinkedLists();

        linkedLists.addAtTheEnd(7);
        System.out.println("\nAfter adding a node at the end: ");
        linkedLists.displayLinkedLists();

        linkedLists.addAtBeginning(8);
        linkedLists.addAtBeginning(8);
        System.out.println("\nAfter adding a node at the beginning: ");
        linkedLists.displayLinkedLists();

       linkedLists.removeNode(thridNode);
       linkedLists.removeNodeByData(6);
       System.out.println("\nAfter removing two nodes: ");
       linkedLists.displayLinkedLists();

        linkedLists.removeDuplicates();
        System.out.println("\nAfter removing a duplicate value: ");
        linkedLists.displayLinkedLists();
        linkedLists.removeDuplicateByUsingHashMap();

        linkedLists.removeMiddleElement();
        System.out.println("\nAfter removing a middle element in a linked list: ");
        linkedLists.displayLinkedLists();

        int middleElement = linkedLists.getMiddleElement();
        System.out.println("\nA linked list before reversing: ");
        linkedLists.displayLinkedLists();
        linkedLists.reverseLinkedList();
        System.out.println("\nA linked list after reversing: ");
        linkedLists.displayLinkedLists();
        
        boolean palindrome = linkedLists.isPalindrome();

        System.out.println("\nThe middle element of a linkedLists is: "+middleElement);
        System.out.println("Is palindrome? " + palindrome);

    }

}
