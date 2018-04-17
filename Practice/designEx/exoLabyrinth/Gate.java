//package com.nespresso.sofa.recruitment.labyrinth;
package design.practice.designEx.exoLabyrinth;

public enum Gate {

    WithSensor("$"), WithoutSensor("|");
    
    private String code;
    
    Gate(String code){
        this.code = code;
    }
    
    public static Gate getGateByCode(String code){
        for (Gate gate : values()) {
            if(gate.code.equals(code))
                return gate;
        }
        return null;
    }
}
