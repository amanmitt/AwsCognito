package com.example.cognito;

import com.example.cognito.response.BaseResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("get-camp-by-zone")
    Call<List<BaseResponse>> getTasks(@Query("zone_username") String zone_username);
}
