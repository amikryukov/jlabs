package javalabs.lab1;

import java.awt.*;

public class  HelloWorld {
    public HelloWorld() {
        Frame frame = new Frame("HelloWorld-example");
        frame.setSize(300, 200);
        HelloComp  c = new HelloComp();
        frame.add(c);
        frame.setVisible(true);
    }

    public static void main(String[] something){
        new HelloWorld();
    }
}

class HelloComp extends Canvas {
    public void paint(Graphics g) {
        g.drawString("Hello, World!", 100, 70);
    }
}
