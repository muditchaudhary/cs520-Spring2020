# FigureEditor
This editor uses the MVC architecture pattern.

### How to build and test (from Terminal):

1. Make sure that you have Apache Ant installed. Run each ant command in the figureeditor folder, which contains the `build.xml` build file.

2. Run `ant document` to generate the javadoc (a hypertext description) for all of the java classes. Generated hypertext description will be in the `jdoc` folder. Open the `index.html` file. 

3. Run `ant compile` to compile all of the java classes. Compiled classes will be in the `bin` folder.

4. Run `ant test` to run all unit tests.

### How to run (from Terminal):

1. After building the project (i.e., running `ant`), run the following command in the figureeditor folder:
   `java -cp bin FigureEditor`

### How to clean up (from Terminal):

1. Run `ant clean` to clean the project (i.e., delete all generated files).

### Observer Design Pattern Implementation
1. The Observer design pattern has been implemeneted, where the FigureModel is the Observable and the FigureView and InforView are the Observers.
2. We have utilized the Class PropertyChangeSupport and PropertyChangeListener for this implementation.
3. The Observable (FigureModel) keeps a reference to an instance of PropertyChangeSupport, which does the wiring between Observable and Observer instances.
3. The FigureModel object invokes firePropertyChange method when the state of the FigureModel bound properties change. i.e imageIcon, caption, complete
4. The Observers implement the Interface PropertyChangeListener and implements the propertyChange method, which gets invoked in case a 'PropertyChange' event gets fired.
5. All the Observers get registered with the Observable by calling addPropertyChangeListener method.