package design.practice.callCenter;

class Director extends Employee {

    public Director(CallHandler callHandler) {
    	super(callHandler);
    	rank = Rank.Director;
    }
}
