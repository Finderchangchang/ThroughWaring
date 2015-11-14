package liuliu.throughwaring.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/11.
 */
public class PoliceModel implements Serializable{
    /// <summary>
    /// 民警编码（长度20）。
    /// </summary>
    private String policeId;

    /// <summary>
    /// 所属辖区（Code_Area字典、长度12）。
    /// </summary>
    private String policeArea;

    /// <summary>
    /// 姓名（长度15）。
    /// </summary>
    private String policeName;

    /// <summary>
    /// 电话号码（长度20）。
    /// </summary>
    private String policePhoneNumber;

    /// <summary>
    /// 证件照片id
    /// </summary>
    private String policeCardImageId;
    /// <summary>
    /// 证件照片（可为null）。
    /// </summary>
    private String policeCardImage;

    /// <summary>
    ///民警在职状态（Code_WorkingStatus字典、长度20）。
    /// </summary>
    private String policeWorkingStatus;

    /// <summary>
    /// 民警信息创建时间
    /// </summary>
    private String policeCreateTime;

    /// <summary>
    /// 民警信息修改时间
    /// </summary>
    private String policeChangeTime;

    /// <summary>
    /// 民警备注（长度200）。
    /// </summary>
    private String policeComment ;
}
