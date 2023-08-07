import javax.swing.*;
import java.awt.*;
import java.util.Random;



class Surface extends JPanel{
    private void doDrawing(Graphics g ){
       Graphics2D g2d = (Graphics2D) g;
       float[] dash={4f,4f,1f};
       BasicStroke bs = new BasicStroke(2,BasicStroke.CAP_BUTT,
               BasicStroke.JOIN_ROUND,1.0f,dash,2f);
        int width=getWidth();
        int height=getHeight();
        Random random = new Random();
        for(int i=0; i<10;i++){
            float alpha=(i+1)*0.1f;
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER,alpha);
            g2d.setComposite(alcom);

            for(int j=0;j<8;j++){
                g2d.setStroke(bs);
                g2d.setPaint(Color.black);
                float red=random.nextFloat();
                float blue= random.nextFloat();
                float green= random.nextFloat();
                g2d.drawRect(i*(width/10),j*(height/8),width/10,height/8);
                g2d.setPaint(new Color(red,blue,green));
                g2d.fillRect(i*(width/10),j*(height/8),width/10,height/8);
            }

        }


    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }
}
public class dikdortgen extends JFrame{
    public dikdortgen(){
        initUI();
    }


    private void initUI() {
        Random rastgele = new Random();
        int h= rastgele.nextInt(521)+200;
        int w= rastgele.nextInt(401)+400;

        add(new Surface());
        setTitle("Saydamlık");
        setSize(h,w);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


    }
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                dikdortgen d = new dikdortgen();
                d.setVisible(true);

            }
        });

    }
}