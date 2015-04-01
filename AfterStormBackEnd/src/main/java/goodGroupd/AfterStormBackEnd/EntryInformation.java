package goodGroupd.AfterStormBackEnd;

import org.mongodb.morphia.annotations.Entity;

@Entity(noClassnameStored=true)
public class EntryInformation {

	private String primaryName;
	
	private String address;
}
