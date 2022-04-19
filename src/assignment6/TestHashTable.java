package assignment6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestHashTable {
    public static void main(String[] args) {    	
    	final int CAPACITY = 37;
        HashTable HT = new HashTable(CAPACITY);
    	
    	//read from csv file
    	try {
			File file = new File("HashTable.csv");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split(",");
				
				//get rid of byte order mark (BOM) on UTF-8 csv file
				if (line[0].length() > 1) {
					line[0] = line[0].substring(line[0].length()-1);
				}
				
				//query HashTable depending on command
				switch (line[0]) {
				case "I":
					try {
						String inserted = HT.tableInsert(line[1], String.format("Name: %s %s || Dept: %s || GPA: %s", line[2], line[3], line[4], line[5]));
						System.out.printf("Element %s inserted%n", inserted);
					} catch (IllegalStateException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "S":
					String searched = HT.tableSearch(line[1]);
					if (searched != null) {
						System.out.printf("Element %s found%n", searched);
					}else {
						System.out.printf("Element %s was NOT found%n", line[1]);
					}
					break;
				case "R":
					try {
						String removed = HT.tableRemove(line[1]);
						System.out.printf("Element %s removed%n", removed);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
				default:
					throw new IllegalArgumentException("Unexpected query: " + line[0]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}   
    	
    	//print HashTable
    	System.out.println("");
    	HT.tablePrint();
    }

}
