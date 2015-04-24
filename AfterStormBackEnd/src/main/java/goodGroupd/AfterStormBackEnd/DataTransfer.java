package goodGroupd.AfterStormBackEnd;
import java.net.UnknownHostException;

import org.mongodb.morphia.*;
import org.mongodb.morphia.query.Criteria;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;

import com.mongodb.MongoClient;

public class DataTransfer{
	
public DataTransfer(){
	
	Morphia morphia = new Morphia();
	morphia.map(EntryInformation.class);
}
	
public static void addInformation(EntryInformation newEntry){
	
	Datastore dstore = getDatastore();
	
	dstore.save(newEntry);
	
	closeMongo(dstore);
	
}

public static EntryInformation findPerson(String phoneNumber){
	
	Datastore dstore = getDatastore();
	
	EntryInformation targPerson = dstore.get(EntryInformation.class, phoneNumber);
	
	closeMongo(dstore);
	
	return targPerson;
	
}

public static void checkIn(String phoneNumber, boolean critical){

	Datastore dstore = getDatastore();

	EntryInformation targPerson = dstore.get(EntryInformation.class, phoneNumber);
	
	targPerson.isCritical(critical);
	
	dstore.save(targPerson);
	
	closeMongo(dstore);
	

}

public static ArrayList<EntryInformation> getCritical(){
	
	Datastore dstore = getDatastore();
	
	ArrayList<EntryInformation> critList = new ArrayList(dstore.find(EntryInformation.class, "critical", true).asList());
	
	closeMongo(dstore);
	
	return critList;
}

public static ArrayList<EntryInformation> getNonChecks(){
	
	Datastore dstore = getDatastore();
	
	ArrayList<EntryInformation> checkList = new ArrayList(dstore.find(EntryInformation.class, "checkedIn", false).asList());
	
	closeMongo(dstore);
	
	return checkList;
}

public static ArrayList<EntryInformation> getNonOrCrit(){
	
	Datastore dstore = getDatastore();
	
	Query targQuery = dstore.createQuery(EntryInformation.class);
			
	targQuery.or((Criteria)targQuery.criteria("checkedIn").equal(false),
				((Criteria)targQuery.criteria("critical").equal(true))
				);
	
	ArrayList<EntryInformation> targList = (ArrayList<EntryInformation>)targQuery.asList();
	
	closeMongo(dstore);
	
	return targList;
}

public static void update(EntryInformation updatedEntry){
	
	Datastore dstore = getDatastore();
	
	dstore.save(updatedEntry);
	
	closeMongo(dstore);
}

public static void closeMongo(Datastore dstore){
	
	MongoClient monClient = dstore.getMongo();
	
	monClient.close();
}

public static Datastore getDatastore(){
	
	MongoClient monClient = null;
	
	try {
		monClient = new MongoClient("192.168.1.7", 27017);
	} catch (UnknownHostException e) {
		System.out.println("Could not connect to DB");
		e.printStackTrace();
	}
	
	Morphia morphia = new Morphia();
	
	Datastore dstore = morphia.createDatastore(monClient, "Afterstorm");
	
	return dstore;
	
}


}