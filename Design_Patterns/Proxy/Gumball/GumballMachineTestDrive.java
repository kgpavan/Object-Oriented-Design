package design.design_patterns.proxy.gumball;
import java.rmi.*;


/*

# Gumball Machine with Proxy Pattern
# To get code running on localhost: 

	1. Change directories to the same level with headfirst/ folder in bin/

	2. Run rmiregistry in background:
	$ rmiregistry &

	3. Run:
	$ java headfirst/designpatterns/proxy/gumball/GumballMachineTestDrive localhost 300

	4. In a different window, run:
	$ java headfirst/designpatterns/proxy/gumball/GumballMonitorTestDrive localhost
*/

public class GumballMachineTestDrive {
 
	public static void main(String[] args) {
		GumballMachineRemote gumballMachine = null;
		int count;

		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
 			System.exit(1);
		}

		try {
			count = Integer.parseInt(args[1]);

			gumballMachine = 
				new GumballMachine(args[0], count);
			Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
