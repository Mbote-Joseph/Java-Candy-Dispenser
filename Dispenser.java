import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dispenser extends JPanel{
    // Implementing the Arraystack class
    private static ArrayStack stack;
    private static JFrame frame;

    public Dispenser(){
        stack = new ArrayStack();
    }
    
    public void paintComponent(Graphics g) {
        // Drawing the candy container
        g.drawRect(350, 20, 100, 450);
        // Check whether the stack is empty
        if (!stack.isEmpty()){
            int count = stack.getCount();
            for(int i=0; i<count; i++)
            {
                // Drawing the oval with color black and text color of yellow
                g.setColor( Color.BLACK );
                g.fillOval(350, (i*30)+20, 100, 30);
                String text = "Candy "+(count-i);
                g.setColor(Color.YELLOW);
                g.drawString(text, 380,((i*30)+40));
            }            
        }
       
        int candyHeight = 20+stack.getCount()*30;
    //    Drawing the spring with compression constant of 15
        while (candyHeight < 450){
            g.setColor(Color.black);
            int height = 450 - candyHeight;
            for (int i=1; i<=10; i++){
                g.drawLine(350, candyHeight,450, candyHeight);
                candyHeight += height/10;
                g.drawLine(350, candyHeight-(height/10),450, candyHeight);
                g.drawLine(350, candyHeight,450, candyHeight);
            }
        }
    }

    public static void main(String args[]) {
        frame = new JFrame("Candy Dispenser");
        frame.setSize(700, 600);
        JPanel panel = new Dispenser();
        panel.setSize(800, 700);
        JLabel title = new JLabel();
        title.setBounds(100, 0, 200, 30);
        title.setText("Candy Dispenser");
        JLabel msg = new JLabel();
        msg.setBounds(80, 100, 300, 30);
        // Displaying the buttons 
        JButton size = new JButton("Size");
        size.setBounds(140, 400, 100, 30);
        size.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                msg.setText("The dispenser has "+stack.getCount()+" candies.");  
            }
        });


        JButton push = new JButton("Push");
        push.setBounds(140, 300, 100, 30);
        push.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                if(stack.isFull()){
                    msg.setText("The dispenser is full.");
                }else{
                    msg.setText(" ");
                    stack.push();
                    frame.repaint();
                }  
            }
        });


        JButton pop = new JButton("Pop");
        pop.setBounds(340, 500, 100, 30);
        pop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                if(stack.isEmpty()){
                    msg.setText("The dispenser is empty.");  
                }else{
                    msg.setText(" ");
                    stack.pop();
                    frame.repaint();
                }  
            }
        });

        
        JButton top = new JButton("peek()");
        top.setBounds(540, 300, 100, 30);
        top.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                if(stack.isEmpty()){
                    msg.setText("The dispenser is empty.");  
                }else{
                    msg.setText("The top candy is Candy "+stack.getCount());  
                }  
            }
        });
        JButton isEmpty = new JButton("Is Empty?"); 
        isEmpty.setBounds(540, 400, 100, 30);
        isEmpty.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                if(stack.isEmpty())
                {
                    msg.setText("The dispenser is isEmpty(): True.");  
                }else{
                    msg.setText("The dispenser is  isEmpty(): False.");  
                }  
            }
        });
        frame.add(msg);
        frame.add(title);
        frame.add(size);
        frame.add(push);
        frame.add(pop);
        frame.add(top);
        frame.add(isEmpty);
        frame.add(panel);
        frame.setVisible(true);
        
    }
      
}





















//   // Implement the spring in the remaining space
//         // The first spring starts at the height below the last candy
//         int candyHeight = 20+stack.getCount()*30;
//         // After the first spring line draw alternating
//         // diagonal lines of height 30 and horizontal lines
//         // representing the spring.
//         while (candyHeight < 450){
//             g.setColor(Color.black);
//             int height = 450 - candyHeight;
//             for (int i=1; i<=10; i++){
//                 // horizontal line  w=120px h=0
//                 g.drawLine(20, candyHeight,120, candyHeight);
//                 // height for the diagonal = 30 px
//                 candyHeight += height/10;
//                 // Diagonal line of h=30px w=120px
//                 g.drawLine(20, candyHeight-(height/10),120, candyHeight);
//                 g.drawLine(20, candyHeight,120, candyHeight);
//             }
//         }