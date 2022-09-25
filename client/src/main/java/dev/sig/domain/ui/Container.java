package dev.sig.domain.ui;

import javax.swing.*;
import java.awt.*;

public class Container {

    private static final Container INSTANCE = new Container();
    private static final Header header = Header.getInstance();
    private static final Body body = Body.getInstance();
    private static final Footer footer = Footer.getInstance();

    public void render(){
        render2();
    }

    public static Container getInstance(){
        return INSTANCE;
    }

    private void render2(){
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 1000));
        frame.setVisible(true);
    }



}
