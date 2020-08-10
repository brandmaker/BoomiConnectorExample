package com.brandmaker.boomi;

public class OperationsConstants {

	
	/**
	 * Enumeration for the connector operations. It consists of a unique ID and a user friendly description which can be put into the connector
	 * configuration form.
	 * 
	 * @author axel.amthor
	 *
	 */
	public static enum ConnectorOperations {
		
		/*
		 * Marketing Planner Operations
		 */
		TREES(		"Marketing Planner: Get Years"),
		YEAR(		"Marketing Planner: Get current fiscal year"),
		NODES(		"Marketing Planner: Get Nodes"),
		BUDGET(		"Marketing Planner: Get Budgets"), // currently not implemented
		
		/*
		 * Job Manager Operations
		 */
		CREATEJOB( 	"Job Manager: Create new Job")
		
		;
		
		private final String operation;
		ConnectorOperations (String operation)
		{
			this.operation = operation;
		}
		
		public String getOperation()
		{
			return this.operation;
		}
	};
	
}
