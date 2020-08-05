package com.brandmaker.boomi.jm;

import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.UpdateRequest;
import com.boomi.connector.util.BaseUpdateOperation;

public class BrandMakerJMUpdateOperation extends BaseUpdateOperation {

	protected BrandMakerJMUpdateOperation(BrandMakerJMConnection conn) {
		super(conn);
	}

	@Override
	protected void executeUpdate(UpdateRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
    public BrandMakerJMConnection getConnection() {
        return (BrandMakerJMConnection) super.getConnection();
    }
}