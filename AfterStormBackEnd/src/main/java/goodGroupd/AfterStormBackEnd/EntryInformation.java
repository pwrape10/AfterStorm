package goodGroupd.AfterStormBackEnd;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored=true)
public class EntryInformation {

	private String primaryName;
	
	private String address;
	
	private String city;
	
	private int zipCode;
	
	private int phoneNumber;
	
	private String email;
	
	private String groupSize;
	
	private boolean critical;
	
	private String comments;
}
