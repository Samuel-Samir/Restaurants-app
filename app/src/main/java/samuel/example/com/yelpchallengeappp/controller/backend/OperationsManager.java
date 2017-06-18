package samuel.example.com.yelpchallengeappp.controller.backend;




import samuel.example.com.yelpchallengeappp.R;
import samuel.example.com.yelpchallengeappp.common.controller.backend.CTHttpError;
import samuel.example.com.yelpchallengeappp.common.helper.Utilities;
import samuel.example.com.yelpchallengeappp.common.view.BaseApplication;
import samuel.example.com.yelpchallengeappp.model.AuthClient;
import samuel.example.com.yelpchallengeappp.model.Business;
import samuel.example.com.yelpchallengeappp.model.Client;
import samuel.example.com.yelpchallengeappp.model.Coordinate;
import samuel.example.com.yelpchallengeappp.model.ResturantsResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class OperationsManager {

    public static final String TAG = "OperationsManager";
    private static OperationsManager _instance = null;

    /*
     * Constructors
     */
    public OperationsManager() {

    }

    public static OperationsManager getInstance() {
        if (_instance == null)
            _instance = new OperationsManager();
        return _instance;
    }

    public AuthClient getAuthClient(Client client) throws IOException {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<AuthClient> call = apiService.getAuthClient(client.getClientId(),client.getClientSecret());
        Response<AuthClient> response = call.execute();


        ensureHttpSuccess(response);

        return response.body();
    }



    public ResturantsResponse getResturants(Coordinate coordinate) throws IOException {
        HashMap<String, String> headers = ApiClient.getDefaultHeaders();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResturantsResponse> call = apiService.getResturants(headers,coordinate.getLatitude(),coordinate.getLongitude());
        Response<ResturantsResponse> response = call.execute();

        ensureHttpSuccess(response);

        return response.body();
    }


    /**
     * Ensure http success
     *
     * @param response of the api
     * @throws Exception if an error found, then throw an exception with the error, and the above layer (Operation) will catch it
     */
    public void ensureHttpSuccess(Response response) throws IOException {
        if (!response.isSuccessful() && response.errorBody() != null) {
            ResponseBody errorBody = response.errorBody();
            String errorMSG = errorBody.string();
            int code = response.code();
            if (code == 504 && Utilities.isNullString(errorMSG)) // Request timeout
                errorMSG = BaseApplication.getContext().getString(R.string.request_timeout);
            else if(!Utilities.isNullString(errorMSG) && errorMSG.trim().startsWith("{")
                    && errorMSG.trim().endsWith("}")) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(errorMSG);
                    errorMSG = jsonObject.getString("message");
                    if(jsonObject.has("code"))
                        code = jsonObject.optInt("code");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            throw new CTHttpError(errorMSG, code);
        }
    }
}
