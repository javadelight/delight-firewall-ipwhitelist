package de.mxro.firewall.ipwhitelist;

import io.nextweb.fn.callbacks.ValueCallback;

public interface IPWhitelist {

	public void checkIP(byte[] ip, ValueCallback<Boolean> callback);
	
}
