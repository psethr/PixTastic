/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixtastic;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rachel
 */
@Entity
@Table(name = "PIXUSERS")
@NamedQueries({
    @NamedQuery(name = "Pixusers.findAll", query = "SELECT p FROM Pixusers p"),
    @NamedQuery(name = "Pixusers.findById", query = "SELECT p FROM Pixusers p WHERE p.id = :id"),
    @NamedQuery(name = "Pixusers.findByUsername", query = "SELECT p FROM Pixusers p WHERE p.username = :username"),
    @NamedQuery(name = "Pixusers.findByFullname", query = "SELECT p FROM Pixusers p WHERE p.fullname = :fullname"),
    @NamedQuery(name = "Pixusers.findByLocation", query = "SELECT p FROM Pixusers p WHERE p.location = :location"),
    @NamedQuery(name = "Pixusers.findByProfilePix", query = "SELECT p FROM Pixusers p WHERE p.profilePix = :profilePix"),
    @NamedQuery(name = "Pixusers.findByBio", query = "SELECT p FROM Pixusers p WHERE p.bio = :bio")})
public class Pixusers implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "FULLNAME")
    private String fullname;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "PROFILE_PIX")
    private String profilePix;
    @Column(name = "BIO")
    private String bio;
    @OneToMany(mappedBy = "pixuser")
    private Collection<Pixtures> pixturesCollection;

    public Pixusers() {
    }

    public Pixusers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        changeSupport.firePropertyChange("username", oldUsername, username);
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        String oldFullname = this.fullname;
        this.fullname = fullname;
        changeSupport.firePropertyChange("FULLNAME", oldFullname, fullname);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
    }

    public String getProfilePix() {
        return profilePix;
    }

    public void setProfilePix(String profilePix) {
        String oldProfilePix = this.profilePix;
        this.profilePix = profilePix;
        changeSupport.firePropertyChange("profilePix", oldProfilePix, profilePix);
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        String oldBio = this.bio;
        this.bio = bio;
        changeSupport.firePropertyChange("bio", oldBio, bio);
    }

    public Collection<Pixtures> getPixturesCollection() {
        return pixturesCollection;
    }

    public void setPixturesCollection(Collection<Pixtures> pixturesCollection) {
        this.pixturesCollection = pixturesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pixusers)) {
            return false;
        }
        Pixusers other = (Pixusers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pixtastic.Pixusers[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
