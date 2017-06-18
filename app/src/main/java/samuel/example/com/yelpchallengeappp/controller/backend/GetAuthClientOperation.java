package samuel.example.com.yelpchallengeappp.controller.backend;


import android.content.Context;

import samuel.example.com.yelpchallengeappp.common.controller.backend.BaseOperation;
import samuel.example.com.yelpchallengeappp.controller.UserManger;
import samuel.example.com.yelpchallengeappp.model.AuthClient;
import samuel.example.com.yelpchallengeappp.model.Client;

public class GetAuthClientOperation extends BaseOperation<AuthClient> {

    private Client mClient;

    public GetAuthClientOperation(Client client, Object requestID,
                                  boolean isShowLoadingDialog, Context activity) {
        super(requestID, isShowLoadingDialog, activity);
        this.mClient = client;
    }

    @Override
    public AuthClient doMain() throws Throwable {
        AuthClient authClient = OperationsManager.getInstance().getAuthClient(mClient);
        if(authClient != null) UserManger.getInstance().setAuthClient(authClient);
        return authClient;
    }
}
