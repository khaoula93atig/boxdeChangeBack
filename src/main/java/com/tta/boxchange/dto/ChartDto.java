package com.tta.boxchange.dto;

import java.util.*;

public class ChartDto {

	public List<String> labels = new ArrayList<>();
	public List<DataSet> datasets = new ArrayList<>();
	
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	public List<DataSet> getDatasets() {
		return datasets;
	}
	public void setDatasets(List<DataSet> datasets) {
		this.datasets = datasets;
	}
	
}
