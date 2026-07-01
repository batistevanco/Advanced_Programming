package be.vives.ti.doubly;

import be.vives.ti.domain.Station;

public class DoublyLinkedStationList {

    private final StationNode head;
    private final StationNode tail;
    private int size;

    public DoublyLinkedStationList() {
        head = new StationNode(null, null, null);
        tail = new StationNode(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    public int getSize() {return size;}

    public boolean isEmpty(){
        return size == 0;
    }

    public StationNode getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.getNext();
    }

    public StationNode getLast(){
        if(isEmpty()){
            return null;
        }
        return tail.getPrevious();
    }

    public String toString(){
        if(isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("null");
        sb.append("<=>");

        StationNode current = getFirst();
        while(current != tail){
            sb.append(current.toString());
            sb.append("<=>");
            current = current.getNext();
        }
        sb.append("null");

        return sb.toString();
    }

    public void addLast(StationNode newStationNode){
        StationNode lastNode = tail.getPrevious();

        newStationNode.setNext(tail);
        newStationNode.setPrevious(lastNode);

        lastNode.setNext(newStationNode);
        tail.setPrevious(newStationNode);

        size++;
    }

    public StationNode removeLast(){
        if(isEmpty()){
            return null;
        }

        StationNode removedNode = getLast();
        StationNode secondLast = removedNode.getPrevious();

        secondLast.setNext(tail);
        tail.setPrevious(secondLast);

        removedNode.setPrevious(null);
        removedNode.setNext(null);

        size--;

        return removedNode;

    }

    public void addFirst(StationNode newStationNode){
        StationNode firstNode = head.getNext();

        newStationNode.setPrevious(head);
        newStationNode.setNext(firstNode);

        firstNode.setPrevious(newStationNode);
        head.setNext(newStationNode);

        size++;
    }

    public StationNode removeFirst(){
        if(isEmpty()){
            return null;
        }

        StationNode removedNode = getFirst();
        StationNode newFirst = removedNode.getNext();

        head.setNext(newFirst);
        newFirst.setPrevious(head);

        removedNode.setPrevious(null);
        removedNode.setNext(null);

        size--;

        return removedNode;
    }

    /**
     * Adds a new station node after the specified node in the list.
     * Precondition: the 'after' node is guaranteed to be part of this list.
     *
     * @param after the node after which the new node should be inserted
     * @param newStationNode the station node to add
     */
    public void addAfter(StationNode after, StationNode newStationNode){
        StationNode nextNode = after.getNext();

        newStationNode.setNext(nextNode);
        newStationNode.setPrevious(after);

        after.setNext(newStationNode);
        nextNode.setPrevious(newStationNode);

        size++;
    }

    /**
     * Removes the specified station node from the list.
     * Precondition: the 'removedNode' is guaranteed to be part of this list.
     * No need to check if the list is empty, as the node is guaranteed to exist in the list.
     *
     * @param removedNode the node to remove
     * @return the removed station node
     */
    public StationNode remove(StationNode removedNode){
        StationNode before = removedNode.getPrevious();
        StationNode after = removedNode.getNext();

        before.setNext(after);
        after.setPrevious(before);

        removedNode.setPrevious(null);
        removedNode.setNext(null);

        size--;
        return removedNode;
    }

    /**
     * Searches for a station node with the specified station name.
     *
     * @param stationName the name of the station to search for
     * @return the station node if found, or null if not found
     */
    public StationNode search(String stationName){
        if(isEmpty()){
            return null;
        }

        StationNode current = getFirst();
        while(current != tail){
            Station station = current.getElement();
            if(station.getName().equals(stationName)){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }


}
