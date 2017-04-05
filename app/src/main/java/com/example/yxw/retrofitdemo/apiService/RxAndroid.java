package com.example.yxw.retrofitdemo.apiService;

import com.example.yxw.retrofitdemo.bean.GsonConverterBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yxw on 2016/12/23.
 */

public interface RxAndroid {
    @GET(value = "article/list/text?page=1")
    Observable<GsonConverterBean> rxAndroid();
}
