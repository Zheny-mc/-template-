/*Класс состояния объекта фигуры
 * 
 * */

public class StateFigure {
	String typeFigure;
	private Point point;
	private double width;
	private double height;
	
	public StateFigure() {
		super();
	}

	public StateFigure(String typeFigure, Point point, double width, double height) {
		super();
		this.typeFigure = typeFigure;
		this.point = point;
		this.width = width;
		this.height = height;
	}
	
	public String getTypeFigure() {
		return typeFigure;
	}

	public void setTypeFigure(String typeFigure) {
		this.typeFigure = typeFigure;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
