package view;

import model.FigureModel;
import controller.FigureController;

import java.beans.PropertyChangeListener;


public interface View extends PropertyChangeListener
{
    public void addController(FigureController controller);

    public void update(FigureModel model);
}
