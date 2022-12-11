package de.tum.in.ase;

public class ListNode<T> {
    // TODO: add attributes
    private T value;
    private ListNode<T> previous; //point to previous node
    private ListNode<T> next;  //point to next node

    // TODO: add 3 constructors as in the problem statement
    public ListNode() {
        this.value=null;
        this.previous=null;
        this.next=null;
    }

    public ListNode(T value) {
        this.value = value;
        previous = null;
        next = null;
    }

    public ListNode(T value, ListNode<T> previous, ListNode<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    // TODO: add getters and setters

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode<T> previous) {
        this.previous = previous;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
