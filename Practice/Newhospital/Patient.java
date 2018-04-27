//package design.practice.designEx.newhospital;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class Patient {
//
//	private HealthStatus healthStatus;
//	private List<Treatment> receivedTreatments;
//
//	public Patient(HealthStatus healthStatus) {
//		this.healthStatus = healthStatus;
//		receivedTreatments = new ArrayList<Treatment>();
//	}
//
//	public void participateInTreatement(Treatment newTreatment) {
//		healthStatus = getNewHealthStatus(newTreatment); //Update
//		receivedTreatments.add(newTreatment);
//	}
//
//	public void participateInStatistic(Map<HealthStatus, Integer> statistic) {
//		int currentHeathStatusCount = statistic.get(healthStatus);
//		statistic.put(healthStatus, currentHeathStatusCount + 1);
//	}
//
//	private HealthStatus getNewHealthStatus(Treatment newTreatment) {
//
//		if(killingSituation(newTreatment))
//			return HealthStatus.Died;
//		else if(healthStatus == HealthStatus.Diabetes)
//			return diabetesCase(newTreatment);
//		else if(healthStatus == HealthStatus.Fever)
//			return feverCase(newTreatment);
//		else if(healthStatus == HealthStatus.Tuberculosis)
//			return tuberculosisCase(newTreatment);
//		else if(healthStatus == HealthStatus.Healthy)
//			return healthyCase(newTreatment);
//
//		return null;
//	}
//
//	private boolean killingSituation(Treatment newTreatment) {
//		if(newTreatment == Treatment.Aspirin && receivedTreatments.contains(Treatment.Paracetamol))
//			return true;
//		return false;
//	}
//
//	private HealthStatus diabetesCase(Treatment newtreatment) {
//		if( ! receivedTreatments.contains(Treatment.Insulin) && newtreatment == Treatment.Wait40Days){
//			return HealthStatus.Died;
//		}else
//			return HealthStatus.Diabetes;
//	}
//
//	private HealthStatus feverCase(Treatment newTreatment) {
//		if(newTreatment == Treatment.Aspirin || newTreatment == Treatment.Paracetamol)
//			return HealthStatus.Healthy;
//
//		return HealthStatus.Fever;
//	}
//
//	private HealthStatus tuberculosisCase(Treatment newTreatment) {
//		if(newTreatment == Treatment.Wait40Days && receivedTreatments.contains(Treatment.Antibiotic))
//			return HealthStatus.Healthy;
//
//		return HealthStatus.Tuberculosis;
//	}
//
//	private HealthStatus healthyCase(Treatment newTreatment) {
//		if(newTreatment == Treatment.Insulin && receivedTreatments.contains(Treatment.Antibiotic))
//			return HealthStatus.Fever;
//		return HealthStatus.Healthy;
//	}
//}
