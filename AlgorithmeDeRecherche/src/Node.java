import java.util.ArrayList;
import java.util.List;

;

public class Node {
	private Node parent; 
	private Carree state;
	private double cost;
	private double pathCost;

	public Node(Carree state) {
		this.state=state;
		parent=null;
		pathCost=0;
	}
	public Node(Node parent, Carree state) {
		this.parent=parent;
		this.state=state;
		this.pathCost=parent.pathCost+1;
	}
	public List<Node> expand(Node node, Environnement problem) {
		List<Node> child = new ArrayList<Node>();
		int x=-1;
		if( (node.getState().getX() > 1)&& (!problem.choisirCarree(node.getState().getX()-1,node.getState().getY()).isObstacle())) {
			child.add( new Node(node,problem.choisirCarree(node.getState().getX()-1,node.getState().getY())));	
			x=x+1;
			problem.calculCost(child.get(x));
		}
		if(node.getState().getX()<problem.getEnX()&& (!problem.choisirCarree(node.getState().getX()+1,node.getState().getY()).isObstacle())) {
			child.add( new Node(node,problem.choisirCarree(node.getState().getX()+1,node.getState().getY())));
			x=x+1;
			problem.calculCost(child.get(x));
		}
		if( (node.getState().getY() > 1)&& (!problem.choisirCarree(node.getState().getX(),node.getState().getY()-1).isObstacle())) {
			child.add( new Node(node,problem.choisirCarree(node.getState().getX(),node.getState().getY()-1)));
			x=x+1;
			problem.calculCost(child.get(x));
		}
		if(node.getState().getY()<problem.getEnY()&& (!problem.choisirCarree(node.getState().getX(),node.getState().getY()+1).isObstacle())) {
			child.add( new Node(node,problem.choisirCarree(node.getState().getX(),node.getState().getY()+1)));
			x=x+1;
			problem.calculCost(child.get(x));
		}
		return child;
	}
	public Node getParent() {
		return parent;
	}
	public Carree getState() {
		return state;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getPathCost() {
		return pathCost;
	}
	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}

}

