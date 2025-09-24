package be.vives.ti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {
    @Test
    void str_eindigt_al_met_suffix(){
        StringProcessor stringProcessor = new StringProcessor();
        String result = stringProcessor.appendIfMissing("hello world", "world");
        assertEquals("hello world", result);
    }

    @Test
    void str_eindigt_niet_met_suffix(){
        StringProcessor stringProcessor = new StringProcessor();
        String result = stringProcessor.appendIfMissing("hello world", "!!!");
        assertEquals("hello world!!!", result);
    }
}