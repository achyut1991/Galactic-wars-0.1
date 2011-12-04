/**
 * Author : Sesha Sendhil Subramanian
 * Author : Achyut Potheri Balaji
 * Purpose : Implementing the User Interface of the game
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;

public class Gui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel gamePlay = null;  //  @jve:decl-index=0:visual-constraint="-61,1902"
	private JPanel Hunter = null;
	private JPanel Phoenix = null;
	private JPanel Textarea = null;
	private JScrollPane imagePane = null;
	private Mapdrawer mapDraw;
	private Point mouseClick; // @jve:decl-index=0:
	private int turn = 0;
	private ArrayList<Point> temper; // @jve:decl-index=0:
	private Logic logic;
	private int thiefPosition;
	private JLabel p1pos = null;
	private JLabel Turn = null;
	private JLabel p2pos = null;
	private JTextField p1PosShow = null;
	private JTextField p2PosShow = null;
	private JButton startGame = null;
	private Timer changer = new Timer(200, this); // @jve:decl-index=0:
	private Timer difficulty = new Timer(800,this);
	private Timer gameplay = new Timer(200,this);
	private int side2;
	private JLabel thiefer = null;
	private int side;
	private int counter;
	private JPanel startPane = null;  //  @jve:decl-index=0:visual-constraint="994,1776"
	private JPanel saveloadPane = null;
	private JPanel storyPane = null;  //  @jve:decl-index=0:visual-constraint="648,612"
	private JPanel instructionPane = null;  //  @jve:decl-index=0:visual-constraint="41,1185"
	private JPanel newgamePane = null;  //  @jve:decl-index=0:visual-constraint="758,54"
	private JButton newGame = null;
	private JButton loadGame = null;
	private JButton instructions = null;
	private JButton story = null;
	private JButton exit = null;
	private JPanel turnNumber = null;
	private JLabel turnNumberlabel = null;
	private JLabel number = null;
	private JLabel startHead = null;
	private JLabel Footer = null;
	private JLabel newgameHead = null;
	private JLabel chooseMap = null;
	private JButton map1 = null;
	private JButton map2 = null;
	private JButton map3 = null;
	private JButton map4 = null;
	private JButton map5 = null;
	private boolean temp = true;
	private JLabel newgamefooter = null;
	private JLabel chooseLength = null;
	private JButton length1 = null;
	private JButton length2 = null;
	private JButton length3 = null;
	private JButton length4 = null;
	private JLabel jLabel = null;
	private JButton difficulty1 = null;
	private JButton difficulty2 = null;
	private JButton difficulty3 = null;
	private JButton difficulty4 = null;
	private JLabel choiceMap = null;
	private JLabel choiceLength = null;
	private JLabel choiceDifficulty = null;
	private JLabel mapLabel = null;
	private JLabel lengthLabel = null;
	private JLabel difficultyLabel = null;
	private JMenuBar Menu = null;
	private JMenu File = null;
	private JMenu Help = null;
	private JMenuItem newGameitem = null;
	private JMenuItem loadGameitem = null;
	private JMenuItem saveGameitem = null;
	private JMenuItem restartLevelitem = null;
	private JMenuItem exititem = null;
	private JMenuItem instructionitem = null;
	private JMenuItem aboutitem = null;
	private int panelCount = 0;
	private boolean newgameadded = false;
	private boolean instructionadded = false;
	private boolean storyadded = false;
	private JMenuItem mainMenuitem = null;
	private String lengthChoice;
	private String difficultyChoice;
	private String mapChoice;
	private JMenu soundMenu = null;
	private JLabel storyHead = null;
	private JLabel storyLabel1 = null;
	private JLabel storyLabel2 = null;
	private JLabel storyLabel3 = null;
	private JLabel storyLabel4 = null;
	private JLabel storyLabel5 = null;
	private JLabel storyLabel6 = null;
	private JLabel storyLabel7 = null;
	private JLabel storyLabel8 = null;
	private JLabel storyLabel9 = null;
	private JLabel storyLabel10 = null;
	private JLabel storyLabel11 = null;
	private JLabel storyLabel12 = null;
	private JLabel storyLabel13 = null;
	private JLabel storyLabel14 = null;
	private JLabel storyLabel15 = null;
	private JLabel storyLabel16 = null;
	private JLabel storyLabel17 = null;
	private JLabel storyLabel18 = null;
	private JLabel storyLabel19 = null;
	private JButton mainmenuButton = null;
	private JPanel jPanel = null;  //  @jve:decl-index=0:visual-constraint="-171,1059"
	private JLabel instructionHead = null;
	private JLabel instructionLabel1 = null;
	private JLabel instructionLabel2 = null;
	private JLabel instructionLabel3 = null;
	private JLabel instructionLabel4 = null;
	private JLabel instructionLabel5 = null;
	private JLabel instructionLabel6 = null;
	private JLabel instructionLabel7 = null;
	private JLabel instructionLabel8 = null;
	private JLabel instructionLabel9 = null;
	private JLabel instructionLabel10 = null;
	private boolean soundOn = false;
	private JLabel instructionLabel11 = null;
	private JLabel instructionLabel13 = null;
	private JLabel instructionLabel12 = null;
	private JLabel instructionLabel14 = null;
	private JLabel instructionLabel15 = null;
	private JButton instructionButton = null;
	private JLabel instructionLabel16 = null;
	private JLabel instructionLabel17 = null;
	private JLabel instructionLabel18 = null;
	private JLabel instructionLabel19 = null;
	private JLabel instructionLabel20 = null;
	private JButton mainmenuButton1 = null;
	private JCheckBoxMenuItem soundCheckBoxMenuItem = null;
	private static MidiSound sound;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	/**
	 * This is the default constructor
	 */

	public Gui() {
		super();
		initialize();
		logic = new Logic();
	}

	/**
	 * This method initializes the object
	 */
	
	private void initialize() {
		this.setSize(1117, 764);
		this.setJMenuBar(getMenu());
		this.setTitle("Galactic War");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./gicon.jpg"));
		this.getContentPane().add(getStartPane());
		panelCount = 0;
		init();
		sound.playSound(true);
		soundOn = true;
	}
	
	private void init() {
	}

	/**
	 * This method initializes gamePlay
	 * @return The JPanel gamePlay
	 */
	
	private JPanel getGamePlay(int mapnumber) {
		//if (gamePlay == null) {
			gamePlay = new JPanel();
			gamePlay.setLayout(new BorderLayout());
			gamePlay.setVisible(true);
			gamePlay.add(getHunter(), BorderLayout.WEST);
			gamePlay.add(getPhoenix(), BorderLayout.EAST);
			gamePlay.add(getTextarea(), BorderLayout.SOUTH);
			gamePlay.add(getImagePane(mapnumber), BorderLayout.CENTER);
		//}
		return gamePlay;
	}

	/**
	 * This method initializes Hunter
	 * @return The JPanel Hunter
	 */
	
	private JPanel getHunter() {
		if (Hunter == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(15, 321, 153, 155));
			jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel1.setIcon(new ImageIcon("./player1right.gif"));
			p1pos = new JLabel();
			p1pos.setBounds(new Rectangle(25, 16, 159, 44));
			p1pos.setBackground(Color.white);
			p1pos.setFont(new Font("SketchFlow Print", Font.BOLD, 30));
			p1pos.setForeground(Color.white);
			p1pos.setText("HUNTER");
			Hunter = new JPanel();
			Hunter.setLayout(null);
			Hunter.setPreferredSize(new Dimension(180, 2));
			Hunter.setBackground(Color.black);
			Hunter.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
			Hunter.add(p1pos, null);
			Hunter.add(getP1PosShow(), null);
			Hunter.add(jLabel1, null);
		}
		return Hunter;
	}

	/**
	 * This method initializes Phoenix
	 * @return The JPanel Phoenix
	 */
	
	private JPanel getPhoenix() {
		if (Phoenix == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(9, 321, 159, 158));
			jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel2.setIcon(new ImageIcon("./player2right.gif"));
			p2pos = new JLabel();
			p2pos.setBounds(new Rectangle(16, 17, 157, 32));
			p2pos.setFont(new Font("SketchFlow Print", Font.BOLD, 30));
			p2pos.setForeground(Color.white);
			p2pos.setText("PHOENIX");
			p2pos.setBackground(Color.white);
			Phoenix = new JPanel();
			Phoenix.setLayout(null);
			Phoenix.setPreferredSize(new Dimension(180, 2));
			Phoenix.setBackground(Color.black);
			Phoenix.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
			Phoenix.add(p2pos, null);
			Phoenix.add(getP2PosShow(), null);
			Phoenix.add(jLabel2, null);
		}
		return Phoenix;
	}

	/**
	 * This method initializes Textarea
	 * @return The JPanel Textarea
	 */
	
	private JPanel getTextarea() {
		if (Textarea == null) {
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.weightx = 2.0D;
			gridBagConstraints9.anchor = GridBagConstraints.NORTH;
			gridBagConstraints9.ipady = 30;
			gridBagConstraints9.gridy = 0;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 3;
			gridBagConstraints8.weightx = 1.0D;
			gridBagConstraints8.ipadx = 20;
			gridBagConstraints8.gridy = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.weightx = 1.0D;
			gridBagConstraints5.ipadx = 40;
			gridBagConstraints5.ipady = 0;
			gridBagConstraints5.gridy = 0;
			thiefer = new JLabel();
			thiefer.setBounds(new Rectangle(30, 11, 165, 128));
			thiefer.setIcon(new ImageIcon("./thiefleft.gif"));
			thiefer.setHorizontalAlignment(SwingConstants.CENTER);
			side = 1;
			thiefer.setText("");
			Turn = new JLabel();
			Turn.setBounds(new Rectangle(226, 29, 747, 53));
			Turn.setFont(new Font("SketchFlow Print", Font.BOLD, 24));
			Turn.setHorizontalTextPosition(SwingConstants.CENTER);
			Turn.setHorizontalAlignment(SwingConstants.CENTER);
			Turn.setForeground(Color.red);
			Turn.setPreferredSize(new Dimension(700, 20));
			Turn.setText("");
			Textarea = new JPanel();
			Textarea.setLayout(new GridBagLayout());
			Textarea.setPreferredSize(new Dimension(2, 150));
			Textarea.setBackground(Color.black);
			Textarea.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
			Textarea.add(Turn, gridBagConstraints9);
			Textarea.add(thiefer, gridBagConstraints5);
			Textarea.add(getTurnNumber(), gridBagConstraints8);
		}
		return Textarea;
	}

	/**
	 * This method runs the game
	 * 
	 */

	private void game() {
		int xOffset = (mapDraw.getWidth() - mapDraw.getIcon().getIconWidth() < 0) ? 0
				: (mapDraw.getWidth() - mapDraw.getIcon().getIconWidth()) / 2;
		int yOffset = (mapDraw.getHeight() - mapDraw.getIcon().getIconHeight() < 0) ? 0
				: (mapDraw.getHeight() - mapDraw.getIcon().getIconHeight()) / 2;
		mouseClick.x -= xOffset;
		mouseClick.y -= yOffset;
		mouseClick.x -= mapDraw.getX();
		mouseClick.y -= mapDraw.getY();
		int node = -1;
		int ans;
		int position = 0;
		Point pos;
		if (turn == 1) {
			temp = false;
			ArrayList<Point> poses = logic.getpos1List();
			for (int i = 0; i < poses.size(); i++) {
				if ((mouseClick.x < poses.get(i).x + 35 && mouseClick.x > poses
						.get(i).x - 35)
						&& (mouseClick.y < poses.get(i).y + 35 && mouseClick.y > poses
								.get(i).y - 35)) {
					node = i;
					break;
				}
			}
			if (node != -1) {
				position = logic.getposPoint(poses.get(node));
				p1PosShow.setText("" + position);
				pos = logic.getpointPos(position);
				thiefPosition = logic.afterplayer1(position);
				if (thiefPosition == 50) {
					Turn.setText("Death Star destroyed by the Hunter");
					turn = 0;
					ans = JOptionPane.showConfirmDialog(null, "Do you want to play again ?", "Game Over", 0, 1);
					if(ans == 0) {
						getNewgame();
					}
				}
				if (thiefPosition == -1) {
					temper = logic.getpos2List();
					temper.remove(logic.getpointPos(logic.getPosition1()));
					mapDraw.setNeighbours(temper);
					turn = 2;
				}
				mapDraw.setPlayerPos(1, pos);
			}
		} else if (turn == 2) {
			temp = true;
			ArrayList<Point> poses = logic.getpos2List();
			for (int i = 0; i < poses.size(); i++) {
				if ((mouseClick.x < poses.get(i).x + 35 && mouseClick.x > poses
						.get(i).x - 35)
						&& (mouseClick.y < poses.get(i).y + 35 && mouseClick.y > poses
								.get(i).y - 35)) {
					node = i;
					break;
				}
			}
			if (node != -1) {
				number.setText(logic.getTurnnumber() + 1 + "");
				position = logic.getposPoint(poses.get(node));
				p2PosShow.setText("" + position);
				pos = logic.getpointPos(position);
				thiefPosition = logic.thiefTurn(position);
				if (thiefPosition == 51) {
					Turn.setText("Death Star destroyed by the Phoenix");
					turn = 0;
					ans = JOptionPane.showConfirmDialog(null, "Do you want to play again ?", "Game Over", 0, 1);
					if(ans == 0) {
						getNewgame();
					}
				} else if (thiefPosition == 52) {
					mapDraw.thiefVisible = true;
					Point posThief = logic
							.getpointPos(logic.thiefGetPosition());
					mapDraw.setThiefPos(posThief);
					Turn.setText("   You have failed!!!");
					ans = JOptionPane.showConfirmDialog(null, "Do you want to play again ?", "Game Over", 0, 1);
					if(ans == 0) {
						getNewgame();
					}
				} else if (thiefPosition != 0) {
					Turn.setText("Planet " + logic.thiefGetPosition()
							+ " has been ravaged by the Death Star");
					mapDraw.thiefVisible = true;
					Point posThief = logic
							.getpointPos(logic.thiefGetPosition());
					if (logic.getTurnnumber() == 2) {
						mapDraw.firstsetPlayerPos(0, posThief);
					} else {
						mapDraw.setThiefPos(posThief);
					}
					temper = logic.getpos1List();
					temper.remove(logic.getpointPos(logic.getPosition2()));
					mapDraw.setNeighbours(temper);
					turn = 1;
				} else {
					mapDraw.thiefVisible = false;
					temper = logic.getpos1List();
					temper.remove(logic.getpointPos(logic.getPosition2()));
					mapDraw.setNeighbours(temper);
					turn = 1;
				}
				mapDraw.setPlayerPos(2, pos);
			}
		}
	}

	/**
	 * This method initializes imagePane
	 * @return The JScrollPane imagePane
	 */
	
	private JScrollPane getImagePane(int mapnumber) {
		//if (imagePane == null) {
			int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			System.out.println("1");
			if(mapnumber == 1) {
			try {
				imagePane = new JScrollPane(mapDraw = new Mapdrawer(
						new ImageIcon("./GalacticMap1.jpg")), v, h);
				System.out.println("2");
			} catch (IOException e) {
				System.out.println("Image not found!");
				e.printStackTrace();
			}
			}
			else if(mapnumber == 2) {
				try {
					imagePane = new JScrollPane(mapDraw = new Mapdrawer(
							new ImageIcon("./GalacticMap2.jpg")), v, h);
					System.out.println("2");
				} catch (IOException e) {
					System.out.println("Image not found!");
					e.printStackTrace();
				}
			}
			else if(mapnumber == 3) {
				try {
					imagePane = new JScrollPane(mapDraw = new Mapdrawer(
							new ImageIcon("./GalacticMap3.jpg")), v, h);
					System.out.println("2");
				} catch (IOException e) {
					System.out.println("Image not found!");
					e.printStackTrace();
				}
			}
			else if(mapnumber == 4) {
				try {
					imagePane = new JScrollPane(mapDraw = new Mapdrawer(
							new ImageIcon("./GalacticMap4.jpg")), v, h);
					System.out.println("2");
				} catch (IOException e) {
					System.out.println("Image not found!");
					e.printStackTrace();
				}
			}
			else if(mapnumber == 5) {
				try {
					imagePane = new JScrollPane(mapDraw = new Mapdrawer(
							new ImageIcon("./GalacticMap5.jpg")), v, h);
					System.out.println("2");
				} catch (IOException e) {
					System.out.println("Image not found!");
					e.printStackTrace();
				}
			}
			
			imagePane.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
			imagePane.setBackground(Color.black);
			imagePane.setVisible(true);
			imagePane.setFont(new Font("Dialog", Font.PLAIN, 12));
			imagePane.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					mouseClick = e.getPoint();
					if (turn > 0) {
						game();
					}
				}
			});
		//}
		return imagePane;
	}

	/**
	 * This method initializes p1PosShow
	 * @return The JTextField p1PosShow
	 */
	
	private JTextField getP1PosShow() {
		if (p1PosShow == null) {
			p1PosShow = new JTextField();
			p1PosShow.setBounds(new Rectangle(25, 100, 135, 124));
			p1PosShow.setForeground(Color.white);
			p1PosShow.setBackground(Color.black);
			p1PosShow.setText("");
			p1PosShow.setEditable(false);
			p1PosShow.setFont(new Font("SketchFlow Print", Font.BOLD, 55));
			p1PosShow.setHorizontalAlignment(JTextField.CENTER);
			p1PosShow.setVisible(true);
		}
		return p1PosShow;
	}

	/**
	 * This method initializes p2PosShow
	 * @return The JTextField p2PosShow
	 */
	
	private JTextField getP2PosShow() {
		if (p2PosShow == null) {
			p2PosShow = new JTextField();
			p2PosShow.setBounds(new Rectangle(32, 100, 128, 124));
			p2PosShow.setFont(new Font("SketchFlow Print", Font.BOLD, 55));
			p2PosShow.setForeground(Color.white);
			p2PosShow.setBackground(Color.black);
			p2PosShow.setText("");
			p2PosShow.setEditable(false);
			p2PosShow.setHorizontalAlignment(JTextField.CENTER);
			p2PosShow.setVisible(true);
		}
		return p2PosShow;
	}
	
	/**
	 * Adds the GamePlay Panel onto the JFrame
	 */

	private void getgameplay(int mapnumber) {
		this.add(getGamePlay(mapnumber));
		panelCount = 5;
	}

	/**
	 * This method initializes startGame
	 * @return The JButton startGame
	 */
	
	private JButton getstartGame() {
		if (startGame == null) {
			startGame = new JButton();
			startGame.setText("START");
			startGame.setVisible(true);
			startGame.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					lengthChoice = choiceLength.getText();
					difficultyChoice = choiceDifficulty.getText();
					mapChoice = choiceMap.getText();
					restartLevelitem.setEnabled(true);
					saveGameitem.setEnabled(true);
					startGame.setVisible(false);
					newgamePane.setVisible(false);
					if(mapChoice.equals("Map 1")) {
						getgameplay(1);
					}
					else if(mapChoice.equals("Map 2")) {
						getgameplay(2);
					}
					else if(mapChoice.equals("Map 3")) {
						getgameplay(3);
					}
					else if(mapChoice.equals("Map 4")) {
						getgameplay(4);
					}
					else if(mapChoice.equals("Map 5")) {
						getgameplay(5);
					}
					try {
						logic.thiefTurn(lengthChoice, difficultyChoice, mapChoice);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					imagePane.setVisible(true);
					p1pos.setVisible(true);
					p1PosShow.setVisible(true);
					p2pos.setVisible(true);
					p2PosShow.setVisible(true);
					Turn.setVisible(true);
					Turn.setText("");
					p1PosShow.setText("" + logic.getPosition1());
					p2PosShow.setText("" + logic.getPosition2());
					thiefPosition = 0;
					mapDraw.firstsetPlayerPos(1, logic.getpointPos(logic
							.getPosition1()));
					mapDraw.firstsetPlayerPos(2, logic.getpointPos(logic
							.getPosition2()));
					mapDraw.setCurrentPlayer(1);
					ArrayList<Point> temper = logic.getpos1List();
					temper.remove(logic.getpointPos(logic.getPosition2()));
					mapDraw.setNeighbours(temper);
					turn = 1;
					changer.start();
					number.setText("1");
				}

			});

		}

		return startGame;
	}
	
	/**
	 * ActionEvent linked to the image animation
	 * @param evt The Action Event that has to be performed
	 */

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == changer) {
			if (side == 1) {
				thiefer.setIcon(new ImageIcon("./thiefright.gif"));
				if(temp == true) {
				jLabel1.setIcon(new ImageIcon("./player1right.gif"));
				}
				else {
				jLabel2.setIcon(new ImageIcon("./player2right.gif"));
				}
				side = 2;
			} else if (side == 2) {
				thiefer.setIcon(new ImageIcon("./thiefleft.gif"));
				if(temp == true)
				jLabel1.setIcon(new ImageIcon("./player1left.gif"));
				else
				jLabel2.setIcon(new ImageIcon("./player2left.gif"));
				side = 1;
			}
		}
		if (evt.getSource() == difficulty) {
			if (counter == 1) {
				instructionButton.setText("Easy");
				instructionLabel16.setText("The Death star's position is revealed every turn in this difficulty");
				counter = 2;
			} else if (counter == 2) {
				instructionButton.setText("Normal");
				instructionLabel16.setText("The Death star's position is revealed every alternate turn in this difficulty");
				counter = 3;
			}
			else if (counter == 3) {
				instructionButton.setText("Hard");
				instructionLabel16.setText("The Death star's position is revealed every three turns in this difficulty");
				counter = 4;
			}
			else if (counter == 4) {
				instructionButton.setText("Diabolique");
				instructionLabel16.setText("The Death star's position is revealed every four turns in this difficulty");
				counter = 1;
			}
		}
	}
	
	

	/**
	 * This method initializes startPane
	 * @return The JPanel startPane
	 */
	
	private JPanel getStartPane() {
		if (startPane == null) {
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 1;
			gridBagConstraints41.weighty = 1.0D;
			gridBagConstraints41.gridy = 6;
			Footer = new JLabel();
			Footer.setText("");
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 1;
			gridBagConstraints31.weighty = 1.0D;
			gridBagConstraints31.gridy = 0;
			startHead = new JLabel();
			startHead.setText("GALACTIC WAR");
			startHead.setForeground(Color.orange);
			startHead.setFont(new Font("SketchFlow Print", Font.BOLD, 90));
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.anchor = GridBagConstraints.CENTER;
			gridBagConstraints4.weighty = 0.0D;
			gridBagConstraints4.gridy = 5;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.weighty = 0.0D;
			gridBagConstraints3.gridy = 4;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.weighty = 0.0D;
			gridBagConstraints2.gridy = 3;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.weighty = 0.0D;
			gridBagConstraints1.gridy = 2;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.weighty = 0.0D;
			gridBagConstraints.gridy = 1;
			startPane = new JPanel();
			startPane.setLayout(new GridBagLayout());
			startPane.setAlignmentX(0.9F);
			startPane.setAlignmentY(0.9F);
			startPane.setBackground(Color.black);
			startPane.setPreferredSize(new Dimension(734, 345));
			startPane.add(getNewGame(), gridBagConstraints);
			startPane.add(getLoadGame(), gridBagConstraints1);
			startPane.add(getInstructions(), gridBagConstraints2);
			startPane.add(getStory(), gridBagConstraints3);
			startPane.add(getExit2(), gridBagConstraints4);
			startPane.add(startHead, gridBagConstraints31);
			startPane.add(Footer, gridBagConstraints41);
		}
		return startPane;
	}

	/**
	 * This method initializes saveloadPane
	 * @return The JPanel saveLoadPane
	 */
	
	private JPanel getSaveloadPane() {
		//if (saveloadPane == null) {
			saveloadPane = new JPanel();
			saveloadPane.setLayout(new GridBagLayout());
		//}
		return saveloadPane;
	}

	/**
	 * This method initializes storyPane
	 * @return The JPanel storyPane
	 */
	
	private JPanel getStoryPane() {
		//if (storyPane == null) {
			GridBagConstraints gridBagConstraints56 = new GridBagConstraints();
			gridBagConstraints56.gridx = 0;
			gridBagConstraints56.weighty = 1.0D;
			gridBagConstraints56.gridy = 20;
			GridBagConstraints gridBagConstraints55 = new GridBagConstraints();
			gridBagConstraints55.gridx = 0;
			gridBagConstraints55.weighty = 0.2D;
			gridBagConstraints55.gridy = 6;
			storyLabel19 = new JLabel();
			storyLabel19.setText("in pursuit of the Death Star and are working towards exterminating it.");
			storyLabel19.setForeground(Color.red);
			storyLabel19.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints54 = new GridBagConstraints();
			gridBagConstraints54.gridx = 0;
			gridBagConstraints54.weighty = 0.2D;
			gridBagConstraints54.gridy = 11;
			storyLabel18 = new JLabel();
			storyLabel18.setText("that is stationary is the 25 different Planets.");
			storyLabel18.setForeground(Color.red);
			storyLabel18.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints53 = new GridBagConstraints();
			gridBagConstraints53.gridx = 0;
			gridBagConstraints53.weighty = 0.2D;
			gridBagConstraints53.gridy = 4;
			storyLabel17 = new JLabel();
			storyLabel17.setText("creates will be shown only after every few moves it makes.");
			storyLabel17.setFont(new Font("Dialog", Font.BOLD, 18));
			storyLabel17.setForeground(Color.red);
			GridBagConstraints gridBagConstraints52 = new GridBagConstraints();
			gridBagConstraints52.gridx = 0;
			gridBagConstraints52.weighty = 0.2D;
			gridBagConstraints52.gridy = 19;
			storyLabel16 = new JLabel();
			storyLabel16.setText("Play ‘Galactic War’ to see the outcome of the war - Mass Destruction or Peace!");
			storyLabel16.setFont(new Font("Dialog", Font.BOLD, 18));
			storyLabel16.setForeground(Color.red);
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.gridx = 0;
			gridBagConstraints51.weighty = 0.2D;
			gridBagConstraints51.gridy = 18;
			storyLabel15 = new JLabel();
			storyLabel15.setText("Finally, the war of the Galaxies ends, with peace everywhere.");
			storyLabel15.setFont(new Font("Dialog", Font.BOLD, 18));
			storyLabel15.setForeground(Color.red);
			GridBagConstraints gridBagConstraints50 = new GridBagConstraints();
			gridBagConstraints50.gridx = 0;
			gridBagConstraints50.weighty = 0.2D;
			gridBagConstraints50.gridy = 17;
			storyLabel14 = new JLabel();
			storyLabel14.setText("as the Empire Stars capture the Death Star.");
			storyLabel14.setFont(new Font("Dialog", Font.BOLD, 18));
			storyLabel14.setForeground(Color.red);
			GridBagConstraints gridBagConstraints49 = new GridBagConstraints();
			gridBagConstraints49.gridx = 0;
			gridBagConstraints49.weighty = 0.2D;
			gridBagConstraints49.gridy = 16;
			storyLabel13 = new JLabel();
			storyLabel13.setText("the position of the Death Star is revealed and the chase comes to a close,");
			storyLabel13.setForeground(Color.red);
			storyLabel13.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints48 = new GridBagConstraints();
			gridBagConstraints48.gridx = 0;
			gridBagConstraints48.weighty = 0.2D;
			gridBagConstraints48.gridy = 15;
			storyLabel12 = new JLabel();
			storyLabel12.setText("If any of the Empire Stars land on the planet where the Death Star has taken shelter,");
			storyLabel12.setForeground(Color.red);
			storyLabel12.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints47 = new GridBagConstraints();
			gridBagConstraints47.gridx = 0;
			gridBagConstraints47.weighty = 0.2D;
			gridBagConstraints47.gridy = 14;
			storyLabel11 = new JLabel();
			storyLabel11.setText("whereas the Empire Stars are visible throughout the chase.");
			storyLabel11.setForeground(Color.red);
			storyLabel11.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints46 = new GridBagConstraints();
			gridBagConstraints46.gridx = 0;
			gridBagConstraints46.weighty = 0.2D;
			gridBagConstraints46.gridy = 13;
			storyLabel10 = new JLabel();
			storyLabel10.setText(" The visibility of the Death Star is special, as his position is revealed to the Empire Stars only at certain intervals,");
			storyLabel10.setForeground(Color.red);
			storyLabel10.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints45 = new GridBagConstraints();
			gridBagConstraints45.gridx = 0;
			gridBagConstraints45.weighty = 0.2D;
			gridBagConstraints45.gridy = 12;
			storyLabel9 = new JLabel();
			storyLabel9.setText("Each Planet can be accessed from other planets via the Galactic Highways between the Planets.");
			storyLabel9.setForeground(Color.red);
			storyLabel9.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints44 = new GridBagConstraints();
			gridBagConstraints44.gridx = 0;
			gridBagConstraints44.weighty = 0.2D;
			gridBagConstraints44.gridy = 10;
			storyLabel8 = new JLabel();
			storyLabel8.setText("All players are allowed to navigate only from one planet to another, as the only part of the Universe ");
			storyLabel8.setForeground(Color.red);
			storyLabel8.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints43 = new GridBagConstraints();
			gridBagConstraints43.gridx = 0;
			gridBagConstraints43.weighty = 0.2D;
			gridBagConstraints43.gridy = 9;
			storyLabel7 = new JLabel();
			storyLabel7.setText("Hence, it the duty of the two Heros left in the Universe to catch the Death Star and put a stop to its atrocities!");
			storyLabel7.setForeground(Color.red);
			storyLabel7.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints42 = new GridBagConstraints();
			gridBagConstraints42.gridx = 0;
			gridBagConstraints42.weighty = 0.2D;
			gridBagConstraints42.gridy = 8;
			storyLabel6 = new JLabel();
			storyLabel6.setText("Otherwise, the Universe will self destruct and the Death Star wins the war, the Death Star’s aim fulfilled. ");
			storyLabel6.setForeground(Color.red);
			storyLabel6.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints40 = new GridBagConstraints();
			gridBagConstraints40.gridx = 0;
			gridBagConstraints40.weighty = 0.2D;
			gridBagConstraints40.gridy = 7;
			storyLabel5 = new JLabel();
			storyLabel5.setText("There are 25 Planets in total and within a fixed number of trips (moves), it HAS to be destroyed!");
			storyLabel5.setForeground(Color.red);
			storyLabel5.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints39 = new GridBagConstraints();
			gridBagConstraints39.gridx = 0;
			gridBagConstraints39.weighty = 0.2D;
			gridBagConstraints39.gridy = 5;
			storyLabel4 = new JLabel();
			storyLabel4.setText("Two of the Empire StarShips namely the Hunter and the Phoenix, are currently ");
			storyLabel4.setForeground(Color.red);
			storyLabel4.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints38 = new GridBagConstraints();
			gridBagConstraints38.gridx = 0;
			gridBagConstraints38.weighty = 0.2D;
			gridBagConstraints38.gridy = 3;
			storyLabel3 = new JLabel();
			storyLabel3.setText("The Death Star has a very well-planned strategy where in, the effect of the destruction it ");
			storyLabel3.setForeground(Color.red);
			storyLabel3.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints37 = new GridBagConstraints();
			gridBagConstraints37.gridx = 0;
			gridBagConstraints37.weighty = 0.2D;
			gridBagConstraints37.gridy = 2;
			storyLabel2 = new JLabel();
			storyLabel2.setText("The main aim of the Death Star is to create havoc and destruct everything in its path to help go into hiding.");
			storyLabel2.setForeground(Color.red);
			storyLabel2.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints36 = new GridBagConstraints();
			gridBagConstraints36.gridx = 0;
			gridBagConstraints36.weighty = 0.2D;
			gridBagConstraints36.gridy = 1;
			storyLabel1 = new JLabel();
			storyLabel1.setText("The war between the Galaxies is almost over and only the Death Star remains.");
			storyLabel1.setForeground(Color.red);
			storyLabel1.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints35 = new GridBagConstraints();
			gridBagConstraints35.gridx = 0;
			gridBagConstraints35.gridy = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.weighty = 0.5D;
			gridBagConstraints6.gridy = 0;
			storyHead = new JLabel();
			storyHead.setFont(new Font("SketchFlow Print", Font.BOLD, 90));
			storyHead.setText("GALACTIC WAR");
			storyHead.setForeground(Color.orange);
			storyPane = new JPanel();
			storyPane.setLayout(new GridBagLayout());
			storyPane.setBackground(Color.black);
			storyPane.add(storyHead, gridBagConstraints6);
			storyPane.add(storyLabel1, gridBagConstraints36);
			storyPane.add(storyLabel2, gridBagConstraints37);
			storyPane.add(storyLabel3, gridBagConstraints38);
			storyPane.add(storyLabel4, gridBagConstraints39);
			storyPane.add(storyLabel5, gridBagConstraints40);
			storyPane.add(storyLabel6, gridBagConstraints42);
			storyPane.add(storyLabel7, gridBagConstraints43);
			storyPane.add(storyLabel8, gridBagConstraints44);
			storyPane.add(storyLabel9, gridBagConstraints45);
			storyPane.add(storyLabel10, gridBagConstraints46);
			storyPane.add(storyLabel11, gridBagConstraints47);
			storyPane.add(storyLabel12, gridBagConstraints48);
			storyPane.add(storyLabel13, gridBagConstraints49);
			storyPane.add(storyLabel14, gridBagConstraints50);
			storyPane.add(storyLabel15, gridBagConstraints51);
			storyPane.add(storyLabel16, gridBagConstraints52);
			storyPane.add(storyLabel17, gridBagConstraints53);
			storyPane.add(storyLabel18, gridBagConstraints54);
			storyPane.add(storyLabel19, gridBagConstraints55);
			storyPane.add(getMainmenuButton(), gridBagConstraints56);
		//}
		return storyPane;
	}

	/**
	 * This method initializes instructionPane
	 * @return The JPanel instructionPane
	 */
	
	private JPanel getInstructionPane() {
			GridBagConstraints gridBagConstraints79 = new GridBagConstraints();
			gridBagConstraints79.gridx = 2;
			gridBagConstraints79.gridy = 16;
			GridBagConstraints gridBagConstraints78 = new GridBagConstraints();
			gridBagConstraints78.gridx = 1;
			gridBagConstraints78.anchor = GridBagConstraints.WEST;
			gridBagConstraints78.gridy = 15;
			instructionLabel20 = new JLabel();
			instructionLabel20.setText("- Phoenix");
			instructionLabel20.setForeground(Color.red);
			instructionLabel20.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints77 = new GridBagConstraints();
			gridBagConstraints77.gridx = 1;
			gridBagConstraints77.anchor = GridBagConstraints.WEST;
			gridBagConstraints77.gridy = 14;
			instructionLabel19 = new JLabel();
			instructionLabel19.setText("- Hunter");
			instructionLabel19.setForeground(Color.red);
			instructionLabel19.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints76 = new GridBagConstraints();
			gridBagConstraints76.gridx = 0;
			gridBagConstraints76.ipady = 20;
			gridBagConstraints76.gridy = 15;
			instructionLabel18 = new JLabel();
			instructionLabel18.setIcon(new ImageIcon("./player2.gif"));
			GridBagConstraints gridBagConstraints75 = new GridBagConstraints();
			gridBagConstraints75.gridx = 0;
			gridBagConstraints75.ipady = 20;
			gridBagConstraints75.gridy = 14;
			instructionLabel17 = new JLabel();
			instructionLabel17.setIcon(new ImageIcon("./player1.gif"));
			GridBagConstraints gridBagConstraints74 = new GridBagConstraints();
			gridBagConstraints74.gridx = 1;
			gridBagConstraints74.gridy = 16;
			instructionLabel16 = new JLabel();
			instructionLabel16.setText("");
			instructionLabel16.setForeground(Color.red);
			instructionLabel16.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints73 = new GridBagConstraints();
			gridBagConstraints73.gridx = 0;
			gridBagConstraints73.weighty = 0.1D;
			gridBagConstraints73.gridy = 16;
			GridBagConstraints gridBagConstraints72 = new GridBagConstraints();
			gridBagConstraints72.gridx = 1;
			gridBagConstraints72.anchor = GridBagConstraints.WEST;
			gridBagConstraints72.gridy = 13;
			instructionLabel15 = new JLabel();
			instructionLabel15.setText("- Death Star");
			instructionLabel15.setFont(new Font("Dialog", Font.BOLD, 18));
			instructionLabel15.setForeground(Color.red);
			GridBagConstraints gridBagConstraints71 = new GridBagConstraints();
			gridBagConstraints71.gridx = 0;
			gridBagConstraints71.weighty = 0.1D;
			gridBagConstraints71.ipady = 10;
			gridBagConstraints71.gridy = 13;
			instructionLabel14 = new JLabel();
			instructionLabel14.setIcon(new ImageIcon("./thief.gif"));
			instructionLabel14.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gridBagConstraints69 = new GridBagConstraints();
			gridBagConstraints69.gridx = 1;
			gridBagConstraints69.anchor = GridBagConstraints.WEST;
			gridBagConstraints69.gridy = 12;
			instructionLabel12 = new JLabel();
			instructionLabel12.setText("- Planet 10 as found on the map with its connections");
			instructionLabel12.setForeground(Color.red);
			instructionLabel12.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints70 = new GridBagConstraints();
			gridBagConstraints70.gridx = 0;
			gridBagConstraints70.weighty = 0.1D;
			gridBagConstraints70.ipadx = 30;
			gridBagConstraints70.gridy = 12;
			instructionLabel13 = new JLabel();
			instructionLabel13.setIcon(new ImageIcon("./instruction1.gif"));
			instructionLabel13.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gridBagConstraints68 = new GridBagConstraints();
			gridBagConstraints68.gridx = 1;
			gridBagConstraints68.weighty = 0.0D;
			gridBagConstraints68.anchor = GridBagConstraints.WEST;
			gridBagConstraints68.gridy = 11;
			instructionLabel11 = new JLabel();
			instructionLabel11.setText("9.\tThe player wins the game if the thief is caught");
			instructionLabel11.setForeground(Color.red);
			instructionLabel11.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints67 = new GridBagConstraints();
			gridBagConstraints67.gridx = 1;
			gridBagConstraints67.weighty = 0.0D;
			gridBagConstraints67.anchor = GridBagConstraints.WEST;
			gridBagConstraints67.gridy = 10;
			instructionLabel10 = new JLabel();
			instructionLabel10.setText("8.\tContinue in this fashion till either the thief is caught or the number of turns is exhausted");
			instructionLabel10.setForeground(Color.red);
			instructionLabel10.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints66 = new GridBagConstraints();
			gridBagConstraints66.gridx = 1;
			gridBagConstraints66.weighty = 0.0D;
			gridBagConstraints66.anchor = GridBagConstraints.WEST;
			gridBagConstraints66.gridy = 9;
			instructionLabel9 = new JLabel();
			instructionLabel9.setText("7.\tThe position of the thief will be revealed at certain fixed intervals to facilitate catching him");
			instructionLabel9.setForeground(Color.red);
			instructionLabel9.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints65 = new GridBagConstraints();
			gridBagConstraints65.gridx = 1;
			gridBagConstraints65.weighty = 0.0D;
			gridBagConstraints65.anchor = GridBagConstraints.WEST;
			gridBagConstraints65.gridy = 8;
			instructionLabel8 = new JLabel();
			instructionLabel8.setText("(Just click on any one of the highlighted nodes to move to that position)");
			instructionLabel8.setForeground(Color.red);
			instructionLabel8.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints64 = new GridBagConstraints();
			gridBagConstraints64.gridx = 1;
			gridBagConstraints64.weighty = 0.0D;
			gridBagConstraints64.anchor = GridBagConstraints.WEST;
			gridBagConstraints64.gridy = 7;
			instructionLabel7 = new JLabel();
			instructionLabel7.setText("6.\tOne can only move to the adjacent nodes that are highlighted by a yellow ");
			instructionLabel7.setForeground(Color.red);
			instructionLabel7.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints63 = new GridBagConstraints();
			gridBagConstraints63.gridx = 1;
			gridBagConstraints63.weighty = 0.0D;
			gridBagConstraints63.anchor = GridBagConstraints.WEST;
			gridBagConstraints63.gridy = 6;
			instructionLabel6 = new JLabel();
			instructionLabel6.setText("5.\tThe Phoenix (i.e. the Player – You) then makes his first move");
			instructionLabel6.setForeground(Color.red);
			instructionLabel6.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints62 = new GridBagConstraints();
			gridBagConstraints62.gridx = 1;
			gridBagConstraints62.weighty = 0.0D;
			gridBagConstraints62.anchor = GridBagConstraints.WEST;
			gridBagConstraints62.gridy = 5;
			instructionLabel5 = new JLabel();
			instructionLabel5.setText("4.\tThis is followed by the Hunter (i.e. the Player – You) making his first move");
			instructionLabel5.setForeground(Color.red);
			instructionLabel5.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.gridx = 1;
			gridBagConstraints61.weighty = 0.0D;
			gridBagConstraints61.anchor = GridBagConstraints.WEST;
			gridBagConstraints61.gridy = 4;
			instructionLabel4 = new JLabel();
			instructionLabel4.setText("3.\tThe game starts with the Thief making his first move");
			instructionLabel4.setForeground(Color.red);
			instructionLabel4.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints60 = new GridBagConstraints();
			gridBagConstraints60.gridx = 1;
			gridBagConstraints60.weighty = 0.0D;
			gridBagConstraints60.anchor = GridBagConstraints.WEST;
			gridBagConstraints60.gridy = 3;
			instructionLabel3 = new JLabel();
			instructionLabel3.setText("2.\tGo on to choose your desired Map, Difficulty Level and the Number turns you wish to play");
			instructionLabel3.setForeground(Color.red);
			instructionLabel3.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints59 = new GridBagConstraints();
			gridBagConstraints59.gridx = 1;
			gridBagConstraints59.weighty = 0.0D;
			gridBagConstraints59.anchor = GridBagConstraints.WEST;
			gridBagConstraints59.gridy = 2;
			instructionLabel2 = new JLabel();
			instructionLabel2.setText("1.\tChoose the ‘New Game’ option");
			instructionLabel2.setForeground(Color.red);
			instructionLabel2.setFont(new Font("Dialog", Font.BOLD, 18));
			GridBagConstraints gridBagConstraints58 = new GridBagConstraints();
			gridBagConstraints58.gridx = 1;
			gridBagConstraints58.weighty = 0.0D;
			gridBagConstraints58.anchor = GridBagConstraints.CENTER;
			gridBagConstraints58.gridy = 1;
			instructionLabel1 = new JLabel();
			instructionLabel1.setText("To get started with the game:");
			instructionLabel1.setForeground(Color.red);
			instructionLabel1.setFont(new Font("Dialog", Font.BOLD, 24));
			GridBagConstraints gridBagConstraints57 = new GridBagConstraints();
			gridBagConstraints57.gridx = 1;
			gridBagConstraints57.weighty = 0.1D;
			gridBagConstraints57.gridy = 0;
			counter = 1;
			difficulty.start();
			instructionHead = new JLabel();
			instructionHead.setFont(new Font("SketchFlow Print", Font.BOLD, 36));
			instructionHead.setText("Instructions:");
			instructionHead.setHorizontalAlignment(SwingConstants.CENTER);
			instructionHead.setForeground(Color.orange);
			instructionPane = new JPanel();
			instructionPane.setLayout(new GridBagLayout());
			instructionPane.setBackground(Color.black);
			instructionPane.add(instructionHead, gridBagConstraints57);
			instructionPane.add(instructionLabel1, gridBagConstraints58);
			instructionPane.add(instructionLabel2, gridBagConstraints59);
			instructionPane.add(instructionLabel3, gridBagConstraints60);
			instructionPane.add(instructionLabel4, gridBagConstraints61);
			instructionPane.add(instructionLabel5, gridBagConstraints62);
			instructionPane.add(instructionLabel6, gridBagConstraints63);
			instructionPane.add(instructionLabel7, gridBagConstraints64);
			instructionPane.add(instructionLabel8, gridBagConstraints65);
			instructionPane.add(instructionLabel9, gridBagConstraints66);
			instructionPane.add(instructionLabel10, gridBagConstraints67);
			instructionPane.add(instructionLabel11, gridBagConstraints68);
			instructionPane.add(instructionLabel13, gridBagConstraints70);
			instructionPane.add(instructionLabel12, gridBagConstraints69);
			instructionPane.add(instructionLabel14, gridBagConstraints71);
			instructionPane.add(instructionLabel15, gridBagConstraints72);
			instructionPane.add(getInstructionButton(), gridBagConstraints73);
			instructionPane.add(instructionLabel16, gridBagConstraints74);
			instructionPane.add(instructionLabel17, gridBagConstraints75);
			instructionPane.add(instructionLabel18, gridBagConstraints76);
			instructionPane.add(instructionLabel19, gridBagConstraints77);
			instructionPane.add(instructionLabel20, gridBagConstraints78);
			instructionPane.add(getMainmenuButton1(), gridBagConstraints79);
	
			return instructionPane;
	}

	/**
	 * This method initializes newgamePane
	 * @return The JPanel newgamePane
	 */
	
	private JPanel getNewgamePane() {
		//if (newgamePane == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 3;
			gridBagConstraints7.ipadx = 100;
			gridBagConstraints7.ipady = 25;
			gridBagConstraints7.weighty = 0.5D;
			gridBagConstraints7.gridy = 9;
			GridBagConstraints gridBagConstraints34 = new GridBagConstraints();
			gridBagConstraints34.gridx = 4;
			gridBagConstraints34.ipadx = 50;
			gridBagConstraints34.ipady = 25;
			gridBagConstraints34.gridy = 1;
			difficultyLabel = new JLabel();
			difficultyLabel.setText("Difficulty:");
			difficultyLabel.setForeground(new Color(0, 0, 204));
			difficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
			difficultyLabel
					.setFont(new Font("SketchFlow Print", Font.BOLD, 24));
			GridBagConstraints gridBagConstraints33 = new GridBagConstraints();
			gridBagConstraints33.gridx = 3;
			gridBagConstraints33.ipadx = 50;
			gridBagConstraints33.ipady = 25;
			gridBagConstraints33.gridy = 1;
			lengthLabel = new JLabel();
			lengthLabel.setText("Length:");
			lengthLabel.setForeground(new Color(0, 0, 204));
			lengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lengthLabel.setFont(new Font("SketchFlow Print", Font.BOLD, 24));
			GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
			gridBagConstraints32.gridx = 2;
			gridBagConstraints32.ipadx = 50;
			gridBagConstraints32.ipady = 25;
			gridBagConstraints32.gridy = 1;
			mapLabel = new JLabel();
			mapLabel.setText("Galaxy:");
			mapLabel.setForeground(new Color(0, 0, 204));
			mapLabel.setHorizontalAlignment(SwingConstants.CENTER);
			mapLabel.setFont(new Font("SketchFlow Print", Font.BOLD, 24));
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
			gridBagConstraints30.gridx = 4;
			gridBagConstraints30.ipadx = 0;
			gridBagConstraints30.ipady = 25;
			gridBagConstraints30.gridy = 2;
			choiceDifficulty = new JLabel();
			choiceDifficulty.setText("Easy");
			choiceDifficulty.setPreferredSize(new Dimension(150, 30));
			choiceDifficulty.setForeground(Color.white);
			choiceDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
			choiceDifficulty
					.setFont(new Font("SketchFlow Print", Font.BOLD, 24));
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.gridx = 3;
			gridBagConstraints29.ipadx = 50;
			gridBagConstraints29.ipady = 25;
			gridBagConstraints29.gridy = 2;
			choiceLength = new JLabel();
			choiceLength.setText("10");
			choiceLength.setPreferredSize(new Dimension(50, 30));
			choiceLength.setForeground(Color.white);
			choiceLength.setHorizontalAlignment(SwingConstants.CENTER);
			choiceLength.setFont(new Font("SketchFlow Print", Font.BOLD, 36));
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.gridx = 2;
			gridBagConstraints28.ipadx = 0;
			gridBagConstraints28.ipady = 25;
			gridBagConstraints28.weighty = 0.1D;
			gridBagConstraints28.gridy = 2;
			choiceMap = new JLabel();
			choiceMap.setText("Map 1");
			choiceMap.setPreferredSize(new Dimension(150, 30));
			choiceMap.setForeground(Color.white);
			choiceMap.setHorizontalAlignment(SwingConstants.CENTER);
			choiceMap.setFont(new Font("SketchFlow Print", Font.BOLD, 24));
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.gridx = 4;
			gridBagConstraints27.weighty = 0.1D;
			gridBagConstraints27.ipadx = 40;
			gridBagConstraints27.ipady = 20;
			gridBagConstraints27.gridy = 8;
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.gridx = 3;
			gridBagConstraints26.weighty = 0.1D;
			gridBagConstraints26.ipadx = 40;
			gridBagConstraints26.ipady = 20;
			gridBagConstraints26.gridy = 8;
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 2;
			gridBagConstraints25.weighty = 0.1D;
			gridBagConstraints25.ipadx = 40;
			gridBagConstraints25.ipady = 20;
			gridBagConstraints25.gridy = 8;
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.gridx = 1;
			gridBagConstraints24.weighty = 0.1D;
			gridBagConstraints24.ipadx = 40;
			gridBagConstraints24.ipady = 20;
			gridBagConstraints24.gridy = 8;
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 0;
			gridBagConstraints23.gridwidth = 6;
			gridBagConstraints23.ipadx = 50;
			gridBagConstraints23.ipady = 25;
			gridBagConstraints23.anchor = GridBagConstraints.WEST;
			gridBagConstraints23.weighty = 0.2D;
			gridBagConstraints23.gridy = 7;
			jLabel = new JLabel();
			jLabel.setText("Choose the difficulty you want to play in:");
			jLabel.setFont(new Font("SketchFlow Print", Font.BOLD, 24));
			jLabel.setForeground(new Color(0, 0, 204));
			jLabel.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 4;
			gridBagConstraints22.weighty = 0.1D;
			gridBagConstraints22.ipadx = 40;
			gridBagConstraints22.ipady = 20;
			gridBagConstraints22.gridy = 6;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 3;
			gridBagConstraints21.weighty = 0.1D;
			gridBagConstraints21.ipadx = 40;
			gridBagConstraints21.ipady = 20;
			gridBagConstraints21.gridy = 6;
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 2;
			gridBagConstraints20.weighty = 0.1D;
			gridBagConstraints20.ipady = 20;
			gridBagConstraints20.ipadx = 40;
			gridBagConstraints20.gridy = 6;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 1;
			gridBagConstraints19.weighty = 0.1D;
			gridBagConstraints19.ipadx = 40;
			gridBagConstraints19.ipady = 20;
			gridBagConstraints19.gridy = 6;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridwidth = 5;
			gridBagConstraints18.anchor = GridBagConstraints.WEST;
			gridBagConstraints18.ipadx = 50;
			gridBagConstraints18.ipady = 25;
			gridBagConstraints18.weighty = 0.2D;
			gridBagConstraints18.gridy = 5;
			chooseLength = new JLabel();
			chooseLength
					.setText("Choose the number of turns you require to save the galaxy:");
			chooseLength.setFont(new Font("SketchFlow Print", Font.BOLD, 24));
			chooseLength.setHorizontalAlignment(SwingConstants.CENTER);
			chooseLength.setForeground(Color.blue);
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.weighty = 0.1D;
			gridBagConstraints17.gridy = 12;
			newgamefooter = new JLabel();
			newgamefooter.setText("");
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 5;
			gridBagConstraints16.weightx = 1.0D;
			gridBagConstraints16.ipady = 20;
			gridBagConstraints16.ipadx = 40;
			gridBagConstraints16.gridy = 4;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 4;
			gridBagConstraints15.weightx = 1.0D;
			gridBagConstraints15.ipadx = 40;
			gridBagConstraints15.ipady = 20;
			gridBagConstraints15.gridy = 4;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 3;
			gridBagConstraints14.weightx = 1.0D;
			gridBagConstraints14.ipadx = 40;
			gridBagConstraints14.ipady = 20;
			gridBagConstraints14.gridy = 4;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 2;
			gridBagConstraints13.weightx = 1.0D;
			gridBagConstraints13.ipady = 20;
			gridBagConstraints13.ipadx = 40;
			gridBagConstraints13.weighty = 0.1D;
			gridBagConstraints13.gridy = 4;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.weightx = 1.0D;
			gridBagConstraints12.ipady = 20;
			gridBagConstraints12.ipadx = 40;
			gridBagConstraints12.weighty = 0.1D;
			gridBagConstraints12.gridy = 4;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.ipadx = 50;
			gridBagConstraints11.gridwidth = 7;
			gridBagConstraints11.weightx = 0.0D;
			gridBagConstraints11.ipady = 25;
			gridBagConstraints11.weighty = 0.2D;
			gridBagConstraints11.gridy = 3;
			chooseMap = new JLabel();
			chooseMap.setText("Choose your Galaxy you want to save:");
			chooseMap.setForeground(Color.blue);
			chooseMap.setHorizontalAlignment(SwingConstants.CENTER);
			chooseMap.setFont(new Font("SketchFlow Print", Font.BOLD, 24));
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.weightx = 0.0D;
			gridBagConstraints10.weighty = 1.0D;
			gridBagConstraints10.gridwidth = 6;
			gridBagConstraints10.gridy = 0;
			newgameHead = new JLabel();
			newgameHead.setFont(new Font("SketchFlow Print", Font.BOLD, 90));
			newgameHead.setText("GALACTIC WAR");
			newgameHead.setForeground(Color.orange);
			newgamePane = new JPanel();
			newgamePane.setLayout(new GridBagLayout());
			newgamePane.setBackground(Color.black);
			newgamePane.add(newgameHead, gridBagConstraints10);
			newgamePane.add(chooseMap, gridBagConstraints11);
			newgamePane.add(getMap1(), gridBagConstraints12);
			newgamePane.add(getMap2(), gridBagConstraints13);
			newgamePane.add(getMap3(), gridBagConstraints14);
			newgamePane.add(getMap4(), gridBagConstraints15);
			newgamePane.add(getMap5(), gridBagConstraints16);
			newgamePane.add(newgamefooter, gridBagConstraints17);
			newgamePane.add(chooseLength, gridBagConstraints18);
			newgamePane.add(getLength1(), gridBagConstraints19);
			newgamePane.add(getLength2(), gridBagConstraints20);
			newgamePane.add(getLength3(), gridBagConstraints21);
			newgamePane.add(getLength4(), gridBagConstraints22);
			newgamePane.add(jLabel, gridBagConstraints23);
			newgamePane.add(getDifficulty1(), gridBagConstraints24);
			newgamePane.add(getDifficulty2(), gridBagConstraints25);
			newgamePane.add(getDifficulty3(), gridBagConstraints26);
			newgamePane.add(getDifficulty4(), gridBagConstraints27);
			newgamePane.add(choiceMap, gridBagConstraints28);
			newgamePane.add(choiceLength, gridBagConstraints29);
			newgamePane.add(choiceDifficulty, gridBagConstraints30);
			newgamePane.add(mapLabel, gridBagConstraints32);
			newgamePane.add(lengthLabel, gridBagConstraints33);
			newgamePane.add(difficultyLabel, gridBagConstraints34);
			newgamePane.add(getstartGame(), gridBagConstraints7);
		//}
		return newgamePane;
	}
	
	/**
	 * This method displays a new game
	 */

	private void getNewgame() {
		if(panelCount == 0) {
			startPane.setVisible(false);
		}
		else if(panelCount == 2) {
			this.remove(saveloadPane);
		}
		else if(panelCount == 3) {
			this.remove(instructionPane);
			difficulty.stop();
		}
		else if(panelCount == 4) {
			this.remove(storyPane);
		}
		else if(panelCount == 5) {
			this.remove(gamePlay);
		} 

			this.add(getNewgamePane());
			panelCount = 1;
			startGame.setVisible(true);
			newgameadded = true;
	}
	
	/**
	 * This method displays the main menu
	 */
	
	private void getMainmenu() {
		if(panelCount == 1) {
			this.remove(newgamePane);
		}
		else if(panelCount == 2) {
			this.remove(saveloadPane);
		}
		else if(panelCount == 3) {
			this.remove(instructionPane);
			difficulty.stop();
		}
		else if(panelCount == 4) {
			this.remove(storyPane);
		}
		else if(panelCount == 5) {
			this.remove(gamePlay);
		}
			startPane.setVisible(true);
			panelCount = 0;
	}

	/**
	 * This method initializes newGame
	 * @return The JButton newGame
	 */
	
	private JButton getNewGame() {
		if (newGame == null) {
			newGame = new JButton();
			newGame.setPreferredSize(new Dimension(300, 50));
			newGame.setText("New Game");
			newGame.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getNewgame();
					startPane.setVisible(false);
				}
			});
		}
		return newGame;
	}

	/**
	 * This method initializes loadGame
	 * @return The JButton loadGame
	 */
	
	private JButton getLoadGame() {
		if (loadGame == null) {
			loadGame = new JButton();
			loadGame.setPreferredSize(new Dimension(300, 50));
			loadGame.setText("Load Game");
		}
		return loadGame;
	}
	
	/**
	 * This method displays the instruction pane
	 */
	
	private void getinstruction() {
			this.add(getInstructionPane());
			panelCount = 3;
			instructionadded = true;
	}

	/**
	 * This method initializes instructions
	 * @return The JButton instructions
	 */
	
	private JButton getInstructions() {
		if (instructions == null) {
			instructions = new JButton();
			instructions.setPreferredSize(new Dimension(300, 50));
			instructions.setText("Instructions");
			instructions.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getinstruction();
					startPane.setVisible(false);
				}
			});
		}
		return instructions;
	}
	
	/**
	 * This method displays the story pane
	 */
	
	private void getstory() {
			this.add(getStoryPane());
			panelCount = 4;
			storyadded = true;
	}

	/**
	 * This method initializes story
	 * @return The JButton story
	 */
	
	private JButton getStory() {
		if (story == null) {
			story = new JButton();
			story.setPreferredSize(new Dimension(300, 50));
			story.setText("Story");
			story.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getstory();
					startPane.setVisible(false);
				}
			});
		}
		return story;
	}

	/**
	 * This method initializes exit
	 * @return The JButton exit
	 */
	
	private JButton getExit2() {
		if (exit == null) {
			exit = new JButton();
			exit.setPreferredSize(new Dimension(300, 50));
			exit.setText("Exit");
			exit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exit;
	}

	/**
	 * This method initializes turnNumber
	 * @return The JPanel turnNumber
	 */
	
	private JPanel getTurnNumber() {
		if (turnNumber == null) {
			number = new JLabel();
			number.setBounds(new Rectangle(19, 28, 111, 96));
			number.setFont(new Font("SketchFlow Print", Font.BOLD, 48));
			number.setForeground(Color.white);
			number.setHorizontalAlignment(SwingConstants.CENTER);
			number.setText("");
			turnNumberlabel = new JLabel();
			turnNumberlabel.setBounds(new Rectangle(6, 1, 137, 29));
			turnNumberlabel
					.setFont(new Font("SketchFlow Print", Font.BOLD, 22));
			turnNumberlabel.setHorizontalAlignment(SwingConstants.CENTER);
			turnNumberlabel.setForeground(Color.red);
			turnNumberlabel.setText("Turn:");
			turnNumber = new JPanel();
			turnNumber.setLayout(null);
			turnNumber.setPreferredSize(new Dimension(130, 130));
			turnNumber.setBackground(Color.black);
			turnNumber.add(turnNumberlabel, null);
			turnNumber.add(number, null);
		}
		return turnNumber;
	}

	/**
	 * This method initializes map1
	 * @return The JButton map1
	 */
	
	private JButton getMap1() {
		if (map1 == null) {
			map1 = new JButton();
			map1.setText("Map 1");
			map1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceMap.setText("Map 1");
				}
			});
		}
		return map1;
	}

	/**
	 * This method initializes map2
	 * @return The JButton map2
	 */
	
	private JButton getMap2() {
		if (map2 == null) {
			map2 = new JButton();
			map2.setText("Map 2");
			map2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceMap.setText("Map 2");
				}
			});
		}
		return map2;
	}

	/**
	 * This method initializes map3
	 * @return The JButton map3
	 */
	
	private JButton getMap3() {
		if (map3 == null) {
			map3 = new JButton();
			map3.setText("Map 3");
			map3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceMap.setText("Map 3");
				}
			});
		}
		return map3;
	}

	/**
	 * This method initializes map4
	 * @return The JButton map4
	 */
	
	private JButton getMap4() {
		if (map4 == null) {
			map4 = new JButton();
			map4.setText("Map 4");
			map4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceMap.setText("Map 4");
				}
			});
		}
		return map4;
	}

	/**
	 * This method initializes map5
	 * @return The JButton map5
	 */
	
	private JButton getMap5() {
		if (map5 == null) {
			map5 = new JButton();
			map5.setText("Map 5");
			map5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceMap.setText("Map 5");
				}
			});
		}
		return map5;
	}

	/**
	 * This method initializes length1
	 * @return The JButton length1
	 */
	
	private JButton getLength1() {
		if (length1 == null) {
			length1 = new JButton();
			length1.setText("10");
			length1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceLength.setText("10");
				}
			});
		}
		return length1;
	}

	/**
	 * This method initializes length2
	 * @return The JButton length2
	 */
	
	private JButton getLength2() {
		if (length2 == null) {
			length2 = new JButton();
			length2.setText("15");
			length2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceLength.setText("15");
				}
			});
		}
		return length2;
	}

	/**
	 * This method initializes length3
	 * @return The JButton length3
	 */
	
	private JButton getLength3() {
		if (length3 == null) {
			length3 = new JButton();
			length3.setText("20");
			length3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceLength.setText("20");
				}
			});
		}
		return length3;
	}

	/**
	 * This method initializes length4
	 * @return The JButton length4
	 */
	
	private JButton getLength4() {
		if (length4 == null) {
			length4 = new JButton();
			length4.setText("25");
			length4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceLength.setText("25");
				}
			});
		}
		return length4;
	}

	/**
	 * This method initializes difficulty1
	 * @return The JButton difficulty1
	 */
	
	private JButton getDifficulty1() {
		if (difficulty1 == null) {
			difficulty1 = new JButton();
			difficulty1.setText("Easy");
			difficulty1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceDifficulty.setText("Easy");
				}
			});
		}
		return difficulty1;
	}

	/**
	 * This method initializes difficulty2
	 * @return The JButton difficulty2
	 */
	
	private JButton getDifficulty2() {
		if (difficulty2 == null) {
			difficulty2 = new JButton();
			difficulty2.setText("Normal");
			difficulty2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceDifficulty.setText("Normal");
				}
			});
		}
		return difficulty2;
	}

	/**
	 * This method initializes difficulty3
	 * @return The JButton difficulty3
	 */
	
	private JButton getDifficulty3() {
		if (difficulty3 == null) {
			difficulty3 = new JButton();
			difficulty3.setText("Hard");
			difficulty3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceDifficulty.setText("Hard");
				}
			});
		}
		return difficulty3;
	}

	/**
	 * This method initializes difficulty4
	 * @return The JButton difficulty4
	 */
	
	private JButton getDifficulty4() {
		if (difficulty4 == null) {
			difficulty4 = new JButton();
			difficulty4.setText("Diabolique");
			difficulty4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					choiceDifficulty.setText("Diabolique");
				}
			});
		}
		return difficulty4;
	}
	
	/**
	 * This method initializes Menu		
	 * @return The JMenuBar	Menu
	 */
	
	private JMenuBar getMenu() {
		if (Menu == null) {
			Menu = new JMenuBar();
			Menu.setPreferredSize(new Dimension(0, 25));
			Menu.add(getFile());
			Menu.add(getSoundMenu());
			Menu.add(getHelp());
		}
		return Menu;
	}

	/**
	 * This method initializes File	
	 * @return The JMenu File	
	 */
	
	private JMenu getFile() {
		if (File == null) {
			File = new JMenu();
			File.setText("File");
			File.setPreferredSize(new Dimension(71, 21));
			File.setHorizontalAlignment(SwingConstants.CENTER);
			File.setLocation(new Point(0, 0));
			File.setSize(new Dimension(71, 23));
			File.add(getNewGameitem());
			File.add(getRestartLevelitem());
			File.add(getMainMenuitem());
			File.addSeparator();
			File.add(getLoadGameitem());
			File.add(getSaveGameitem());
			File.addSeparator();
			File.add(getExititem());
			
		}
		return File;
	}

	/**
	 * This method initializes Help	
	 * @return The JMenu Help
	 */
	
	private JMenu getHelp() {
		if (Help == null) {
			Help = new JMenu();
			Help.setText("Help");
			Help.setHorizontalAlignment(SwingConstants.CENTER);
			Help.setPreferredSize(new Dimension(71, 21));
			Help.add(getInstructionitem());
			Help.add(getAboutitem());
		}
		return Help;
	}

	/**
	 * This method initializes newGameitem		
	 * @return The JMenuItem newGameitem
	 */
	
	private JMenuItem getNewGameitem() {
		if (newGameitem == null) {
			newGameitem = new JMenuItem("New Game",new ImageIcon("./gicon2.gif"));
			newGameitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.ALT_MASK));
			newGameitem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a New Game ?", "New Game", 0, 0,new ImageIcon("./player2.gif"));
					if(ans == 0) {
						getNewgame();
					}
				}
			});
		}
		return newGameitem;
	}

	/**
	 * This method initializes loadGameitem	
	 * @return The JMenuItem loadGameitem	
	 */
	
	private JMenuItem getLoadGameitem() {
		if (loadGameitem == null) {
			loadGameitem = new JMenuItem("Load Game",new ImageIcon("./load.gif"));
			loadGameitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
			loadGameitem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to Load Game ?", "Load Game", 0, 0,new ImageIcon("./player2.gif"));
					if(ans == 0) {
						
					}
				}
			});
		}
		return loadGameitem;
	}

	/**
	 * This method initializes saveGameitem		
	 * @return The JMenuItem saveGameitem
	 */
	
	private JMenuItem getSaveGameitem() {
		if (saveGameitem == null) {
			saveGameitem = new JMenuItem("Save Game",new ImageIcon("./save.gif"));
			saveGameitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
			saveGameitem.setEnabled(false);
			saveGameitem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
				}
			});
		}
		return saveGameitem;
	}

	/**
	 * This method initializes restartLevelitem		
	 * @return The JMenuItem restartLevelitem	
	 */
	
	private JMenuItem getRestartLevelitem() {
		if (restartLevelitem == null) {
			restartLevelitem = new JMenuItem("Restart Game",new ImageIcon("./gicon2.gif"));
			restartLevelitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.ALT_MASK));
			restartLevelitem.setEnabled(false);
			restartLevelitem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to Restart ?", "Restart Level", 0, 0,new ImageIcon("./player2.gif"));
					if(ans == 0) {
						try {
							logic.thiefTurn(lengthChoice, difficultyChoice, mapChoice);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						imagePane.setVisible(true);
						mapDraw.thiefVisible = false;
						p1pos.setVisible(true);
						p1PosShow.setVisible(true);
						p2pos.setVisible(true);
						p2PosShow.setVisible(true);
						Turn.setVisible(true);
						p1PosShow.setText("" + logic.getPosition1());
						p2PosShow.setText("" + logic.getPosition2());
						thiefPosition = 0;
						mapDraw.firstsetPlayerPos(1, logic.getpointPos(logic
								.getPosition1()));
						mapDraw.firstsetPlayerPos(2, logic.getpointPos(logic
								.getPosition2()));
						mapDraw.setCurrentPlayer(1);
						ArrayList<Point> temper = logic.getpos1List();
						temper.remove(logic.getpointPos(logic.getPosition2()));
						mapDraw.setNeighbours(temper);
						turn = 1;
						changer.start();
						number.setText("1");
					}
				}
			});
			
		}
		return restartLevelitem;
	}

	/**
	 * This method initializes exititem	
	 * @return The JMenuItem exititem
	 */
	
	private JMenuItem getExititem() {
		if (exititem == null) {
			exititem = new JMenuItem("Exit",new ImageIcon("./exit.gif"));
			exititem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit ?", "Exit", 0, 0,new ImageIcon("./player2.gif"));
					if(ans == 0) {
						System.exit(0);
					}
				}
			});
		}
		return exititem;
	}

	/**
	 * This method initializes instructionitem		
	 * @return The JMenuItem instructionitem	
	 */
	
	private JMenuItem getInstructionitem() {
		if (instructionitem == null) {
			instructionitem = new JMenuItem("How to Play",new ImageIcon("./instructions.gif"));
			instructionitem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane.showMessageDialog(null, "1.	The game starts with the Thief making his first move\n 2.	This is followed by the Hunter (i.e. the Player – You) making his first move\n 3.	The Phoenix (i.e. the Player – You) then makes his first move\n 4.	One can only move to the adjacent nodes that are highlighted by a yellow halo\n (Just click on any one of the highlighted nodes to move to that position)\n 5.	The position of the thief will be revealed at certain fixed intervals to facilitate catching him\n 6.	Continue in this fashion till either the thief is caught or the number of turns is exhausted\n 7.	The player wins the game if the thief is caught", "Instructions", 0);
				}
			});
		}
		return instructionitem;
	}

	/**
	 * This method initializes aboutitem		
	 * @return The JMenuItem aboutitem
	 */
	
	private JMenuItem getAboutitem() {
		if (aboutitem == null) {
			aboutitem = new JMenuItem("About Us",new ImageIcon("./AboutUs.gif"));
			aboutitem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Galactic War \n Version V0.2 (Build 250)\n Copyright © 2010. All rights reserved.\n The Galactic War gaming system and its user interface are protected by trademark\n and other pending or existing intellectual property rights in Singapore and other countries.\n This product is licensed under the Citron Software License Terms.", "About Us", 0);
				}
			});
		}
		return aboutitem;
	}

	/**
	 * This method initializes mainMenuitem		
	 * @return The JMenuItem mainMenuitem	
	 */
	
	private JMenuItem getMainMenuitem() {
		if (mainMenuitem == null) {
			mainMenuitem = new JMenuItem("Main Menu",new ImageIcon("./gicon2.gif"));
			mainMenuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.ALT_MASK));
			mainMenuitem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int ans = JOptionPane.showConfirmDialog(null, "Are you sure you want to go to Main menu ?", "Main menu", 0, 0,new ImageIcon("./player2.gif"));
					if(ans == 0) {
						getMainmenu();
					}
				}
			});
		}
		return mainMenuitem;
	}
	
	/**
	 * This method initializes soundMenu		
	 * @return The JMenu soundMenu
	 */
	
	private JMenu getSoundMenu() {
		if (soundMenu == null) {
			soundMenu = new JMenu();
			soundMenu.setText("Sounds");
			soundMenu.add(getSoundCheckBoxMenuItem());
		}
		return soundMenu;
	}

	/**
	 * This method initializes mainmenuButton		
	 * @return The JButton mainmenuButton	
	 */
	
	private JButton getMainmenuButton() {
		if (mainmenuButton == null) {
			mainmenuButton = new JButton();
			mainmenuButton.setText("Main Menu");
			mainmenuButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getMainmenu();
				}
			});
		}
		return mainmenuButton;
	}

	/**
	 * This method initializes instructionButton		
	 * @return The JButton instructionButton
	 */
	
	private JButton getInstructionButton() {
		if (instructionButton == null) {
			instructionButton = new JButton();
			instructionButton.setPreferredSize(new Dimension(110, 40));
		}
		return instructionButton;
	}

	/**
	 * This method initializes mainmenuButton1	
	 * @return The JButton mainmenuButton1	
	 */
	
	private JButton getMainmenuButton1() {
		if (mainmenuButton1 == null) {
			mainmenuButton1 = new JButton();
			mainmenuButton1.setText("Main menu");
			mainmenuButton1.setPreferredSize(new Dimension(96, 46));
			mainmenuButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getMainmenu();
				}
			});
		}
		return mainmenuButton1;
	}

	/**
	 * This method initializes soundCheckBoxMenuItem		
	 * @return The JCheckBoxMenuItem soundCheckBoxMenuItem
	 */
	
	private JCheckBoxMenuItem getSoundCheckBoxMenuItem() {
		if (soundCheckBoxMenuItem == null) {
			soundCheckBoxMenuItem = new JCheckBoxMenuItem();
			soundCheckBoxMenuItem.setText("Sound");
			soundCheckBoxMenuItem.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(soundOn == true) {
						sound.playSound(false);
						soundOn = false;
					}
					else if(soundOn == false) {
						sound.playSound(true);
						soundOn = true;
					}
				}
			});
		}
		return soundCheckBoxMenuItem;
	}

	/**
	 * The main method
	 * @param args The input given at run time
	 */

	public static void main(String[] args) {
		SwingUtilities.invokeLater(
		new Runnable() {
			public void run() {
				Gui thisClass = new Gui();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}
}