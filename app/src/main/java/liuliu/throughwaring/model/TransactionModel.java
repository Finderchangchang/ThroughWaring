package liuliu.throughwaring.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/11.
 */
public class TransactionModel implements Serializable {
    /// <summary>
    /// 采集事务编码（长度20）。
    /// </summary>
    private String transactionId;

    //    / <summary>
    /// 设备编码（长度8）。
    /// </summary>
    private String transactionTerminalId;

    /// <summary>
    /// 企业编码（长度10）。
    /// </summary>
    private String transactionCompanyId;

    /// <summary>
    /// 民警警号（长度20）。
    /// </summary>
    private String transactionPoliceId;

    /// <summary>
    /// 采集地点（东经）。
    /// </summary>
    private String transactionEastPoint;

    /// <summary>
    /// 采集地点（北纬）。
    /// </summary>
    private String transactionNorthPoint;

    /// <summary>
    /// 事务坐标图。
    /// </summary>
    private String transactionPointImage;

    /// <summary>
    /// 采集民警照片。
    /// </summary>
    private String transactionPoliceImage;

    /// <summary>
    /// 事务备注。
    /// </summary>
    private String transactionComment;

    /// <summary>
    /// 事务日期。
    /// </summary>
    private String transactionDate;

    /// <summary>
    /// 事务流水号。
    /// </summary>
    private int transactionIndex;

}
