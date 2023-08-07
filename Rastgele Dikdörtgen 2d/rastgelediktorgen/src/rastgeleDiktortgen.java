import javax.swing.*;
import java.awt.*;
import java.util.Random;


class Surface extends JPanel{
    private int height;
    private int width;

    private void doDrawing(Graphics g){
        height=getHeight();
        width=getWidth();
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.white);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        dikdortgen(g2d);


    }

    private void dikdortgen(Graphics2D g) {
        Random random= new Random();
        double h = height;
        double w = width-2;
        double a = w/10;
        double b = h/8;
        int i;
        int z;
        for (z=0;z<=w;z+=a) {
            for (i = 0; i < h || i < w; i += b) {
                float red = random.nextFloat();
                float green = random.nextFloat();
                float blue = random.nextFloat();
                Color rastgeleRenk = new Color(red, green, blue);
                g.setColor(rastgeleRenk);
                g.fillRect(z, i, (int) a, (int) b);
                if (i == h || i == w) {
                    break;
                }
            }

        }
        g.setColor(Color.white);
        g.fillRect(0,(int)h-4,width,200);
        g.fillRect((int)w-2,0,200,(int)h);


    }
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        doDrawing(g);
    }
}
public class rastgeleDiktortgen extends JFrame{
    public rastgeleDiktortgen(){
        Random r = new Random();

        add(new Surface());
        int width=(400+(r.nextInt(40)*10));
        int height=(200+(r.nextInt(65)*8));
        setTitle("Rastgele Dikdortgen");
        setLocationRelativeTo(null);
        setResizable(false);

        setSize(width,height);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(width);
        System.out.println(height);
    }
    public static void main(String[]args){
        rastgeleDiktortgen rd=new rastgeleDiktortgen();
        rd.setVisible(true);
    }
}