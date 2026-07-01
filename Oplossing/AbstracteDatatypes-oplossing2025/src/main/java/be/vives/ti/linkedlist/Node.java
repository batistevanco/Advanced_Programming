package be.vives.ti.linkedlist;

public class Node<E> {

    private E element;
    private Node<E> previous;
    private Node<E> next;

    public Node(E element, Node<E> previous, Node<E> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    public Node(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public String toString(){
        return element.toString();
    }
}
