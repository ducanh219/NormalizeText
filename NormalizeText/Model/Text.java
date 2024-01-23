
package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    public String normalizeText(String input) {
        String[] sentences = input.split("(?<=[.!?])\\s+");

        StringBuilder normalizedText = new StringBuilder();

        for (String sentence : sentences) {
            sentence = sentence.trim();
            if (!sentence.isEmpty()) {
                sentence = normalizeLine(sentence);
                normalizedText.append(sentence).append(" ");
            }
        }

        return normalizedText.toString().trim() + ".";
    }

    private String normalizeLine(String line) {
        line = line.replaceAll("\\s+", " ");

        line = line.replaceAll("\\s*,\\s*", ", ");
        line = line.replaceAll("\\s*\\.\\s*", ".");
        line = line.replaceAll("\\s*:\\s*", ": ");

        // Handle different quote characters and ensure proper encoding
        line = line.replaceAll("\\s*�?\\s*\"(\\S)", "\"$1");

        line = capitalizeFirstCharacter(line);

        return line;
    }

    // private String capitalizeFirstCharacter(String line) {
    //     Pattern pattern = Pattern.compile("(^|[.!?]\\s+|\"\\s+)(the|[a-z])", Pattern.CASE_INSENSITIVE);
    //     Matcher matcher = pattern.matcher(line);

    //     StringBuffer result = new StringBuffer();

    //     while (matcher.find()) {
    //         String replacement = matcher.group(1) + matcher.group(2).toLowerCase();
    //         matcher.appendReplacement(result, replacement);
    //     }

    //     matcher.appendTail(result);

    //     return result.toString();
    // }
    private String capitalizeFirstCharacter(String line) {
        Pattern pattern = Pattern.compile("(^|[.!?]\\s+|\"\\s+)(The|[a-z])");
        Matcher matcher = pattern.matcher(line);
    
        StringBuffer result = new StringBuffer();
    
        while (matcher.find()) {
            String replacement = matcher.group(1) + matcher.group(2).toLowerCase();
            matcher.appendReplacement(result, replacement);
        }
    
        matcher.appendTail(result);
    
        return result.toString();
    }
    

}
