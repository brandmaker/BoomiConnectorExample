package brandmakerjm;

import com.boomi.connector.api.GetRequest;
import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.util.BaseGetOperation;

public class BrandMakerJMGetOperation extends BaseGetOperation {

    protected BrandMakerJMGetOperation(BrandMakerJMConnection conn) {
        super(conn);
    }

	@Override
	protected void executeGet(GetRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
    public BrandMakerJMConnection getConnection() {
        return (BrandMakerJMConnection) super.getConnection();
    }
}