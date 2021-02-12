package com.nilhcem.fakesmtp;

import java.net.InetAddress;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.server.SMTPServer;

import com.nilhcem.fakesmtp.core.exception.BindPortException;
import com.nilhcem.fakesmtp.core.exception.OutOfRangePortException;
import com.nilhcem.fakesmtp.server.SMTPServerHandler;

/**
 * Entry point of the application.
 *
 * @author Nilhcem
 * @since 1.0
 */
public final class FakeSMTP {
	private static final Logger LOGGER = LoggerFactory.getLogger(FakeSMTP.class);

	private FakeSMTP() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Useful for usage in JUnit-tests
	 * */
	public static void up(int port, InetAddress bindAddress) throws BindPortException, OutOfRangePortException {
		if (!SMTPServerHandler.INSTANCE.getSmtpServer().isRunning()) {
			SMTPServerHandler.INSTANCE.startServer(port, bindAddress);
		}
	}
	
	/**
	 * Useful for usage in JUnit-tests
	 * */
	public static void down() {
		SMTPServer smtpServer = SMTPServerHandler.INSTANCE.getSmtpServer();
		if (smtpServer.isRunning()) {
			smtpServer.stop();
		}
	}
	
	/**
	 * Useful for usage in JUnit-tests
	 * */
	public static Collection<String> getEmails() {
		return SMTPServerHandler.INSTANCE.getMailSaver().getEmails();
	}
	
	/**
	 * Useful for usage in JUnit-tests
	 * */
	public static void deleteEmails() {
		SMTPServerHandler.INSTANCE.getMailSaver().deleteEmails();
	}
}