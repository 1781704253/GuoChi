package zhangyanran20181017.bwie.com.day13.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import zhangyanran20181017.bwie.com.day13.bean.NewBean;
import zhangyanran20181017.bwie.com.day13.mvp.model.HttpUtils;
import zhangyanran20181017.bwie.com.day13.mvp.view.IView;

/**
 * Created by 匹诺曹 on 2018/10/17.
 */

public class MainPresenter implements IPresenter{

    IView iView;

    public MainPresenter(IView iView) {
        this.iView = iView;
    }

    public void getData(String key ,int page, String sort){
        Observable<NewBean> toget = HttpUtils.getUtilsInstance().api.toget(key, page, sort);
        toget.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<NewBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(NewBean newBean) {
                iView.onSuccess(newBean.getData());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    @Override
    public void onDestroy() {

    }
}
