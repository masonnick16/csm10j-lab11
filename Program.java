
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
/**
 *
 * @author Nick
 */
public class Program extends JFrame{
    private JTextField[] grades;
    private JTextField[] weights;
    private JTextField finGrade;
    public void setup(){
        setLayout( new GridLayout(6,2));
        add(new JLabel("Grade %"));
        add(new JLabel("Weight"));
        this.grades = new JTextField[4];
        this.weights = new JTextField[4];
        for(int i =0;i<4;i++){
            this.grades[i] = new JTextField();
            this.weights[i] = new JTextField();
        }
        for (int i = 0; i < 4; i++)
        {
            this.add(this.grades[i]);
            this.add(this.weights[i]);
        }
        add(new JButton("Calculate"));
        add(this.finGrade);
    }
    
    private class CalculateButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            double sum=0;
            String fing="";
            for(int i=0; i<4; i++){
                if(isInteger(Double.parseDouble(grades[i].getText()))&&isInteger(Double.parseDouble(weights[i].getText()))){
                    sum+=Double.parseDouble(grades[i].getText())*Double.parseDouble(weights[i].getText());
                    sum=Double.valueOf(new DecimalFormat("#.##").format(sum));
                    fing= Double.toString(sum);
                }
                else{
                    fing="N/A";
                }
            }
            finGrade.setText(fing);
            
        }
        
    }
    
    public static boolean isInteger( String input )
    {
        try
        {
            Integer.parseInt( input );
            return true;
        }
        catch ( Exception e)
        {
            return false;
        }
    }
    
    public static void main(String[] args) {
        Program p = new Program();
        p.setup();
        p.setSize(200, 300);
        p.setVisible(true);
    }
}
