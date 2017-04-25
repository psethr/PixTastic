import java.util.*;

/**
 *Compares users to match location 
 */
public class ComparatorByLocation implements Comparator<RegisteredUser> {
             /**
             * 
             * @param user1 registered user
             * @param user2 another registered user
             * @return 
             */       
            @Override
                public int compare(RegisteredUser user1, RegisteredUser user2) {
                    return user1.getLocation().compareToIgnoreCase(user2.getLocation());
      }
  }
                    
