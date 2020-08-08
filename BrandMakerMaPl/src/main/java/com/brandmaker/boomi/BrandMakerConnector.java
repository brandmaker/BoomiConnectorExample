package com.brandmaker.boomi;

import java.util.logging.Logger;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.util.BaseConnector;
import com.brandmaker.boomi.OperationsConstants.ConnectorOperations;
import com.brandmaker.boomi.jm.JMConnection;
import com.brandmaker.boomi.jm.JMCreateOperation;
import com.brandmaker.boomi.mapl.MapsConnection;
import com.brandmaker.boomi.mapl.MapsGetOperation;
import com.brandmaker.boomi.mapl.MapsQueryOperation;

/**
 * "Master" connector to the BrandMaker suite. Currently, it implements few Marketing Planner and Job Manager end-points. It can be extended by just adding new Operations to 
 * OperationsConstants and extending the switches below accordingly. The according browser, get, query, create and update classes have to be implemented then according to the given MaPl example.
 * 
 * @see OperationsConstants#OperationsConstants()
 * 
 * @author axel.amthor
 *
 */
public class BrandMakerConnector extends BaseConnector {

	private static final Logger Logger = java.util.logging.Logger.getLogger(BrandMakerConnector.class.getName());
	
    @Override
    public Browser createBrowser(BrowseContext context) {
    	
    	return new BrandMakerBrowser(createMapsConnection(context));
				
    }    
    
    
    @Override
    protected Operation createCreateOperation(OperationContext context) {
    	
    	ConnectorOperations objectType = OperationsConstants.ConnectorOperations.valueOf( context.getObjectTypeId() );
		
		switch ( objectType ) {
			case CREATEJOB:
				Logger.severe( "Invoking Job Manager Sub Connector");
				return new JMCreateOperation(createJMConnection(context));
				
			default:
				return null;
		}
        
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
				return new MapsGetOperation(createMapsConnection(context));
				
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
				return new MapsQueryOperation(createMapsConnection(context));
				
			default:
				return null;
		}
        
    }
   
    private MapsConnection createMapsConnection(BrowseContext context) {
    	
    	return new MapsConnection(context);
				
    }
    
    private JMConnection createJMConnection(BrowseContext context) {
    	
    	return new JMConnection(context);
				
    }
 
}
