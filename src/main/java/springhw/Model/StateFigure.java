package springhw.Model;
/*Класс состояния объекта фигуры
 * 
 * */

public class StateFigure {
	
	private Point point;
	private double width;
	private double height;
	
	public StateFigure() {}

	public StateFigure(Point point, double width, double height) {
		super();
		this.point = point;
		this.width = width;
		this.height = height;
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
	
	@Override
	public String toString() {
		return "StateFigure [point=" + point + ", width=" + width + "]";
	}
}
