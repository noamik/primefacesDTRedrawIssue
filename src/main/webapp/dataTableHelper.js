var isDataTableAdjustmentRunning = false;

function adjustTableColumns(tableName, wrapperName, debug) {
	debug = (typeof debug === 'undefined') ? false : debug;
	if (debug) {
		console.log("Resize detected!");
	}
	if (isDataTableAdjustmentRunning) {
		return;
	} else {
		isDataTableAdjustmentRunning = true;
		renderTable(tableName, wrapperName, debug);
	}
}

function renderTable(tableId, wrapperName, debug) {
	var table = PF(tableId);
	var tableCssId = "#"+tableId;
	var tableHeadId = tableCssId+" th";

	if (table) {

		var width = document.getElementById(wrapperName).clientWidth;
		var columnCount = columnCountFunction(tableCssId);
		var columnWidth = Math.floor((parseInt(width) - parseInt(table.scrollbarWidth)) / parseInt(columnCount)) - 20;

		if (debug) {
			console.log("Width of wrapper element: ", parseInt(width));
			console.log("Number of columns: ", parseInt(columnCount));
			console.log("New column width: ", parseInt(columnWidth));
		}

		$(tableHeadId).css('width',columnWidth);
		table.refresh(table.cfg);

		if (debug) {
			console.log("Adjusted table and recalculated scroll bars.");
		}
				
	} else {
		console.warn("Couldn't find table");
	}
	isDataTableAdjustmentRunning = false;
}

function columnCountFunction(tableCssId) {
	var colCount = 0;
	$(tableCssId).find('tr:last-child td').each(function() {
		if ($(this).attr('colspan')) {
			colCount += +$(this).attr('colspan');
		} else {
			colCount++;
		}
	});
	return colCount;
}