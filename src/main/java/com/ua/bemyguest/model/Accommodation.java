package com.ua.bemyguest.model;

public class Accommodation {

    public static final String ID = "id";
    public static final String HOST_ID = "host_id";
    public static final String TITLE = "title";
    public static final String LOCALITY = "locality";
    public static final String COUNTRY = "country";
    public static final String ADDRESS = "address";
    public static final String ACCOMMODATION_TYPE = "accommodation_type";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";

    private int id;
    private int hostId;
    private String title;
    private String locality;
    private String country;
    private String address;
    private Host host;
    private AccommodationType accommodationType;
    private String description;
    private double price;

    public Accommodation(int id, int hostId, String title, String locality, String country, String address,
                         Host host, AccommodationType accommodationType, String description, double price) {
        this.id = id;
        this.hostId = hostId;
        this.title = title;
        this.locality = locality;
        this.country = country;
        this.address = address;
        this.host = host;
        this.accommodationType = accommodationType;
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accommodation)) return false;

        Accommodation that = (Accommodation) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (locality != null ? !locality.equals(that.locality) : that.locality != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (accommodationType != that.accommodationType) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (locality != null ? locality.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (accommodationType != null ? accommodationType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHostId() {
        return hostId;
    }

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Accommodation() {

    }

    public static Builder newBuilder() {
        return new Accommodation().new Builder();
    }

    public Builder toBuilder() {
        return this.new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setId(int id) {
            Accommodation.this.id = id;
            return this;
        }

        public Builder setHostId(int hostId) {
            Accommodation.this.hostId = hostId;
            return this;
        }

        public Builder setTitle(String title) {
            Accommodation.this.title = title;
            return this;
        }

        public Builder setLocality(String locality) {
            Accommodation.this.locality = locality;
            return this;
        }

        public Builder setCountry(String country) {
            Accommodation.this.country = country;
            return this;
        }

        public Builder setAddress(String address) {
            Accommodation.this.address = address;
            return this;
        }

        public Builder setHost(Host host) {
            Accommodation.this.host = host;
            return this;
        }

        public Builder setAccommodationType(AccommodationType accommodationType) {
            Accommodation.this.accommodationType = accommodationType;
            return this;
        }

        public Builder setDescription(String description) {
            Accommodation.this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            Accommodation.this.price = price;
            return this;
        }

        public Accommodation build() {
            return Accommodation.this;
        }
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", locality='" + locality + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", host=" + host +
                ", accommodationType=" + accommodationType +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
