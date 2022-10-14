package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import javax.swing.*;

import model.FigureModel;
import controller.FigureController;


public class FigureView implements View {
	JPanel figurePanel;
	JLabel imageView;
	JButton changeImageButton;
	JLabel captionView;
	JButton editCaptionButton;


	public FigureView() {
		super();

		this.figurePanel = new JPanel(new GridLayout(2, 1));

		JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.imageView = new JLabel();
		imagePanel.add(this.imageView);
		this.changeImageButton = new JButton("Change image...");
		this.changeImageButton.setSize(125, 75);
		imagePanel.add(this.changeImageButton);
		this.figurePanel.add(imagePanel);

		JPanel captionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.captionView = new JLabel();
		this.captionView.setSize(500, 75);
		captionPanel.add(this.captionView);
		this.editCaptionButton = new JButton("Edit caption...");
		this.editCaptionButton.setSize(125, 75);
		captionPanel.add(this.editCaptionButton);
		this.figurePanel.add(captionPanel);
	}

	public JPanel getPanel() {
		return this.figurePanel;
	}

	public void addController(final FigureController controller) {
		this.changeImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.changeImage();
			}
		});

		this.editCaptionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.editCaption();
			}
		});
	}

	/*
	** Instead of using update method, using the below method 'propertyChange'
	*/
	public void update(FigureModel model) {
	/*
		if (model.getImageIcon() != null) {
			this.imageView.setIcon(model.getImageIcon());
		}
		if (model.getCaption() != null) {
			this.captionView.setText(model.getCaption());
		}
		}
    */
	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ("caption".equals(evt.getPropertyName())) {
			this.captionView.setText((String) evt.getNewValue());
		}

		if ("imageIcon".equals(evt.getPropertyName())) {
			this.imageView.setIcon((Icon) evt.getNewValue());
		}
	}

}