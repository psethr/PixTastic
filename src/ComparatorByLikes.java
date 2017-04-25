import java.util.*;
import java.time.LocalDateTime;


/**
 *Compares picture posts by number of likes
 * 
 */
public class ComparatorByLikes implements Comparator<Picture> {
   /**
    * 
    * @param a picture post 
    * @param b another picture post
    * @return  ordered array list
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
        } else if (likes1 == likes2) { //if likes equal, compare time
            if (time1.compareTo(time2) > 0) { //order picture that was posted first
                return 1;
            } else if (time1.compareTo(time2) < 0) {
                return -1;
        }
        
}
  return 0;
    }
    
}
      
