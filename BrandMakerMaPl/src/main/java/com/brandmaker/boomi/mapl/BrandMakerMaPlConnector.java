package com.brandmaker.boomi.mapl;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.util.BaseConnector;

public class BrandMakerMaPlConnector extends BaseConnector {

    @Override
    public Browser createBrowser(BrowseContext context) {
        return new BrandMakerMaPlBrowser(createConnection(context));
    }    

    @Override
    protected Operation createGetOperation(OperationContext context) {
        return new BrandMakerMaPlGetOperation(createConnection(context));
    }

    @Override
    protected Operation createQueryOperation(OperationContext context) {
        return new BrandMakerMaPlQueryOperation(createConnection(context));
    }
   
    private BrandMakerMaPlConnection createConnection(BrowseContext context) {
        return new BrandMakerMaPlConnection(context);
    }
}