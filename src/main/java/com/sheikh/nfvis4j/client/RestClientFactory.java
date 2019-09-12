package com.sheikh.nfvis4j.client;

import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;

/**
 * @author Sheikh Qumruzzaman
 * Sep 8, 2019
 */

public class RestClientFactory {

	public static WebTarget getWebTargetClient(final URL url) {

		// if (!"development".equals(System.getenv("ENVIRONMENT"))) {
		// return buildSecureWebTarget(url);
		// } else {
		return buildUnsecureWebTarget(url);
		// }

	}

	private static WebTarget buildSecureWebTarget(final URL url) {
		final Client client = ClientBuilder.newClient(new ClientConfig());
		final WebTarget webTarget = client.target(url.toString());
		return webTarget;
	}

	private static WebTarget buildUnsecureWebTarget(final URL url) {
		try {
			final SSLContext context = SSLContext.getInstance("TLSv1.2");
			final TrustManager[] trustManagerArray = { new NullX509TrustManager() };

			context.init(null, trustManagerArray, null);

			final Client client = ClientBuilder.newBuilder().hostnameVerifier(new NullHostnameVerifier())
					.sslContext(context).build();

			final WebTarget webTarget = client.target(url.toString());
			return webTarget;

		} catch (Exception ex) {

			// Log the error
			return buildSecureWebTarget(url);

		}

	}

	/**
	 * Host name verifier that does not perform nay checks.
	 */
	private static class NullHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	/**
	 * Trust manager that does not perform nay checks.
	 */
	private static class NullX509TrustManager implements X509TrustManager {
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[0];
		}
	}

}
