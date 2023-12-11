

/**
 *
 * @author Abdulrhman
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Currency extends JFrame {
JComboBox list1, list2;
    JTextField text1, text2;
    JButton convert, clear, back, save;
    JLabel l;
    boolean isSaved = false;
    String measurments[]={"USD | US dollar","ERU | Euro","SAR | Saudi Riyal","GBP | British Pound", "JPY | Japanese Yen"};
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    public Currency(Home home) {
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(500,100);
        this.setTitle("Currency");
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        p1.setBackground(Color.decode("#36454F"));
               
        back = new JButton ("Back");
        back.setFocusable(false);
        back.setFont(bFonts);
        back.setBackground(Color.decode("#B6BBC4"));
        back.setForeground(Color.decode("#31304D"));
        back.setBorderPainted(false);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                setVisible(false);
                home.setVisible(true);
            }
        });
        
        p1.add(back);
        JPanel pLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pLabel.setBackground(Color.decode("#36454F"));
        l = new JLabel("Currency");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
        
        pLabel.add(l);
        
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
        p3.add(list2);
        p3.add(text2);
        
       
        //functions 
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
        this.setVisible(true);//
        
        //action listeners of currency
        clear.addActionListener(new ClearText());
        save.addActionListener(new Save());
        convert.addActionListener(new Calculate());
    }
   private class Save implements ActionListener{
        public void actionPerformed (ActionEvent e){         
                            try{
                            if(text1.getText().equals("") || text2.getText().equals(""))
                                throw new InputException("Missing inputs");
                                String s = text1.getText()+" "+String.valueOf(list1.getSelectedItem())+" = "+ text2.getText()+" "+String.valueOf(list2.getSelectedItem());
                                BufferedWriter This = new BufferedWriter(new FileWriter("History.txt",true));
                                This.write(s+"\n\n");
                                This.close();
                                JOptionPane.showMessageDialog(null, "Saving is done", "Save", JOptionPane.INFORMATION_MESSAGE);
                        }
                        catch(IOException e1){
                                JOptionPane.showMessageDialog(null, "I/O Error","Save failed",JOptionPane.ERROR_MESSAGE);

                        }
                        catch(InputException e2){
                        JOptionPane.showMessageDialog(null, e2.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);

                        }
        }
    }
    private class ClearText implements ActionListener{
        public void actionPerformed (ActionEvent e){
                text1.setText("");
                text2.setText("");
        }
    }
    private class Calculate implements ActionListener{
        public void actionPerformed (ActionEvent e){
        try{    double num1,result;
            num1 = Double.parseDouble(text1.getText());
            String s1 = String.valueOf(list1.getSelectedItem());
            String s2 = String.valueOf(list2.getSelectedItem());
       if (num1<0) {
                            JOptionPane.showMessageDialog(null,
                                    "Negative Input!\nPlease enter positive number in a currency.",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);

    }      
       else if(e.getSource()==convert){ // same as line 124 no need ... Ifaris25 (:
                //converting from USD to other 
                if (s1.equals("USD | US dollar")){
                    switch(s2){
                        case "USD | US dollar":
                            result = num1;
                            text2.setText(result+"");
                            break;
                        case "ERU | Euro":
                            result = num1*0.919242 ;
                            text2.setText(result+"");
                            break;
                        case "SAR | Saudi Riyal":
                            result = num1*3.75;
                            text2.setText(result+"");
                            break;
                        case "GBP | British Pound":
                            result = num1 * 0.78731335;
                            text2.setText(result+"");
                            break;
                        case "JPY | Japanese Yen":
                            result = num1 * 146.80719;
                            text2.setText(result+"");
                            break;
                    }
              
                }
                }
                //converting from ERU to other 
                if(s1.equals("ERU | Euro")){
                    switch (s2){
                        case "USD | US dollar":
                            result = num1/0.919242;
                            text2.setText(result+"");
                            break;//USD | US dollar","ERU | Euro","SAR | Saudi Riyal","GBP | British Pound", "JPY | Japanese Yen
                        case "ERU | Euro":
                            result = num1;
                            text2.setText(result+"");
                            break;
                        case "SAR | Saudi Riyal":
                            result = num1 * 4.0794463;
                            text2.setText(result+"");
                            break;
                        case "GBP | British Pound":
                            result = 0.856473 / num1;
                            text2.setText(result+"");
                            break;
                        case "JPY | Japanese Yen":
                            result = num1 * 159.694;
                            text2.setText(result+"");
                            break; 
                    }
                }
                //converting from SAR to other
                if(s1.equals("SAR | Saudi Riyal")){
                    switch(s2){
                        case "USD | US dollar":
                            result = 0.26666667  * num1;
                            text2.setText(result+"");
                            break;
                        case "ERU | Euro":
                            result = 0.24514719 * num1;
                            text2.setText(result+"");
                            break;
                        case "SAR | Saudi Riyal":
                            result = num1;
                            text2.setText(result+"");
                            break;
                        case "GBP | British Pound":
                            result = num1 * 0.20994832;
                            text2.setText(result+"");
                            break;
                        case "JPY | Japanese Yen":
                            result = num1 * 39.148583;
                            text2.setText(result+"");
                            break; 
                    }
                }
                //converting from GBP to other 
                if(s1.equals("GBP | British Pound")){
                    switch(s2){
                        case "USD | US dollar":
                            result = num1 / 0.787306 ;
                            text2.setText(result+"");
                            break;
                        case "ERU | Euro":
                            result = num1 / 0.856411;
                            text2.setText(result+"");
                            break;
                        case "SAR | Saudi Riyal":
                            result = num1 * 4.7631116;
                            text2.setText(result+"");
                            break;
                        case "GBP | British Pound":
                            result = num1;
                            text2.setText(result+"");
                            break;
                        case "JPY | Japanese Yen":
                            result = num1 *186.46771 ;
                            text2.setText(result+"");
                            break; 
                    }
                }
                //converting from JPY to other units
                if(s1.equals("JPY | Japanese Yen")){
                    switch(s2){
                        case "USD | US dollar":
                            result = num1 * 0.0068116556 ;
                            text2.setText(result+"");
                            break;
                        case "ERU | Euro":
                            result = num1 * 0.0062619683;
                            text2.setText(result+"");
                            break;
                        case "SAR | Saudi Riyal":
                            result = num1 * 0.02555437;
                            text2.setText(result+"");
                            break;
                        case "GBP | British Pound":
                            result = num1 * 0.0053628197;
                            text2.setText(result+"");
                            break;
                        case "JPY | Japanese Yen":
                            result = num1;
                            text2.setText(result+"");
                            break; 
                    }
                }
                //end of converting
            }  catch(Exception ee){
                    JOptionPane.showMessageDialog(null,"Enter a number my friend","Error",JOptionPane.ERROR_MESSAGE);
            }
           
               
            }
    }
    
}
