//package com.nespresso.sofa.interview.hospital;
//
//import java.util.List;
//import java.util.Map;
//
//public class Quarantine {
//
//	private List<Patient> patients;
//	private QuarantineStatistic quarantineStatistic;
//
//	public Quarantine(String listOfPatient) {
//		patients = PatientsFactory.getPatients(listOfPatient);
//		quarantineStatistic = createDefaultStatistic();
//	}
//
//	public void wait40Days() {
//		applyTreatment(Treatment.Wait40Days);
//	}
//
//	public void aspirin() {
//		applyTreatment(Treatment.Aspirin);
//	}
//
//	public void antibiotic() {
//		applyTreatment(Treatment.Antibiotic);
//	}
//
//	public void insulin() {
//		applyTreatment(Treatment.Insulin);
//	}
//
//	public void paracetamol() {
//		applyTreatment(Treatment.Paracetamol);
//	}
//
//	public String report() {
//		Map<HealthStatus, Integer> statistic = quarantineStatistic.getStatistic(this.patients);
//		return createNewReport(statistic);
//	}
//
//	private void applyTreatment(Treatment treatment){
//		for(Patient patient : patients){
//			patient.participateInTreatement(treatment);
//		}
//	}
//
//	private String createNewReport(Map<HealthStatus, Integer> statistic) {
//		StringBuilder report = new StringBuilder();
//		for (Map.Entry<HealthStatus, Integer> healthStatus : statistic.entrySet()) {
//			int healthStatusCount = healthStatus.getValue();
//            report.append(healthStatus.getKey().print()+":"+healthStatusCount+" ");
//        }
//		report.deleteCharAt(report.length() -1);
//		return report.toString();
//	}
//
//	private QuarantineStatistic createDefaultStatistic() {
//		return new QuarantineStatistic();
//	}
//
//}
