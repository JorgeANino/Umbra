import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;

public class MyCanvas extends JPanel implements KeyListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private ArrayList<Character> enemies;
	protected ArrayList<Door> DoorList;
	protected ArrayList<Heart> lives;
	protected ArrayList<Heart> treasures;
	protected ArrayList<AdventuringStuff> adventuringStuff;
	private MainCharacter MC;
	private Timer time;
	private int Room, counter, start, EK, BK, proPos, roomspassed, i = 0;
	private boolean addingEnemies, addingDoors, addingLives, proFlag, roomClear, randomLives, pickedItems;
	private Rectangle e, m, top, bot, left, right, rdleft, rdright, rdup, rddown;
	private TreasureRoom room1;
	private EnemyRoom room2;
	private BossRoom room3;
	private Menu menu;
	private Slash pro;
	private String weapon;
	private BufferedImage img, stuffImg;

	public MyCanvas() {
		super();
		weapon = "";
		enemies = new ArrayList<Character>();
		DoorList = new ArrayList<Door>();
		adventuringStuff = new ArrayList<AdventuringStuff>();
		EK = 0;
		BK = 0;
		roomspassed = 0;
		randomLives = true;
		pickedItems = false;
		MC = new MainCharacter(100, "   LINK", 200, 3, false, 40, 40, 50, 10, 100);
		addingLives = true;
		lives = new ArrayList<Heart>();
		treasures = new ArrayList<Heart>();
		time = new Timer(200, this);
		this.addKeyListener(this);
		// this.addMouseListener(this);
		this.setFocusable(true);
		this.setDoubleBuffered(true);
		proFlag = false;
		proPos = 2;
		Room = 1;
		addingEnemies = true;
		addingDoors = true;
		time.start();
		e = null;
		m = null;
		start = 0;
		counter = 0;
		i = 0;
		top = new Rectangle(40, 0, 410, 35);
		bot = new Rectangle(40, 435, 410, 35);
		left = new Rectangle(0, 40, 35, 410);
		right = new Rectangle(455, 40, 35, 410);
		room1 = new TreasureRoom();
		room2 = new EnemyRoom();
		room3 = new BossRoom();
		menu = new Menu();
		roomClear = false;
		rdup = null;
		rddown = null;
		rdright = null;
		rdleft = null;
	}

	public void addEnemies(int enem, int bosses, boolean boss, boolean ene) {
		Random r = new Random();
		if (ene == true) {
			for (int i = 0; i < enem + 1; i++) {
				Character enemy = new Enemy(100, "Enemy", r.nextInt(5), r.nextInt(300) + 50, r.nextInt(300) + 50, 50,
						r.nextInt(4) + 1, 20);
				enemies.add(enemy);
			}
		}
		if (boss == true) {
			for (int i = 0; i < bosses + 1; i++) {
				Character fb = new FinalBoss(500, "BOSS", r.nextInt(5) + 15, r.nextInt(300) + 50, r.nextInt(300) + 50,
						50, r.nextInt(4) + 3, 50);
				enemies.add(fb);
			}
		}

	}

	public void enemiesMoving() {
		Random r = new Random();
		ListIterator<Character> iterator = enemies.listIterator();
		while (iterator.hasNext()) {
			Character aux = iterator.next();
			e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
			aux.setHitbox(e);
			if (aux instanceof Enemy) {
				// ((Enemy) aux).setDirection(r.nextInt(4));
				for (int i = 0; i < 5; i++) {
					if (((Enemy) aux).getDirection() == 0 && aux.getHitbox().intersects(bot) == false) {
						if (((Enemy) aux).getMove() == 1) {
							((Enemy) aux).setPosition(0.1);
							aux.setY(aux.getY() + ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(2);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((Enemy) aux).getMove() == 2) {
							((Enemy) aux).setPosition(0.0);
							aux.setY(aux.getY() + ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(3);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((Enemy) aux).getMove() == 3) {
							((Enemy) aux).setPosition(0.2);
							aux.setY(aux.getY() + ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(1);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						}
					} else if (((Enemy) aux).getDirection() == 1 && aux.getHitbox().intersects(top) == false) {
						if (((Enemy) aux).getMove() == 1) {
							((Enemy) aux).setPosition(1.1);
							aux.setY(aux.getY() - ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(2);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((Enemy) aux).getMove() == 2) {
							((Enemy) aux).setPosition(1.0);
							aux.setY(aux.getY() - ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(3);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((Enemy) aux).getMove() == 3) {
							((Enemy) aux).setPosition(1.2);
							aux.setY(aux.getY() - ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(1);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						}
					} else if (((Enemy) aux).getDirection() == 2 && aux.getHitbox().intersects(right) == false) {
						if (((Enemy) aux).getMove() == 1) {
							((Enemy) aux).setPosition(2.1);
							aux.setX(aux.getX() + ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(2);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((Enemy) aux).getMove() == 2) {
							((Enemy) aux).setPosition(2.0);
							aux.setX(aux.getX() + ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(3);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((Enemy) aux).getMove() == 3) {
							((Enemy) aux).setPosition(2.2);
							aux.setX(aux.getX() + ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(1);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						}
					} else if (((Enemy) aux).getDirection() == 3 && aux.getHitbox().intersects(left) == false) {
						if (((Enemy) aux).getMove() == 1) {
							((Enemy) aux).setPosition(3.1);
							aux.setX(aux.getX() - ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(2);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((Enemy) aux).getMove() == 2) {
							((Enemy) aux).setPosition(3.0);
							aux.setX(aux.getX() - ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(3);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((Enemy) aux).getMove() == 3) {
							((Enemy) aux).setPosition(3.2);
							aux.setX(aux.getX() - ((Enemy) aux).getSpeed());
							((Enemy) aux).setMove(1);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						}
					}
				}
				repaint();
				((Enemy) aux).setDirection(r.nextInt(4));
			} else if (aux instanceof FinalBoss) {
				for (int i = 0; i < 5; i++) {
					if (((FinalBoss) aux).getDirection() == 0 && aux.getHitbox().intersects(bot) == false) {
						if (((FinalBoss) aux).getMove() == 1) {
							((FinalBoss) aux).setPosition(0.1);
							aux.setY(aux.getY() + ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(2);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((FinalBoss) aux).getMove() == 2) {
							((FinalBoss) aux).setPosition(0.0);
							aux.setY(aux.getY() + ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(3);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((FinalBoss) aux).getMove() == 3) {
							((FinalBoss) aux).setPosition(0.2);
							aux.setY(aux.getY() + ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(1);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						}
					} else if (((FinalBoss) aux).getDirection() == 1 && aux.getHitbox().intersects(top) == false) {
						if (((FinalBoss) aux).getMove() == 1) {
							((FinalBoss) aux).setPosition(1.1);
							aux.setY(aux.getY() - ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(2);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((FinalBoss) aux).getMove() == 2) {
							((FinalBoss) aux).setPosition(1.0);
							aux.setY(aux.getY() - ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(3);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((FinalBoss) aux).getMove() == 3) {
							((FinalBoss) aux).setPosition(1.2);
							aux.setY(aux.getY() - ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(1);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						}
					} else if (((FinalBoss) aux).getDirection() == 2 && aux.getHitbox().intersects(right) == false) {
						if (((FinalBoss) aux).getMove() == 1) {
							((FinalBoss) aux).setPosition(2.1);
							aux.setX(aux.getX() + ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(2);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((FinalBoss) aux).getMove() == 2) {
							((FinalBoss) aux).setPosition(2.0);
							aux.setX(aux.getX() + ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(3);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((FinalBoss) aux).getMove() == 3) {
							((FinalBoss) aux).setPosition(2.2);
							aux.setX(aux.getX() + ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(1);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						}
					} else if (((FinalBoss) aux).getDirection() == 3 && aux.getHitbox().intersects(left) == false) {
						if (((FinalBoss) aux).getMove() == 1) {
							((FinalBoss) aux).setPosition(3.1);
							aux.setX(aux.getX() - ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(2);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((FinalBoss) aux).getMove() == 2) {
							((FinalBoss) aux).setPosition(3.0);
							aux.setX(aux.getX() - ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(3);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						} else if (((FinalBoss) aux).getMove() == 3) {
							((FinalBoss) aux).setPosition(3.2);
							aux.setX(aux.getX() - ((FinalBoss) aux).getSpeed());
							((FinalBoss) aux).setMove(1);
							e = new Rectangle(aux.getX(), aux.getY(), aux.getSize(), aux.getSize());
							aux.setHitbox(e);
						}
					}
				}
				repaint();
				((FinalBoss) aux).setDirection(r.nextInt(4));

			}
		}
	}

	public void mcAttacked() {
		ListIterator<Character> iterator = enemies.listIterator();
		while (iterator.hasNext()) {
			Character aux = iterator.next();
			if (MC.getLives() > 0) {
				if (aux.getHitbox().intersects(MC.getHitbox())) {
					if (aux.getX() < MC.getX()) {
						MC.setX(MC.getX() + aux.getKnockback());
					} else if (aux.getX() > MC.getX()) {
						MC.setX(MC.getX() - aux.getKnockback());
					} else if (aux.getY() < MC.getY()) {
						MC.setY(MC.getY() + aux.getKnockback());
					} else if (aux.getY() > MC.getY()) {
						MC.setY(MC.getY() - aux.getKnockback());
					}
					if (MC.getHp() > 0) {
						MC.setHp(MC.getHp() - aux.getPower());
						MC.setAttacked(true);
						start = 0;
						MC.setInmune(true);

					}
					System.out.println(MC.getHp());
					System.out.println(MC.getLives());
				}
				if (MC.getHp() <= 0) {
					lives.remove(MC.getLives() - 1);
					MC.setLives(MC.getLives() - 1);
					MC.setHp(100);
				}
			} else {
				Room = 0;
			}
		}
	}

	public void enemiesAttacked() {
		ListIterator<Character> iterator = enemies.listIterator();
		while (iterator.hasNext()) {
			Character aux = iterator.next();
			if (pro != null) {
				if (aux.getHitbox().intersects(pro.getHitBox())) {
					if (aux.getHp() > 0) {
						aux.setHp(aux.getHp() - MC.getPower());
					}
				}
			}
			if (aux.getHp() <= 0) {
				if (aux instanceof Enemy) {
					EK += 1;
				} else if (aux instanceof FinalBoss) {
					BK += 1;
				}
				iterator.remove();
			}
		}
	}

	public void movProyectil() {
		if (pro != null) {
			for (int j = 0; j < 14; j++) {
				switch (proPos) {
				case 8:
					pro.setPos(proPos);
					pro.setY(pro.getY() - 3);
					break;
				case 6:
					pro.setPos(proPos);
					pro.setX(pro.getX() + 3);
					break;
				case 2:
					pro.setPos(proPos);
					pro.setY(pro.getY() + 3);
					break;
				case 4:
					pro.setPos(proPos);
					pro.setX(pro.getX() - 3);
					break;
				}
				pro.getHitBox().setLocation(pro.getX(), pro.getY());
			}
		}
		if (i > 2) {
			pro = null;
			i = 0;
		}
	}

	public void addDoors() {
		Door dleft = new Door(0, 225, 3);
		rdleft = new Rectangle(0, 255, 40, 40);
		Door dup = new Door(225, 0, 2);
		rdup = new Rectangle(225, 0, 40, 40);
		Door ddown = new Door(225, 430, 0);
		rddown = new Rectangle(225, 430, 40, 40);
		Door dright = new Door(450, 225, 1);
		rdright = new Rectangle(455, 225, 40, 40);
		DoorList.add(dleft);
		DoorList.add(dright);
		DoorList.add(dup);
		DoorList.add(ddown);
	}

	public void walkThroughDoor() {
		Random r = new Random();
		if (MC.getHitbox().intersects(rddown)) {
			Room = r.nextInt(3) + 1;
			MC.setX(225);
			MC.setY(50);
			addingDoors = true;
			roomspassed += 1;
			this.closeDoors();
		} else if (MC.getHitbox().intersects(rdup)) {
			Room = r.nextInt(3) + 1;
			MC.setX(225);
			MC.setY(375);
			addingDoors = true;
			roomspassed += 1;
			this.closeDoors();
		} else if (MC.getHitbox().intersects(rdright)) {
			Room = r.nextInt(3) + 1;
			MC.setX(50);
			MC.setY(225);
			addingDoors = true;
			roomspassed += 1;
			this.closeDoors();
		} else if (MC.getHitbox().intersects(rdleft)) {
			Room = r.nextInt(3) + 1;
			MC.setX(390);
			MC.setY(225);
			addingDoors = true;
			roomspassed += 1;
			this.closeDoors();
		}
		if (Room == 2) {
			addingEnemies = true;
		} else if (Room == 1) {
			randomLives = true;
		} else if (Room == 3) {
			addingEnemies = true;
		}

	}

	public void openDoors() {
		ListIterator<Door> iterator = DoorList.listIterator();
		while (iterator.hasNext()) {
			iterator.next().setOpen(true);
		}

	}

	public void closeDoors() {
		ListIterator<Door> iterator = DoorList.listIterator();
		while (iterator.hasNext()) {
			iterator.next().setOpen(false);
		}
	}

	public void isRoomClear() {
		ListIterator<Character> iterator = enemies.listIterator();
		if (iterator.hasNext() == false) {
			roomClear = true;
		}
		ListIterator<Heart> itrh = treasures.listIterator();
		if (itrh.hasNext() == false) {
			pickedItems = true;
		}
	}

	public void paint(Graphics g) {
		try {
			img = ImageIO.read(new File("Images\\hud.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (Room == 0) {
			try {
				menu.paint(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (Room == 1) {
			room1.paint(g);
			ListIterator<Door> itr = DoorList.listIterator();
			while (itr.hasNext()) {
				Door aux = itr.next();
				try {
					aux.paint(g);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ListIterator<Character> iterator = enemies.listIterator();
			while (iterator.hasNext()) {
				Character aux = iterator.next();
				if (aux instanceof Enemy) {
					try {
						((Enemy) aux).paint(g);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (aux instanceof FinalBoss) {
					try {
						((FinalBoss) aux).paint(g);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				MC.paint(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (Room == 2) {
			room2.paint(g);

			ListIterator<Door> itr = DoorList.listIterator();
			while (itr.hasNext()) {
				Door aux = itr.next();
				try {
					aux.paint(g);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ListIterator<Character> iterator = enemies.listIterator();
			while (iterator.hasNext()) {
				Character aux = iterator.next();
				if (aux instanceof Enemy) {
					try {
						((Enemy) aux).paint(g);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (aux instanceof FinalBoss) {
					try {
						((FinalBoss) aux).paint(g);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				MC.paint(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (Room == 3) {
			try {
				room3.paint(g);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			ListIterator<Door> itr = DoorList.listIterator();
			while (itr.hasNext()) {
				Door aux = itr.next();
				try {
					aux.paint(g);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ListIterator<Character> iterator = enemies.listIterator();
			while (iterator.hasNext()) {
				Character aux = iterator.next();
				if (aux instanceof Enemy) {
					try {
						((Enemy) aux).paint(g);
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else if (aux instanceof FinalBoss) {
					try {
						((FinalBoss) aux).paint(g);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				MC.paint(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pro != null && proFlag == true) {
			try {
				pro.paint(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		g.drawImage(img, 10, 435, 200, 30, null);
		ListIterator<Heart> itrh = lives.listIterator();
		while (itrh.hasNext()) {
			Heart auxh = itrh.next();
			try {
				auxh.paint(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ListIterator<Heart> itrrh = treasures.listIterator();
		while (itrrh.hasNext()) {
			Heart auxrh = itrrh.next();
			try {
				auxrh.paint(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ListIterator<AdventuringStuff> itras = adventuringStuff.listIterator();
		while (itras.hasNext()) {
			AdventuringStuff auxas = itras.next();
			try {
				auxas.paint(g);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		g.drawImage(img, 340, 435, 120, 30, null);
		g.setColor(Color.WHITE);
		g.drawString("Bosses Slayed: " + BK, 350, 450);
		g.setColor(Color.WHITE);
		g.drawString("Enemies Slayed: " + EK, 350, 460);
		g.drawImage(img, 10, 5, 200, 30, null);
		g.drawString(weapon, 23, 25);
		g.drawImage(img, 280, 5, 180, 30, null);
		g.drawString("DMG " + MC.getPower() + " KnB " + MC.getKnockback(), 290, 25);
		if (stuffImg != null) {
			g.drawImage(stuffImg, 395, 2, 60, 35, null);
		}
	}

	public void addLives() {
		// agregar hitbox a los corazones e intersects con el MC.
		ListIterator<Heart> iteratorh = treasures.listIterator();
		while (iteratorh.hasNext()) {
			Heart auxh = iteratorh.next();
			if (MC.getHitbox().intersects(auxh.getHitbox())) {
				iteratorh.remove();
				MC.setLives(MC.getLives() + 1);
				addingLives = true;
			}
		}
		if (addingLives == true) {
			int heartpos = 0;
			for (int i = 0; i < MC.getLives(); i++) {
				heartpos += 10;
				Heart newheart = new Heart(heartpos, 435, 30);
				lives.add(newheart);
			}
			addingLives = false;
		}

	}

	public void addStuff4Adventuring() {
		Random r = new Random();
		int rs = r.nextInt(3), rkb = r.nextInt(40) + 10, ratk = r.nextInt(20) + 50;
		AdventuringStuff auxa = new AdventuringStuff(rs, rkb, ratk, r.nextInt(200) + 50, r.nextInt(200) + 50);
		adventuringStuff.add(auxa);
	}

	public void addStuff2MC() {
		ListIterator<AdventuringStuff> itrad = adventuringStuff.listIterator();
		while (itrad.hasNext()) {
			AdventuringStuff auxaitr = itrad.next();
			if (MC.getHitbox().intersects(auxaitr.getR())) {
				try {
					stuffImg = auxaitr.stuffImg();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MC.setPower(MC.getPower() + auxaitr.getAtk());
				MC.setKnockback(MC.getKnockback() + auxaitr.getKnockback());
				this.weapon = auxaitr.getName();
				System.out.println(
						"Stuff= " + auxaitr.getName() + " MC Atk= " + MC.getPower() + "MC KB= " + MC.getKnockback());
				itrad.remove();
			}
		}
	}

	public void addRandomLives() {
		if (randomLives == true && MC.getLives() < 5) {
			Random rh = new Random();
			for (int y = 0; y < rh.nextInt(1) + 1; y++) {
				Heart newrh = new Heart(rh.nextInt(300) + 50, rh.nextInt(300) + 50, 30);
				treasures.add(newrh);
			}
			randomLives = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		this.enemiesAttacked();
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			proFlag = true;
			MC.setX(MC.getX());
			MC.setY(MC.getY());
			switch (proPos) {
			case 2:
				MC.setPosition(4.0);
				break;
			case 6:
				MC.setPosition(5.0);
				break;
			case 8:
				MC.setPosition(6.0);
				break;
			case 4:
				MC.setPosition(7.0);
				break;
			}
			pro = new Slash(MC.getX(), MC.getY());
			break;
		case KeyEvent.VK_DOWN:
			proPos = 2;
			if (MC.getHitbox().intersects(bot) == false) {
				if (MC.getPressed() == 1) {
					MC.setPosition(0.1);
					MC.setY(MC.getY() + MC.getSpeed());
					MC.setPressed(2);
				} else if (MC.getPressed() == 2) {
					MC.setPosition(0.2);
					MC.setY(MC.getY() + MC.getSpeed());
					MC.setPressed(1);
				}
			}
			m = new Rectangle(MC.getX(), MC.getY(), MC.getSize(), MC.getSize());
			MC.setHitbox(m);
			break;
		case KeyEvent.VK_RIGHT:
			proPos = 6;
			if (MC.getHitbox().intersects(right) == false) {
				if (MC.getPressed() == 1) {
					MC.setPosition(1.1);
					MC.setX(MC.getX() + MC.getSpeed());
					MC.setPressed(2);
				} else if (MC.getPressed() == 2) {

					MC.setPosition(1.2);
					MC.setX(MC.getX() + MC.getSpeed());
					MC.setPressed(1);
				}
			}
			m = new Rectangle(MC.getX(), MC.getY(), MC.getSize(), MC.getSize());
			MC.setHitbox(m);
			break;
		case KeyEvent.VK_UP:
			proPos = 8;
			if (MC.getHitbox().intersects(top) == false) {
				if (MC.getPressed() == 1) {
					MC.setPosition(2.1);
					MC.setY(MC.getY() - MC.getSpeed());
					MC.setPressed(2);
				} else if (MC.getPressed() == 2) {
					MC.setPosition(2.2);
					MC.setY(MC.getY() - MC.getSpeed());
					MC.setPressed(1);
				}
			}
			m = new Rectangle(MC.getX(), MC.getY(), MC.getSize(), MC.getSize());
			MC.setHitbox(m);
			break;
		case KeyEvent.VK_LEFT:
			proPos = 4;
			if (MC.getHitbox().intersects(left) == false) {
				if (MC.getPressed() == 1) {
					MC.setPosition(3.1);
					MC.setX(MC.getX() - MC.getSpeed());
					MC.setPressed(2);
				} else if (MC.getPressed() == 2) {
					MC.setPosition(3.2);
					MC.setX(MC.getX() - MC.getSpeed());
					MC.setPressed(1);
				}
			}
			m = new Rectangle(MC.getX(), MC.getY(), MC.getSize(), MC.getSize());
			MC.setHitbox(m);
			break;
		}

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			MC.setPosition(0.0);
			break;
		case KeyEvent.VK_RIGHT:
			MC.setPosition(1.0);
			break;
		case KeyEvent.VK_UP:
			MC.setPosition(2.0);
			break;
		case KeyEvent.VK_LEFT:
			MC.setPosition(3.0);
			break;
		}
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Random r = new Random();
		if (Room == 0) {
			MC = null;
		} else if (Room == 1 && randomLives == true && addingDoors == true) {
			this.addDoors();
			this.addStuff4Adventuring();
			// roomClear = false;
			addRandomLives();
			addingDoors = false;
			pickedItems = false;
			// this.addEnemies(r.nextInt(3) + 1, false, 0);
			// addingEnemies = false;
			// addingDoors = false;
		} else if (Room == 2 && addingEnemies == true && addingDoors == true) {
			this.addDoors();
			this.addEnemies(r.nextInt(5) + roomspassed, 0, false, true);
			addingEnemies = false;
			addingDoors = false;
			roomClear = false;
		} else if (Room == 3 && addingEnemies == true && addingDoors == true) {
			this.addDoors();
			this.addEnemies(0, r.nextInt(1) + roomspassed, true, false);
			addingEnemies = false;
			addingDoors = false;
			roomClear = false;
		}
		if (Room == 2 && roomClear == true) {
			this.openDoors();
			walkThroughDoor();
		} else if (Room == 1 && pickedItems == true) {
			this.openDoors();
			walkThroughDoor();
		} else if (Room == 3 && roomClear == true) {
			this.openDoors();
			walkThroughDoor();
		}
		this.addLives();
		this.enemiesMoving();
		this.movProyectil();
		this.enemiesAttacked();
		this.isRoomClear();
		this.addStuff2MC();
		if (MC.isInmune() == false) {
			this.mcAttacked();
		}

		repaint();
		if (MC.isAttacked() && start == 0) {
			counter = 0;
			start = 1;
		}
		counter = counter + 1;
		if (counter == 20) {
			MC.setAttacked(false);
			counter = 0;
			MC.setInmune(false);
		}

	}

}
