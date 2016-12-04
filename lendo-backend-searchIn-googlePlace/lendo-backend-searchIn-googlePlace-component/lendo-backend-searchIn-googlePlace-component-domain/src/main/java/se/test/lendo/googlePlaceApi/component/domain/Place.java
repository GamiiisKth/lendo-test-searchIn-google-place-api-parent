package se.test.lendo.googlePlaceApi.component.domain;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ali yusha {@literal <mailto:ali.yusha.hasan@gmail.com>}
 */
public class Place {

    private List<String> types = new ArrayList<>();


    private String placeId;
    private double lat = -1, lng = -1;
    private JSONObject json;
    private String iconUrl;
    private InputStream icon;
    private String name;
    private String addr;
    private String vicinity;
    private double rating = -1;
    private String phone, internationalPhone;
    private String googleUrl, website;
    private int utcOffset;
    private int accuracy;
    private String lang;


    public String getPlaceId() {
        return placeId;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public JSONObject getJson() {
        return json;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public InputStream getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String getVicinity() {
        return vicinity;
    }

    public double getRating() {
        return rating;
    }

    public String getPhone() {
        return phone;
    }

    public String getInternationalPhone() {
        return internationalPhone;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public String getWebsite() {
        return website;
    }

    public int getUtcOffset() {
        return utcOffset;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getLang() {
        return lang;
    }

    //we should add required.notNull
    private Place(Builder builder) {
        this.types = builder.types;
        this.placeId = builder.placeId;
        this.lat = builder.lat;
        this.lng = builder.lng;
        this.json = builder.json;
        this.iconUrl = builder.iconUrl;
        this.icon = builder.icon;
        this.name = builder.name;
        this.addr = builder.addr;
        this.vicinity = builder.vicinity;
        this.rating = builder.rating;
        this.phone = builder.phone;
        this.internationalPhone = builder.internationalPhone;
        this.googleUrl = builder.googleUrl;
        this.website = builder.website;
        this.utcOffset = builder.utcOffset;
        this.accuracy = builder.accuracy;
        this.lang = builder.lang;
    }


    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private List<String> types;
        private String placeId;
        private double lat;
        private double lng;
        private JSONObject json;
        private String iconUrl;
        private InputStream icon;
        private String name;
        private String addr;
        private String vicinity;
        private double rating;
        private String phone;
        private String internationalPhone;
        private String googleUrl;
        private String website;
        private int utcOffset;
        private int accuracy;
        private String lang;

        public Builder types(List<String> types) {
            this.types = types;
            return this;
        }

        public Builder withPlaceId(String placeId) {
            this.placeId = placeId;
            return this;
        }

        public Builder withLat(double lat) {
            this.lat = lat;
            return this;
        }

        public Builder withLng(double lng) {
            this.lng = lng;
            return this;
        }

        public Builder withJson(JSONObject json) {
            this.json = json;
            return this;
        }

        public Builder withIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
            return this;
        }

        public Builder withIcon(InputStream icon) {
            this.icon = icon;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAddr(String addr) {
            this.addr = addr;
            return this;
        }

        public Builder withVicinity(String vicinity) {
            this.vicinity = vicinity;
            return this;
        }

        public Builder Rating(double rating) {
            this.rating = rating;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withInternationalPhone(String internationalPhone) {
            this.internationalPhone = internationalPhone;
            return this;
        }

        public Builder withGoogleUrl(String googleUrl) {
            this.googleUrl = googleUrl;
            return this;
        }

        public Builder withWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder withUtcOffset(int utcOffset) {
            this.utcOffset = utcOffset;
            return this;
        }

        public Builder withAccuracy(int accuracy) {
            this.accuracy = accuracy;
            return this;
        }

        public Builder withLang(String lang) {
            this.lang = lang;
            return this;
        }

        public Place build() {
            return new Place(this);
        }
    }
}
