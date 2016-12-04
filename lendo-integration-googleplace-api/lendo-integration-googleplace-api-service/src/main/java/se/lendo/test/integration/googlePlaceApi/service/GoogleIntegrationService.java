package se.lendo.test.integration.googlePlaceApi.service;

import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 *
 *  request forwarder to google clinet
 */


public interface GoogleIntegrationService {


    InputStream getInputStream(String uri) throws IOException;

    String getUriData(String uri) throws IOException;

    String HttpPostData(HttpPost httpPost) throws IOException;

}
