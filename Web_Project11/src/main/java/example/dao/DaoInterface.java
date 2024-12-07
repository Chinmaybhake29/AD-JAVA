package example.dao;

import java.util.Collection;

public interface DaoInterface<t,k> {
		//A method to retrieve all record
	Collection<t>retrieveAll();
	
	//A method to retrieve a single record based upon its Identity
	
	t retrieveOne(k key);
	
	//A method to insert a new record
	void create(t t);
	
	//A method to update the record
	void update(t t1);
	
	//A method to delete the record
	void delete(k key);
	
	
}
