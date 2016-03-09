package Sir_tp7_nosql.model;

import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;
import org.bson.types.ObjectId;

@Entity("article")
public class Article {
	
	@Id
	private ObjectId id;
	
	private String name;
	
	private int stars;
	
	@Reference
	private List<Person> buyers;

	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param stars
	 */
	public Article(ObjectId id, String name, int stars) {
		super();
		this.id = id;
		this.name = name;
		this.stars = stars;
		this.buyers = new ArrayList<Person>();
	}
	/**
	 * Constructor
	 */
	public Article() {
		super();
		this.buyers = new ArrayList<Person>();
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
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * @param stars the stars to set
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}

	/**
	 * @return the buyers
	 */
	public List<Person> getBuyers() {
		return buyers;
	}

	/**
	 * @param buyers the buyers to set
	 */
	public void setBuyers(List<Person> buyers) {
		this.buyers = buyers;
	}
	
	
	
}
