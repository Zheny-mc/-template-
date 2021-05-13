package springhw.Model;

import org.springframework.stereotype.Component;

@Component
public class InfoComplexMoving {
	
	private String info;
	ComplexMoving complexMoving;
	private Boolean isMake;
	
	public InfoComplexMoving() {
		isMake = false;
	}
	
	public InfoComplexMoving(String info, ComplexMoving complexMoving) {
		this.info = info;
		this.complexMoving = complexMoving;
		isMake = false;
	}

	public ComplexMoving getComplexMoving() {
		return complexMoving;
	}

	public void setComplexMoving(ComplexMoving complexMoving) {
		this.complexMoving = complexMoving;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Boolean getIsMake() {
		return isMake;
	}

	public void setIsMake(Boolean isMake) {
		this.isMake = isMake;
	}
}
