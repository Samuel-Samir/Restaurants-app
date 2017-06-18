package samuel.example.com.yelpchallengeappp.model;


import java.util.List;

public class ResturantsResponse {
    List<Business> businesses;

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
}
