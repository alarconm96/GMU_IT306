/*
   Marco Alarcon
   IT 306-002
   January 27, 2022
   Assignment 0
*/

package assignment0;

import java.io.*;

public class PetList {

    private static final String INPUT_FILE = "./pet_data.csv";
    private static final String OUTPUT_FILE = "./pet_report.txt";

    private static String[] petData;
    private static Pet[] pets;
    private static int numPets = 0;

    public static void main (String[] args) {
        retrievePetData();
        convertPetDataToPetObjects();
        writeOutput();
    }

    private static void retrievePetData() {
        int incrementSize = 5;
        petData = new String[incrementSize];
       
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) { 
            String line;
            while ((line = br.readLine()) != null) {
                petData[numPets] = line;
                numPets++;      
                if (numPets == petData.length) {
                    String[] tmpData = new String[petData.length + incrementSize];
                    for (int idx = 0; idx < petData.length; idx++) {
                        tmpData[idx] = petData[idx];
                    }
                    petData = tmpData;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.print(e.getClass().getName() + " ");
            System.out.println(e.getMessage());
        }
    }
    
    //custom method to check if String can become integer
    private static boolean isInteger(String in){
      try{
         Integer.parseInt(in);
         return true;
      }catch(Exception e){
         return false;
      }
    }

    private static void convertPetDataToPetObjects() {
      pets = new Pet[numPets];
      int validPets = 0;
      for(String x: petData){
            try{
               //separate each pet data element into its own array
               String[] tempArr = x.split(",");
               
               //check that data is correct length
               if(tempArr.length != 4){
                  throw new IllegalArgumentException("Malformed input line");
               }
               
               //check for null values in element
               for(String s: tempArr){
                  if(s == null || s.equals("")){
                     throw new IllegalArgumentException("Input must not contain null values");
                  }
               }
               
               //check if string tempArr[3] can be int
               if(isInteger(tempArr[3]) == false){
                  throw new NumberFormatException("Pet age must be digit");
               }
               
               //check if Cat or Dog
               switch(tempArr[0]){
                  case "Dog":
                     Dog dog = new Dog(Integer.parseInt(tempArr[3]), tempArr[2], tempArr[1]);
                     pets[validPets++] = dog;
                     break;
                  case "Cat":
                     Cat cat = new Cat(Integer.parseInt(tempArr[3]), tempArr[2], tempArr[1]);
                     pets[validPets++] = cat;
                     break;
                  default:
                     throw new IllegalArgumentException("Pet must be either Cat or Dog");
               }
            }catch(Exception e){
               System.out.print(e.getClass().getName() + " ");
               System.out.println(e.getMessage());
            }
      }
    }

    private static void writeOutput () {
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(OUTPUT_FILE)); 
            writePetObjects(pw);
            writePetStatistics(pw);
            pw.close();
        } catch (Exception e) {
            System.out.print(e.getClass().getName() + " ");
            System.out.println(e.getMessage());
        }
    }

    private static void writePetObjects (PrintWriter pw) {
        if (pets != null) {
            for (Pet aPet: pets) {
                if (aPet != null) pw.println(aPet.toString()); 
            } 
        }
    }

    private static void writePetStatistics (PrintWriter pw) {
        int numberOfCats = 0;
        int numberOfDogs = 0;
        float averageCatAge = 0.0f;
        float averageDogAge = 0.0f;
        
        int totalDogAge = 0;
        int totalCatAge = 0;
        
        //tally up cats and dogs
        for(Pet p: pets){
            if(p != null){
               switch(p.getClass().getName()){
                  case "Dog":
                     numberOfDogs++;
                     totalDogAge+= p.getAge();
                     break;
                  case "Cat":
                     numberOfCats++;
                     totalCatAge+= p.getAge();
                     break;
               }
            }
        }
        
        //ensure average is not undefined for values of 0
        if(numberOfDogs != 0){
            averageDogAge = totalDogAge / numberOfDogs;
        }
        if(numberOfCats != 0){
            averageCatAge = totalCatAge / numberOfCats;
        }

        pw.println("Number of cats: " + numberOfCats);
        pw.println("Number of dogs: " + numberOfDogs);
        pw.println("Average cat age: " + averageCatAge);
        pw.println("Average dog age: " + averageDogAge);
    }

}