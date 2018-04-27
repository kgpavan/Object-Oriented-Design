package design.practice.designEx.hospital;


public enum HealthStatus {
    
    Healthy("H"), Fever("F"), Diabetes("D"), Tuberculosis("T"), Died("X");
    
    String code;
    
    private HealthStatus(String code) {
        this.code = code;
    }
    
    public static HealthStatus getHealthStatusByCode(String code){
        for (HealthStatus healthStatus : values()) {
            if(healthStatus.code.equals(code)){
                return healthStatus;
            }
        }
        return null;
    }

}
