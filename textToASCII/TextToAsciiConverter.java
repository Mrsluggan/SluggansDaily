import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TextToAsciiConverter {


    String output;
    String input;
    WindowHandler windowHandler = new WindowHandler();
    BigASCIICharacters bigASCIICharacters = new BigASCIICharacters();

    public TextToAsciiConverter() {
        handleButtons();
    }

    private void handleButtons() {

        JButton submitButton = new JButton("convert");

        submitButton.addActionListener(e -> {
            input = windowHandler.inputArea.getText();
            windowHandler.handlePrintOutput(convertToAscci(input));
        });

        JButton clearButton = new JButton("Clear");

        clearButton.addActionListener(e -> {
            input = "";
            windowHandler.inputArea.setText(input);
            windowHandler.outputArea.setText(input);
        });
        windowHandler.buttonPanel.add(submitButton);
        windowHandler.buttonPanel.add(clearButton);
    }

    public List<String[]> convertToAscci(String input) {

        output = "";
        List<String[]> listOfCharecters = new ArrayList<>();

        for (char stringChar : input.toCharArray()) {
            System.out.println(stringChar);
            switch (stringChar) {
                case 'a':
                    listOfCharecters.add(bigASCIICharacters.a_lowercase);
                    break;
                case 'b':
                    listOfCharecters.add(bigASCIICharacters.b_lowercase);
                    break;
                case 'c':
                    listOfCharecters.add(bigASCIICharacters.c_lowercase);
                    break;
                case 'd':
                    listOfCharecters.add(bigASCIICharacters.d_lowercase);
                    break;
                case 'e':
                    listOfCharecters.add(bigASCIICharacters.e_lowercase);
                    break;
                case 'f':
                    listOfCharecters.add(bigASCIICharacters.f_lowercase);
                    break;
                case 'g':
                    listOfCharecters.add(bigASCIICharacters.g_lowercase);
                    break;
                case 'h':
                    listOfCharecters.add(bigASCIICharacters.h_lowercase);
                    break;
                case 'i':
                    listOfCharecters.add(bigASCIICharacters.i_lowercase);
                    break;
                case 'j':
                    listOfCharecters.add(bigASCIICharacters.j_lowercase);
                    break;
                case 'k':
                    listOfCharecters.add(bigASCIICharacters.k_lowercase);
                    break;
                case 'l':
                    listOfCharecters.add(bigASCIICharacters.l_lowercase);
                    break;
                case 'm':
                    listOfCharecters.add(bigASCIICharacters.m_lowercase);
                    break;
                case 'n':
                    listOfCharecters.add(bigASCIICharacters.n_lowercase);
                    break;
                case 'o':
                    listOfCharecters.add(bigASCIICharacters.o_lowercase);
                    break;
                case 'p':
                    listOfCharecters.add(bigASCIICharacters.p_lowercase);
                    break;
                case 'q':
                    listOfCharecters.add(bigASCIICharacters.q_lowercase);
                    break;
                case 'r':
                    listOfCharecters.add(bigASCIICharacters.r_lowercase);
                    break;
                case 's':
                    listOfCharecters.add(bigASCIICharacters.s_lowercase);
                    break;
                case 't':
                    listOfCharecters.add(bigASCIICharacters.t_lowercase);
                    break;
                case 'u':
                    listOfCharecters.add(bigASCIICharacters.u_lowercase);
                    break;
                case 'v':
                    listOfCharecters.add(bigASCIICharacters.v_lowercase);
                    break;
                case 'w':
                    listOfCharecters.add(bigASCIICharacters.w_lowercase);
                    break;
                case 'x':
                    listOfCharecters.add(bigASCIICharacters.x_lowercase);
                    break;
                case 'y':
                    listOfCharecters.add(bigASCIICharacters.y_lowercase);
                    break;
                case 'z':
                    listOfCharecters.add(bigASCIICharacters.z_lowercase);
                    break;
                case ' ':
                    listOfCharecters.add(bigASCIICharacters.middleSpace);
                    break;
                default:
                    // Hantera okända tecken om nödvändigt, till exempel:
                    // listOfCharecters.add(bigASCIICharacters.unknown_character);
                    break;
            }
        }


        return listOfCharecters;
    }


}
