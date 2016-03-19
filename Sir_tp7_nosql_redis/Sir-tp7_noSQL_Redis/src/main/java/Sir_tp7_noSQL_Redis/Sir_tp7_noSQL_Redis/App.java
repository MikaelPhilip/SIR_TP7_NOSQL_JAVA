package Sir_tp7_noSQL_Redis.Sir_tp7_noSQL_Redis;

import redis.clients.jedis.Jedis;

/**
 * Classe pour tester les possibilités de Jedis
 * @author Mikaël
 *
 */
public class App
{
	public static void main( String[] args )
	{
		/*Ajout classique*/
	    Jedis jedis = new Jedis("localhost"); //On créer une instance Jedis qui manipule redis
	    jedis.set("foo", "bar"); //le set permet de rajouter une valeur
	    String value = jedis.get("foo"); //le get permet de lire une valeur
	    System.out.println(value);    
	    
	    /*Création d'un compteur (pour gerer les id?)*/ 
	    System.out.println(jedis.get("counter")); //renvoit null l'objet existe pas
        jedis.incr("counter"); //création (si besoin) et incrémentation d'un objet counter qui est donc un compteur
        System.out.println(jedis.get("counter")); //afficher le compteur
        
        /*Création d'une clé à durée limité (en cache)*/
        try {
	        //On crée une clé
	        String cacheKey = "cachekey";
	        jedis.set(cacheKey, "cached value");
	      
	        //On indique que la cle va expirer dans 15 secondes
	        jedis.expire(cacheKey, 15); 
	        //Afficher le temps restant
	        System.out.println("TTL:" + jedis.ttl(cacheKey));
	        Thread.sleep(1000); //On attends
	        System.out.println("TTL:" + jedis.ttl(cacheKey));
	        //Afficher la vleur dans le cache
	        System.out.println("Cached Value:" + jedis.get(cacheKey)); //on affiche la valeur 
	        //On attends que le délais fixé s'ecoule
	        Thread.sleep(15000);
	        //On affiche la valeur
	        System.out.println("Expired Key:" + jedis.get(cacheKey)); //Null car n'existe plus car le délais TTL est écoulé
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
        }
        
        /*Utilisation d'une même clé pour plusieurs valeurs (tableau de donnée)*/
        String cacheKey2 = "languages";
        //Rajouter plusieurs valeurs une clé (/!\ != set)
        jedis.sadd(cacheKey2, "Java");
        jedis.sadd(cacheKey2, "C#");
        jedis.sadd(cacheKey2, "Python");// SADD

        //Récuperer tout les vlaeurs pour cette clé SMEMBERS
        System.out.println("Languages: " + jedis.smembers(cacheKey2));
        
        // Rajouter plusieurs valeurs une clé dont une déja présente
        jedis.sadd(cacheKey2, "Java");
        jedis.sadd(cacheKey2, "Ruby");
        //Recupérer les valeur : on a une seule fois la valeur java pas de duplication
        System.out.println("Languages: " + jedis.smembers(cacheKey2));
	}
}