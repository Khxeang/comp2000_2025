import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Main extends JFrame{
    public static void main(String[] args) throws Exception {
        Main window = new Main();
        window.run();
    }
    
    class Canvas extends JPanel {
        Stage stage;

        public Canvas(String chosenAnimal){
            stage = new Stage(chosenAnimal);
            setPreferredSize(new Dimension(720, 720));

            //Add a key binding for the Escape key to return to the menu
            InputMap im = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = this.getActionMap();
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "backToMenu");
            am.put("backToMenu", new AbstractAction() {
                @Override
               public void actionPerformed(ActionEvent e){
                backToMenu();
               }
                }
            );
        }

        @Override
        public void paint(Graphics g){
            stage.paint(g, getMousePosition());
        }
    }


    private Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Menu(this));
        this.pack();
        this.setVisible(true);
    }

    public void startGame(String animal){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Canvas(animal));
        this.pack();
        this.repaint();
    }

    //Method to return to the menu
    public void backToMenu(){
        this.setContentPane(new Menu(this));
        this.pack();
        this.repaint();
    }

    public void run() {
        while (true) {
            repaint();
        }
    }
}