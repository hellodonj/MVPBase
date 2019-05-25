package com.example.mvpbase.model;

import android.os.Bundle;

import com.example.mvpbase.LoginContract;
import com.example.mvpbase.presenter.BasePresenter;

/**
 * 描述: 控制器实现类
 * 作者|时间: djj on 2019/5/24 0024 下午 5:07
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */
public class LoginPresenterImp extends BasePresenter<LoginContract.ILoginView>
        implements LoginContract.ILoginPresenter {
    @Override
    public void login(String userName, String password) {
        //先对view进行非空判断
        if (isViewAttach()) {
            onLogin(getView(), userName, password);
        }
    }

    private void onLogin(LoginContract.ILoginView view, String userName, String password) {
        if (userName.isEmpty() || password.isEmpty()) {
            view.loginFailed("账号或密码不能为空");
        } else {
            if (userName.equals("哈哈")) {
                if (password.equals("123")) {
                    view.loginSuccess();
                } else {
                    view.loginFailed("密码错误！");
                }
            } else {
                view.loginFailed("账号错误！");
            }
        }
    }

    @Override
    public void onMvpAttachView(LoginContract.ILoginView view, Bundle savedInstanceState) {
        super.onMvpAttachView(view, savedInstanceState);
    }

    @Override
    public void onMvpDetachView(boolean retainInstance) {
        super.onMvpDetachView(retainInstance);
    }
}
