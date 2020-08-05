package brandmakerjm;

import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.QueryRequest;
import com.boomi.connector.util.BaseQueryOperation;

public class BrandMakerJMQueryOperation extends BaseQueryOperation {

	protected BrandMakerJMQueryOperation(BrandMakerJMConnection conn) {
		super(conn);
	}

	@Override
	protected void executeQuery(QueryRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
    public BrandMakerJMConnection getConnection() {
        return (BrandMakerJMConnection) super.getConnection();
    }
}