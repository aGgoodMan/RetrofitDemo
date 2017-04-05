package com.example.yxw.retrofitdemo.apiService;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by yxw on 2016/12/23.
 */

public interface GetAndQueryMap {
    @GET(value = "fcg-bin/fcg_music_fav_getinfo.fcg")
    Call<ResponseBody> getAndQueryMap(@QueryMap Map<String,String> map);
}
