/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.mtp.i4.controller;

import epsi.mtp.i4.models.Attribute;
import epsi.mtp.i4.models.Question;
import epsi.mtp.i4.models.Character;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author mehdi <your.name at your.org>
 */
public final class CSVController {

    private List<Question> loadedQuestions = new ArrayList<>();
    private List<Character> loadedCharacters = new ArrayList<>();
    private static final String CSVPath = "src//epsi//mtp//i4//data//knowledge_base_questions.csv";

    public CSVController() {

        this.loadQuestions(CSVPath, ',');
        this.loadCharacters(CSVPath, ',');
    }

    public Question fetchFirstQuestion() {
        return loadedQuestions.get(new Random().nextInt(loadedQuestions.size()));
    }

    public CSVParser readCSVFile(String path, char delimiter) {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(delimiter).withQuote(null);
        CSVParser parser = null;
        try {
            parser = new CSVParser(new FileReader(path), format);
        } catch (IOException ex) {
            Logger.getLogger(CSVController.class.getName()).log(Level.SEVERE, "can't read CSV file", ex);
        }
        return parser;
    }

    public void loadQuestions(String path, char delimiter) {
        CSVParser dataParser = readCSVFile(path, delimiter);
        Map<String, Integer> headersToLoad = new HashMap<>();
        headersToLoad = dataParser.getHeaderMap();
        for (String headerToLoad : headersToLoad.keySet()) {
            loadedQuestions.add(new Question(headerToLoad));
        }

        try {
            dataParser.close();
        } catch (IOException ex) {
            Logger.getLogger(CSVController.class.getName()).log(Level.SEVERE, "can't close parser", ex);
        }
    }

    public void loadCharacters(String path, char delimiter) {
        CSVParser dataParser = readCSVFile(path, delimiter);
        List<CSVRecord> charactersToLoad = new ArrayList<>();
        try {
            charactersToLoad = dataParser.getRecords();
        } catch (IOException ex) {
            Logger.getLogger(CSVController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (CSVRecord record : charactersToLoad) {
            Character c = new Character(record.get("Personnage"));
            for(Question q : loadedQuestions){
                c.addAttribute(new Attribute(q,record.get(q.getText()).equals("Oui")));
            }
            
            loadedCharacters.add(c);
        }

        try {
            dataParser.close();
        } catch (IOException ex) {
            Logger.getLogger(CSVController.class.getName()).log(Level.SEVERE, "can't close parser", ex);
        }
    }
}
