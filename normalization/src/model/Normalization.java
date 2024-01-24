/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public final class Normalization {

    private String input;

    public Normalization() {
        readFile("string.txt");
    }

    public String getInput() {
        return input.trim();
    }

    public void readFile(String file) {
        StringBuilder sb = new StringBuilder();
        try ( Scanner reader = new Scanner(new File(file))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                sb.append(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        input = sb.toString().trim();
    }

    public void saveFile(String file) throws IOException {
        try ( FileWriter f = new FileWriter(new File(file))) {
            f.write(input);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void normalizeInput() {// a, b, c
        
        input = input.replaceAll("\\s+", " ").toLowerCase();
        input = handleDot(input);
        input = handleCommaAndColon(input);
        input = handleQuotes(input);
    }

    private String handleDot(String text) {
        String[] words = text.split("\\s*\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                words[0] = Character.toUpperCase(words[0].charAt(0)) + words[0].substring(1);
            } else {
                if (!words[i].matches("\\s*")) {

                    words[i] = toUpper(words[i]);
                }
            }
            sb.append(words[i].trim());
            sb.append(". ");

        }
        return sb.toString();
    }

    private String handleCommaAndColon(String text) {
        return text.replaceAll("\\s*[,:]\\s*", ", ");
    }

    private String handleQuotes(String text) {
        return text.replaceAll("\\s*\"\\s*", "\"");
    }

    private String toUpper(String word) {
        return Character.toUpperCase(word.charAt(1)) + word.substring(2);
    }


}
