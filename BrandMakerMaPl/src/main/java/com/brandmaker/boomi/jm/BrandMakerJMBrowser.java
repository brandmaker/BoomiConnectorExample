package com.brandmaker.boomi.jm;

import java.util.Collection;

import com.boomi.connector.api.ObjectDefinitionRole;
import com.boomi.connector.api.ObjectDefinitions;
import com.boomi.connector.api.ObjectTypes;
import com.boomi.connector.util.BaseBrowser;

public class BrandMakerJMBrowser extends BaseBrowser {

    @SuppressWarnings("unchecked")
	protected BrandMakerJMBrowser(BrandMakerJMConnection conn) {
        super(conn);
    }

	@Override
	public ObjectDefinitions getObjectDefinitions(String objectTypeId,
			Collection<ObjectDefinitionRole> roles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectTypes getObjectTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public BrandMakerJMConnection getConnection() {
        return (BrandMakerJMConnection) super.getConnection();
    }
}