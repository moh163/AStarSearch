import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javax.swing.JPanel;

public class Environnement extends JPanel implements Runnable {
	private int enX;
	private int enY;
	private Carree[][] allState;
	private Carree goal;
	private Carree initial;
	private boolean enCoursDAnimation;
	/**
	 * Create the panel.
	 */
	public Environnement(int enX, int enY, Carree initial, Carree goal) {

		this.enX=enX;
		this.enY=enY;
		this.initial=initial;
		this.goal=goal;
		allState=new Carree[enX][enY];
		creergeometrie();
		
	}
	public void creergeometrie() {
		for(int x=0; x<enX;x++) {
			for(int y=0; y<enY;y++) {
				if(goal.getX()==x && goal.getY()==y) {

					allState[x][y]=goal;
					allState[x][y].setGoal(true);

				}else {
					if(initial.getX()==x && initial.getY()==y) {

						allState[x][y]=initial;
						allState[x][y].setInitial(true);

					}else {
						if(Math.random()*100<33) {
							Carree o=new Carree(x,y);
							o.setObstacle(true);
							allState[x][y]=o;
						}else {
							Carree c = new Carree(x,y);
							allState[x][y]=	c;
						}
					}
				}
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		for(int x=0; x<enX;x++) {
			for(int y=0; y<enY;y++) {
				allState[x][y].dessiner(g2d,allState[x][y]);
			}
		}

	}
	@Override
	public void run() {
		while (enCoursDAnimation) {

		}

	}
	public void demarrer() {
		if (!enCoursDAnimation) { 
			Thread processusAnim = new Thread(this);
			processusAnim.start();
			enCoursDAnimation = true;
		}
	}

	public Node recherche() {
		System.out.println("Recherche commencée");
		Node courant= new Node(initial);
		PriorityQueue<Node> frontier = new  PriorityQueue<Node>(1, new NodeComparator());
		frontier.add(courant);
		Map<Carree, Node> reached = new HashMap<>();
		reached.put(this.initial,courant);
		Carree s;
		Node n;
		while(!frontier.isEmpty()){
			courant=frontier.poll();
			if(courant.getState()==this.goal) {
				this.traceChemin(courant);
				return courant;
			}else {
				List<Node> child =courant.expand(courant,this);
				while(!child.isEmpty()) {
					n=child.remove(0);
					s=n.getState();
					if(!reached.containsKey(s)) {
						reached.put(s,n);
						frontier.add(n);
					}else {
						if( n.getCost()<reached.get(s).getCost()) {
							reached.replace(s,n);
							frontier.add(n);
						}
					}
				}
			}
		}
		return null;
	}

	public void traceChemin(Node n) {
		while(!(n.getState()==this.initial)) {
			n.getState().setChemin(true);
			n=n.getParent();
		}
		repaint();
	}

	public Carree choisirCarree(int x, int y) {
		return allState[x][y];
	}

	public double calculHeuristic(Node n) {
		return (Math.sqrt(Math.pow(n.getState().getX()-goal.getX(),2)+Math.pow(n.getState().getY()-goal.getY(),2)));
	}
	public double calculCost(Node n) {
		double cost= n.getPathCost()+calculHeuristic(n);
		n.setCost(cost);
		return cost;
	}
	public int getEnX() {
		return enX;
	}


	public int getEnY() {
		return enY;
	}


	public Carree[][] getAllState() {
		return allState;
	}
	public void setEnX(int enX) {
		this.enX = enX;
		creergeometrie();
	}
	public void setEnY(int enY) {
		this.enY = enY;
		creergeometrie();
	}
	public void setGoal(Carree goal) {
		this.goal = goal;
		creergeometrie();
	}
	public void setInitial(Carree initial) {
		this.initial = initial;
		creergeometrie();
	}
}
