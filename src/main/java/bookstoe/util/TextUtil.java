
package bookstoe.util;

public class TextUtil {

    public String sanitize(String textToSanitize) {
        return textToSanitize.replaceAll("\\s+", " ");
    }
    
}
