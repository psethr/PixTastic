
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Compares picture posts by number of likes
 * 
 */
public class ComparatorByLikes implements Comparator<Picture> {
   /**
    * 
    * @param a picture post 
    * @param b another picture post
    * @return 
    */
    public int compare(Picture a, Picture b) {
        int likes1 = a.getLikes();
        int likes2 = b.getLikes();
        LocalDateTime time1 = a.getTime();
        LocalDateTime time2 = b.getTime();
        
        if (likes1 > likes2) {
            return 1;
        } else if (likes1 < likes2) {
            return -1;
        } else if (likes1 == likes2) {
            if (time1.compareTo(time2) > 0) {
                return 1;
            } else if (time1.compareTo(time2) < 0) {
                return -1;
        }
        
}
  return 0;
    }
    
}
      