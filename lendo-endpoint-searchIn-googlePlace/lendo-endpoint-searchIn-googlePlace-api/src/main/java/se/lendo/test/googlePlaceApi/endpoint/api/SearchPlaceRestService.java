package se.lendo.test.googlePlaceApi.endpoint.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import se.lendo.test.common.googlePlaceApi.domain.Place;
import se.lendo.test.common.googlePlaceApi.param.SearchType;
import se.lendo.test.common.googlePlaceApi.param.TypeParam;
import se.lendo.test.search.backend.component.clinet.SearchPlaceClient;

import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
@RestController("SearchPlaceRestService")
@Api(value = "SearchPlaceRestService-docs")
@RequestMapping("/search")
public class SearchPlaceRestService {

    private SearchPlaceClient searchPlaceClient;

    public SearchPlaceRestService(SearchPlaceClient searchPlaceClient) {
        this.searchPlaceClient = searchPlaceClient;
    }

    /**
     * the path which will map the request ("/")
     *
     * @return
     */

    @RequestMapping(value = "/{brand}", method = RequestMethod.GET)
    @ResponseBody
    public List<Place> getGyms(@RequestParam(value = "gymBrand") @PathVariable String gymBrand) {

        return searchPlaceClient.getPlacesByQuery(gymBrand, 60, TypeParam.valueOf("types").searchTypeValue(SearchType.TYPE_GYM));
    }

    @RequestMapping(value = "/{place}/{type}", method = RequestMethod.GET)
    @ResponseBody
    public List<Place> getPlacesByType(@RequestParam(value = "place") @PathVariable String place,
                                       @RequestParam(value = "type") @PathVariable String type) {

        return searchPlaceClient.getPlacesByQuery(place, 60, TypeParam.valueOf("types").searchTypeValue(type));
    }

    @RequestMapping(value = "{place}/{type}/{radius}", method = RequestMethod.GET)
    @ResponseBody
    public List<Place> getPlacesByTypeAndRadius(@PathVariable String place,
                                                @PathVariable String type,
                                                @PathVariable int radius) {

        return searchPlaceClient.getPlacesByQueryBasedOnRadar(place, 60, radius, TypeParam.valueOf("types").searchTypeValue(type));
    }

    @RequestMapping(value = "/{place}/{radius}", method = RequestMethod.GET)
    @ResponseBody
    public List<Place> getBicycleStoreByRadius(@RequestParam(value = "place") @PathVariable String place,
                                               @RequestParam(value = "radius") @PathVariable int radius) {

        return searchPlaceClient.getPlacesByQueryBasedOnRadar(place, 60, radius, TypeParam.valueOf("types").searchTypeValue(SearchType.BICYCLE_STORE));


    }

}
