package se.lendo.test.common.googlePlaceApi.domain;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;

        Place place = (Place) o;

        if (Double.compare(place.lat, lat) != 0) return false;
        if (Double.compare(place.lng, lng) != 0) return false;
        if (Double.compare(place.rating, rating) != 0) return false;
        if (utcOffset != place.utcOffset) return false;
        if (accuracy != place.accuracy) return false;
        if (placeId != null ? !placeId.equals(place.placeId) : place.placeId != null) return false;
        if (json != null ? !json.equals(place.json) : place.json != null) return false;
        if (iconUrl != null ? !iconUrl.equals(place.iconUrl) : place.iconUrl != null) return false;
        if (icon != null ? !icon.equals(place.icon) : place.icon != null) return false;
        if (name != null ? !name.equals(place.name) : place.name != null) return false;
        if (addr != null ? !addr.equals(place.addr) : place.addr != null) return false;
        if (vicinity != null ? !vicinity.equals(place.vicinity) : place.vicinity != null) return false;
        if (phone != null ? !phone.equals(place.phone) : place.phone != null) return false;
        if (internationalPhone != null ? !internationalPhone.equals(place.internationalPhone) : place.internationalPhone != null)
            return false;
        if (googleUrl != null ? !googleUrl.equals(place.googleUrl) : place.googleUrl != null) return false;
        if (website != null ? !website.equals(place.website) : place.website != null) return false;
        return lang != null ? lang.equals(place.lang) : place.lang == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = placeId != null ? placeId.hashCode() : 0;
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (json != null ? json.hashCode() : 0);
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (addr != null ? addr.hashCode() : 0);
        result = 31 * result + (vicinity != null ? vicinity.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (internationalPhone != null ? internationalPhone.hashCode() : 0);
        result = 31 * result + (googleUrl != null ? googleUrl.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + utcOffset;
        result = 31 * result + accuracy;
        result = 31 * result + (lang != null ? lang.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId='" + placeId + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", json=" + json +
                ", iconUrl='" + iconUrl + '\'' +
                ", icon=" + icon +
                ", valueOf='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", vicinity='" + vicinity + '\'' +
                ", rating=" + rating +
                ", phone='" + phone + '\'' +
                ", internationalPhone='" + internationalPhone + '\'' +
                ", googleUrl='" + googleUrl + '\'' +
                ", website='" + website + '\'' +
                ", utcOffset=" + utcOffset +
                ", accuracy=" + accuracy +
                ", lang='" + lang + '\'' +
                '}';
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

        public Builder withTypes(List<String> types) {
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
