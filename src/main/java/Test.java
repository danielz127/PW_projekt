import java.awt.*;
import java.io.IOException;

/**
 * Created by Daniel on 2017-05-15.
 */
public class Test {
    public static void main(String[] args) {
        EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        try {
                            new Okno();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
    }
}


