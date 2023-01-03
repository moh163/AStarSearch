import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Carree {
	private int x;
	private int y;
	private static double cote=25;
	private boolean isObstacle=false;
	private boolean isGoal=false;
	private boolean isInitial=false;
	private boolean isChemin=false;

	public Carree(int x, int y) {
		this.x=x;
		this.y=y;	
	}

	public void dessiner(Graphics2D g2d, Carree c) {
		Graphics2D g2dPrive = (Graphics2D) g2d.create();
		Rectangle2D.Double	leCarree= new Rectangle2D.Double(this.x*cote-cote,this.y*cote-cote,cote,cote);
		if(c.isObstacle()) {
			g2dPrive.setColor(Color.BLACK);
		} else{
			if(c.isGoal()) {
				g2dPrive.setColor(Color.BLUE);
			} else{
				if(c.isInitial()) {
					g2dPrive.setColor(Color.YELLOW);
				} else{
					if(c.isChemin()) {
						g2dPrive.setColor(Color.GREEN);
					} else{
						g2dPrive.setColor(Color.GRAY);
					}
				}
			}
			
		}
		g2dPrive.fill(leCarree);
		g2dPrive.setColor(Color.RED);
		g2dPrive.draw(leCarree);
	}

	public boolean isGoal() {
		return isGoal;
	}

	public void setGoal(boolean isGoal) {
		this.isGoal = isGoal;
	}

	public boolean isInitial() {
		return isInitial;
	}

	public void setInitial(boolean isInitial) {
		this.isInitial = isInitial;
	}

	public boolean isChemin() {
		return isChemin;
	}

	public void setChemin(boolean isChemin) {
		this.isChemin = isChemin;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}

	public boolean isObstacle() {
		return isObstacle;
	}

	public void setObstacle(boolean isObstacle) {
		this.isObstacle = isObstacle;
	}
}
