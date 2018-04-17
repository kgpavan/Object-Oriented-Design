package design.practice.designEx.hospital;

import java.util.HashMap;
import java.util.Map;

public class Quarantine {
    
    private Map<HealthStatus, Integer> groupOfPatients;
    private Map<Medicine, Integer> listMedicine ;

	public Quarantine(String listOfPatient) {
		groupOfPatients = QuarantineFactory.getGroupOfPatients(listOfPatient);
		this.listMedicine = new HashMap<Medicine, Integer>(); 
	}
	
	public void wait40Days() {

	    if( ! listMedicine.containsKey(Medicine.Insulin)){
	        changeHealthStatus(HealthStatus.Diabetes, HealthStatus.Died);
	    }

	    if(listMedicine.containsKey(Medicine.Antibiotic) && listMedicine.containsKey(Medicine.Insulin)){
	        changeHealthStatus(HealthStatus.Healthy, HealthStatus.Fever);
            int feverCount = groupOfPatients.get(HealthStatus.Fever);
            int antibioticCount = listMedicine.get(Medicine.Antibiotic);
            
            groupOfPatients.put(HealthStatus.Healthy, antibioticCount);
            groupOfPatients.put(HealthStatus.Fever, feverCount - antibioticCount);
	    }
    }

	public void aspirin() {
	    if(listMedicine.containsKey(Medicine.Paracetamol)){
	        killAll();
	    }
	    changeHealthStatus(HealthStatus.Fever, HealthStatus.Healthy);
	}

	public void antibiotic() {
	    int tuberculosisCount = changeHealthStatus(HealthStatus.Tuberculosis, HealthStatus.Healthy);
        listMedicine.put(Medicine.Antibiotic, tuberculosisCount);
	}

	public void insulin() {
	    int insulinCount = groupOfPatients.get(HealthStatus.Diabetes);
	    listMedicine.put(Medicine.Insulin, insulinCount);
	}

	public void paracetamol() {
	    int feverCount = changeHealthStatus(HealthStatus.Fever, HealthStatus.Healthy);
        listMedicine.put(Medicine.Paracetamol, feverCount);
	}

	public String report() {
		StringBuilder stringToReport = new StringBuilder();
		for (Map.Entry<HealthStatus, Integer> healthStatus : groupOfPatients.entrySet()) {
            stringToReport.append(healthStatus.getKey().code+":"+healthStatus.getValue()+" ");
        }
		stringToReport.deleteCharAt(stringToReport.length() -1);
		return stringToReport.toString();
	}
	
	private int changeHealthStatus(HealthStatus initialStatus, HealthStatus finalStatus){
	    int initialStatusCount = groupOfPatients.get(initialStatus);
        int finalStatusCount = groupOfPatients.get(finalStatus);
        
        groupOfPatients.put(initialStatus, 0);
        groupOfPatients.put(finalStatus, initialStatusCount + finalStatusCount);
        
        return initialStatusCount;        
	}
	
	private void killAll() {
        int totalPatients = 0;
        for (HealthStatus healthStatus : groupOfPatients.keySet()) {
            totalPatients += groupOfPatients.get(healthStatus);
            groupOfPatients.put(healthStatus, 0);
        }
        groupOfPatients.put(HealthStatus.Died, totalPatients);
    }

}
