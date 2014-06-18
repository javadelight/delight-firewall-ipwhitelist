package de.mxro.firewall.ipwhitelist;

import java.util.ArrayList;

import de.mxro.abstracthttpserver.Response;
import de.mxro.firewall.Rule;
import de.mxro.firewall.ipwhitelist.internal.IPWhitelistRuleImpl;

public class IPWhitelistRule {

	public static Rule createIPWhitelistRule(Response deniedResponse, ArrayList<String> validTokens, IPWhitelist whitelistService) {
		return new IPWhitelistRuleImpl(whitelistService, validTokens,deniedResponse);	
	}
	
}
