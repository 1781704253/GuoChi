package zhangyanran20181017.bwie.com.day13.mvp.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 匹诺曹 on 2018/10/17.
 */

public class HttpUtils {
    public final Api api;

    private HttpUtils(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.URL_P)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    private static class GetUtilsInstance{
        private static HttpUtils httpUtils = new HttpUtils();
    }

    public static HttpUtils getUtilsInstance(){
        return GetUtilsInstance.httpUtils;
    }
}
