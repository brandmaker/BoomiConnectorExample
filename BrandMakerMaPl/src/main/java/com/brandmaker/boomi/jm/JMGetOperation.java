package com.brandmaker.boomi.jm;

import com.boomi.connector.api.GetRequest;
import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.util.BaseGetOperation;

public class JMGetOperation extends BaseGetOperation {

    protected JMGetOperation(JMConnection conn) {
        super(conn);
    }

	@Override
	protected void executeGet(GetRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
    public JMConnection getConnection() {
        return (JMConnection) super.getConnection();
    }
}