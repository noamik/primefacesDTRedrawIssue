package de.countr.beans;

import javax.ejb.Stateless;
import javax.inject.Inject;

import de.countr.datamodel.DisplayDataResult;
import de.countr.service.TableService;

@Stateless
public class TableEJB {

	@Inject
	private TableService service;
	
	public DisplayDataResult getResult(int first, int pageSize) {
		return service.getResult(first, pageSize);
	}
}
