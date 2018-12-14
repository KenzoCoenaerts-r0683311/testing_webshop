package domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import db.*;

public class ShopService {
	private PersonDB personDb;
	private ProductDB productDb;

	public ShopService(Properties properties) {
		personDb = new PersonDbSql(properties);
		productDb = new ProductDbSql(properties);
	    //personDb = new PersonDbInMemory();
	    //productDb = new ProductDbInMemory();
	}

	// personDb methods
	public Person getPerson(String personId) {
		return getPersonDb().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonDb().getAll();
	}

	public void addPerson(Person person) {
		getPersonDb().add(person);
	}

	public void updatePersons(Person person) {
		getPersonDb().update(person);
	}

	public void deletePerson(String id) {
		getPersonDb().delete(id);
	}

	private PersonDB getPersonDb() {
		return personDb;
	}

	//productDb methods
	public Product getProduct(int productId) {
		return getProductDb().get(productId);
	}

	public List<Product> getProducts() {
		return getProductDb().getAll();
	}

	public void addProduct(Product product) {
		getProductDb().add(product);
	}

	public void updateProduct(Product product) {
		getProductDb().update(product);
	}

	public void deleteProduct(int id) {
		getProductDb().delete(id);
	}

	private ProductDB getProductDb() {
		return productDb;
	}

    public Map<Product, Integer> getCartInfo(String currentUser) {
	   Person p = personDb.get(currentUser);
	   return p.getCartInfo();
    }
}
