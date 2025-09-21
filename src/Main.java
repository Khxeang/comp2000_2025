import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

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

    public void run() {
        while (true) {
            repaint();
        }
    }
}