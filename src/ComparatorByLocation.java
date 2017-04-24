import java.util.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tiffanylower
 */
public class ComparatorByLocation implements Comparator<RegisteredUser> {
                   
            @Override
                public int compare(final RegisteredUser user1, final RegisteredUser user2) {
                    return user1.getLocation().compareTo(user2.getLocation());
      }
  }
                    
