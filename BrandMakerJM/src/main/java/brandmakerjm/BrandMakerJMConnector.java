package brandmakerjm;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.util.BaseConnector;

public class BrandMakerJMConnector extends BaseConnector {

    @Override
    public Browser createBrowser(BrowseContext context) {
        return new BrandMakerJMBrowser(createConnection(context));
    }    

    @Override
    protected Operation createGetOperation(OperationContext context) {
        return new BrandMakerJMGetOperation(createConnection(context));
    }

    @Override
    protected Operation createQueryOperation(OperationContext context) {
        return new BrandMakerJMQueryOperation(createConnection(context));
    }

    @Override
    protected Operation createCreateOperation(OperationContext context) {
        return new BrandMakerJMCreateOperation(createConnection(context));
    }

    @Override
    protected Operation createUpdateOperation(OperationContext context) {
        return new BrandMakerJMUpdateOperation(createConnection(context));
    }
   
    private BrandMakerJMConnection createConnection(BrowseContext context) {
        return new BrandMakerJMConnection(context);
    }
}