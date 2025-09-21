import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Menu extends JPanel {
    public Menu(Main mainMenu) {
        setPreferredSize(new Dimension(720, 720));
        setLayout(new GridLayout(3, 1, 20, 10));

        JButton dog = new JButton("Play as Dog");
        JButton cat = new JButton("Play as Cat");
        JButton bird = new JButton("Play as Bird");


        dog.addActionListener (e -> mainMenu.startGame("Dog"));
        cat.addActionListener (e -> mainMenu.startGame("Cat"));
        bird.addActionListener (e -> mainMenu.startGame("Bird"));

        add (dog);
        add (cat);
        add (bird);
    }

}
