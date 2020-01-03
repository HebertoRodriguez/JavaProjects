package face;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Class contains the images and algorithms necessary to loop through each image
 * @author Heberto Rodriguez, Assignment A06 Face
 *
 */
public class ImagePanel extends JPanel {
	
	private ImageIcon eyes;
	private ImageIcon nose;
	private ImageIcon face;
	private ImageIcon mouth;
	private int faceCount = 0;
	private int eyesCount = 0;
	private int noseCount = 0;
	private int mouthCount = 0;
	
	/**
	 * Creates the default face panel to display on the window when the app is ranned.
	 */
	public ImagePanel() {
		
		eyes = new ImageIcon(Face.class.getResource("/face/images/face eyes.png"));
		nose = new ImageIcon(Face.class.getResource("/face/images/nose 1.png"));
		mouth = new ImageIcon(Face.class.getResource("/face/images/tongue.png"));
		face = new ImageIcon(Face.class.getResource("/face/images/red circle.png"));
	}
	
	/**
	 * loops through all the face images.
	 */
	public void changeFace() {
		faceCount++;
		
		switch(faceCount) {
		case 1:
			face = new ImageIcon(Face.class.getResource("/face/images/CircleGreen.png"));
			repaint();
			break;
		
		case 2: 
			face = new ImageIcon(Face.class.getResource("/face/images/PurpleCircle.png"));
			repaint();
			break;
			
		case 3: 
			face = new ImageIcon(Face.class.getResource("/face/images/red circle.png"));
			repaint();
			break;			
		}
		if(faceCount >= 3)
			faceCount = 0;
	}
	
	/**
	 * loops through all the eyes images.
	 */
	public void changeEyes() {
		eyesCount++;
		
		switch(eyesCount) {
		case 1: 
			eyes = new ImageIcon(Face.class.getResource("/face/images/three eyes.png"));
			repaint();
			break;
		
		case 2: 
			eyes = new ImageIcon(Face.class.getResource("/face/images/looking left.png"));
			repaint();
			break;
			
		case 3:	
			eyes = new ImageIcon(Face.class.getResource("/face/images/face eyes.png"));
			repaint();
			break;
		}
		if(eyesCount >= 3)
			eyesCount = 0;
	}
	
	/**
	 * loops through all the nose images.
	 */
	public void changeNose() {
		noseCount++;
		
		switch(noseCount) {
		case 1: 
			nose = new ImageIcon(Face.class.getResource("/face/images/pig-nose.png"));
			repaint();
			break;
		
		case 2: 
			nose = new ImageIcon(Face.class.getResource("/face/images/freckled nose.png"));
			repaint();
			break;
			
		case 3:	
			nose = new ImageIcon(Face.class.getResource("/face/images/nose 1.png"));
			repaint();
			break;
		}
		if(noseCount >= 3)
			noseCount = 0;
	}
	
	/**
	 * loops through all the mouth images.
	 */
	public void changeMouth() {
		mouthCount++;
		
		switch(mouthCount) {
		case 1: 
			mouth = new ImageIcon(Face.class.getResource("/face/images/angry mouth.png"));
			repaint();
			break;
		
		case 2: 
			mouth = new ImageIcon(Face.class.getResource("/face/images/boca.jpg"));
			repaint();
			break;
			
		case 3:	
			mouth = new ImageIcon(Face.class.getResource("/face/images/tongue.png"));
			repaint();
			break;
		}
		if(mouthCount >= 3)
			mouthCount = 0;
	}
	
	/**
	 * Paints the images on the JPanel facePanel
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		face.paintIcon(this, g, 10, 10);
		eyes.paintIcon(this, g, 250, 100);
		nose.paintIcon(this, g, 250, 250);
		mouth.paintIcon(this, g, 250, 400);
		

	}

}
