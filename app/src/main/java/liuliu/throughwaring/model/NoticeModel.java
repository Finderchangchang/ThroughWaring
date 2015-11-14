package liuliu.throughwaring.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/11.
 */
public class NoticeModel implements Serializable{
    /// <summary>
    /// 通告编号（长度10）。
    /// </summary>
    private String noticeId;

    /// <summary>
//    / 通告类型（长度20）。
    /// </summary>
    private String noticeType;

    /// <summary>
    /// 通告有效范围（长度12）。
    /// </summary>
    private String noticeArea;

    /// <summary>
    /// 通告标题（长度80）。
    /// </summary>
    private String noticeTitle;

    /// <summary>
    /// 通告内容（长度102400）。
    /// </summary>
    private String noticeContent;

    /// <summary>
    /// 发布者（长度30）。
    /// </summary>
    private String noticeAuthor;

    /// <summary>
    /// 创建时间。
    /// </summary>
    private String noticeCreateTime;

    /// <summary>
    /// 有效期至。
    /// </summary>
    private String noticeEffectiveTime;

    /// <summary>
    /// 备注（长度200）。
    /// </summary>
    private String noticeComment;
}
