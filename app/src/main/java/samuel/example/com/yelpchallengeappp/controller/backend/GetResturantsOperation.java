package samuel.example.com.yelpchallengeappp.controller.backend;


import android.content.Context;

import samuel.example.com.yelpchallengeappp.common.controller.backend.BaseOperation;
import samuel.example.com.yelpchallengeappp.model.Business;
import samuel.example.com.yelpchallengeappp.model.Coordinate;
import samuel.example.com.yelpchallengeappp.model.ResturantsResponse;

import java.util.List;

public class GetResturantsOperation extends BaseOperation<ResturantsResponse>{

    private Coordinate mCoordinate;

    public GetResturantsOperation(Coordinate coordinate, Object requestID, boolean isShowLoadingDialog, Context activity) {
        super(requestID, isShowLoadingDialog, activity);
        this.mCoordinate = coordinate;
    }


    @Override
    public ResturantsResponse doMain() throws Throwable {
        ResturantsResponse responseApi = OperationsManager.getInstance().getResturants(mCoordinate);
        return responseApi != null ? responseApi : null;
    }
}
