package samuel.example.com.yelpchallengeappp;

import java.util.List;

/**
 * Created by samuel on 6/15/2017.
 */

public class Resturant {
    private List<Business> businesses;
    private int total;


    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
