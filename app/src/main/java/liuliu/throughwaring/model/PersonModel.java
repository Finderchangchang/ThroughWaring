package liuliu.throughwaring.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/11.
 */
public class PersonModel implements Serializable{
    private String personId;//人员编码
    private String personCompanyId;//企业编码
    private String personPoliceId;//民警编码
    private String personTerminalId;//设备编码
    private String personTransactionId;//事务编码
    private String personComapnyType;//人员隶属企业类型
    private String personComapnyName;//企业名称
    private String personCardType;//证件类型
    private String personCardId;//证件号码
    private String personName;//人员姓名
    private String personSex;//性别1男2女
    private String personNation;//民族
    private String personNative;//籍贯
    private String personBirthday;//出生日期
    private String personAddress;//详细地址
    private String personPhoneNumeber;//联系电话
    /// <summary>
    /// 东经。
    /// </summary>
    private String personEastPoint;

    /// <summary>
    /// 北纬。
    /// </summary>
    private String personNorthPoint;

    /// <summary>
    /// 证件照片。
    /// </summary>
    private String personCardImage;

    /// <summary>
    /// 实际照片。
    /// </summary>
    private String personRealImage;

    /// <summary>
    /// 备注（长度200）。
    /// </summary>
    private String personComment;

    /// <summary>
    /// 人员状态。
    /// </summary>
    private String personStatus;

    /// <summary>
    /// 创建时间。
    /// </summary>
    private String personCreateTime;

    /// <summary>
    /// 修改时间。
    /// </summary>
    private String personChangeTime;
    /// <summary>
    /// 日期。
    /// </summary>
    private String personDate;

    /// <summary>
    /// 流水序号。
    /// </summary>
    private int personIndex;

    private int personUpload;

    private int personAtLarge;
}
