package be.vives.ti.doubly;

import be.vives.ti.domain.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DoublyLinkedStationListTest {

    private DoublyLinkedStationList list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedStationList();
    }

    private StationNode createStationNode(String stationName){
        return new StationNode(new Station(stationName));
    }

    @Test
    void addLastEmptyList() {
        list.addLast(createStationNode("Kortrijk"));
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>null");
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
        assertThat(list.getLast().toString()).isEqualTo("Kortrijk");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void addLastMultipleStations() {
        list.addLast(createStationNode("Kortrijk"));
        list.addLast(createStationNode("Roeselare"));
        list.addLast(createStationNode("Brugge"));
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>Roeselare<=>Brugge<=>null");
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
        assertThat(list.getLast().toString()).isEqualTo("Brugge");
        assertThat(list.getSize()).isEqualTo(3);
    }

    @Test
    void addAfter() {
        list.addLast(createStationNode("Kortrijk"));
        StationNode roeselare = createStationNode("Roeselare");
        list.addLast(roeselare);
        list.addLast(createStationNode("Torhout"));
        list.addLast(createStationNode("Brugge"));
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>Roeselare<=>Torhout<=>Brugge<=>null");
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
        assertThat(list.getLast().toString()).isEqualTo("Brugge");

        list.addAfter(roeselare, createStationNode("Lichtervelde"));
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>Roeselare<=>Lichtervelde<=>Torhout<=>Brugge<=>null");
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
        assertThat(list.getLast().toString()).isEqualTo("Brugge");
        assertThat(list.getSize()).isEqualTo(5);
    }

    @Test
    void remove() {
        list.addLast(createStationNode("Kortrijk"));
        StationNode roeselare = createStationNode("Roeselare");
        list.addLast(roeselare);
        list.addLast(createStationNode("Torhout"));
        list.addLast(createStationNode("Brugge"));
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>Roeselare<=>Torhout<=>Brugge<=>null");
        assertThat(list.getSize()).isEqualTo(4);

        StationNode removedRoeselare = list.remove(roeselare);
        assertThat(removedRoeselare.toString()).isEqualTo("Roeselare");
        assertThat(removedRoeselare.getNext()).isNull();
        assertThat(removedRoeselare.getPrevious()).isNull();

        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>Torhout<=>Brugge<=>null");
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
        assertThat(list.getLast().toString()).isEqualTo("Brugge");
        assertThat(list.getSize()).isEqualTo(3);
    }

    @Test
    void removeOnlyOneLeft() {
        StationNode kortrijk = createStationNode("Kortrijk");
        list.addLast(kortrijk);
        assertThat(list.getSize()).isEqualTo(1);
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>null");

        StationNode removedKortrijk = list.remove(kortrijk);
        assertThat(removedKortrijk.toString()).isEqualTo("Kortrijk");
        assertThat(removedKortrijk.getNext()).isNull();
        assertThat(removedKortrijk.getPrevious()).isNull();
        assertThat(list.toString()).isEqualTo("");
        assertThat(list.getFirst()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void getFirstInEmptyList() {
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void getFirstInListWithOneElement() {
        StationNode kortrijk = createStationNode("null<=>Kortrijk");
        list.addLast(kortrijk);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getFirst()).isEqualTo(kortrijk);
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void getFirstInList() {
        list.addLast(createStationNode("Kortrijk"));
        list.addLast(createStationNode("Roeselare"));
        list.addLast(createStationNode("Torhout"));
        list.addLast(createStationNode("Brugge"));
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
    }

    @Test
    void getLastInEmptyList() {
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.getLast()).isNull();
    }

    @Test
    void getLastInListWithOneElement() {
        StationNode kortrijk = createStationNode("Kortrijk");
        list.addLast(kortrijk);
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getFirst()).isEqualTo(kortrijk);
    }

    @Test
    void getLastInList() {
        list.addLast(createStationNode("Kortrijk"));
        list.addLast(createStationNode("Roeselare"));
        list.addLast(createStationNode("Torhout"));
        list.addLast(createStationNode("Brugge"));
        assertThat(list.isEmpty()).isFalse();
        assertThat(list.getLast().toString()).isEqualTo("Brugge");
    }

    @Test
    void addFirstEmptyList() {
        list.addFirst(createStationNode("Kortrijk"));
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>null");
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
        assertThat(list.getLast().toString()).isEqualTo("Kortrijk");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void addFirstMultipleStations() {
        list.addFirst(createStationNode("Kortrijk"));
        list.addFirst(createStationNode("Roeselare"));
        list.addFirst(createStationNode("Brugge"));
        assertThat(list.toString()).isEqualTo("null<=>Brugge<=>Roeselare<=>Kortrijk<=>null");
        assertThat(list.getFirst().toString()).isEqualTo("Brugge");
        assertThat(list.getLast().toString()).isEqualTo("Kortrijk");
        assertThat(list.getSize()).isEqualTo(3);
    }

    @Test
    void removeFirstMultipleStations() {
        list.addFirst(createStationNode("Kortrijk"));
        list.addFirst(createStationNode("Roeselare"));
        list.addFirst(createStationNode("Brugge"));
        assertThat(list.toString()).isEqualTo("null<=>Brugge<=>Roeselare<=>Kortrijk<=>null");
        assertThat(list.getSize()).isEqualTo(3);

        StationNode removedBrugge = list.removeFirst();
        assertThat(removedBrugge.toString()).isEqualTo("Brugge");
        assertThat(removedBrugge.getNext()).isNull();
        assertThat(removedBrugge.getPrevious()).isNull();
        assertThat(list.getLast().toString()).isEqualTo("Kortrijk");
        assertThat(list.getFirst().toString()).isEqualTo("Roeselare");
        assertThat(list.toString()).isEqualTo("null<=>Roeselare<=>Kortrijk<=>null");
        assertThat(list.getSize()).isEqualTo(2);

        StationNode removedRoeselare = list.removeFirst();
        assertThat(removedRoeselare.toString()).isEqualTo("Roeselare");
        assertThat(removedRoeselare.getNext()).isNull();
        assertThat(removedRoeselare.getPrevious()).isNull();
        assertThat(list.getLast().toString()).isEqualTo("Kortrijk");
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>null");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void removeFirstOneLeft() {
        list.addFirst(createStationNode("Kortrijk"));
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>null");

        StationNode removedKortrijk = list.removeFirst();
        assertThat(removedKortrijk.toString()).isEqualTo("Kortrijk");
        assertThat(removedKortrijk.getNext()).isNull();
        assertThat(removedKortrijk.getPrevious()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getFirst()).isNull();
        assertThat(list.toString()).isEqualTo("");
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void removeFirstEmptyList() {
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.removeFirst()).isNull();
        assertThat(list.toString()).isEqualTo("");
        assertThat(list.getLast()).isNull();
        assertThat(list.getFirst()).isNull();
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void searchEmptyList() {
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.search("Kortrijk")).isNull();
    }

    @Test
    void searchGevonden() {
        list.addFirst(createStationNode("Kortrijk"));
        list.addFirst(createStationNode("Roeselare"));
        list.addFirst(createStationNode("Brugge"));
        StationNode gevondenStationNode = list.search("Kortrijk");
        assertThat(gevondenStationNode.toString()).isEqualTo("Kortrijk");
    }

    @Test
    void searchNietGevonden() {
        list.addFirst(createStationNode("Kortrijk"));
        list.addFirst(createStationNode("Roeselare"));
        list.addFirst(createStationNode("Brugge"));
        StationNode gevondenStationNode = list.search("Oostende");
        assertThat(gevondenStationNode).isNull();
    }

    @Test
    void removeLastMultipleStations() {
        list.addLast(createStationNode("Kortrijk"));
        list.addLast(createStationNode("Roeselare"));
        list.addLast(createStationNode("Brugge"));
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>Roeselare<=>Brugge<=>null");
        assertThat(list.getSize()).isEqualTo(3);

        StationNode removedBrugge = list.removeLast();
        assertThat(removedBrugge.toString()).isEqualTo("Brugge");
        assertThat(removedBrugge.getNext()).isNull();
        assertThat(removedBrugge.getPrevious()).isNull();
        assertThat(list.getLast().toString()).isEqualTo("Roeselare");
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>Roeselare<=>null");
        assertThat(list.getSize()).isEqualTo(2);

        StationNode removedRoeselare = list.removeLast();
        assertThat(removedRoeselare.toString()).isEqualTo("Roeselare");
        assertThat(removedRoeselare.getNext()).isNull();
        assertThat(removedRoeselare.getPrevious()).isNull();
        assertThat(list.getLast().toString()).isEqualTo("Kortrijk");
        assertThat(list.getFirst().toString()).isEqualTo("Kortrijk");
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>null");
        assertThat(list.getSize()).isEqualTo(1);
    }

    @Test
    void removeLastOneLeft() {
        list.addLast(createStationNode("Kortrijk"));
        assertThat(list.toString()).isEqualTo("null<=>Kortrijk<=>null");
        assertThat(list.getSize()).isEqualTo(1);

        StationNode removedKortrijk = list.removeLast();
        assertThat(removedKortrijk.toString()).isEqualTo("Kortrijk");
        assertThat(removedKortrijk.getNext()).isNull();
        assertThat(removedKortrijk.getPrevious()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getFirst()).isNull();
        assertThat(list.toString()).isEqualTo("");
        assertThat(list.getSize()).isEqualTo(0);
    }

    @Test
    void removeLastEmptyList() {
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.removeLast()).isNull();
        assertThat(list.getLast()).isNull();
        assertThat(list.getFirst()).isNull();
        assertThat(list.toString()).isEqualTo("");
        assertThat(list.getSize()).isEqualTo(0);
    }

}