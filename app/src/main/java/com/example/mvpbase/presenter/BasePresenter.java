package com.example.mvpbase.presenter;

import android.os.Bundle;

import com.example.mvpbase.view.IBaseView;

import java.lang.ref.WeakReference;

/**
 * 控制器基类：
 * Presenter生命周期包装、View的绑定和解除，P层实现的基类
 */
public class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    private WeakReference<V> viewRef;

    protected V getView() {
        return viewRef.get();
    }

    protected boolean isViewAttach() {
        return viewRef != null && viewRef.get() != null;
    }

    private void attach(V view, Bundle savedInstanceState) {
        viewRef = new WeakReference<V>(view);
    }

    @Override
    public void onMvpAttachView(V view, Bundle savedInstanceState) {
        attach(view, savedInstanceState);
    }

    @Override
    public void onMvpStart() {

    }

    @Override
    public void onMvpResume() {

    }

    @Override
    public void onMvpPause() {

    }

    @Override
    public void onMvpStop() {

    }

    @Override
    public void onMvpSaveInstanceState(Bundle savedInstanceState) {

    }

    private void detach(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    @Override
    public void onMvpDetachView(boolean retainInstance) {
        detach(retainInstance);
    }

    @Override
    public void onMvpDestroy() {

    }
}
