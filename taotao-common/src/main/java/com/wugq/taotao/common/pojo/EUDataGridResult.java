package com.wugq.taotao.common.pojo;

import java.util.List;

/**
 * easyui的DataGrid需要的返回结果
 */
public class EUDataGridResult {

	private long total;

	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
