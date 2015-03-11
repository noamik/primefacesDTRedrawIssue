package de.countr.beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import de.countr.datamodel.DisplayData;
import de.countr.datamodel.DisplayDataResult;


@ManagedBean
@ViewScoped
public class TableBean {

	private LazyDataModel<DisplayData> tableData;

	@EJB
	private TableEJB serviceEJB;
	
	@PostConstruct
	public void init() {
	
		try {
			this.tableData = new LazyDataModel<DisplayData>() {
				private static final long serialVersionUID = 1L;

				@Override
				public List<DisplayData> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
					// For simplicity we don't support sorting or ordering
					DisplayDataResult data = serviceEJB.getResult(first, pageSize);
					tableData.setRowCount(data.getMaxResults());
					return data.getData();
				}
			};
		} catch (Exception e) {
		}
	}
	
	public LazyDataModel<DisplayData> getTableData() {
		return tableData;
	}

	public void setTableData(LazyDataModel<DisplayData> tableData) {
		this.tableData = tableData;
	}

	public TableEJB getServiceEJB() {
		return serviceEJB;
	}

	public void setServiceEJB(TableEJB serviceEJB) {
		this.serviceEJB = serviceEJB;
	}
}
