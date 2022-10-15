package view;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.FigureModel;
import controller.FigureController;


public class InfoView implements View
{
    JPanel infoPanel;
    JLabel infoLabel;
    JTextField infoField;


    public InfoView() {
	super();

	this.infoPanel = new JPanel(new GridLayout(1, 2));

	this.infoLabel = new JLabel();
	this.infoLabel.setText("Info:");
	this.infoPanel.add(this.infoLabel);

	this.infoField = new JTextField();
	this.infoField.setEditable(false);
	this.infoField.setText("This figure is not yet complete");
	this.infoPanel.add(this.infoField);
    }

    public JPanel getPanel() {
	return this.infoPanel;
    }

    public void addController(final FigureController controller) {
	//No-op
    }

    public void update(FigureModel model) {
	String infoMsg = "";
	if (model.isComplete() == false) {
	    infoMsg = "This figure is not yet complete.";
	}

	this.infoField.setText(infoMsg);
    }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String infoMsg = "";
		if ("isComplete".equals(evt.getPropertyName())) {
			if ((String)evt.getNewValue() == "True"){
				this.infoField.setText(infoMsg);
			}
			else{
				this.infoField.setText("This figure is not yet complete");
			}
			//this.captionView.setText((boolean) evt.getNewValue());
		}

		//this.infoField.setText(infoMsg);

	}
}
