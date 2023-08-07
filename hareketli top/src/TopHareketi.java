

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


class Surface extends JPanel implements Runnable {
    private int y1=0;
    private Thread runner;


    public Surface() {
        initThread();
    }
    private void initThread() {

        runner=new Thread(this);
        runner.start();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setPaint(new Color(50, 50, 50));

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        run();
        g2d.fillOval(200,y1,50,50);

        g2d.dispose();
    }
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }


    @Override
    public void run() {

        if (y1<getHeight()-50){
            y1 ++;
            repaint();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

public class TopHareketi extends JFrame {

    public TopHareketi(){

        add(new Surface());

        setTitle("Top Hareketi");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TopHareketi ex = new TopHareketi();
                ex.setVisible(true);
            }
        });
    }
}
