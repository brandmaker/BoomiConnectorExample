package com.brandmaker.boomi;

import java.util.logging.Logger;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.util.BaseConnector;
import com.brandmaker.boomi.OperationsConstants.ConnectorOperations;
import com.brandmaker.boomi.mapl.MapsBrowser;
import com.brandmaker.boomi.mapl.MapsConnection;
import com.brandmaker.boomi.mapl.MapsGetOperation;
import com.brandmaker.boomi.mapl.MapsQueryOperation;

/**
 * "Master" connector to the BrandMaker suite. Currently, it implements only few MaPl end-points. It can be extended by just adding new Operations to OperationsConstants and extending the switches below accordingly.
 * The according browser, get, query, create and update classes have to be implemented then according to the given MaPl example.
 * 
 * @author axel.amthor
 *
 */
public class BrandMakerConnector extends BaseConnector {

	private static final Logger Logger = java.util.logging.Logger.getLogger(BrandMakerConnector.class.getName());
	
    @Override
    public Browser createBrowser(BrowseContext context) {
    	
    	return new BrandMakerBrowser(createConnection(context));
				
    }    

    @Override
    protected Operation createGetOperation(OperationContext context) {
    	
    	ConnectorOperations objectType = OperationsConstants.ConnectorOperations.valueOf( context.getObjectTypeId() );
		
		switch ( objectType ) {
			case TREES:
			case YEAR:
			case BUDGET:
			case NODE:
				Logger.severe( "Invoking Marketing Planner Sub Connector");
				return new MapsGetOperation(createConnection(context));
				
			default:
				return null;
		}
		
        
    }

    @Override
    protected Operation createQueryOperation(OperationContext context) {
    	
    	ConnectorOperations objectType = OperationsConstants.ConnectorOperations.valueOf( context.getObjectTypeId() );
		
		switch ( objectType ) {
			case TREES:
			case YEAR:
			case BUDGET:
			case NODE:
				Logger.severe( "Invoking Marketing Planner Sub Connector");
				return new MapsQueryOperation(createConnection(context));
				
			default:
				return null;
		}
        
    }
   
    private MapsConnection createConnection(BrowseContext context) {
    	
    	
    	// FIXME: We need a separation here as well as JM and MaPl have different login mechanics ...
    	return new MapsConnection(context);
				
    }
}
