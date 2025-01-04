import javax.swing.*;
import java.util.Date;

public class MainFile {



    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimeClock::new);
    }
}