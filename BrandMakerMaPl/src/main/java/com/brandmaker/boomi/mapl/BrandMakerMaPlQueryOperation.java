package com.brandmaker.boomi.mapl;

import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.QueryRequest;
import com.boomi.connector.util.BaseQueryOperation;

public class BrandMakerMaPlQueryOperation extends BaseQueryOperation {

	protected BrandMakerMaPlQueryOperation(BrandMakerMaPlConnection conn) {
		super(conn);
	}

	@Override
	protected void executeQuery(QueryRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
    public BrandMakerMaPlConnection getConnection() {
        return (BrandMakerMaPlConnection) super.getConnection();
    }
}