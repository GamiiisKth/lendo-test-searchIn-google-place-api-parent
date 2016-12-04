package se.lendo.test.search.backend.component.clinet.test;

import org.junit.Before;
import org.junit.Test;
import se.lendo.test.common.googlePlaceApi.domain.Place;
import se.lendo.test.common.googlePlaceApi.param.SearchType;
import se.lendo.test.common.googlePlaceApi.param.TypeParam;
import se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClient;
import se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClientImpl;
import se.lendo.test.search.backend.component.clinet.SearchPlaceClient;
import se.lendo.test.search.backend.component.clinet.SearchPlaceClientImp;

import java.util.List;

import static org.junit.Assert.fail;
import static se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClient.MAXIMUM_PAGE_RESULTS;
import static se.lendo.test.intergration.googleplace.api.client.GooglePlaceApiSearchClient.MAXIMUM_RADIUS_SEARCH;


public class GooglePlacesTest {
    private static final String API_KEY_FILE_NAME = "";
    private static final String TEST_PLACE_NAME = "University of Vermont";
    private static final double TEST_PLACE_LAT = 44.478025, TEST_PLACE_LNG = -73.196475;
    private SearchPlaceClient google;

    @Before
    public void setUp() {
        try {
            google = new SearchPlaceClientImp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPlaceByQuery() {

        if (!findPlace(google.getPlacesByQuery("SATS", MAXIMUM_PAGE_RESULTS, TypeParam.valueOf("types").searchTypeValue(SearchType.TYPE_GYM))
                , "SATS Sveavägen"))
            fail("Test place could not be found at coordinates.");
    }

    @Test
    public void getPlaceByQuerySearchByRadius() {

        if (!findPlace(google.getPlacesByQueryBasedOnRadar("Sergels torg", MAXIMUM_PAGE_RESULTS, 2000, TypeParam.valueOf("types").searchTypeValue(SearchType.BICYCLE_STORE)),
                "EcoRide Stockholm Sergels Torg"))
            fail("Test place could not be found at coordinates.");

    }


    private boolean findPlace(List<Place> places, String name) {
        boolean found = false;
        for (Place place : places) {
            System.out.println(place);
            if (place.getName().equals(name))
                found = true;
        }
        return found;
    }

    private boolean hasAtLeastAPlace(List<Place> places) {
        return (places != null) && places.size() > 0;
    }
}
