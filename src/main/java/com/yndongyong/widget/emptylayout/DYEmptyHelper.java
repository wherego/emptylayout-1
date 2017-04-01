package com.yndongyong.widget.emptylayout;

import android.content.Context;
import android.view.View;

/**
 * 用户控制RefreshLayout 加载中，加载为空，加载失败等的情况的view的父类
 * Created by Dong on 2017/3/29.
 */
public interface DYEmptyHelper {

//    int STATUS_HIDE = 1;
//    int STATUS_RELOADING = 2;
//    int STATUS_NETWORK_ERROR = 3;

    /**
     * 获取状态显示控件
     *
     * @return
     */
    public abstract View getRefreshStatusView();

    /**
     * 进入 正在 加载状态
     */
    public abstract void changeToLoading();


    /**
     * 进入 数据集为空 状态
     */
    public abstract void changeToDataSetEmpty();

    /**
     * 进入 接口调用失败 状态
     */
    public abstract void changeToInterfaceError();

    /**
     * 进入 网络异常 状态
     */
    public abstract void changeToNetWorkError();

    /**
     * 结束 加载 状态这个状态不由自己控制
     */
    /*public abstract void onEndLoading();*/

    /**
     * 隐藏整个布局
     */
    void changeToHide();

    /**
     * 点击重试的回调
     *
     * @param listener
     */
    public abstract void setOnClickListener(View.OnClickListener listener);

}
