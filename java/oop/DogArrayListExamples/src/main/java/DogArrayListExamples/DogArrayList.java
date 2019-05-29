package DogArrayListExamples;

import java.util.*;

public class DogArrayList {
	
	public static void main(String[] args) {
		
		DogArrayList dogArrayList = new DogArrayList();
		
		// create dog array list
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		
		// create dog objects and add them into the array list 
		dogs.add(new Dog(1, "Larry"));
		dogs.add(new Dog(2, "Bob"));
		
		// iterate through the Array List 
		System.out.println("Print out the dogs:");
		dogArrayList.printDog(dogs);
		
		// use ArrayList's constructor to make shallow copy
		ArrayList<Dog> shallowCopyDogs = new ArrayList<Dog>(dogs);
		dogArrayList.printDog(shallowCopyDogs);
		
		System.out.println("checking to see if you make shallow copy");
		Dog larry = dogs.get(0);		
		larry.setName("Larry Larry");	
		System.out.println("Print out dogs:");
		dogArrayList.printDog(dogs);		// "Larry Larry"
		System.out.println("Print out shallow copy dogs:");
		dogArrayList.printDog(shallowCopyDogs); // shallow copy "Larry Larry"
		
		ArrayList<Dog> deepCopyDogs = dogArrayList.makeDeepCopy(dogs);
		System.out.println("checking to see if you make deep copy");
		Dog bob = dogs.get(1);
		bob.setName("Bob Bob");
		System.out.println("Print out dogs:");
		dogArrayList.printDog(dogs);			// "Bob Bob"
		System.out.println("Print out deep copy dogs:");
		dogArrayList.printDog(deepCopyDogs);	// deep copy "Bob"

	}
	
	private void printDog(ArrayList<Dog> dogs) {
		
		for(Dog dog : dogs) {
			System.out.println(dog.toString());
		}
	}
	
	private ArrayList<Dog> makeDeepCopy(ArrayList<Dog> dogs) {
		ArrayList<Dog> deepCopyDogs = new ArrayList<Dog>();
		for(Dog dog : dogs) {
			deepCopyDogs.add(Dog.newInstance(dog));
		}
		return deepCopyDogs;
	}
	
	
	
}