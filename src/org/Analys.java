package org;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Analys {

    private Scanner scan = new Scanner(System.in);
    private String maxString = new String("");
    private int maxLength = 0;

    public void TheAnalysisOfSupply(){
        System.out.println("Введите название файла с текстом");
        String FileName = ".\\doc\\" + scan.nextLine() + ".txt";
        ArrayList<String> alfabet = new ArrayList<>();

        try{
            Path filePath = Paths.get(FileName);
            List<String> lines = new ArrayList<>();
            lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for (String strLine: lines) {
                String result = strLine.replaceAll("[\\-\\+\\.\\^:,\\(\\)\\ \\!\\?]","").toUpperCase();
                for(int i = 0;i<result.length();i++) {
                    if(!alfabet.contains(Character.toString(result.charAt(i)))){
                        alfabet.add(Character.toString(result.charAt(i)));
                    }
                }
                if(maxLength<alfabet.size()){
                    maxString = strLine;
                    maxLength = alfabet.size();
                }
                alfabet.clear();
            }
        }
        catch(IOException e){
            System.out.println("Ошибка");
        }
    }

    public void ComparisonWithPangrams(){

        try{
            ArrayList<String> alfabet = new ArrayList<>();
            System.out.println("Предложение '" + maxString + "' из Текста существует, с " + maxLength + " уникальных символов.");
            Path filePath = Paths.get(".\\doc\\Pangrams.txt");
            List<String> lines = new ArrayList<>();
            lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for(String strLine: lines) {
                String result = strLine.replaceAll("[\\-\\+\\.\\^:,\\(\\)\\ \\!\\?]","").toUpperCase();
                for(int i = 0;i<result.length();i++) {
                    if(!alfabet.contains(Character.toString(result.charAt(i)))){
                        alfabet.add(Character.toString(result.charAt(i)));
                    }
                }
                System.out.println("Панграмма '" + strLine + "' самое большое, с " + alfabet.size() + " уникальных символов." );
                alfabet.clear();
            }
        }
        catch(IOException e){
            System.out.println("Ошибка");
        }
    }
}