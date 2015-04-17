package goodGroupd.AfterStormBackEnd;

import goodGroupd.AfterStormBackEnd.DataTransfer;
import java.util.ArrayList;

public class TestTransfer {


		
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntryInformation per1 = new EntryInformation("per1", "huntingtonWay", 15403, "4564567899", "first");
		EntryInformation per2 = new EntryInformation("per2", "duntingtonWay", 12342, "2343224453", "second");
		EntryInformation per3 = new EntryInformation("per3", "suckVille", 13432, "3332221111", "third");
		EntryInformation per4 = new EntryInformation("per4", "notSuckVille", 23322, "2221112222", "fourth");
		
		DataTransfer trans = new DataTransfer();
		
		/*trans.addInformation(per1);
		trans.addInformation(per2);
		trans.addInformation(per3);
		trans.addInformation(per4);*/
		
		EntryInformation tempPerson = trans.findPerson("4564567899");
		
		System.out.println(tempPerson.getPrimaryName());
		
		trans.checkIn("2221112222", true);
		trans.checkIn("3332221111", false);
		
		ArrayList<EntryInformation> criticals = trans.getCritical();
		for(int i = 0; i < criticals.size(); i++){
			System.out.println(criticals.get(i).getPrimaryName());
		}
		
		ArrayList<EntryInformation> nonChecks = trans.getNonChecks();
		for(int j = 0; j < nonChecks.size(); j++){
			
			System.out.println(nonChecks.get(j).getPrimaryName());
		}
		
		ArrayList<EntryInformation> both = trans.getNonOrCrit();
		for(int k = 0; k < both.size(); k++){
			
			System.out.println(both.get(k).getPrimaryName());
		}
	}	
	
}