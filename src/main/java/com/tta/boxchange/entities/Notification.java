package com.tta.boxchange.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Notification {
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "channel")
    private String channel;

    @Column(name = "sender")
    private String sender;
    
    @Column(name = "titre")
    private String titre;
    @Column(name = "content")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Date timestamp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "read_date")
    private Date readDate;

    private int count;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void increment() {
        this.count++;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Date getReadDate() {
		return readDate;
	}
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	@Override
	public String toString() {
		return "Notification [id=" + id + ", channel=" + channel + ", sender=" + sender + ", titre=" + titre
				+ ", content=" + content + ", timestamp=" + timestamp + ", readDate=" + readDate + ", count=" + count
				+ "]";
	}
    
    
}
