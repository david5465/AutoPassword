import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class SimuladorTeclado {

    public static void main(String[] args) {
        String password = "N2H2vWw7E";

        try {
            Robot robot = new Robot();
            robot.delay(100);
            for (char c : password.toCharArray()) {
                boolean isUpperCase = Character.isUpperCase(c);
                if (isUpperCase) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }

                int keyCode = KeyEvent.getExtendedKeyCodeForChar(Character.toLowerCase(c));

                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);

                if (isUpperCase) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
                robot.delay(100);
            }
            robot.keyPress(10);
            robot.keyRelease(10);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}