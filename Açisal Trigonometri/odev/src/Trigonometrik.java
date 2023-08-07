import java.awt.*;
import java.awt.geom.GeneralPath;
import javax.swing.*;

class Surface extends JPanel {
    int sinira;
    int sinirb;
    int gen;
    public Surface(){
        kullanici();
        hata();
    }
    private void hata(){
        System.out.println();
        JOptionPane.showMessageDialog(null,"Sinüs ile Kosinüs -360 ile +360 aralığındadır.");

    }
    private void kullanici(){
        String sinirx= JOptionPane.showInputDialog(null,"Eksi sınırı girin:");
        sinira=Integer.valueOf(sinirx);
        if(sinira<-360){
            JOptionPane.showMessageDialog(null,"-360'dan daha küçük olamaz");
            sinira=-360;

        } else if (sinira>0) {
            JOptionPane.showMessageDialog(null,"Eksi sınır 0 dan büyük olamaz");
            sinira=0;
        }
        System.out.println("Eksi Sınır"+sinira);

        String siniry=JOptionPane.showInputDialog(null,"Artı sınır değeri girin");
        sinirb=Integer.valueOf(siniry);
        if(sinirb>360){
            JOptionPane.showMessageDialog(null,"360'dan büyük olamaz");
        } else if (sinirb<0) {
            JOptionPane.showMessageDialog(null,"0'dan küçük olamaz");
            sinirb=0;

        }
        System.out.println("Artı Sınır"+sinirb);
        String genlik=JOptionPane.showInputDialog(null,"Genlik değeri girin");
        gen=Integer.valueOf(genlik);
        if(gen<=10){
            JOptionPane.showMessageDialog(null,"Genlik minimum 10 olmalıdır");
            gen=10;

        }
        System.out.println("Genlik Değeri"+gen);


        }int sinusDegeri(int x){
            return getHeight()/2-(int)(gen*Math.sin(x*Math.PI/180));

        }
        int cosinusDegeri(int x){
            return getHeight()/2-(int)(gen*Math.cos(x*Math.PI/180));
        }
        int tanjantDegeri(int x){
            return getHeight()/2-(int)(gen*Math.tan(x*Math.PI/180));
        }
        int cotanjantDegeri(int x){
            return getHeight()/2-(int)(gen/Math.tan(x*Math.PI/180));
        }
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        int w= getWidth();
        int h= getHeight();
        g2d.setPaint(Color.BLACK);
        g2d.drawLine(w/10,h/2,(int)(w*0.9),h/2);//X çizgim
        g2d.drawLine(w/2,h/10,w/2,(int)(h*0.9));//y çizgim
        g2d.drawLine((w/10)+20,h/2+20,w/10,h/2);//-x
        g2d.drawLine((w/10)+20,(h/2)-20,w/10,h/2);

        g2d.drawLine((int)(w*0.9),h/2,(int)(w*0.9)-20,(h/2)+20); //+çizgi okları
        g2d.drawLine((int)(w*0.9),h/2,(int)(w*0.9)-20,(h/2)-20);

        g2d.drawLine(w/2,h/10,(w/2)-20,(h/10)+20);//+y
        g2d.drawLine(w/2,h/10,(w/2)+20,(h/10)+20);




        g2d.drawLine(w/2,(int)(h*0.9),(w/2)-20,(int)((h*0.9)-20));//-y
        g2d.drawLine(w/2,(int)(h*0.9),(w/2)+20,(int)((h*0.9)-20));

        g2d.drawString("-2π",(w/10)+30,(h/2)+20);
        g2d.drawString("2π",(int)((w*0.9)-40),(h/2)+20);
        g2d.drawString("0",(w/2)+10,(h/2)+20);
        GeneralPath sinusPath=new GeneralPath();
        sinusPath.moveTo(w/2-sinira,sinusDegeri(sinira));
        for(int i=sinira; i<=sinirb;i++){
            sinusPath.lineTo(w/2+i,sinusDegeri(i));
        }
        g2d.setColor(Color.blue);
        g2d.draw(sinusPath);
        GeneralPath cosinusPath=new GeneralPath();
        cosinusPath.moveTo(w/2-sinira,cosinusDegeri(sinira));
        for(int i=sinira;i<=sinirb;i++){
            cosinusPath.lineTo(w/2+i,cosinusDegeri(i));
        }
        g2d.setColor(Color.red);
        g2d.draw(cosinusPath);

        GeneralPath tanjantPath=new GeneralPath();
        tanjantPath.moveTo(w/2-sinira,tanjantDegeri(sinira));
        for(int i=sinira;i<=sinirb;i++){
            tanjantPath.lineTo(w/2+i,tanjantDegeri(i));
        }
        g2d.setColor(new Color(255,165,0));
        g2d.draw(tanjantPath);
        GeneralPath cotanjantPath=new GeneralPath();
        cotanjantPath.moveTo(w/2+sinira,cosinusDegeri(sinira));
        for(int i=sinira;i<=sinirb;i++){
            cotanjantPath.lineTo(w/2+i,cotanjantDegeri(i));
        }
        g2d.setColor(new Color(145,0,220));
        g2d.draw(cotanjantPath);





    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class Trigonometrik extends JFrame {

    public Trigonometrik() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Sinüs, Cosinüs, Tanjant, Cotanjant");
        setSize(1024, 960);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Trigonometrik ex = new Trigonometrik();
                ex.setVisible(true);
            }
        });
    }
}