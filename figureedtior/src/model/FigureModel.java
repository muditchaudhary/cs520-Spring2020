package model;

import javax.swing.ImageIcon;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class FigureModel 
{
    ImageIcon imageIcon = null;
    String caption = null;

    String isComplete = "False";
    private PropertyChangeSupport support;

    public FigureModel() {
        support = new PropertyChangeSupport(this);
    }

    public ImageIcon getImage() {
        return this.imageIcon;
    }

    /**
     * Sets the image to the given non-null ImageIcon.
     *
     * @param newImage The ImageIcon must be non-null
     *
     * @throws IllegalArgumentException if the ImageIcon is null
     */
    public void setImage(ImageIcon newImage) {
        support.firePropertyChange("imageIcon", this.imageIcon, newImage);
	    this.imageIcon = newImage;
    }

    public String getCaption() {
	    return this.caption;
    }

    /**
     * Sets the caption to the given non-null and non-empty String.
     *
     * @param newCaption The String must be non-null and non-empty
     *
     * @throws IllegalArgumentException if the String is null or empty
     */
    public void setCaption(String newCaption) {
        support.firePropertyChange("caption", this.caption, newCaption);
	    this.caption = newCaption;
    }

    /**
     * Returns true if this figure is complete, meaning its Image 
     * is non-null and its caption is non-null and non-empty, and
     * false otherwise.
     *
     * @return True if this figure is complete and false otherwise
     */
    public boolean isComplete() {
	    if (getCaption() != null && getImage()!=null){
            return true;
        }
        return false;
    }

    public void setComplete(String complete) {
        support.firePropertyChange("isComplete", this.isComplete, complete);
        isComplete = complete;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
