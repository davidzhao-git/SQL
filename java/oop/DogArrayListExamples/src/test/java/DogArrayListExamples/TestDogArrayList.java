package DogArrayListExamples;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class TestDogArrayList {
	
	@Test
	public void testNewName() {
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog(100, "Kenny"));
		dogs.add(new Dog(200, "Nick"));
		
		ArrayList<Dog> expectedDogs = new ArrayList<Dog>();
		expectedDogs.add(new Dog());
		expectedDogs.get(0).setID(100);
		expectedDogs.get(0).setName("Kenny");
		
		assertEquals(dogs.get(0).getName(), expectedDogs.get(0).getName());
	}
	
}
