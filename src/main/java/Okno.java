import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Daniel on 2017-05-16.
 */
public class Okno extends JFrame {
    public PanelTrasy pg;

    Okno() throws IOException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Metro");
        setIconImage(new ImageIcon("Train.jpg").getImage());
        setSize(600, 750);
        setResizable(false);
        setFocusable(true);
        setVisible(true);
        setLocation(getWidth() / 2, getHeight() / 10);

        pg = new PanelTrasy();
        add(pg, BorderLayout.CENTER);
    }
}
