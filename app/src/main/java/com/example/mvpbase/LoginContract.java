package com.example.mvpbase;

import com.example.mvpbase.presenter.IPresenter;
import com.example.mvpbase.view.IBaseView;

/**
 * 契约接口类：
 * P层与 V层接口定义
 */

public class LoginContract {


    public interface ILoginView extends IBaseView {

        /**
         * 成功回调
         */
        void loginSuccess();

        /**
         * 失败回调
         *
         * @param msg
         */
        void loginFailed(String msg);
    }

    public interface ILoginPresenter extends IPresenter<ILoginView> {
        void login(String userName, String password);
    }
}
