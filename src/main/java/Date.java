/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faris-Almokayad
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date extends JFrame{
    JButton back,find_Dif,clr;
    JLabel l , fDate, sDate;
    JComboBox fdays, fmonths, sdays, smonths;      
    JTextField year_1, year_2,result;
    String days[];
    String months[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
    int d=1;
    int da,mo,ye;
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    Font b1Fonts = new Font(Font.SANS_SERIF,  Font.BOLD, 20);
    public Date(Home homepage,String s){
        super(s);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(500,100);
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        p1.setBackground(Color.decode("#36454F"));
               
        //Back bar
        back = new JButton ("Back");
        back.setFocusable(false);
        back.setFont(bFonts);
        back.setBackground(Color.decode("#B6BBC4"));
        back.setForeground(Color.decode("#023020"));
        back.setBorderPainted(false);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                setVisible(false);
                homepage.setVisible(true);
            }
        });
        p1.add(back);
        
        //Label bar
        JPanel pLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pLabel.setBackground(Color.decode("#36454F"));
        l = new JLabel("Date");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
        pLabel.add(l);
        
        //First date label panel
        JPanel fD = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fD.setBackground(Color.decode("#36454F"));
        fDate = new JLabel("First date");
        fDate.setFont(b1Fonts);
        fDate.setForeground(Color.decode("#fafeff"));
        fD.add(fDate);
        
        //first days/months/year panel
        JPanel fLists = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fLists.setBackground(Color.decode("#36454F"));
        
        days = new String[30];
        for(int i =0;i<30;i++){
            days[i]=String.valueOf(d);
            d++;
        }
      
        fdays = new JComboBox(days);
        fdays.setBackground(Color.decode("#fafeff"));
        fdays.setForeground(Color.decode("#36454F"));
        fdays.setFont(bFonts);
        fdays.setFocusable(false);
        
        fmonths = new JComboBox(months);
        fmonths.setBackground(Color.decode("#fafeff"));
        fmonths.setForeground(Color.decode("#36454F"));
        fmonths.setFont(bFonts);
        fmonths.setFocusable(false);
       
        year_1 = new JTextField(5);
        year_1.setBackground(Color.decode("#fafeff"));
        year_1.setForeground(Color.decode("#36454F"));
        year_1.setFont(bFonts);
        
        
        fLists.add(fdays);
        fLists.add(fmonths);
        fLists.add(year_1);
        
        //First date components
        JPanel pfd = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pfd.setBackground(Color.decode("#36454F"));
        
        pfd.add(fD);
        pfd.add(fLists);
        
        //second date label bar
        JPanel sD = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sD.setBackground(Color.decode("#36454F"));
        sDate = new JLabel("Second date");
        sDate.setFont(b1Fonts);
        sDate.setForeground(Color.decode("#fafeff"));
        sD.add(sDate);
        
        //second days/months/year panel a5b0b3
        JPanel sLists = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sLists.setBackground(Color.decode("#36454F"));
        sdays = new JComboBox(days);
        sdays.setBackground(Color.decode("#fafeff"));
        sdays.setForeground(Color.decode("#36454F"));
        sdays.setFont(bFonts);
        sdays.setFocusable(false);
        
        smonths = new JComboBox(months);
        smonths.setBackground(Color.decode("#fafeff"));
        smonths.setForeground(Color.decode("#36454F"));
        smonths.setFont(bFonts);
        smonths.setFocusable(false);
        
        year_2 = new JTextField(5);
        year_2.setBackground(Color.decode("#fafeff"));
        year_2.setForeground(Color.decode("#36454F"));
        year_2.setFont(bFonts);
        
        sLists.add(sdays);
        sLists.add(smonths);
        sLists.add(year_2);
        //second date components
        JPanel psd = new JPanel(new FlowLayout(FlowLayout.CENTER));
        psd.setBackground(Color.decode("#36454F"));
        
        psd.add(sD);
        psd.add(sLists);
        
        //Find difference button
        JPanel fDif = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fDif.setBackground(Color.decode("#36454F"));
        find_Dif = new JButton("Find difference");
        find_Dif.setFont(b1Fonts);
        find_Dif.setBackground(Color.decode("#B6BBC4"));
        find_Dif.setForeground(Color.decode("#023020"));
        find_Dif.setFocusable(false);
        find_Dif.setBorderPainted(true);
        
        clr = new JButton("Clear");
        clr.setFont(b1Fonts);
        clr.setBackground(Color.decode("#B6BBC4"));
        clr.setForeground(Color.decode("#023020"));
        clr.setFocusable(false);
        clr.setBorderPainted(true);
        fDif.add(find_Dif);
        fDif.add(clr);
        
        //result bar
        JPanel res = new JPanel(new FlowLayout(FlowLayout.CENTER));
        res.setBackground(Color.decode("#36454F"));
        result = new JTextField(20);
        result.setBackground(Color.decode("#B6BBC4"));
        result.setForeground(Color.decode("#023020"));
        result.setFont(b1Fonts);
        result.setEditable(false);
        
        
        
        res.add(result);
        //main bar
        JPanel p = (JPanel)this.getContentPane();
        p.setLayout(new GridLayout(6,1));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(pLabel);
        p.add(pfd);
        p.add(psd);
        p.add(fDif);
        p.add(res);
        
        this.setVisible(true);
        
        find_Dif.addActionListener(new Calc());
        clr.addActionListener(new Clr());
    }
    
    private class Calc implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
            int firstDay = Integer.parseInt(fdays.getSelectedItem().toString());
            int firstMonth = Integer.parseInt(fmonths.getSelectedItem().toString());
            int firstYear = Integer.parseInt(year_1.getText());

            int secondDay = Integer.parseInt(sdays.getSelectedItem().toString());
            int secondMonth = Integer.parseInt(smonths.getSelectedItem().toString());
            int secondYear = Integer.parseInt(year_2.getText());
            
            if(firstYear <0 || secondYear <0){
                JOptionPane.showMessageDialog(null, "Negative year!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
            if (firstYear > secondYear){
                ye = firstYear - secondYear;
            }
            else if(firstYear <= secondYear){
                ye = secondYear-firstYear;
            }
            
            if(firstMonth > secondMonth){
                mo = firstMonth - secondMonth;
            }
            else if(firstMonth <= secondMonth){
                mo = secondMonth - firstMonth;
            }
            
            if(firstDay > secondDay){
                da = firstDay - secondDay;
            }
            else if(firstDay <= secondDay){
                da = secondDay - firstDay;
            }
            result.setText(ye+" Years - "+mo+" Months - "+da+" Days");
            } 
            }
            catch (NumberFormatException ee) {
            JOptionPane.showMessageDialog(null, "Invalid inputs","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
       }
    
    private class Clr implements ActionListener{
        public void actionPerformed (ActionEvent e){
            fdays.setSelectedIndex(0);
            sdays.setSelectedIndex(0);
            fmonths.setSelectedIndex(0);
            smonths.setSelectedIndex(0);
            year_1.setText("");
            year_2.setText("");
            result.setText("");
        }
    }
    }
    

