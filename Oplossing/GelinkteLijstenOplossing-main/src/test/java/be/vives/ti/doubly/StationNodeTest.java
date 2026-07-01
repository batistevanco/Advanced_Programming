package be.vives.ti.doubly;

import be.vives.ti.domain.Station;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StationNodeTest {

    private StationNode stationNode;

    @BeforeEach
    void setUp() {
        stationNode = new StationNode(new Station("Kortrijk"));
    }

    @Test
    void stationNodeToString() {
        assertThat(stationNode.toString()).isEqualTo("Kortrijk");
    }

    @Test
    void getElementFromNode() {
        Station station = stationNode.getElement();
        assertThat(station.getName()).isEqualTo("Kortrijk");
    }
}