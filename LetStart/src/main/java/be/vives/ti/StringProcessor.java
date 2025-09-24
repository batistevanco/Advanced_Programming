package be.vives.ti;

import org.apache.commons.lang3.Strings;

public class StringProcessor {
    public String appendIfMissing(String str, String suffix){
        return Strings.CI.appendIfMissing(str,suffix);
    }

}
