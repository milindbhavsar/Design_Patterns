import java.util.HashMap;
import java.util.Map;

class User{
	
	int counter ;
	String userid;
	long timestamp;
	
	public User(String string, int i) {
		// TODO Auto-generated constructor stub
		userid= string;
		
	}

	public void setTime(long currentTimeMillis) {
		// TODO Auto-generated method stub
		timestamp = currentTimeMillis;
	}

}

public class RateLimiter {

	final static int MAX_USER_REQUESTS = 50;
	static Map<String, User> userMap = new HashMap<String, User>();

	public static void main(String args[]) {
		User myUser = new User("milind",0);

		String id = "userID";
		ratelimiter(id);

	}

	public static boolean ratelimiter(String userid) {
		boolean allow =false;
		User usr = userMap.get(userid);
		long currentTime = System.currentTimeMillis();
		if (userMap.get(userid) != null) {
			if(currentTime-userMap.get(userid).timestamp<50) {
				if(usr.counter<=MAX_USER_REQUESTS) {
					usr.counter++;
					allow= true;
				}
			}
		} else {
			usr.counter=0;
			usr.setTime(System.currentTimeMillis());
				
		}
		return allow;
			
		}

	}

