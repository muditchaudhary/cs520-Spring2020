package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.FigureModel;
import view.View;


public class FigureController 
{
    public static final String ERROR_REPORT = "Error Report";

    private JFrame parent;
    private FigureModel model;
    private List<View> views;

	FigureModel observable;


    public FigureController(JFrame parent, FigureModel model, List<View> views)
    {
	super();

	this.parent = parent;
	this.model = model;
	this.views = new ArrayList<View>();
	this.views.addAll(views);

	observable = model;

	// Initialize the views
	for (View currentView : this.views) {
		observable.addPropertyChangeListener(currentView);
	    currentView.addController(this);
	    //currentView.update(this.model);
	}
    }

    public void changeImage() {
	JFileChooser fileChooser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
	fileChooser.setFileFilter(filter);
	int returnVal = fileChooser.showOpenDialog(this.parent);
	if(returnVal == JFileChooser.APPROVE_OPTION) {
	    System.out.println("New image: " +
			       fileChooser.getSelectedFile().getPath());
	    ImageIcon newImage = new ImageIcon(fileChooser.getSelectedFile().getPath(), "");

	    // After user input, update the model
	    try {
			observable.setImage(newImage);
			if ((boolean) observable.isComplete()==true){
				observable.setComplete("True");
			}
			else{
				observable.setComplete("False");
			}

		/*
		//this.model.setImageIcon(newImage);
		// After updating the model, update its views
		for (View currentView : this.views) {
		    currentView.update(this.model);
		}*/
	    }
	    catch (IllegalArgumentException e) {
		JOptionPane.showMessageDialog(null, ERROR_REPORT, e.getMessage(), JOptionPane.ERROR_MESSAGE);
	    }
	}
    }

    public void editCaption() {
	String newCaption = JOptionPane.showInputDialog("New caption");
	System.out.println("New caption: " + newCaption);

	// After user input, update the model
	try {
		observable.setCaption(newCaption);
		System.out.println("new Caption setting");
		if ((boolean) observable.isComplete()){
			observable.setComplete("True");
		}
		else{
			observable.setComplete("False");
		}
		/*
	    this.model.setCaption(newCaption);
	
	    // After updating the model, update its views
	    for (View currentView : this.views) {
		currentView.update(this.model);
	    }
	    */
	}
	catch (IllegalArgumentException e) {
	    JOptionPane.showMessageDialog(null, ERROR_REPORT, e.getMessage(), JOptionPane.ERROR_MESSAGE);
	}
    }
}
