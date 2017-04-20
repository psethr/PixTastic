import java.time.LocalDateTime;

public class Picture
{
    protected String filepath;  //filepath of the picture
    protected String caption; //caption attached to the picture
    protected String comments; //comments attached to the picture
    protected String hashtag; //hashtags assigned to the picture
    protected int likes; //number of likes associated with a picture
    protected LocalDateTime time;  //time a picture was 
    
    /**
    *  Default constructor to initialize a picture.
    *  @param f the pathway to the picture
    *  @param cap the caption for the picture
    *  @param com the comments attached to the picture
    *  @param h the hashtags attached to the picture
    *  @param l the number of likes a picture has
    */
    public Picture(String f, String cap, String com, String h, int l, 
            LocalDateTime t){
        filepath = f;
        caption = cap;
        comments = com;
        hashtag = h;
        likes = l;
        time = t;
    }
    /**
     * Accessor method for file-path.
     * @return the file-path of a picture
     */
    public String getFPath()
    {
        return filepath;
    }
    /**
     * Accessor method for the caption.
     * @return the caption of a picture
     */
    public String getCaption()
    {
        return caption;
    }
    /**
     * Accessor method for comments.
     * @return the comments of a picture
     */
    public String getComments()
    {
        return comments;
    }
    
    /**
     * Accessor method for hashtags.
     * @return the hashtags of a picture
     */
    public String getHashtag()
    {
        return hashtag;
    }
    /**
     * Accessor method for likes.
     * @return the number of likes a picture has
     */
    public int getLikes()
    {
        return likes;
    }
    /**
     * Increases the number of likes when the like button is clicked.
     * @return the new number of likes associated with a picture
     */
    public int setLikes()
    {
        likes = likes + 1;
        return likes;
    }
}
