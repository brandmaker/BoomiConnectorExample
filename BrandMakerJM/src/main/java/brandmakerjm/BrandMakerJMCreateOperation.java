package brandmakerjm;

import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.UpdateRequest;
import com.boomi.connector.util.BaseUpdateOperation;

public class BrandMakerJMCreateOperation extends BaseUpdateOperation {

	protected BrandMakerJMCreateOperation(BrandMakerJMConnection conn) {
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