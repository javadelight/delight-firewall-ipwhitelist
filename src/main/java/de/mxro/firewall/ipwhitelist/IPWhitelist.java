package de.mxro.firewall.ipwhitelist;

import de.mxro.async.callbacks.ValueCallback;

public interface IPWhitelist {

	public void ipInWhitelist(byte[] ip, ValueCallback<Boolean> callback);
	
}
