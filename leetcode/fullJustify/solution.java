package java.leetcode.fullJustify;

import java.util.ArrayList;
import java.util.List;

public class solution {

    // Text Justification
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int i = 0;
        int len = 0;

        while (i < words.length) {
            if (len + line.size() + words[i].length() > maxWidth) {
                int extraSpace = maxWidth - len;

                StringBuilder sb = new StringBuilder();
                if (line.size() == 1) {
                    // Ako red ima samo jednu reč, dodaj sve razmake posle nje
                    sb.append(line.get(0)).append(" ".repeat(extraSpace));
                } else {
                    int space = extraSpace / (line.size() - 1);
                    int remainder = extraSpace % (line.size() - 1);

                    for (int j = 0; j < line.size(); j++) {
                        sb.append(line.get(j));
                        if (j < line.size() - 1) {
                            sb.append(" ".repeat(space));
                            if (remainder > 0) {
                                sb.append(" ");
                                remainder--;
                            }
                        }
                    }
                }

                result.add(sb.toString());
                line = new ArrayList<>();
                len = 0;
            }
            line.add(words[i]);
            len += words[i].length();
            i++;
        }

        // Poslednji red - levo poravnanje
        String lastLine = String.join(" ", line);
        result.add(lastLine + " ".repeat(maxWidth - lastLine.length()));

        return result;
    }
}
