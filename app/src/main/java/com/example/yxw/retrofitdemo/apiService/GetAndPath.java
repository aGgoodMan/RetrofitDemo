package com.example.yxw.retrofitdemo.apiService;

import com.example.yxw.retrofitdemo.bean.GsonConverterBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yxw on 2016/12/23.
 */

public interface GetAndPath {
    @GET(value = "article/list/{change}?page=1")
    Call<GsonConverterBean> getAndPath(@Path("change") String str);
}
