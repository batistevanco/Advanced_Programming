package be.vives.ti.doubly;

import be.vives.ti.domain.Station;

public class StationNode {

    private final Station element;
    private StationNode previous;
    private StationNode next;

    public StationNode(Station station, StationNode previous, StationNode next) {
        this.element = station;
        this.previous = previous;
        this.next = next;
    }

    public StationNode(Station station) {
        this.element = station;
    }

    public Station getElement() {
        return element;
    }

    public StationNode getPrevious() {
        return previous;
    }

    public void setPrevious(StationNode previous) {
        this.previous = previous;
    }

    public StationNode getNext() {
        return next;
    }

    public void setNext(StationNode next) {
        this.next = next;
    }

    public String toString(){
        return element.toString();
    }
}
