package de.mxro.firewall.ipwhitelist.internal;

import delight.async.callbacks.ValueCallback;

import de.mxro.firewall.CheckCallback;
import de.mxro.firewall.Rule;
import de.mxro.firewall.ipwhitelist.IPWhitelist;
import de.mxro.httpserver.Request;
import de.mxro.httpserver.Response;
import de.mxro.server.ComponentContext;

public class IPWhitelistRuleImpl implements Rule {

    private final String whitelistProperty;
    private final ComponentContext ctx;

    private final Response deniedResponse;

    @Override
    public void apply(final Request request, final Response response, final CheckCallback callback) {
        assertWhitelist(new ValueCallback<IPWhitelist>() {

            @Override
            public void onFailure(final Throwable t) {
                callback.onFailure(t);
            }

            @Override
            public void onSuccess(final IPWhitelist whitelist) {
                whitelist.ipInWhitelist(request.getSourceAddress().getAddress(), new ValueCallback<Boolean>() {

                    @Override
                    public void onSuccess(final Boolean value) {
                        if (!value) {
                            response.setAll(deniedResponse);
                            callback.block();
                            return;
                        }

                        callback.allow();
                    }

                    @Override
                    public void onFailure(final Throwable t) {
                        callback.onFailure(t);
                    }
                });
            }
        });

    }

    private final void assertWhitelist(final ValueCallback<IPWhitelist> callback) {
        ctx.state().retrieve(whitelistProperty, IPWhitelist.class, callback);
    }

    public IPWhitelistRuleImpl(final String whitelistProperty, final ComponentContext ctx, final Response deniedResponse) {
        super();

        this.deniedResponse = deniedResponse;
        this.whitelistProperty = whitelistProperty;
        this.ctx = ctx;
    }

}
