package proyecto.Renderers;

import java.net.URL;

import proyecto.Colors;
import proyecto.Uppercase;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JLabel;
import java.awt.*;


public class RenderTextArea {
 

    public RenderTextArea(String LabelText, JPanel MainPanel, InputVerifier inputVerifier, String url){
        JPanel RowPanel = new JPanel(); // We create a Panel for the first row
        RowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10)); // Set it to FlowLayout so it can be aligned horizontally
        RowPanel.setBackground(Colors.bg);
    
        //We create the component label
        JLabel CompLabel = new JLabel(LabelText);
        CompLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
        CompLabel.setBackground(Colors.bg);
        CompLabel.setOpaque(true);
        CompLabel.setHorizontalAlignment(JLabel.RIGHT);
        CompLabel.setPreferredSize(new Dimension(260,30));
    
         // We create the component text 
         JTextArea compField = new JTextArea(3, 20);
        //  compField.setPreferredSize(new Dimension(250, 950));
         JScrollPane areaScrollPane = new JScrollPane(compField);
         compField.setLineWrap(true);
         compField.setWrapStyleWord(true);
         areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
         areaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         areaScrollPane.setPreferredSize(new Dimension(250, 90)); // Adjust the size here
         compField.setFont(new Font("Helvetica", Font.PLAIN, 20));
         compField.setInputVerifier(inputVerifier);
         compField.setBackground(Colors.formbg);


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
         RowPanel.add(areaScrollPane); // Add the JScrollPane instead of the JTextArea directly
         RowPanel.add(imageLabel);
     
         // Render it to the main frame (panel being rendered)
         MainPanel.add(RowPanel);
    }    
}
