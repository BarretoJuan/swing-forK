package proyecto.Renderers;
import proyecto.Colors;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.net.URL;

public class RenderBloodType {

    public RenderBloodType(JPanel MainPanel, String url){
        JPanel RowPanel = new JPanel(); // We create a Panel for the first row
        RowPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10)); // Set it to FlowLayout so it can be aligned horizontally
        RowPanel.setBackground(Colors.bg);
    
        //We create the component label
        JLabel CompLabel = new JLabel("Tipo de Sangre:");
        CompLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        CompLabel.setBackground(Colors.bg);
        CompLabel.setOpaque(true);
        CompLabel.setHorizontalAlignment(JLabel.RIGHT);
        CompLabel.setPreferredSize(new Dimension(260,30));
        
        String bloodTypes[] = {"O+", "A+", "B+", "AB+", "O-", "A-", "B-", "AB-"};
        JComboBox<String> bloodMenu = new JComboBox<>(bloodTypes);
        bloodMenu.setPreferredSize(new Dimension(250,30));
        bloodMenu.setSelectedItem(null);
        


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
        RowPanel.add(bloodMenu);
        RowPanel.add(imageLabel);

   
        // Render it to the main frame (panel being rendered)
        MainPanel.add(RowPanel);
    }

    public class Paint extends JFrame{
    public void paint(Graphics g, JPanel MainPanel) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(25));
         
        //circulo derecha
        g.drawArc(200,100,200,200,40,280);
        //circulo izquierda
        g.drawArc(100,100,200,200,220,280);
        MainPanel.add(this);
        }
}
}
