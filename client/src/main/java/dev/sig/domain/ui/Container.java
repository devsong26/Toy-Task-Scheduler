package dev.sig.domain.ui;

import dev.sig.framework.annotation.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Container {

    private Header header;
    private Body body;
    private Footer footer;

    private Container(){}

    public void render(){
        render2();
    }

    private void render2(){
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(500, 1000));
        frame.setVisible(true);
    }

}
