package com.yndongyong.widget.emptylayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dongzhiyong on 2017/3/28.
 */

public class DYEmptyLayout extends LinearLayout implements DYEmptyHelper, View.OnClickListener {

    private View containerView;

    private ImageView ivStatus;
    private TextView tvTips;
    private ProgressBar pbProgress;

    private int networkErrorImageResId = R.mipmap.ic_error;
    private int interfaceErrorImageResId = R.mipmap.ic_retry;
    private int dataSetEmptyImageResId = R.mipmap.ic_empty;


    private String loadingTips = "正在加载...";
    private String dataEmptyTips = "暂无数据";
    private String interfaceErrorTips = "加载失败";
    private String networkErrorTips = "网络错误";

    public static final int STATUS_LOAINDG = -1;
    public static final int STATUS_DATA_EMTPY = -2;
    public static final int STATUS_INTERFACE_ERROR = -3;
    public static final int STATUS_NETWROK_ERROR = -4;
    public static final int STATUS_HIDE = -5;

    private int mStatus = STATUS_HIDE;

    private OnStatusClickListener listener;

    /**
     * 点击回调方法
     * @param listener
     */
    public void setOnStatusClickListener(OnStatusClickListener listener) {
        this.listener = listener;
    }

    private Context mContext;

    public DYEmptyLayout(Context context) {
        this(context, null);
    }

    public DYEmptyLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public DYEmptyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        if (containerView == null) {
            containerView = getRefreshStatusView();
            containerView.setOnClickListener(this);
        }
        addView(containerView);
    }

    @Override
    public View getRefreshStatusView() {
        View rootView = View.inflate(mContext, R.layout.empty_layout, null);
        ivStatus = (ImageView) rootView.findViewById(R.id.img_status);
        tvTips = (TextView) rootView.findViewById(R.id.tv_tips);
        pbProgress = (ProgressBar) rootView.findViewById(R.id.pb_progress);
        return rootView;
    }

    @Override
    public void changeToLoading() {
        mStatus = STATUS_LOAINDG;
        containerView.setVisibility(View.VISIBLE);
        ivStatus.setVisibility(GONE);
        tvTips.setVisibility(View.VISIBLE);
        tvTips.setText(loadingTips);
        pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void changeToDataSetEmpty() {
        mStatus = STATUS_DATA_EMTPY;
        containerView.setVisibility(View.VISIBLE);
        ivStatus.setVisibility(VISIBLE);
        ivStatus.setImageResource(dataSetEmptyImageResId);
        tvTips.setVisibility(View.VISIBLE);
        tvTips.setText(dataEmptyTips);
        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void changeToInterfaceError() {
        mStatus = STATUS_INTERFACE_ERROR;
        containerView.setVisibility(View.VISIBLE);
        ivStatus.setVisibility(VISIBLE);
        ivStatus.setImageResource(interfaceErrorImageResId);
        tvTips.setVisibility(View.VISIBLE);
        tvTips.setText(interfaceErrorTips);
        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void changeToNetWorkError() {
        mStatus = STATUS_NETWROK_ERROR;
        containerView.setVisibility(View.VISIBLE);
        ivStatus.setVisibility(VISIBLE);
        ivStatus.setImageResource(networkErrorImageResId);
        tvTips.setVisibility(View.VISIBLE);
        tvTips.setText(networkErrorTips);
        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void changeToHide() {
        mStatus = STATUS_HIDE;
        containerView.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(mStatus);
        }
    }

    public interface OnStatusClickListener {
        void onClick(int status);
    }



    public void setLoadingTips(String loadingTips) {
        this.loadingTips = loadingTips;
    }

    public void setDataEmptyTips(String dataEmptyTips) {
        this.dataEmptyTips = dataEmptyTips;
    }

    public void setInterfaceErrorTips(String interfaceErrorTips) {
        this.interfaceErrorTips = interfaceErrorTips;
    }

    public void setNetworkErrorTips(String networkErrorTips) {
        this.networkErrorTips = networkErrorTips;
    }

    public void setNetworkErrorImageResId(int networkErrorImageResId) {
        this.networkErrorImageResId = networkErrorImageResId;
    }

    public void setInterfaceErrorImageResId(int interfaceErrorImageResId) {
        this.interfaceErrorImageResId = interfaceErrorImageResId;
    }

    public void setDataSetEmptyImageResId(int dataSetEmptyImageResId) {
        this.dataSetEmptyImageResId = dataSetEmptyImageResId;
    }


}
