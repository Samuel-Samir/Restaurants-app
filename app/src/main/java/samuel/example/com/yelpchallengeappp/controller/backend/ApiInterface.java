package samuel.example.com.yelpchallengeappp.controller.backend;


import samuel.example.com.yelpchallengeappp.model.AuthClient;
import samuel.example.com.yelpchallengeappp.model.Business;
import samuel.example.com.yelpchallengeappp.model.Client;
import samuel.example.com.yelpchallengeappp.model.Resturant;
import samuel.example.com.yelpchallengeappp.model.ResturantsResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {


    @FormUrlEncoded
    @POST(ApiClient.REQUESTS_BASE_URL + "oauth2/token")
    Call<AuthClient> getAuthClient(@Field("client_id") String clinetId,
                                   @Field("client_secret") String clientSecret);


    @GET(ApiClient.REQUESTS_BASE_URL + "v3/businesses/search")
    Call<ResturantsResponse> getResturants(@HeaderMap Map<String, String> headers,
                                           @Query("latitude") double lat,
                                           @Query("longitude") double lng);



}
