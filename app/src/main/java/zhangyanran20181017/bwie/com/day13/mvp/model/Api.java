package zhangyanran20181017.bwie.com.day13.mvp.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zhangyanran20181017.bwie.com.day13.bean.NewBean;

/**
 * Created by 匹诺曹 on 2018/10/17.
 */

public interface Api {
    @GET("product/searchProducts")
    Observable<NewBean> toget(@Query("keywords") String keywords, @Query("page") int page, @Query("sort") String sort);
}
