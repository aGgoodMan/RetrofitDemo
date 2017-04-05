package com.example.yxw.retrofitdemo.apiService;

import com.example.yxw.retrofitdemo.bean.GsonConverterBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yxw on 2016/12/23.
 */

public interface GetAndQuery {
    @GET(value = "article/list/text")
    Call<GsonConverterBean> getAndQuery(@Query("page") String page);
}
