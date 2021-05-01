package springhw;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestApp {

	private Properties properties;
    private List list;
    private Set set;
    private Map map;
    
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    public void setList(List list) {
        this.list = list;
    }
    public void setSet(Set set) {
        this.set = set;
    }
    public void setMap(Map map) {
        this.map = map;
    }
    
    @Override
	public String toString() {
		return "TestApp [properties=" + properties + ", list=" + list + ", set=" + set + ", map=" + map + "]";
	}
}