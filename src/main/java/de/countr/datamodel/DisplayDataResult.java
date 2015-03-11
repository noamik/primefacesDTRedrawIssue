package de.countr.datamodel;

import java.util.List;

public class DisplayDataResult {
	
	private List<DisplayData> data;
	private int maxResults = 0;
	
	public DisplayDataResult(List<DisplayData> list, int maxResults) {
		this.data       = list;
		this.maxResults = maxResults;
	}

	public List<DisplayData> getData() {
		return data;
	}

	public void setData(List<DisplayData> data) {
		this.data = data;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

}
