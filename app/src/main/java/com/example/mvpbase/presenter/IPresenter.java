package com.example.mvpbase.presenter;

import android.os.Bundle;

import com.example.mvpbase.view.IBaseView;

/**
 * 描述: 控制器接口
 * 定义P层生命周期与 V层同步
 * 将Presenter的生命周期和View层的生命周期绑定在一起
 * 作者|时间: djj on 2019/5/24 0024 下午 4:13
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */
public interface IPresenter<V extends IBaseView> {

    void onMvpAttachView(V view, Bundle savedInstanceState);

    void onMvpStart();

    void onMvpResume();

    void onMvpPause();

    void onMvpStop();

    void onMvpSaveInstanceState(Bundle savedInstanceState);

    void onMvpDetachView(boolean retainInstance);

    void onMvpDestroy();
}
