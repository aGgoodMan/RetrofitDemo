package com.example.yxw.retrofitdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yxw.retrofitdemo.apiService.Get;
import com.example.yxw.retrofitdemo.apiService.GetAndGsonVerter;
import com.example.yxw.retrofitdemo.apiService.GetAndPath;
import com.example.yxw.retrofitdemo.apiService.GetAndQuery;
import com.example.yxw.retrofitdemo.apiService.GetAndQueryMap;
import com.example.yxw.retrofitdemo.apiService.PostAndHeader;
import com.example.yxw.retrofitdemo.apiService.RxAndroid;
import com.example.yxw.retrofitdemo.bean.GsonConverterBean;
import com.example.yxw.retrofitdemo.utils.NetWorkUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        img = (ImageView) findViewById(R.id.img);
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.get:
                getNoHeader();
                break;
            case R.id.getAndHeader:
                getAndHeader();
                break;
            case R.id.post:
                post();
                break;
            case R.id.postAndHeader:
                postAndHeader();
                break;
            case R.id.getAndGsonConverter:
                getAndGsonConverter();
                break;
            case R.id.getAndQuery:
                getAndQuery();
                break;
            case R.id.getAndQueryMap:
                getAndQueryMap();
                break;
            case R.id.getAndPath:
                getAndPath();
                break;
            case R.id.RxAndroid:
                RxAndroid();
                break;
        }
    }

    /**
     * 请求方式:get
     * 请求头:无
     */
    private void getNoHeader() {
//        福利社：http://m2.qiushibaike.com/article/list/text
//        请求方式：GET
//        请求体：page=1
//        请求头：无
        //协议加主机名,以/结尾
        String baseUrl = "http://m2.qiushibaike.com/";
        //建造者模式,创建Retrofit对象
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl);
        Retrofit build = builder.build();

        Get get = build.create(Get.class);
        Call<ResponseBody> call = get.get();
        //异步执行任务
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //数据结果返回
                    //主线程环境,可以更新UI
                    String string = response.body().string();
                    text.setText(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    /**
     * 请求方式:get
     * 请求头:有
     */
    private void getAndHeader() {

    }

    /**
     * 请求方式:post
     * 请求头:无
     */
    private void post() {

    }

    /**
     * 请求方式:post
     * 请求头:有
     */
    private void postAndHeader() {
//        福利社：http://api.menghuoapp.com/v1/welfare_good/list
//        请求方式：POST
//        请求体：page_size=20，page=0
//        请求头：名称：Content-Type，值：application/json; charset=UTF-8
        String baseUrl = "http://api.menghuoapp.com/";
        //建造者模式
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(baseUrl);
        Retrofit build = builder.build();
        //调用create()生成对应类的对象
        PostAndHeader postAndHeader = build.create(PostAndHeader.class);
        Call<ResponseBody> call = postAndHeader.postAndHeader();
        //异步执行
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //主线程环境,可更新UI
                try {
                    String string = response.body().string();
                    text.setText(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    /**
     * 请求方式:get
     * 请求头:无
     * 解析数据:用GsonConverter
     */
    private void getAndGsonConverter() {
//        福利社：http://m2.qiushibaike.com/article/list/text
//        请求方式：GET
//        请求体：page=1
//        请求头：无
        String baseUrl = "http://m2.qiushibaike.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //这一步,直接将下载的json数据解析成了对应的Javabean类
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetAndGsonVerter getAndGsonVerter = retrofit.create(GetAndGsonVerter.class);
        Call<GsonConverterBean> call = getAndGsonVerter.getAndGsonConverter();

        call.enqueue(new Callback<GsonConverterBean>() {
            @Override
            public void onResponse(Call<GsonConverterBean> call, Response<GsonConverterBean> response) {
                //直接返回GsonConverterBean对象
                GsonConverterBean body = response.body();
                int size = body.getItems().size();
                text.setText(String.valueOf(size));
            }

            @Override
            public void onFailure(Call<GsonConverterBean> call, Throwable t) {

            }
        });
    }

    /**
     * 请求方式:get
     * 请求头:无
     * 参数传递:@Query
     */
    private void getAndQuery() {
//        福利社：http://m2.qiushibaike.com/article/list/text
//        请求方式：GET
//        请求体：page=1
//        请求头：无
        String page = "1";
        String baseUrl = "http://m2.qiushibaike.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //这一步,直接将下载的json数据解析成了对应的Javabean类
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetAndQuery getAndQuery = retrofit.create(GetAndQuery.class);
        Call<GsonConverterBean> call = getAndQuery.getAndQuery(page);
        call.enqueue(new Callback<GsonConverterBean>() {
            @Override
            public void onResponse(Call<GsonConverterBean> call, Response<GsonConverterBean> response) {
                GsonConverterBean body = response.body();
                int size = body.getItems().size();
                text.setText(String.valueOf(size + 1));
            }

            @Override
            public void onFailure(Call<GsonConverterBean> call, Throwable t) {

            }
        });


    }

    /**
     * 请求方式:get
     * 请求头:无
     * 参数传递:@QueryMap
     */
    private void getAndQueryMap() {
//        QQ空间：http://qzone-music.qq.com/fcg-bin/fcg_music_fav_getinfo.fcg
//        请求方式：GET
//        请求体：dirinfo=0&dirid=1&uin=QQ号&p=0.519638272547262&g_tk=1284234856
//        请求头：无
        String str = "http://qzone-music.qq.com/";
        //用map存储参数
        Map<String, String> map = new HashMap<>();
        map.put("dirinfo", "0");
        map.put("dirid", "1");
        map.put("uin", "QQ");
        map.put("p", "0.519638272547262");
        map.put("g_tk", "1284234856");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(str)
//                .addConverterFactory()
                .build();
        GetAndQueryMap getAndQueryMap = retrofit.create(GetAndQueryMap.class);
        Call<ResponseBody> call = getAndQueryMap.getAndQueryMap(map);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    text.setText(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    /**
     * 请求方式:get
     * 请求头:无
     * 参数替换:@Path
     */
    private void getAndPath() {
//        福利社：http://m2.qiushibaike.com/article/list/text
//        请求方式：GET
//        请求体：page=1
//        请求头：无
        String str = "text";
        String baseUrl = "http://m2.qiushibaike.com/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //这一步,直接将下载的json数据解析成了对应的Javabean类
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetAndPath getAndPath = retrofit.create(GetAndPath.class);
        Call<GsonConverterBean> call = getAndPath.getAndPath(str);
        call.enqueue(new Callback<GsonConverterBean>() {
            @Override
            public void onResponse(Call<GsonConverterBean> call, Response<GsonConverterBean> response) {
                GsonConverterBean body = response.body();
                int size = body.getItems().size();
                text.setText(String.valueOf(size));
            }

            @Override
            public void onFailure(Call<GsonConverterBean> call, Throwable t) {

            }
        });
    }

    /**
     * RxAndroid结合retrofit
     */
    private void RxAndroid() {
//        福利社：http://m2.qiushibaike.com/article/list/text
//        请求方式：GET
//        请求体：page=1
//        请求头：无
        String baseUrl = "http://m2.qiushibaike.com/";
        //建造者模式,配置retrofit
        Retrofit retrofit = new Retrofit.Builder()
                //解析下载下来的json数据,使其直接变成一个Javabean
                .addConverterFactory(GsonConverterFactory.create())
                //想用rxAndroid,必须配置这句话
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //配置根路径
                .baseUrl(baseUrl)
                .build();
        RxAndroid rxAndroid = retrofit.create(RxAndroid.class);
        //得到Observable对象
        Observable<GsonConverterBean> call = rxAndroid.rxAndroid();
        //利用rxAndroid进行图片下载
        //subscribeOn()线程切换,事件产生在子线程
        call.subscribeOn(Schedulers.io())
                //见图片地址转换成bitmap
                .map(new Func1<GsonConverterBean, Bitmap>() {
                    @Override
                    public Bitmap call(GsonConverterBean gsonConverterBean) {
                        int size = gsonConverterBean.getItems().size();
                        Bitmap bt = null;
                        if (size > 0) {
                            GsonConverterBean.ItemsBean itemsBean = gsonConverterBean.getItems().get(0);
                            String medium = itemsBean.getUser().getMedium();
                            bt = NetWorkUtils.getBt("http:" + medium);
                            Log.e("====", "===call===" + medium);

                        }
                        return bt;
                    }
                })
                //切换线程,使时间消费在主线程当中
                .observeOn(AndroidSchedulers.mainThread())
                //消费事件的方法
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        if (bitmap != null) {
                            Log.e("====", "===call===");
                            img.setImageBitmap(bitmap);

                        }
                    }
                });
    }
}
