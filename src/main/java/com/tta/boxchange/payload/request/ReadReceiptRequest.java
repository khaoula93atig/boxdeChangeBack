package com.tta.boxchange.payload.request;

public class ReadReceiptRequest {
	private String channel;
    private String username;
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "ReadReceiptRequest [channel=" + channel + ", username=" + username + "]";
	}
    
    

}
