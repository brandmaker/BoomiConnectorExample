package com.brandmaker.boomi.jm;

import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.QueryRequest;
import com.boomi.connector.util.BaseQueryOperation;

public class JMQueryOperation extends BaseQueryOperation {

	protected JMQueryOperation(JMConnection conn) {
		super(conn);
	}

	@Override
	protected void executeQuery(QueryRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
    public JMConnection getConnection() {
        return (JMConnection) super.getConnection();
    }
}