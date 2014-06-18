package de.mxro.firewall.ipwhitelist.internal;

import de.mxro.abstracthttpfirewall.CheckCallback;
import de.mxro.abstracthttpfirewall.Rule;
import de.mxro.abstracthttpserver.Request;
import de.mxro.abstracthttpserver.Response;
import de.mxro.firewall.ipwhitelist.IPWhitelist;

public class IPWhitelistRuleImpl implements Rule {

	private final IPWhitelist whitelist;
	private final Response deniedResponse;
	
	@Override
	public void apply(Request request, Response response, CheckCallback callback) {
		
	}

	public IPWhitelistRuleImpl(IPWhitelist whitelist, Response deniedResponse) {
		super();
		this.whitelist = whitelist;
		this.deniedResponse = deniedResponse;
	}

	
	
}
