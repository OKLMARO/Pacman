import javax.swing.JFrame;

public class Gui {
    private Vue view;

    /**
     * Constructeur de la classe Gui
     */
    public Gui(){
        Partie partie = new Partie();
        this.view = new Vue(partie);

        JFrame frame = new JFrame("Pacman");
        frame.setContentPane(view);
        frame.setSize(view.getSize());
        frame.setLocation(100, 100);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Retourne la vue
     * 
     * @return Vue
     */
    public Vue getView() {
        return view;
    }
}
