import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Canvas extends JPanel {
    private Stage stage;

    /**
     * Game canvas that draws the Stage for the chosen animal.
     * @param chosenAnimal "Dog", "Cat", or "Bird"
     */
    public Canvas(String chosenAnimal) {
        setPreferredSize(new Dimension(720, 720));
        stage = new Stage(chosenAnimal);

        // 'B' key → back to menu (fresh Menu in the same window)
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed B"), "backToMenu");
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed b"), "backToMenu");
        getActionMap().put("backToMenu", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Back to Menu triggered via key binding");
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(Canvas.this);
                if (topFrame instanceof Main) {
                    Main mainApp = (Main) topFrame;
                    mainApp.setContentPane(new Menu(mainApp));
                    mainApp.pack();
                    mainApp.repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // If your Stage.paint expects a mouse position, pass it; otherwise, adjust accordingly.
        stage.paint(g, getMousePosition());
    }
}