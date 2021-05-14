package springhw.Model;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListColors {
	
	private int index;
	private List<Color> colors;
	
	public ListColors() {
		colors = Arrays.asList(Color.red, Color.green, Color.blue);
		index = 0;
	}

	public Color getNextColor() {
		if (index >= colors.size())
			index = 0;
		return colors.get(index++);
	}
}
