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
                public int compare(final RegisteredUser user1, final RegisteredUser user2) {
                    return user1.getLocation().compareTo(user2.getLocation());
      }
  }
                    
