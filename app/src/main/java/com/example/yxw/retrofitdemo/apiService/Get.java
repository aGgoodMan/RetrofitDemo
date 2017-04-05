package com.example.yxw.retrofitdemo.apiService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yxw on 2016/12/23.
 */

public interface Get {
    @GET(value = "article/list/text?page=1")
    Call<ResponseBody> get();
}
