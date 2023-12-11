

/**
 *
 * @author Abdulrhman
 */
//import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Age extends JFrame {
JButton back,Cal_Age,clear , save;
    JLabel l , fDate, sDate;
    JComboBox fdays, fmonths, sdays, smonths;      
    JTextField year_1, year_2,result;
    String days[];
    String months[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
    int d=1;
    int da,mo,ye;
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    Font b1Fonts = new Font(Font.SANS_SERIF,  Font.BOLD, 24);
    public Age(Home ho,String s) {
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
        back.setBackground(Color.decode("#a5b0b3"));
        back.setForeground(Color.decode("#023020"));
        back.setBorderPainted(false);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                setVisible(false);
                ho.setVisible(true);
            }
        });
        p1.add(back);
        
        //Label bar
        JPanel pLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pLabel.setBackground(Color.decode("#36454F"));
        l = new JLabel("Age");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
        pLabel.add(l);
        
        //First date label panel
        JPanel fD = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fD.setBackground(Color.decode("#36454F"));
        fDate = new JLabel("Enter Your Brithday");
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
        
      
        
        //Calculate button
        JPanel cal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cal.setBackground(Color.decode("#36454F"));
        Cal_Age = new JButton("Calculate Age");
        Cal_Age.setFont(b1Fonts);
        Cal_Age.setBackground(Color.decode("#a5b0b3"));
        Cal_Age.setForeground(Color.decode("#023020"));
        Cal_Age.setFocusable(false);
        Cal_Age.setBorderPainted(true);
        //clear button
        clear = new JButton("clear");
        clear.setFont(b1Fonts);
        clear.setBackground(Color.decode("#a5b0b3"));
        clear.setForeground(Color.decode("#023020"));
        clear.setFocusable(false);
        clear.setBorderPainted(true);
        cal.add(Cal_Age);
        cal.add(clear);
        
        // save bar
         JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
       p6.setBackground(Color.decode("#36454F"));
       save = new JButton("Save");
       save.setFont(bFonts);
       save.setBackground(Color.decode("#B6BBC4"));
       save.setForeground(Color.decode("#023020"));
       save.setFocusable(false);
       save.setBorderPainted(false);
       p6.add(save);
       
        //result bar
        JPanel res = new JPanel(new FlowLayout(FlowLayout.CENTER));
        res.setBackground(Color.decode("#36454F"));
        result = new JTextField(20);
        result.setBackground(Color.decode("#a5b0b3"));
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
        p.add(cal);
        p.add(res);
        p.add(p6);
        
        this.setVisible(true);
        
        Cal_Age.addActionListener(new Calc_Age());
        clear.addActionListener(new ClearFunc());
        save.addActionListener(new  ActionAge() );
    }
    
    private class Calc_Age implements ActionListener{
        public void actionPerformed(ActionEvent e){
try{  
    int birthDay = Integer.parseInt((String) fdays.getSelectedItem());
        int birthMonth = Integer.parseInt((String) fmonths.getSelectedItem());
        int birthYear = Integer.parseInt(year_1.getText());
    if (birthYear<0) {
                            JOptionPane.showMessageDialog(null,
                                    "Negative Input!\nPlease enter positive number in  the year.  ",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);

    }
    else{
        Calendar birthCalendar = new GregorianCalendar(birthYear, birthMonth-1 , birthDay);
        Calendar currentCalendar = Calendar.getInstance();

        int age = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

        if (currentCalendar.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        result.setText("Your age is: " + age + " years.");}}
            catch(Exception ee){
                    JOptionPane.showMessageDialog(null,"Enter a number my friend","Error",JOptionPane.ERROR_MESSAGE);
                }
       }}
    
    private class ClearFunc implements ActionListener{
        public void actionPerformed (ActionEvent e){
            fdays.setSelectedIndex(0);
          
            fmonths.setSelectedIndex(0);
           
            year_1.setText("");
            
            result.setText("");
        }
    }
    private class ActionAge implements ActionListener{
        public void actionPerformed(ActionEvent e){
             try{
                            if(year_1.getText().equals("") )
                                throw new InputException("Missing inputs");
                                String s3 = "Your Brithday is "+fdays.getSelectedItem()+"/"+ fmonths.getSelectedItem()+
                                      "/"+year_1.getText()+"\n"+result.getText();
                                BufferedWriter This = new BufferedWriter(new FileWriter("History.txt",true));
                                This.write(s3+"\n\n");
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

    }

