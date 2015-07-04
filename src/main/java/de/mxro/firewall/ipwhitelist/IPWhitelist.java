package de.mxro.firewall.ipwhitelist;

import delight.async.callbacks.ValueCallback;

public interface IPWhitelist {

	public void ipInWhitelist(byte[] ip, ValueCallback<Boolean> callback);
	
}
