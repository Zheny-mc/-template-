package springhw.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("configPanel.properties")
public class DataGraphicsPanel {
	
	//-------------------------------
	//for change colors Circle
	@Autowired
	private ListColors colors;
	@Autowired
	private Circle circle;
	@Autowired
	private ComplexMovingCircle complexMovingCircle;
	
	private Map<Integer, InfoComplexMoving> buttons;

	@Value("#{'${moving.keys}'.split(',')}")
	private Integer[] keys;
	@Value("${moving.info}")
	private String[] info_keys;

	@Autowired
	private ListComplexMoving listComplexMoving;
	
	private boolean isClearPanel;
	//-----------------------------------------
	public DataGraphicsPanel() {}
	//--------------get - set------------------
	public boolean getClearPanel() {
		return isClearPanel;
	}

	public void setClearPanel(boolean isClearPanel) {
		this.isClearPanel = isClearPanel;
	}

	public ListColors getColors() {
		return colors;
	}

	public Circle getCircle() {
		return circle;
	}

	public ComplexMovingCircle getComplexMovingCircle() {
		return complexMovingCircle;
	}

	public Map<Integer, InfoComplexMoving> getButtons() {
		return buttons;
	}

	//------------------method actor---------------------
	public void createButtons() {
		List<ComplexMoving> complexMoving = listComplexMoving.getListComplexMoving();
		
		buttons = new HashMap<Integer, InfoComplexMoving>();
		for (int i = 0; i < complexMoving.size(); ++i) {
			buttons.put(
					keys[i], 
					new InfoComplexMoving(info_keys[i], complexMoving.get(i) ));
		}
		
	}
}
