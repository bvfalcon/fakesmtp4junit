package name.bychkov.fakesmtp;

import java.net.InetAddress;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nilhcem.fakesmtp.FakeSMTP;

public class FakeSmtpJUnitExcension implements BeforeAllCallback, AfterAllCallback, AfterEachCallback
{
	private static final Logger logger = LoggerFactory.getLogger(FakeSmtpJUnitExcension.class);
	private InetAddress host;
	private int port = 25;
	
	public FakeSmtpJUnitExcension host(InetAddress host)
	{
		this.host = host;
		return this;
	}

	public FakeSmtpJUnitExcension port(int port)
	{
		this.port = port;
		return this;
	}
	
	@Override
	public void afterEach(ExtensionContext context) throws Exception
	{
		FakeSMTP.deleteEmails();
		logger.debug("FakeSMTP server removes emails.");
	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception
	{
		FakeSMTP.down();
		logger.debug("FakeSMTP server shutdown completed.");
	}

	@Override
	public void beforeAll(ExtensionContext context) throws Exception
	{
		InetAddress hostLocal = host != null ? host : InetAddress.getByName("localhost");
		FakeSMTP.up(port, hostLocal);
		logger.debug("FakeSMTP server started with inetAddress={}, port={}.", hostLocal, port);
	}
}