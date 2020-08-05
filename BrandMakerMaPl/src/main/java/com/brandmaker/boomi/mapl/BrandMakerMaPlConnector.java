package com.brandmaker.boomi.mapl;

import java.util.logging.Logger;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.util.BaseConnector;

public class BrandMakerMaPlConnector extends BaseConnector {

	private static final Logger Logger = java.util.logging.Logger.getLogger(BrandMakerMaPlConnector.class.getName());
	
    @Override
    public Browser createBrowser(BrowseContext context) {
    	Logger.severe( ((OperationContext)context).getObjectTypeId());
        return new BrandMakerMaPlBrowser(createConnection(context));
    }    

    @Override
    protected Operation createGetOperation(OperationContext context) {
    	Logger.severe( context.getObjectTypeId());
        return new BrandMakerMaPlGetOperation(createConnection(context));
    }

    @Override
    protected Operation createQueryOperation(OperationContext context) {
    	Logger.severe( context.getObjectTypeId());
        return new BrandMakerMaPlQueryOperation(createConnection(context));
    }
   
    private BrandMakerMaPlConnection createConnection(BrowseContext context) {
        return new BrandMakerMaPlConnection(context);
    }
}