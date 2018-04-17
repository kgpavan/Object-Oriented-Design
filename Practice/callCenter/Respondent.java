package design.practice.callCenter;

class Respondent extends Employee {

    public Respondent(CallHandler callHandler) {

    	super(callHandler);
    	rank = Rank.Responder;
    }
}
