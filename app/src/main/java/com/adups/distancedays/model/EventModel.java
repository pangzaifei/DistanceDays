package com.adups.distancedays.model;

import com.adups.distancedays.utils.DateUtils;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * 应用层事件model
 * <p>
 * Created by Chang.Xiao on 2019/10/15.
 *
 * @version 1.0
 */
public class EventModel implements Serializable {

    private String eventTitle; // 事件title
    private long createTime; // 创建时间戳
    private long targetTime; // 目标时间戳
    private boolean isLunarCalendar; // 是否为阴历
    private boolean isTop; // 是否置顶
    private int repeatType; // 重复类型

    /* 下面为附属属性 */ // 注意：附属属性在存在修改可能时不会及时更新，只在converter时更新，使用时动态获取，如days
    private long eventId; // 事件id
    private Date targetDate; // 到期日
    private int days; // 距离天数
    private boolean isOutOfTargetDate; // 是否超过到期日
    private Date endDate; // 结束日
    private boolean hasEndDate; // 是否有结束日
    private boolean isOutOfEndDate; // 是否超过结束日

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getTargetTime() {
        return targetTime;
    }

    public void setTargetTime(long targetTime) {
        this.targetTime = targetTime;
    }

    public boolean isLunarCalendar() {
        return isLunarCalendar;
    }

    public void setLunarCalendar(boolean lunarCalendar) {
        isLunarCalendar = lunarCalendar;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public int getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(int repeatType) {
        this.repeatType = repeatType;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    /**
     * 获取目标日期与今天的时间差
     *
     * @return
     */
    public int getDays() {
        int days = DateUtils.getDateOffset(targetTime);
        return Math.abs(days);
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isOutOfTargetDate() {
        int days = DateUtils.getDateOffset(targetTime);
        return days < 0;
    }

    public void setOutOfTargetDate(boolean outOfTargetDate) {
        isOutOfTargetDate = outOfTargetDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isHasEndDate() {
        return hasEndDate;
    }

    public void setHasEndDate(boolean hasEndDate) {
        this.hasEndDate = hasEndDate;
    }

    public boolean isOutOfEndDate() {
        return isOutOfEndDate;
    }

    public void setOutOfEndDate(boolean outOfEndDate) {
        isOutOfEndDate = outOfEndDate;
    }
}
