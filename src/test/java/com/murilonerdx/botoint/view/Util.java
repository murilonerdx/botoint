package com.murilonerdx.botoint.view;

import com.murilonerdx.botoint.model.Ponto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Util {

    final static String PATH_INTERN = "src/test/resources/";
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                PATH_INTERN + "system.config");
        props.load(file);
        return props;
    }

    public static String getTimeNow() {
        return LocalDateTime.now().format(formatter);
    }

    public static void writter(Ponto ponto) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_INTERN + "pointer-log.txt", true))) {
            String content = ponto.toString();
            bw.write(content);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            BufferedReader br = new BufferedReader(new FileReader(PATH_INTERN + "pointer-log.txt"));
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        }
    }
}
