package Sir_tp7_nosql.Sir_tp7_nosql;

import java.net.UnknownHostException;

import Sir_tp7_nosql.model.Article;
import Sir_tp7_nosql.model.Person;
import Sir_tp7_nosql.model.Adresse;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws UnknownHostException
	{
		//Création de morphia et d'un objet qui représente MongoDB
		Morphia morphia = new Morphia();    
	    //Mongo mongo = new Mongo();
	    
	    
	    morphia.map(Person.class).map(Adresse.class);
	    Datastore ds = morphia.createDatastore(new MongoClient(), "my_database");
	    
	    //Create person
	    Person p1 = new Person();
	    p1.setName("Marc");
	    
	    Person p2 = new Person();
	    p2.setName("Luc");
	    
	    Person p3 = new Person();
	    p3.setName("Robert");
	    
	    Person p4 = new Person();
	    p4.setName("Marcel");
	    
	    Person p5 = new Person();
	    p5.setName("Mohamed");
	    
	    Person p6 = new Person();
	    p6.setName("Benoit");
	    
	    Person p7 = new Person();
	    p7.setName("Bruce");
	
	    //Create adress
	    Adresse address1 = new Adresse();
	    address1.setStreet("12 rue quelquepart");
	    address1.setCity("Nantes");
	    address1.setPostCode("44000");
	    address1.setCountry("France");
	    
	    Adresse address2 = new Adresse();
	    address2.setStreet("13 rue DelaChance");
	    address2.setCity("Rennes");
	    address2.setPostCode("35000");
	    address2.setCountry("France");
	    
	    Adresse address3 = new Adresse();
	    address3.setStreet("11 rue SabreReligieux");
	    address3.setCity("SeifCity");
	    address3.setPostCode("98700");
	    address3.setCountry("Tunisie");
	    
	    Adresse address4 = new Adresse();
	    address4.setStreet("14 rue DeLaSoif");
	    address4.setCity("Rennes");
	    address4.setPostCode("3500");
	    address4.setCountry("France");
	    
	    //Save adresse
	    ds.save(address1); //Sauvegarde dans mongoDB
	    ds.save(address2); //Sauvegarde dans mongoDB
	    ds.save(address3); //Sauvegarde dans mongoDB
	    ds.save(address4); //Sauvegarde dans mongoDB
	    
	    //set address for person
	    p1.getAdresse().add(address1);
	    p2.getAdresse().add(address2);
	    p3.getAdresse().add(address2);
	    p4.getAdresse().add(address2);
	    p5.getAdresse().add(address3);
	    p6.getAdresse().add(address3);
	    p7.getAdresse().add(address4);
	    // Save person
	    ds.save(p1); //Sauvegarde dans mongoDB
	    ds.save(p2);
	    ds.save(p3);
	    ds.save(p4);
	    ds.save(p5);
	    ds.save(p6);
	    ds.save(p7);
	    
	    //Create article
	    Article ar1 = new Article();
	    ar1.setName("PS4");
	    ar1.setStars(4);
	    ar1.getBuyers().add(p1);
	    ar1.getBuyers().add(p3);
	    ar1.getBuyers().add(p5);
	    ar1.getBuyers().add(p7);
	    ar1.getBuyers().add(p6);
	    
	    Article ar2 = new Article();
	    ar2.setName("XboxOne");
	    ar2.setStars(2);
	    ar2.getBuyers().add(p2);
	    ar2.getBuyers().add(p4);
	    
	    Article ar3 = new Article();
	    ar3.setName("PC");
	    ar3.setStars(5);
	    ar3.getBuyers().add(p1);
	    ar3.getBuyers().add(p2);
	    ar3.getBuyers().add(p3);
	    ar3.getBuyers().add(p6);
	    ar3.getBuyers().add(p7);
	    
	    ds.save(ar1);
	    ds.save(ar2);
	    ds.save(ar3);
	    
	    //exemple suppression
	    ds.delete(ar1);
	    //Affichage
	    for(Person e : ds.find(Person.class)){
	    	System.out.println(e.getName());
	    }
	    
	    for(Article e : ds.find(Article.class)){
	        System.out.println(e.getName());
		}
	    
	    for(Adresse e : ds.find(Adresse.class)){
	        System.out.println(e.getStreet()+" "+e.getCity());
		}

	    
	}
}
