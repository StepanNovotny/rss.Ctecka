package com.ctecka.rss.Ctecka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@RestController
public class MainController {

    //localhost:8080/read/history
    //localhost:8080/read/romantic
    //localhost:8080/read/scifi
    @GetMapping("read/{fileName}")

        public String readText(@PathVariable String fileName) {
        StringBuilder text = new StringBuilder();
        try (Scanner scanner = new Scanner(
                new BufferedReader(new FileReader("src/" + fileName + ".txt", StandardCharsets.UTF_8)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                text.append(line);
            }
        } catch (IOException e) {
            return e.toString();
        }
        return text.toString();
    }

}
