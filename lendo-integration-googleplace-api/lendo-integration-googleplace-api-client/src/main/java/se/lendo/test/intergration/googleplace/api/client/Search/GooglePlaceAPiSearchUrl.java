package se.lendo.test.intergration.googleplace.api.client.Search;

import se.lendo.test.common.googlePlaceApi.builder.ParentSubClassBuilder;
import se.lendo.test.common.googlePlaceApi.param.Param;

import java.util.Locale;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public abstract class GooglePlaceAPiSearchUrl {

    private String baseUrl = "https://maps.googleapis.com/maps/api/place/";
    private String buildOnBaseUrl = "%s%s/json?%s";
    private Param[] params;


    public String getBaseUrl() {
        return baseUrl;
    }

    public GooglePlaceAPiSearchUrl(GooglePlaceAPiSearchUrlAbstractBuilder<?, ?> builder) {

        this.buildOnBaseUrl = builder.buildOnBaseUrl;
        this.params = builder.params;
        for (Param param : params) {

            baseUrl = String.format(Locale.ENGLISH, buildOnBaseUrl, baseUrl, "&" + param.name + "=", param.value);

        }

    }

    public abstract static class GooglePlaceAPiSearchUrlAbstractBuilder<T extends GooglePlaceAPiSearchUrlAbstractBuilder<T, U>, U> implements ParentSubClassBuilder<T, U> {

        private Param[] params;
        private String buildOnBaseUrl;

        private T withParam(Param... param) {
            this.params = param;
            return self();
        }

        public T withType(String buildOnBaseUrl) {

            this.buildOnBaseUrl = buildOnBaseUrl;

            return self();
        }

    }


}
