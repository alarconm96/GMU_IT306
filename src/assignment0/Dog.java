/*
   Marco Alarcon
   IT 306-002
   January 28, 2022
   Assignment 0
*/

package assignment0;

public class Dog extends Pet{
   //super constructor call
   public Dog(int age, String color, String name){
      super(age, color, name);
   }
   
   //overridden speak() method
   public String speak(){return "woof";}
}