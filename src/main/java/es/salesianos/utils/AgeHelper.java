package es.salesianos.utils;

import java.util.ArrayList;
import java.util.List;

public class AgeHelper {
	private final String i1 = "TP";
	private final String i2 = "+7";
	private final String i3 = "+13";
	private final String i4 = "+18";
	List<String> list;
	
	public AgeHelper() {
		list = new ArrayList<String>();
	}
	public List<String> getList() {
		return list;
	}
	
	public List<String> listAges(String edadRecomendada) {
		if("TP".equals(edadRecomendada)) {
			list.add(i1);
			list.add(i2);
			list.add(i3);
			list.add(i4);
		}else if("+7".equals(edadRecomendada)) {
			list.add(i2);
			list.add(i3);
			list.add(i4);
		}else if("+13".equals(edadRecomendada)) {
			list.add(i3);
			list.add(i4);
		}else if("+18".equals(edadRecomendada)){
			list.add(i4);
		}
		return list;
	}

	/*public List<String> listAges(String edadRecomendada) {
		if(edadRecomendada.equals(i1)) {
			createFor(0);
		}else if(edadRecomendada.equals(i2)) {
			createFor(1);
		}else if(edadRecomendada.equals(i3)) {
			createFor(2);
		}else {
			createFor(3);
		}
		return list;
	}
	
	public void createFor(int x) {
		for (int i = 0; i < x; i++) {
			list.remove(i);
		}
	}*/

}
