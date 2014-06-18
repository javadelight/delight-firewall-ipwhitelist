package de.mxro.firewall.ipwhitelist;

import de.mxro.abstracthttpserver.Response;
import de.mxro.firewall.Rule;
import de.mxro.firewall.ipwhitelist.internal.IPWhitelistRuleImpl;

public class IPWhitelistRule {

	public Rule createIPWhitelistRule(Response deniedResponse, IPWhitelist whitelistService) {
		return new IPWhitelistRuleImpl(whitelistService, deniedResponse);	
	}
	
}
