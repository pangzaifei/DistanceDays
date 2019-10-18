package com.adups.distancedays.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.adups.distancedays.R;
import com.adups.distancedays.base.ToolBarActivity;
import com.adups.distancedays.model.EventModel;
import com.adups.distancedays.utils.BundleConstants;
import com.adups.distancedays.utils.DateUtils;
import com.adups.distancedays.utils.FormatHelper;
import com.adups.distancedays.utils.ToastUtil;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 事件详情
 * <p>
 * Created by Chang.Xiao on 2019/10/15.
 *
 * @version 1.0
 */
public class EventDetailActivity extends ToolBarActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_day)
    TextView tvDay;
    @BindView(R.id.tv_due_date)
    TextView tvDueDate;

    private EventModel mEventModel;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_event_detail;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        parseBundle();
        refreshUi();
        setMenuTypes(MENU_TYPE_EDIT_EVENT);
    }

    private void parseBundle() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            mEventModel = (EventModel) bundle.get(BundleConstants.KEY_MODEL);
        }
    }

    private void refreshUi() {
        if (mEventModel == null) {
            return;
        }
        tvTitle.setText(Html.fromHtml(FormatHelper.getDateCardTitlePartBold(mEventModel, this.mContext)).toString());
        tvDay.setText(String.valueOf(mEventModel.getDays()));
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(mEventModel.getTargetTime());
        tvDueDate.setText(DateUtils.getFormatedDate(mContext, instance, 2, mEventModel.isLunarCalendar()));
    }

    @Override
    public Runnable getMenuEditEventAction() {
        return new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(mContext, AddEventActivity.class);
                intent.putExtra(BundleConstants.KEY_TYPE, AddEventActivity.TYPE_EDIT);
                intent.putExtra(BundleConstants.KEY_MODEL, mEventModel);
                startActivity(intent);
            }
        };
    }

    @OnClick(R.id.fab_button)
    public void onFloatButtonClick() {
        ToastUtil.showToast(mContext, getString(R.string.toast_function_development));
    }

    /**
     * 天数点击事件
     */
    @OnClick(R.id.tv_day)
    public void onDaysClick() {
        if (tvDay == null || mEventModel == null) {
            return;
        }
        tvDay.setText(DateUtils.getFormatDaysText(mEventModel.getDays(), tvDay.getText().toString()));
    }
}
