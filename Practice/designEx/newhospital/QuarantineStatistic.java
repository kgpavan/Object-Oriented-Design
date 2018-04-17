//package design.practice.designEx.newhospital;
//
//import design.practice.designEx.hospital.HealthStatus;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class QuarantineStatistic {
//
//	public Map<HealthStatus, Integer> getStatistic(List<Patient> patients){
//		Map<HealthStatus, Integer> statistic = initializeStatistic();
//		for (Patient patient : patients) {
//			patient.participateInStatistic(statistic);
//		}
//		return statistic;
//	}
//
//	private Map<HealthStatus, Integer> initializeStatistic() {
//		Map<HealthStatus, Integer> emptyStatistic = new LinkedHashMap<HealthStatus, Integer>();
//
//		for (HealthStatus healthStatus : HealthStatus.values()) {
//			emptyStatistic.put(healthStatus, 0);
//		}
//		return emptyStatistic;
//	}
//}
