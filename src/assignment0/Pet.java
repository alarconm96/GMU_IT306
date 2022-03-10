/*
   Marco Alarcon
   IT 306-002
   January 28, 2022
   Assignment 0
*/

package assignment0;

public abstract class Pet {
   //vars
   private int petID;
   private int age;
   private String color;
   private String name;
   private int numPets = 0;
   
   //constructor
   public Pet(int age, String color, String name){
      if(age <= 0){
         throw new IllegalArgumentException("Pet age must be non-negative value");
      }
      if(color == null || color.equals("")){
         throw new IllegalArgumentException("Pet color must be provided");
      }
      if(name == null || name.equals("")){
         throw new IllegalArgumentException("Pet name must be provided");
      }
      
      this.numPets++;
      this.petID = this.numPets;
      this.age = age;
      this.color = color;
      this.name = name;
   }
   
   //GET METHODS
   
   public int getPetID(){return this.petID;}
   public int getAge(){return this.age;}
   public String getColor(){return this.color;}
   public String getName(){return this.name;}
   
   
   //SET METHODS
   
   public void setAge(int age){
      if(age <= 0){
         throw new IllegalArgumentException("Pet age must be non-negative value");
      }
      this.age = age;
   }
   
   public void setColor(String color){
      if(color == null || color.equals("")){
         throw new IllegalArgumentException("Pet color must be provided");
      }
      this.color = color;
   }
   
   public void setName(String name){
      if(name == null || name.equals("")){
         throw new IllegalArgumentException("Pet name must be provided");
      }
      this.name = name;
   }
   
   //SPECIAL METHODS
   
   //abstract speak()
   public abstract String speak();
   
   //overridden toString()
   public String toString(){
      return String.format("Pet ID: %d, Name: %s, Type: %s, Color: %s, Age: %d, Sound: %s%n", getPetID(), getName(), getClass().getName(), getColor(), getAge(), speak());
   }
   
   //overridden equals()
   public boolean equals(Object o){
      if(this == o){
         return true;
      }
      if(o == null || getClass() != o.getClass()){
         return false;
      }
      Pet pet = (Pet) o;
      return this.getPetID() == pet.getPetID();
   }
}