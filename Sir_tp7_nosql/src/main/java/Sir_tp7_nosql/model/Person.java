package Sir_tp7_nosql.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity("person")
public class Person {
	
	@Id
	private ObjectId id;
	
	private String name;

	@Reference
	private List<Adresse> adresse;
	
	public Person(ObjectId id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.adresse = new ArrayList<Adresse>();
	}
	
	public Person() {
		super();
		this.adresse = new ArrayList<Adresse>();
	}

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the adresse
	 */
	public List<Adresse> getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(List<Adresse> adresse) {
		this.adresse = adresse;
	}
}
