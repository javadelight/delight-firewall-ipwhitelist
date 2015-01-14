package de.mxro.firewall.ipwhitelist;

import de.mxro.firewall.Rule;
import de.mxro.firewall.ipwhitelist.internal.IPWhitelistRuleImpl;
import de.mxro.httpserver.Response;
import de.mxro.server.ComponentContext;

public class IPWhitelistRule {

    public static Rule createIPWhitelistRule(final String whitelistProperty, final ComponentContext ctx,
            final Response deniedResponse) {
        return new IPWhitelistRuleImpl(whitelistProperty, ctx, deniedResponse);
    }

}
