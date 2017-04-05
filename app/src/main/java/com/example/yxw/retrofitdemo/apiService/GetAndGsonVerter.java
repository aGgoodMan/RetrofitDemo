package com.example.yxw.retrofitdemo.apiService;

import com.example.yxw.retrofitdemo.bean.GsonConverterBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yxw on 2016/12/23.
 */

public interface GetAndGsonVerter {
    @GET(value = "article/list/text?page=1")
    Call<GsonConverterBean> getAndGsonConverter();
}
