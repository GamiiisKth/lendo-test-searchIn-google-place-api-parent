package se.lendo.test.common.googlePlaceApi.status;

import java.util.Locale;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class Test {

    public static String API_URL_FORMAT_STRING = "%s%s/json?%s";

    static String GOOGLE_API_URL = "https://maps.googleapis.com/maps/api/place/";

    public static void main(String[] args) {

        String uri1= String.format("query=%s+in+=%s&radius=%s&key=%s","gym","farsta",String.valueOf(500),"1111asbasdasdasdasda");

         uri1=String.format(API_URL_FORMAT_STRING, GOOGLE_API_URL,"textSearch", uri1);
        System.out.println(uri1);

    }
}
