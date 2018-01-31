package com.andy.util;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;

public class IPAddressUtil {
	public static String getIp()
			throws MalformedObjectNameException, NullPointerException, UnknownHostException {
		MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
		Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
				Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
		String host = InetAddress.getLocalHost().getHostAddress();
		String port = objectNames.iterator().next().getKeyProperty("port");
		String ipadd = "http" + "://" + host + ":" + port;
		System.out.println(ipadd);
		return host;
	}

	public static int getTomcatPort() throws MalformedObjectNameException, NullPointerException {
		MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
		Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
				Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
		String port = objectNames.iterator().next().getKeyProperty("port");
		return Integer.valueOf(port);
	}
}
