package de.mxro.firewall.ipwhitelist.internal;

import io.nextweb.fn.callbacks.ValueCallback;
import de.mxro.firewall.CheckCallback;
import de.mxro.firewall.Rule;
import de.mxro.firewall.ipwhitelist.IPWhitelist;
import de.mxro.httpserver.Request;
import de.mxro.httpserver.Response;

public class IPWhitelistRuleImpl implements Rule {

	private final IPWhitelist whitelist;
	private final Response deniedResponse;
	
	@Override
	public void apply(final Request request, final Response response, final CheckCallback callback) {
		
		whitelist.ipInWhitelist(request.getSourceAddress().getAddress(), new ValueCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean value) {
				if (!value) {
					response.setAll(deniedResponse);
					callback.block();
					return;
				}
				
				callback.allow();
			}
			
			@Override
			public void onFailure(Throwable t) {
				callback.onFailure(t);
			}
		});
		
	}

	public IPWhitelistRuleImpl(IPWhitelist whitelist, Response deniedResponse) {
		super();
		this.whitelist = whitelist;
		this.deniedResponse = deniedResponse;
	}

	
	
}
