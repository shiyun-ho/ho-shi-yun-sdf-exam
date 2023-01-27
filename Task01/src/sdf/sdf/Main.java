package sdf;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main{

    //need to fix input when compiling !!!!
    //entry point for the program
    public static void main(String[] args) throws IOException {
        //creates data structure hashmap to store data, where key is the word and value is the number of occurrence (double is used as the term frequency uses double)
        HashMap<String, Double> mapOfTf = new HashMap<String, Double>();
        
        //need to prompt user for input; do remember to address it later
        // Prints the welcome message
        System.out.println("Welcome to your term-frequency calculator!");
        
        //require a console object to read input from the command line
        Console console = System.console();
        //empty string to store items within userinput
        String userinput = console.readLine("Enter your file name (without directory path and .txt extension): >>>");
        
        //reads the data
        Reader r = new FileReader(userinput + ".txt");

        //try catch thrown to account for exceptions
        try (BufferedReader br = new BufferedReader(r)) {
            //store the txt into string
            String input = br.readLine();
            //declare variable d as total word count to help calculation later
            int dtotalWordCount = 0;

            //while loop to loop through the entire text file
            while (null != (input = br.readLine())){
                //convert the input to lower case 
                input = input.toLowerCase();
                //trim spaces 
                input = input.trim(); 
                //if line is empty, discard
                if (input.length() <= 0){
                    continue;
                }

                //replaces the non word character with space, and split the text when puncutation is seen
                String[] lines = input.replaceFirst("^\\W+", "").split("([.,!?:;'\"-]|\\s)+");

                //for loop to loop through each word in lines to place it in word and freq (key  value pairs) and to calculate word count
                for (int i = 0; i < lines.length; i++) {
                    //word is represented by each element of String[] lines
                    String word = lines[i];
                    //if hashmap contains word
                    if(mapOfTf.containsKey(word)) {
                        mapOfTf.put(word, mapOfTf.get(word)+1);
                    } else {
                        mapOfTf.put(word, 1.0);
                    } 
                    dtotalWordCount = dtotalWordCount + 1;
                }
                
            }
            //print to test if map works
                //System.out.println(">>>Hashmap before sorting: \n" + mapOfTf + "\n \n");
                //System.out.println("The word count is: " + dtotalWordCount + "\n \n");

            //for loop to place word and term-frequency in hashmap
            for (Entry<String, Double> entry : mapOfTf.entrySet()) {
                String word = entry.getKey();
                Double count = entry.getValue();
                double frequency = count / dtotalWordCount;
                mapOfTf.put(word, frequency);
            }
        } 
            

        //sort the map by value by calling method sortByValue
            mapOfTf = sortByValue(mapOfTf);

        //check hashmap after sorting
            //System.out.println(">>>Hashmap after sorting: \n");

        // get the first 10 values of the sorted HashMap
        Map<String, Double> topTen = new LinkedHashMap<>();
        int counter = 0;
        for (Entry<String, Double> entry : mapOfTf.entrySet()) {
            topTen.put(entry.getKey(), entry.getValue());
            counter++;
            if (counter >= 10) {
                break;
            }
        }

        // print out the top 10 values
        System.out.println("\n \nTop 10 words with highest frequency (i.e. Term Frequency): ");
        for (Map.Entry<String, Double> entry : topTen.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
            
    }

    //method to sort Hashmap by values
    public static HashMap<String, Double> sortByValue(HashMap<String, Double> mapOfTf){
        //creates list from elements of hashmap
        List<Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(mapOfTf.entrySet());
       
        //sorting list through lambda expression
        Collections.sort(list, (i1,i2) -> i2.getValue().compareTo(i1.getValue()));
        
        // put data from sorted list to hashmap
        //creates new hashmap 
        HashMap<String, Double> newSorted= new LinkedHashMap<String, Double>();
        for (int i = 0; i< list.size(); i++){
            Map.Entry<String, Double> entry = list.get(i);
            newSorted.put(entry.getKey(), entry.getValue());
        }
        return newSorted;


    }
    }

            

            

        
    

