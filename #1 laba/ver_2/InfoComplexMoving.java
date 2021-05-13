package ver_2;

public class InfoComplexMoving {
	
	String info;
	ComplexMoving complexMoving;
	Boolean isMake;
	
	public InfoComplexMoving() {
		isMake = false;
		complexMoving = null;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public ComplexMoving getComplexMoving() {
		return complexMoving;
	}

	public void setComplexMoving(ComplexMoving complexMoving) {
		this.complexMoving = complexMoving;
	}

	public Boolean getIsMake() {
		return isMake;
	}

	public void setIsMake(Boolean isMake) {
		this.isMake = isMake;
	}
	
	
}
