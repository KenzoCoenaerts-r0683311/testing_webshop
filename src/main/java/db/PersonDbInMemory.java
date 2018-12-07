package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;

public class PersonDbInMemory implements PersonDB {
	private Map<String, Person> persons = new HashMap<String, Person>();
    int i = 1;
	public PersonDbInMemory () { }
	
	public Person get(String personId){
		if(personId == null){
			throw new DbException("No id given");
		}

		return persons.get(personId);
	}
	
	public List<Person> getAll(){
		return new ArrayList<>(persons.values());
	}

	public void add(Person person){
		if(person == null){
			throw new DbException("No person given");
		}

		if (persons.containsKey(person.getUserid())) {
			throw new DbException("User already exists");
		}

		person.setUserid(String.valueOf(i));
		i++;

        persons.put(person.getUserid(), person);
	}
	
	public void update(Person person){
		if(person == null){
			throw new DbException("No person given");
		}
		if(!persons.containsKey(person.getUserid())){
			throw new DbException("No person found");
		}
		persons.put(person.getUserid(), person);
	}
	
	public void delete(String personId){
		if(personId == null){
			throw new DbException("No id given");
		}
		persons.remove(personId);
	}
}
