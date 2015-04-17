package goodGroupd.AfterStormBackEnd;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;

@Entity(noClassnameStored=true)
public class EntryInformation {

	private String primaryName;
	
	private String address;
		
	private int zipCode;
	
	@Id
	private String phoneNumber;
		
	private ArrayList<String> otherPeople;
	
	private boolean critical;
	
	private String comments;
	
	private boolean checkedIn;
	
	public EntryInformation(){}
	
	public EntryInformation(String name, String address, int zipCode, String phoneNumber, String comments, ArrayList<String> additionalPeople ){
		
		this.setPrimaryName(name);
		this.address = address;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
		this.comments = comments;
		this.otherPeople = additionalPeople;
	}

	public EntryInformation(String name, String address, int zipCode, String phoneNumber, String comments){
		
		new EntryInformation(name, address, zipCode, phoneNumber, comments, new ArrayList<String>());
		
	}
	

	
	public void isCritical(boolean criticalStatus){
		this.critical = criticalStatus;
		this.checkedIn = true;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}
	
}