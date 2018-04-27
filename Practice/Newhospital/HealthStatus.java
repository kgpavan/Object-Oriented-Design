//package com.nespresso.sofa.interview.hospital;
//
//
//public enum HealthStatus {
//
//    Fever("F") {
//		@Override
//		public String print() {
//			return "F";
//		}
//	},Healthy("H") {
//		@Override
//		public String print() {
//			return "H";
//		}
//	},  Diabetes("D") {
//		@Override
//		public String print() {
//			return "D";
//		}
//	}, Tuberculosis("T") {
//		@Override
//		public String print() {
//			return "T";
//		}
//	}, Died("X") {
//		@Override
//		public String print() {
//			return this.acronym;
//		}
//	};
//
//	protected String acronym;
//
//	HealthStatus(String acronym){
//		this.acronym = acronym;
//	}
//
//    public static HealthStatus getHealthStatusByAcronym(String acronym){
//        for (HealthStatus healthStatus : values()) {
//            if(healthStatus.acronym.equals(acronym)){
//                return healthStatus;
//            }
//        }
//        return null;
//    }
//
//    public abstract String print();
//}
