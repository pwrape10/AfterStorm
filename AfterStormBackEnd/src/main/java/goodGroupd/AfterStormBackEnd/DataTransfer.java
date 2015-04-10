package goodGroupd.AfterStormBackEnd;
import java.net.UnknownHostException;

import org.mongodb.morphia.*;

import com.mongodb.MongoClient;

public class DataTransfer{
	
public static void addInformation(EntryInformation newEntry){
	
	Datastore dstore = getDatastore();
	
	dstore.save(newEntry);
	
	MongoClient mongo = dstore.getMongo();
	
	mongo.close();
	
}







public static Datastore getDatastore(){
	
	MongoClient monClient = null;
	
	try {
		monClient = new MongoClient("localhost", 27017);
	} catch (UnknownHostException e) {
		System.out.println("Could not connect to DB");
		e.printStackTrace();
	}
	
	Morphia morphia = new Morphia();
	
	Datastore dstore = morphia.createDatastore(monClient, "Afterstorm");
	
	return dstore;
	
}


}