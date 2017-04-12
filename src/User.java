public class User
{
    protected String hashtag;
  /**
     * Compares a user specified hashtag to see if it matches any attached to 
     * any pictures.
     * @param other Hashtag to compare to
     * @return true if the hashtag has a match and false otherwise
     */ 
    public boolean equals(Picture other) {
        return (hashtag.equals(other.hashtag));
    }  
}
