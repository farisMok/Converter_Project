

/**
 *
 * @author Abdulrhman
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
public class BMI extends JFrame{
      JButton back ,calc, clear,save;
    JLabel l;
    JLabel high,weight,fPrice, kg,saved,cm;
    JTextField text1, text2,res,sa;
    Font labelFont = new Font(Font.SANS_SERIF,  Font.BOLD, 32);
    Font bFonts = new Font(Font.SANS_SERIF,  Font.CENTER_BASELINE, 16);
    Font b1Fonts = new Font(Font.SANS_SERIF,  Font.BOLD, 20);

    public BMI(Home homepage, String s) {
          super(s);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        this.setLocation(500,100);
        
        //label panel
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));


        p1.setBackground(Color.decode("#36454F"));
               
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
        
        JPanel pLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pLabel.setBackground(Color.decode("#36454F"));
        l = new JLabel("BMI");
        l.setFont(labelFont);
        l.setForeground(Color.decode("#fafeff"));
        
        pLabel.add(l);
        
        //first bar
        JPanel fBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        fBar.setBackground(Color.decode("#36454F"));
        high = new JLabel(" Enter Your High ");
        high.setFont(b1Fonts);
        high.setForeground(Color.decode("#fafeff"));

        
        text1 = new JTextField(10);
        text1.setBackground(Color.decode("#fafeff"));
        text1.setForeground(Color.decode("#36454F"));
        text1.setFont(bFonts);
        
         cm = new JLabel("cm");
        cm.setForeground(Color.decode("#fafeff"));
        cm.setFont(bFonts);
        
        fBar.add(high);
        fBar.add(text1);
        fBar.add(cm);
        
        //second bar
        JPanel sBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sBar.setBackground(Color.decode("#36454F"));

        weight = new JLabel(" Enter Your Weight ");
        weight.setFont(b1Fonts);
        weight.setForeground(Color.decode("#fafeff"));
        
        text2 = new JTextField(10);
         text2.setBackground(Color.decode("#fafeff"));
         text2.setForeground(Color.decode("#36454F"));
         text2.setFont(bFonts);
        
        kg = new JLabel("kg");
        kg.setForeground(Color.decode("#fafeff"));
        kg.setFont(bFonts);
        
        sBar.add(weight);
        sBar.add( text2);
        sBar.add(kg);
        
      
        
        //Your BMI bar
        JPanel saveBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        saveBar.setBackground(Color.decode("#36454F"));
        saved = new JLabel("  Your BMI is   ");
        saved.setFont(b1Fonts);
        saved.setForeground(Color.decode("#fafeff"));

        sa = new JTextField(10);
        sa.setBackground(Color.decode("#B6BBC4"));
        sa.setForeground(Color.decode("#36454F"));
        sa.setFont(bFonts);
        sa.setEditable(false);
        
        saveBar.add(saved);
        saveBar.add(sa);
         JPanel forbmi = new JPanel(new FlowLayout(FlowLayout.CENTER));
        forbmi.setBackground(Color.decode("#36454F"));
        res = new JTextField(20);
        res.setBackground(Color.decode("#a5b0b3"));
        res.setForeground(Color.decode("#023020"));
        res.setFont(b1Fonts);
        res.setEditable(false);
        forbmi.add(res);
        
        //for clear , calculte
        JPanel foBar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        foBar.setBackground(Color.decode("#36454F"));
        calc = new JButton("Calculate");
        calc.setFocusable(false);
        calc.setFont(b1Fonts);
        calc.setBackground(Color.decode("#B6BBC4"));
        calc.setForeground(Color.decode("#023020"));
        calc.setBorderPainted(false);
        
        clear = new JButton("Clear");
        clear.setFocusable(false);
        clear.setFont(b1Fonts);
        clear.setBackground(Color.decode("#B6BBC4"));
        clear.setForeground(Color.decode("#023020"));
        clear.setBorderPainted(false);
       
        foBar.add(calc);
        foBar.add(clear);
      
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
       
        JPanel p = (JPanel)this.getContentPane();
        p.setLayout(new GridLayout(8,1));
        p.setBackground(Color.decode("#36454F"));
        p.add(p1);
        p.add(pLabel);
        p.add(fBar);
        p.add(sBar);
        p.add(saveBar);
        p.add(forbmi);
        p.add(foBar);
        p.add(p6);
       
        
        clear.addActionListener(new Clear());
        calc.addActionListener(new Calculate());
         save.addActionListener(new ActionBMI());
        this.setVisible(true);//
    }
    // Function Calculate (BMI)
    public  double CalculateBMI(double h, double w) {
    double SqrtOfHeight = h * h;
    double BMIYou = w / SqrtOfHeight;
       
    if (BMIYou < 18.5) {
         res.setText( "you are underweight.Thin and skinny");
       }
    else if (BMIYou>18.5 & BMIYou < 24.9) {
        res.setText("Congrats! You are healthy");
      } 
    else if(BMIYou>25 & BMIYou < 29.9) {
        res.setText( "You are overweight");
        
    }
    else{  
        res.setText("You are Obese");
    }
    return BMIYou;
    
}
    
    private class Clear implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==clear){
                text1.setText(" ");
                text2.setText(" ");
                sa.setText(" ");
                res.setText(" ");
            }
        }
    }
    private class ActionBMI implements ActionListener{
        public void actionPerformed(ActionEvent e){
             try{
                            if(text1.getText().equals("") || text2.getText().equals(""))
                                throw new InputException("Missing inputs");
                                String s1 = "Your High Is "+text1.getText()+"cm"+"\n"+"Your Weight Is "
                                        + text2.getText()+"kg"+"\n"+"Your BMi is "+sa.getText()+","+res.getText();
                                BufferedWriter This = new BufferedWriter(new FileWriter("History.txt",true));
                                This.write(s1+"\n\n");
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
    
    private class Calculate implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (e.getSource()==calc){
                double num1, num2,ress;
                
                try{
                    num1 = Double.parseDouble(text1.getText());
                    num2 = Double.parseDouble(text2.getText());
                 if (num1<0||num2<0) {
                            JOptionPane.showMessageDialog(null,
                                    "Negative Input!\nPlease enter positive number.",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                           
                          

    }   else{
              num1 = num1 / 100 ;
              double bmi = CalculateBMI(num1,num2);
                DecimalFormat df = new DecimalFormat("###.###");
                    sa.setText(df.format(bmi));
                   
                }}
                 catch (NumberFormatException ee) {
            JOptionPane.showMessageDialog(null, "Invalid inputs","Error",JOptionPane.ERROR_MESSAGE);
            }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,"Enter a number my friend","Error",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }
    }
    }
    

