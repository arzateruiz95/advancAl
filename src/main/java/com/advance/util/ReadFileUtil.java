package com.advance.util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class ReadFileUtil {
    private static final String SPACE = "\\s";
    private static String fileName;


    public ReadFileUtil(String fileName) {
        this.fileName = fileName;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> extractFile() throws IOException {
        List lines = Files.readAllLines(Paths.get(fileName));
        return lines;
    }

    public String extractString(Integer linePosition) throws IOException {
        return extractFile().get(linePosition);
    }

    public Integer extractInteger(Integer linePosition) throws IOException {
        return Integer.parseInt(extractFile().get(linePosition));
    }

    public String[] extractStringArray(Integer linePosition) throws IOException {
        return extractFile().get(linePosition).split(SPACE);
    }

    public <T> T[] extractNumberArray(Integer linePosition, Class<T> clazz) throws IOException {
        String[] charLine = extractFile().get(linePosition).split(SPACE);
        T[] res = (T[]) Array.newInstance(clazz, charLine.length);
        int count = 0;
        for (String c : charLine) {
            if (clazz == (Integer.class)) {
                res[count] = clazz.cast(Integer.parseInt(c));
            } else if (clazz == (Double.class)) {
                res[count] = clazz.cast(Double.parseDouble(c));
            } else if (clazz == (Long.class)) {
                res[count] = clazz.cast(Long.parseLong(c));
            } else if (clazz == (Float.class)) {
                res[count] = clazz.cast(Float.parseFloat(c));
            }
            count++;
        }
        return res;
    }

    public <T> T[][] extractNumberSquare(Class<T> clazz) throws IOException {
        List<String> lines = extractFile();
        String[] charLine;
        T[][] res = (T[][]) Array.newInstance(clazz, lines.get(0).split(SPACE).length, lines.size());
        for (int i = 0; i < lines.size(); i++) {
            charLine = lines.get(i).split(SPACE);
            for (int j = 0; j < charLine.length; j++) {
                if (clazz == (Integer.class)) {
                    res[i][j] = clazz.cast(Integer.parseInt(charLine[j]));
                } else if (clazz == (Double.class)) {
                    res[i][j] = clazz.cast(Double.parseDouble(charLine[j]));
                } else if (clazz == (Long.class)) {
                    res[i][j] = clazz.cast(Long.parseLong(charLine[j]));
                } else if (clazz == (Float.class)) {
                    res[i][j] = clazz.cast(Float.parseFloat(charLine[j]));
                }
            }
        }
        return res;
    }

}
