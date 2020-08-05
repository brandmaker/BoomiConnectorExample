package com.brandmaker.boomi;

public class OperationsConstants {

	public static enum ConnectorOperations {
		TREES(	"Marketing Planner: Get Years"),
		YEAR(	"Marketing Planner: Get current fiscal year"),
		NODE(	"Marketing Planner: Get Nodes"),
		BUDGET(	"Marketing Planner: Get Budgets"), 
		
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
