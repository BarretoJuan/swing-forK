package proyecto;

import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SetImageLabel {
 public void SetImage(JLabel label, String url) {

    try {
        URL imageUrl = getClass().getResource(url); 
        if (imageUrl == null) {
            throw new Exception("Image not found: " + imageUrl);
        }
        Image image = ImageIO.read(imageUrl);
        Image scaledImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); 
        label.setIcon(new ImageIcon(scaledImage));
    }
     catch (Exception e) {
        e.printStackTrace();
    }

 }

 public void SetIconLabel (JLabel label, String url) {

    try {
        URL imageUrl = getClass().getResource(url); 
        if (imageUrl == null) {
            throw new Exception("Image not found: " + imageUrl);
        }
        Image image = ImageIO.read(imageUrl);
        Image scaledImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
        label.setIcon(new ImageIcon(scaledImage));
    }
     catch (Exception e) {
        e.printStackTrace();
    }

 }

}