package proyecto.Renderers;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import proyecto.Colors;
import proyecto.ShowHint;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.*;
import java.net.*;

public class RenderID {

    public RenderID(String LabelText, String EntryText, JPanel MainPanel, InputVerifier inputVerifier, String url){
        JPanel RowPanel = new JPanel(); // We create a Panel for the first row
        RowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10)); // Set it to FlowLayout so it can be aligned horizontally
        RowPanel.setBackground(Colors.bg);
    
        //We create the component label
        JLabel CompLabel = new JLabel(LabelText);
        CompLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        CompLabel.setBackground(Colors.bg);
        CompLabel.setOpaque(true);
        CompLabel.setHorizontalAlignment(JLabel.RIGHT);
        CompLabel.setPreferredSize(new Dimension(260,30));
    
        //We create the component text 
        JTextField CompField = new JTextField();
        ShowHint.setHint(EntryText,CompField);
        CompField.setPreferredSize(new Dimension(210, 30));
        CompField.setFont(new Font("Verdana", Font.PLAIN, 20));
        CompField.setInputVerifier(inputVerifier);
        CompField.setBackground(Colors.formbg);
        String tiposCedula[] = {"V","E"};
        JComboBox tipoCedula = new JComboBox(tiposCedula);
        tipoCedula.setPreferredSize(new Dimension(35,30));
        
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
    
        // Add the components to the panel
  
        RowPanel.add(CompLabel);
        RowPanel.add(tipoCedula);
        RowPanel.add(CompField);
        RowPanel.add(imageLabel);
    
        // Render it to the main frame (panel being rendered)
        MainPanel.add(RowPanel);
    }
        
}
