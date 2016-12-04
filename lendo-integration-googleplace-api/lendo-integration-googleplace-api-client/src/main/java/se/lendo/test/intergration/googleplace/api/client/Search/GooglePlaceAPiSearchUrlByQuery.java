package se.lendo.test.intergration.googleplace.api.client.Search;

import se.lendo.test.common.googlePlaceApi.domain.Place;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha@so4it.com>}
 */
public class GooglePlaceAPiSearchUrlByQuery extends GooglePlaceAPiSearchUrl {

    private String searchQuery;

    private String TEXT_SEARCH = "textsearch";

    public GooglePlaceAPiSearchUrlByQuery(GooglePlaceAPiSearchUrlByQueryBuilder builder) {
        super(builder);

        this.searchQuery=builder.searchQuery;
    }

    @Override
    public String getBaseUrl() {
        return super.getBaseUrl();
    }


    public static class GooglePlaceAPiSearchUrlByQueryBuilder extends GooglePlaceAPiSearchUrlAbstractBuilder<GooglePlaceAPiSearchUrlByQueryBuilder, GooglePlaceAPiSearchUrlByQuery> {

        private String searchQuery;

        private GooglePlaceAPiSearchUrlByQueryBuilder withSearchQuery(String searchQuery) {
            this.searchQuery = searchQuery;
            return self();
        }

        @Override
        public GooglePlaceAPiSearchUrlByQuery Build() {
            return null;
        }

        @Override
        public GooglePlaceAPiSearchUrlByQueryBuilder self() {
            return this;
        }
    }
}
