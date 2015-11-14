package liuliu.throughwaring.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/11.
 */
public class ConfigModel implements Serializable{
    /// <summary>
    /// 数据库版本。
    /// </summary>
    private String version;

    /// <summary>
    /// 服务器地址。
    /// </summary>
    private String server;

    /// <summary>
    /// 通知检测时间间隔。
    /// </summary>
    private int noticeCheckLong;

    /// <summary>
    /// 通知检测时间间隔。
    /// </summary>
    private int personCheckLong;

    /// <summary>
    /// 设备地点上传时间间隔。
    /// </summary>
    private int posCheckLong;

    /// <summary>
    /// 人员最大存储数目。
    /// </summary>
    private int storeMaxCount;


}
