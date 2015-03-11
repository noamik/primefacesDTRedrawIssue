package de.countr.service;

import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import de.countr.datamodel.DisplayData;
import de.countr.datamodel.DisplayDataResult;

@ManagedBean
@ApplicationScoped
public class TableService {
	
	private DisplayData[] data = null;

	public DisplayDataResult getResult(int first, int pageSize) {
		if (data == null) {
			generateData();
		}
		List<DisplayData> list = new LinkedList<DisplayData>();
		for (int i = first; i < first + pageSize; i++) {
			list.add(data[i]);
		}
		return new DisplayDataResult(list, data.length);
	}

	private void generateData() {
		data = new DisplayData[1000];
		for (int i = 0; i < 1000; i++) {
			data[i] = new DisplayData();
			data[i].setData1("data1-" + i);
			data[i].setData2("data2-" + i);
			data[i].setData3("data3-" + i);
			data[i].setData4("data4-" + i);
			data[i].setData5("data5-" + i);
			data[i].setData6("data6-" + i);
			data[i].setData7("data7-" + i);
		}
	}

}
