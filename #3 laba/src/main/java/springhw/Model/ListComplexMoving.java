package springhw.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListComplexMoving {
	@Autowired
	private List<ComplexMoving> listComplexMoving = new ArrayList<ComplexMoving>();

	public List<ComplexMoving> getListComplexMoving() {
		return listComplexMoving;
	}

	@Override
	public String toString() {
		return "ListComplexMoving [listComplexMoving=" + listComplexMoving + "]";
	}
	
	
}
