package com.example.yxw.retrofitdemo.apiService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by yxw on 2016/12/23.
 */

public interface PostAndHeader {
    @Headers({
            "Content-Type:application/json;charset=UTF-8"
    })
    @POST(value = "v1/welfare_good/list?page_size=20&page=0")
    Call<ResponseBody> postAndHeader();
}
