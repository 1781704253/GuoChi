package zhangyanran20181017.bwie.com.day13.mvp.view;

import java.util.List;

import zhangyanran20181017.bwie.com.day13.bean.NewBean;

/**
 * Created by 匹诺曹 on 2018/10/17.
 */

public interface IView {
    void onSuccess(List<NewBean.DataBean> list);
    void onError(int code);
}
