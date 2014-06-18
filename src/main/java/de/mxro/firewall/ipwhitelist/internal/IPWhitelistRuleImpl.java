package de.mxro.firewall.ipwhitelist.internal;

import io.nextweb.fn.callbacks.ValueCallback;
import de.mxro.abstracthttpfirewall.CheckCallback;
import de.mxro.abstracthttpfirewall.Rule;
import de.mxro.abstracthttpserver.Request;
import de.mxro.abstracthttpserver.Response;
import de.mxro.firewall.ipwhitelist.IPWhitelist;

public class IPWhitelistRuleImpl implements Rule {

	private final IPWhitelist whitelist;
	private final Response deniedResponse;
	
	@Override
	public void apply(final Request request, final Response response, final CheckCallback callback) {
		
		whitelist.checkIP(request.getSourceAddress().getAddress(), new ValueCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean value) {
				if (!value) {
					response.setAll(deniedResponse);
					callback.block();
					return;
				}
				
				callback.proceed();
				
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
