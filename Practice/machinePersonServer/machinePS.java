///*10-2*/
//class Machine {
//
//	public HashMap<Integer, Person> persons = new HashMap<Integer, Person>();
//	public int machineID;
//
//	public Person getPersonWithID(int personID) {
//
//		return persons.get(personID);
//	}
//}
//
//
//
//class Person {
//
//
//	private ArrayList<Integer> friends;
//	private int personID;
//	private String info;
//
//	public String getInfo() { return info; }
//	public void setInfo(String info) {
//		this.info = info;
//	}
//
//	public int[] getFriends() {
//		int[] temp = new int[friends.size()];
//		for (int i = 0; i < temp.length; i++) {
//			temp[i] = friends.get(i);
//		}
//		return temp;
//	}
//	public int getID() { return personID; }
//	public void addFriend(int id) { friends.add(id); }
//
//	public Person(int id) {
//		this.personID = id;
//	}
//}
//
//
//class Server {
//
//
//	HashMap<Integer, Machine> machines = new HashMap<Integer, Machine>();
//	HashMap<Integer, Integer> personToMachineMap = new HashMap<Integer, Integer>();
//
//	public Machine getMachineWithId(int machineID) {
//		return machines.get(machineID);
//	}
//
//	public int getMachineIDForUser(int personID) {
//		Integer machineID = personToMachineMap.get(personID);
//		return machineID == null ? -1 : machineID;
//	}
//
//	public Person getPersonWithID(int personID) {
//		Integer machineID = personToMachineMap.get(personID);
//		if (machineID == null) {
//			return null;
//		}
//		Machine machine = getMachineWithId(machineID);
//		if (machine == null) {
//			return null;
//		}
//		return machine.getPersonWithID(personID);
//	}
//}
///*10-2*/
//
//
//public class machinePS {
//
//	public static void main(String[] args) {
//
//	}
//}
