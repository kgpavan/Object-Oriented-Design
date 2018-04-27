package design.practice.designEx.hospital;

import java.util.LinkedHashMap;
import java.util.Map;


public class QuarantineFactory {


    public static Map<HealthStatus, Integer> getGroupOfPatients(String listOfPatient) {
        Map<HealthStatus, Integer> groupOfPatients = new LinkedHashMap<HealthStatus, Integer>();
        
        String[] healthStatusArray = factorySpliter(listOfPatient, ",");

        for (int i = 0; i < healthStatusArray.length; i++) {
            HealthStatus healthStatus = HealthStatus.getHealthStatusByCode(healthStatusArray[i]);
            
            if(notInGroupOfPatients(groupOfPatients, healthStatus)){
                groupOfPatients.put(healthStatus, 1);
            }
            else{
                incrementExistingHealthStatus(groupOfPatients, healthStatus);
            }
        }
        initDiedHealthStatus(groupOfPatients);        
        return groupOfPatients;
    }

    private static void initDiedHealthStatus(Map<HealthStatus, Integer> groupOfPatients) {
        groupOfPatients.put(HealthStatus.Died, 0);
    }

    private static void incrementExistingHealthStatus(Map<HealthStatus, Integer> groupOfPatients,
                                                        HealthStatus healthStatus) {
        Integer patientCount = groupOfPatients.get(healthStatus);
        groupOfPatients.put(healthStatus, patientCount + 1);        
    }

    private static boolean notInGroupOfPatients(Map<HealthStatus, Integer> groupOfPatients, HealthStatus healthStatus) {        
        for (HealthStatus currentHealthStatus : groupOfPatients.keySet()) {
            if(currentHealthStatus.code.equals(healthStatus.code))
                return false;
        }
        
        return true;
    }

    private static String[] factorySpliter(String string, String separator) {
        return string.split(separator);
    }
}
