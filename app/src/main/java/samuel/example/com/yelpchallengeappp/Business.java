package samuel.example.com.yelpchallengeappp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by samuel on 6/15/2017.
 */

public class Business {
    private String id;
    private String name;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("is_closed")
    private boolean isClosed;


}
