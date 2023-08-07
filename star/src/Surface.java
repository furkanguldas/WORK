import javax.swing.*;
import java.awt.*;


class Surface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(30, 30, 200, 30);

    }
    @Override
    public void paintComponent(Graphics g) { //içerisine bir resim kompenenti eklenir

        super.paintComponent(g);
        doDrawing(g);
    }
}

