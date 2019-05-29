package DogArrayListExamples;

import java.util.*;

public class Dog {
	
	private int id;
	private String name;
	
	Dog(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	Dog() {
		this.id = -1;
		this.name = "";
	}
	
	// return a dog object
	public static Dog newInstance(Dog dog) {
		return new Dog(dog.id, dog.name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Dog[id] " + id + " ,Dog[name] " + name;
	}
	
	public boolean equals(Dog otherDog) {
		System.out.println("Calling equals(Dog otherDog)...");
		if (otherDog != null && id == otherDog.id && name == otherDog.name) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
