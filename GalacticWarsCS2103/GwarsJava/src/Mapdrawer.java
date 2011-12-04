/**
 * Author : Achyut Potheri Balaji
 * Purpose : Implementing the display of the map
 */
import java.awt.AlphaComposite;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Mapdrawer extends JLabel implements ActionListener {

	private static final long serialVersionUID = 3766030465808611745L;
	private static final int NO_OF_DETECTIVES = 2;
	private BufferedImage flagImage[];
	private BufferedImage glow;
	private Point2D.Double[] playerPositions = null;
	private Point2D.Double newPosition = null;
	private int currentPlayer = -1;
	private double xTerm = 0;
	private double yTerm = 0;
	private int k = 0;
	boolean draw = false;
	private ArrayList<Point> neighbours;
	boolean blinkOn = false;
	boolean thiefVisible = false;
	Timer blinkTimer = new Timer(1000, this);
	Timer moveTimer = new Timer(2,this);
	
	/**
	 * Class constructor initializing the Map onto the JPanel
	 * @param imageIcon The image of the map
	 * @throws IOException
	 */

	public Mapdrawer(ImageIcon imageIcon) throws IOException {
		super(imageIcon);
		playerPositions = new Point2D.Double[3];
		flagImage = new BufferedImage[NO_OF_DETECTIVES + 1];
		flagImage[0] = ImageIO.read(new File("./thief.gif"));
		flagImage[1] = ImageIO.read(new File("./player1.gif"));
		flagImage[2] = ImageIO.read(new File("./player2.gif"));
		glow = ImageIO.read(new File("./yellow.gif"));
		moveTimer.stop();
	}
	
	/**
	 * Paints the small images onto the bigger map image
	 * @param g The graphics to be painted
	 */

	public void paint(Graphics g) {
		super.paint(g);
		if (this.playerPositions != null) {
			Graphics2D g2 = (Graphics2D) g;
			for (int i = 0; i < playerPositions.length; i++) {
				if (playerPositions[i] != null && !(blinkOn && i == currentPlayer) && !(i == 0 && !thiefVisible)) {
					Point2D.Double playerPos = this.getPlayerPos(i);
					Point playerPos2 = new Point((int) playerPos.x,(int) playerPos.y);
					//g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
					g2.drawImage(flagImage[i], playerPos2.x - 38, playerPos2.y - flagImage[i].getHeight(), null);
				}
			}
			if(draw == true) {
				for(int j=0;j<neighbours.size();j++) {
					Point drawer = neighbours.get(j);
					int xOffset = (this.getWidth() - this.getIcon().getIconWidth() < 0) ? 0 : (this.getWidth() - this.getIcon().getIconWidth()) / 2;
					int yOffset = (this.getHeight() - this.getIcon().getIconHeight() < 0) ? 0 : (this.getHeight() - this.getIcon().getIconHeight()) / 2;
					g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
					g2.drawImage(glow, xOffset + drawer.x - 50, yOffset + drawer.y - glow.getHeight() + 50, null);
				}
			}
		}
	}
	
	/**
	 * Sets the position of the players on the map
	 * @param player The number of the player
	 * @param pos The coordinates of the position of the player
	 */
	
	public void setPlayerPos(int player, Point pos) {
		this.newPosition = new Point2D.Double(pos.x, pos.y);
		blinkTimer.stop();
		blinkOn = false;
		xTerm = (newPosition.x - playerPositions[player].x) / 500;
		yTerm = (newPosition.y - playerPositions[player].y) / 500;
		moveTimer.start();
		k = 0;
		this.repaintPlayerPos(player);
	}
	
	/**
	 * Sets the position of the thief on the map
	 * @param pos The coordinates of the position of the thief
	 */
	
	public void setThiefPos(Point pos) {
		this.playerPositions[0] = new Point2D.Double(pos.x, pos.y);
		this.repaintPlayerPos(0);
	}
	
	/**
	 * Sets the initial positions of the players on the map
	 * @param pos The coordinates of the position of the player
	 * @param player The number of the player
	 */

	public void firstsetPlayerPos(int player, Point pos) {
		this.playerPositions[player] = new Point2D.Double(pos.x, pos.y);
		this.repaintPlayerPos(player);
	}
	
	/**
	 * Sets the coordinates of the neighbours of a node
	 * @param noofNeighbours The number of neighbours of a node
	 */
	
	public void setNeighbours(ArrayList<Point> noofNeighbours) {
		neighbours = new ArrayList<Point>();
		for(int i =0;i < noofNeighbours.size();i++) {
			neighbours.add(noofNeighbours.get(i));
		}
	}
	
	/**
	 * Gets the position of the player
	 * @param player The number of the player
	 * @return The coordinates of position of the player
	 */

	public Point2D.Double getPlayerPos(int player) {
		if (player < 0 || player >= playerPositions.length) {
			return null;
		}
		int xOffset = (this.getWidth() - this.getIcon().getIconWidth() < 0) ? 0 : (this.getWidth() - this.getIcon().getIconWidth()) / 2;
		int yOffset = (this.getHeight() - this.getIcon().getIconHeight() < 0) ? 0 : (this.getHeight() - this.getIcon().getIconHeight()) / 2;
		return new Point2D.Double(xOffset + playerPositions[player].x, yOffset + playerPositions[player].y);
	}
	
	/**
	 * Sets the currentPlayer and makes the image of the current player to blink
	 * @param player The number of the player
	 */

	public void setCurrentPlayer(int player) {
		if (player != currentPlayer) {

			if (blinkTimer.isRunning()) {
				blinkTimer.stop();
			}

			blinkOn = false;
			draw = true;
			if (currentPlayer != -1) {
				repaintPlayerPos(currentPlayer);
			}

			currentPlayer = player;
			blinkTimer.start();
			repaintPlayerPos(currentPlayer);
		}
	}
	
	/**
	 * Repaints the image of the player on the map
	 * @param player The number of the player
	 */

	public void repaintPlayerPos(int player) {
		Point2D.Double playerPos = getPlayerPos(player);

		if (player != -1 && playerPos != null) {
			this.repaint(0, 0, 1500, 1000);
		}
	}
	
	/**
	 * ActionEvent linked to the timer objects
	 * @param evt The Action Event that has to be performed
	 */

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == blinkTimer) {
			this.blinkOn = !this.blinkOn;

			if (this.playerPositions != null) {

				this.repaintPlayerPos(currentPlayer);
			}
		}
		
		if(evt.getSource() == moveTimer) { 
			if (this.playerPositions != null)
			{ 
				if(playerPositions[currentPlayer] != newPosition ) {
					playerPositions[currentPlayer].x += xTerm;
					playerPositions[currentPlayer].y += yTerm;
					this.repaintPlayerPos(currentPlayer); 
					k++;
					if(k>500) {
						moveTimer.stop();
						if(currentPlayer == 1)
							setCurrentPlayer(2);
						else if(currentPlayer == 2) 
							setCurrentPlayer(1);
					}
				} 
			}
		  } 
		 
	}

}
