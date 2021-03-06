import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SquareSimp
{
    public static void main( String[] args )
    {
        FilledFrame frame = new FilledFrame();

        frame.setVisible( true );
    }
}

class FilledFrame extends JFrame
{
    int size = 400;

    public FilledFrame()
    {
        JButton butSmall   = new JButton("Small");
        JButton butMedium  = new JButton("Medium");
        JButton butLarge   = new JButton("Large");
        JButton butMessage = new JButton("Say Hi!");

        SquarePanel panel = new SquarePanel(this);
        JPanel butPanel = new JPanel();

        butPanel.add(butSmall);
        butPanel.add(butMedium);
        butPanel.add(butLarge);
        butPanel.add(butMessage);
        add(butPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setSize( size+100, size+100 );

        butMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(getContentPane(), "Hi Boyo! :D");
            }
        });

        butSmall.addActionListener(new butListener(150, this));

        butMedium.addActionListener(new butListener(300, this));

        butLarge.addActionListener(new butListener(400, this));

    }

    class butListener implements ActionListener {
        int size;
        FilledFrame frame;

        public butListener(int size, FilledFrame frame){
            this.size = size;
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent s) {
            frame.size = size;
            frame.repaint();
        }
    }
}

class SquarePanel extends JPanel
{
    FilledFrame theApp;

    SquarePanel(FilledFrame app)
    {
        theApp = app;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(20, 20, theApp.size, theApp.size);
    }
}