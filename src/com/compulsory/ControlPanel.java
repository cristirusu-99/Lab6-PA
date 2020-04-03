package com.compulsory;

import javafx.scene.shape.Shape;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn;
    //create all buttons (Load, Reset, Exit)
    JButton loadBtn;
    JButton resetBtn;
    JButton exitBtn;
 //...DONE
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        saveBtn = new JButton("Save");
        loadBtn = new JButton("Load");
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...DONE
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
 //...DONE
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("output/test.png"));
        } catch (IOException ex) { System.err.println(ex + " :: Save Error!"); }
    }

    private void load(ActionEvent e){
        try {
            frame.canvas.image = ImageIO.read(new File("output/test.png"));
        } catch (IOException ex) { System.err.println(ex + " :: Load Error!"); }
        frame.canvas.paintComponent(frame.canvas.graphics);
    }

    private void reset(ActionEvent e) {
        Color currentColor = frame.canvas.graphics.getColor();
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fill(new RegularPolygon(frame.canvas.getW()/2, frame.canvas.getH()/2, frame.canvas.getW()+frame.canvas.getH(), 4));
    }

    private void exit(ActionEvent e ){
        frame.dispose();
    }
 //...TODO
}

