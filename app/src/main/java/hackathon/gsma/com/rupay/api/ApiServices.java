package hackathon.gsma.com.rupay.api;

import hackathon.gsma.com.rupay.datasets.BalanceResponce;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by issy on 5/16/17.
 */

public interface ApiServices {

    @Headers({
            "X-User-Credential-2: 1357",
            "Authorization: Njg4MDg5NjAzOjEzNTc=",
            "X-Account-Type: mechant"
    })
    @GET("accounts/msisdn/{msisdn}/balance")
    Call<BalanceResponce> getMsisdnBalance(@Path("msisdn") String msisdn);

    @GET("articles-category")
    Call<String> getArticleCategories();

    @GET("/api/v1/articles/{id}/category")
    Call<String> getArticlesByCategory(@Path("id") int id);

    @GET("/api/v1/chama")
    Call<String> getChamaContent();

    @GET("/api/v1/history")
    Call<String> getHistoryContent();

    @GET("/api/v1/leadership")
    Call<String> getLeadership();

    @GET("/api/v1/harambee")
    Call<String> getHarambeeList();

    @GET("accounts/msisdn/{msisdn}/statemententries")
    Call<ResponseBody> getStatement(@Path("msisdn") String msisdn);

}
