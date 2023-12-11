/**
 *
 * @author MUSTAFA
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Mass extends JFrame {
    
    JLabel title;
    
    JComboBox list1, list2;
    String measurments[] = {"Tonne | T", "Kilogram | Kg", "Gram | G", "Pound | Lb", "Ounce | Oz"};

    JTextField text1, text2;
    
    JButton convert, clear, back, save;
    
    boolean noError = true;
    
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    
    public Mass(Home homepage) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(500,100);
        this.setTitle("Mass");
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.setBackground(Color.decode("#36454F"));
               
        back = new JButton ("Back");
        back.setFocusable(false);
        back.setFont(bFonts);
        back.setBackground(Color.decode("#B6BBC4"));
        back.setForeground(Color.decode("#31304D"));
        back.setBorderPainted(false);
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                homepage.setVisible(true);
            }
        });
        
        p1.add(back);
        
        JPanel pLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pLabel.setBackground(Color.decode("#36454F"));
        title = new JLabel("Mass");
        title.setFont(labelFont);
        title.setForeground(Color.decode("#fafeff"));
        pLabel.add(title);
        
        //First bar
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2.setBackground(Color.decode("#36454F"));
        list1 = new JComboBox(measurments);
        list1.setBackground(Color.decode("#fafeff"));
        list1.setForeground(Color.decode("#36454F"));
        list1.setFont(bFonts);
        list1.setFocusable(false);
        
        text1 = new JTextField(10);
        text1.setBackground(Color.decode("#fafeff"));
        text1.setForeground(Color.decode("#36454F"));
        text1.setFont(bFonts);
        p2.add(list1);
        p2.add(text1);
        
        
        //second bar
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3.setBackground(Color.decode("#36454F"));
        list2 = new JComboBox(measurments);
        list2.setBackground(Color.decode("#fafeff"));
        list2.setForeground(Color.decode("#36454F"));
        list2.setFont(bFonts);
        list2.setFocusable(false);
        
        text2 = new JTextField(10);
        text2.setEditable(false);
        text2.setBackground(Color.decode("#B6BBC4"));
        text2.setForeground(Color.decode("#36454F"));       
        text2.setFont(bFonts);
        text2.setEditable(false);
        p3.add(list2);
        p3.add(text2);
        
       
        //functions bar
        JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p5.setBackground(Color.decode("#36454F"));
        convert = new JButton("Convert");
        convert.setFont(bFonts);
        convert.setBackground(Color.decode("#B6BBC4"));
        convert.setForeground(Color.decode("#31304D"));
        convert.setFocusable(false);
        convert.setBorderPainted(false);
       
        clear = new JButton("Clear");
        clear.setFont(bFonts);
        clear.setBackground(Color.decode("#B6BBC4"));
        clear.setForeground(Color.decode("#31304D"));
        clear.setFocusable(false);
        clear.setBorderPainted(false);

        p5.add(convert);
        p5.add(clear);
        
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p6.setBackground(Color.decode("#36454F"));
        save = new JButton("Save");
        save.setFont(bFonts);
        save.setBackground(Color.decode("#B6BBC4"));
        save.setForeground(Color.decode("#31304D"));
        save.setFocusable(false);
        save.setBorderPainted(false);
        p6.add(save);
       
        //main bar
        JPanel p = (JPanel)this.getContentPane();
        p.setLayout(new GridLayout(6,1));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(pLabel);
        p.add(p2);
        p.add(p3);
        p.add(p5);
        p.add(p6);
        this.setVisible(true);
        
        //action listeners call
        /*---*/
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setText("");
                text2.setText("");
            }
        });
        
        convert.addActionListener(new Action());
        save.addActionListener(new Action());
        
    }
    
    private class Action implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if(e.getSource() == convert || e.getSource() == save) {
                double num1, result = 0;
                boolean noError = true;
                try {
                    num1 = Double.parseDouble(text1.getText());
                    String s1 = String.valueOf(list1.getSelectedItem());
                    String s2 = String.valueOf(list2.getSelectedItem());
                    
                    if(num1 < 0) {
                    JOptionPane.showMessageDialog(null,  "Negative Input! ", "Error", JOptionPane.ERROR_MESSAGE);
                    } else 
                    if (s1.equals("Tonne | T")) {
                        switch(s2) {
                            case "Tonne | T":
                                result = num1;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Kilogram | Kg":
                                result = num1 * 1000;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Gram | G":
                                result = num1 * 1000000;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Pound | Lb":
                                result = num1 * 2205;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Ounce | Oz":
                                result = num1 * 35270;
                                text2.setText(String.format("%.4f", result));
                                break;
                        }
                    }
                    //converting from Kilogram to other units
                    if(s1.equals("Kilogram | Kg")) {
                        switch (s2){
                            case "Tonne | T":
                                result = num1 / 1000;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Kilogram | Kg":
                                result = num1;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Gram | G":
                                result = num1 * 1000;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Pound | Lb":
                                result = num1 * 2.205;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Ounce | Oz":
                                result = num1 * 35.274;
                                text2.setText(String.format("%.4f", result));
                                break; 
                        }
                    }
                    //converting from Gram to other units
                    if(s1.equals("Gram | G")) {
                        switch(s2) {
                            case "Tonne | T":
                                result = num1 / 1000000;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Kilogram | Kg":
                                result = num1 / 1000;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Gram | G":
                                result = num1;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Pound | Lb":
                                result = num1 / 453.6;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Ounce | Oz":
                                result = num1 / 28.35;
                                text2.setText(String.format("%.4f", result));
                                break; 
                        }
                    }
                    //converting from Pound to other units
                    if(s1.equals("Pound | Lb")){
                        switch(s2){
                            case "Tonne | T":
                                result = num1 / 2205 ;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Kilogram | Kg":
                                result = num1 / 2.205;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Gram | G":
                                result = num1 * 453.6;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Pound | Lb":
                                result = num1;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Ounce | Oz":
                                result = num1 * 16;
                                text2.setText(String.format("%.4f", result));
                                break; 
                        }
                    }
                    //converting from Ounce to other units
                    if(s1.equals("Ounce | Oz")) {
                        switch(s2) {
                            case "Tonne | T":
                                result = num1 / 35270 ;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Kilogram | Kg":
                                result = num1 / 35.274;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Gram | G":
                                result = num1 * 28.35;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Pound | Lb":
                                result = num1 / 16;
                                text2.setText(String.format("%.4f", result));
                                break;
                            case "Ounce | Oz":
                                result = num1;
                                text2.setText(String.format("%.4f", result));
                                break; 
                        }
                    }
                }
                catch(Exception e1) {
                    JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    noError = false;
                }
            
                
                if(e.getSource()== save && noError) {
                    try {
                        if(text1.getText().equals("") || text2.getText().equals("")) {
                            throw new InputException("Missing inputs");
                        }
                        String s = text1.getText() + " " + String.valueOf(list1.getSelectedItem()) + " = " + text2.getText() + " "+String.valueOf(list2.getSelectedItem());
                        BufferedWriter file = new BufferedWriter(new FileWriter("History.txt",true));
                        file.write(s+"\n\n");
                        file.close();
                        JOptionPane.showMessageDialog(null, "Saving is done", "Save", JOptionPane.INFORMATION_MESSAGE);
                    }
                    catch(IOException e1) {
                        JOptionPane.showMessageDialog(null, "I/O Error","Save failed",JOptionPane.ERROR_MESSAGE);
                    }
                    catch(InputException e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }            
        }
    }
}