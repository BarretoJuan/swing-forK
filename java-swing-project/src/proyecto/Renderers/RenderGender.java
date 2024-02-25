package proyecto.Renderers;

import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import java.awt.FlowLayout;
import proyecto.Colors;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;


public class RenderGender {

    public RenderGender(JPanel MainPanel, String url){
        JPanel RowPanel = new JPanel(); // We create a Panel for the first row
        RowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10)); // Set it to FlowLayout so it can be aligned horizontally
        RowPanel.setBackground(Colors.bg);
    
        //We create the component label
        JLabel CompLabel = new JLabel("Sexo:");
        CompLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        CompLabel.setBackground(Colors.bg);
        CompLabel.setOpaque(true);
        CompLabel.setHorizontalAlignment(JLabel.RIGHT);
        CompLabel.setPreferredSize(new Dimension(260,30));
        
    
        JRadioButton masculino=new JRadioButton("Masculino");
        masculino.setPreferredSize(new Dimension(125,30));
            
        JRadioButton femenino=new JRadioButton("Femenino"); 
        femenino.setPreferredSize(new Dimension(120,30));   
        ButtonGroup bg=new ButtonGroup();    
        
        bg.add(masculino);
        bg.add(femenino);    
        // Add the components to the panel

        JLabel imageLabel = new JLabel();
        imageLabel.setSize(30,30);

        try {
            URL imageUrl = getClass().getResource(url); 
            if (imageUrl == null) {
                throw new Exception("Image not found: " + imageUrl);
            }
            Image image = ImageIO.read(imageUrl);
            Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
            imageLabel.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        RowPanel.add(CompLabel);
        RowPanel.add(masculino);
        RowPanel.add(femenino);
        RowPanel.add(imageLabel);
   
        // Render it to the main frame (panel being rendered)
        MainPanel.add(RowPanel);
    }
         
}
