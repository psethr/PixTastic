
import java.util.ArrayList;

public class RegisteredUser
{
    private String username;
    private String name;
    private String location;
    private String profilePic;
    private String bio;
    private boolean isRegistered;
    private boolean isLoggedIn;
    private ArrayList<Picture> al;
    
    public RegisteredUser(
            String username,
            String name,
            String location,
            String profilePic,
            String bio,
            boolean isRegistered,
            boolean isLoggedIn)
    {
        this.username = username;
        this.name = name;
        this.location = location;
        this.profilePic = profilePic;
        this.bio = bio;
        this.isRegistered = isRegistered;
        this.isLoggedIn = isLoggedIn;
        al = new ArrayList<Picture>();
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the profilePic
     */
    public String getProfilePic() {
        return profilePic;
    }

    /**
     * @param profilePic the profilePic to set
     */
    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * @return the isRegistered
     */
    public boolean isRegistered() {
        return isRegistered;
    }

    /**
     * @param isRegistered the isRegistered to set
     */
    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    /**
     * @return the al
     */
    public ArrayList<Picture> getArraylist() {
        return al;
    }

    /**
     * @param al the al to set
     */
    public void setArratList(ArrayList<Picture> al) {
        this.al = al;
    }
    
    /**
     * @param pic 
     */
    public void addPicture(Picture pic) {
        al.add(pic);
    }

    /**
     * @return the isLoggedIn
     */
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    /**
     * @param isLoggedIn the isLoggedIn to set
     */
    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
}
