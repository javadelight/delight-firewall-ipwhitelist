package de.mxro.firewall.ipwhitelist;

import de.mxro.firewall.Rule;
import de.mxro.firewall.ipwhitelist.internal.IPWhitelistRuleImpl;
import de.mxro.httpserver.Response;

public class IPWhitelistRule {

	public static Rule createIPWhitelistRule(Response deniedResponse, IPWhitelist whitelistService) {
		return new IPWhitelistRuleImpl(whitelistService, deniedResponse);	
	}
	
}
