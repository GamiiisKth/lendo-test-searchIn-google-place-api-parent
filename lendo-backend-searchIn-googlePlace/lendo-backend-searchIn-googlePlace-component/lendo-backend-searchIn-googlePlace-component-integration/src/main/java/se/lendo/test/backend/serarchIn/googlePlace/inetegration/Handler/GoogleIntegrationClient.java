package se.lendo.test.backend.serarchIn.googlePlace.inetegration.Handler;

import org.apache.http.client.methods.HttpPost;

import java.io.InputStream;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 *
 *  request forwarder to google clinet
 */


public interface GoogleIntegrationClient {


    InputStream getInputStream(String uri);

    String getUriData(String uri);

    String HttpPostData(HttpPost httpPost);



}
