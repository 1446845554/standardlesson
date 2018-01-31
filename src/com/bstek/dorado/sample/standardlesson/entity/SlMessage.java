package com.bstek.dorado.sample.standardlesson.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * sl_message:
 */
@Entity
@Table(name = "sl_message")
public class SlMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * message_id:
	 */
	private int messageId;

	/**
	 * receiver:
	 */
	private String receiver;

	/**
	 * receiver_mail:
	 */
	private String receiverMail;

	/**
	 * sender_mail:
	 */
	private String senderMail;

	/**
	 * send_date:
	 */
	private Date sendDate;

	/**
	 * content:
	 */
	private String content;

	/**
	 * sl_employee:
	 */
	private SlEmployee slEmployee;

	public SlMessage() {
		super();
	}

	public SlMessage(int messageId, String receiver, String receiverMail,
			String senderMail, Date sendDate, String content,
			SlEmployee slEmployee) {
		super();
		this.messageId = messageId;
		this.receiver = receiver;
		this.receiverMail = receiverMail;
		this.senderMail = senderMail;
		this.sendDate = sendDate;
		this.content = content;
		this.slEmployee = slEmployee;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "message_id", nullable = false)
	public int getMessageId() {
		return messageId;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Column(name = "receiver", length = 45)
	public String getReceiver() {
		return receiver;
	}

	public void setReceiverMail(String receiverMail) {
		this.receiverMail = receiverMail;
	}

	@Column(name = "receiver_mail", length = 45)
	public String getReceiverMail() {
		return receiverMail;
	}

	public void setSenderMail(String senderMail) {
		this.senderMail = senderMail;
	}

	@Column(name = "sender_mail", length = 45)
	public String getSenderMail() {
		return senderMail;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "send_date")
	public Date getSendDate() {
		return sendDate;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "content", length = 200)
	public String getContent() {
		return content;
	}

	public void setSlEmployee(SlEmployee slEmployee) {
		this.slEmployee = slEmployee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender")
	public SlEmployee getSlEmployee() {
		return slEmployee;
	}

	public String toString() {
		return "SlMessage [messageId=" + messageId + ",receiver=" + receiver
				+ ",receiverMail=" + receiverMail + ",senderMail=" + senderMail
				+ ",sendDate=" + sendDate + ",content=" + content
				+ ",slEmployee=" + slEmployee + "]";
	}

}
