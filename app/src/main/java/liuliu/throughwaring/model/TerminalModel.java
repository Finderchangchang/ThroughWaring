package liuliu.throughwaring.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/11.
 */
public class TerminalModel implements Serializable {
    private String id;
    /// <summary>
    /// 设备编码（长度8）。
    /// </summary>
    private String TerminalId;

    ///<summary>
    /// 设备IMEI编码（长度15）。
    /// </summary>
    private String TerminalCode;

    /// <summary>
    /// 设备登录密码（长度20）。
    /// </summary>
    private String TerminalPassword;

    /// <summary>
    /// 设备电话号码（最大长度20）。
    /// </summary>
    private String TerminalPhoneNumber;

    /// <summary>
    /// 设备类型（最大长度30）。
    /// </summary>
    private String TerminalType;

    /// <summary>
    /// 设备状态（Code_TerminalStatus字典、最大长度20）。
    /// </summary>
    private String terminalStatus;

    /// <summary>
    /// 设备所属辖区（Code_Area字典、长度12）。
    /// </summary>
    private String TerminalArea;

    /// <summary>
    /// 设备创建时间
    /// </summary>
    private String terminalCreateTime;

    /// <summary>
    /// 设备修改时间
    /// </summary>
    private String TerminalChangeTime;
    /// <summary>
    /// 备注（最大长度200）。
    /// </summary>
    private String TerminalComment;


    private String bOnLine;

    private String version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getBOnLine() {
        return bOnLine;
    }

    public String getbOnLine() {
        return bOnLine;
    }

    public void setbOnLine(String bOnLine) {
        this.bOnLine = bOnLine;
    }

    public String getTerminalArea() {
        return TerminalArea;
    }

    public void setTerminalArea(String terminalArea) {
        TerminalArea = terminalArea;
    }

    public String getTerminalChangeTime() {
        return TerminalChangeTime;
    }

    public void setTerminalChangeTime(String terminalChangeTime) {
        TerminalChangeTime = terminalChangeTime;
    }

    public String getTerminalCode() {
        return TerminalCode;
    }

    public void setTerminalCode(String terminalCode) {
        TerminalCode = terminalCode;
    }

    public String getTerminalComment() {
        return TerminalComment;
    }

    public void setTerminalComment(String terminalComment) {
        TerminalComment = terminalComment;
    }

    public String getTerminalCreateTime() {
        return terminalCreateTime;
    }

    public void setTerminalCreateTime(String terminalCreateTime) {
        this.terminalCreateTime = terminalCreateTime;
    }

    public String getTerminalId() {
        return TerminalId;
    }

    public void setTerminalId(String terminalId) {
        TerminalId = terminalId;
    }

    public String getTerminalPassword() {
        return TerminalPassword;
    }

    public void setTerminalPassword(String terminalPassword) {
        TerminalPassword = terminalPassword;
    }

    public String getTerminalPhoneNumber() {
        return TerminalPhoneNumber;
    }

    public void setTerminalPhoneNumber(String terminalPhoneNumber) {
        TerminalPhoneNumber = terminalPhoneNumber;
    }

    public String getTerminalStatus() {
        return terminalStatus;
    }

    public void setTerminalStatus(String terminalStatus) {
        this.terminalStatus = terminalStatus;
    }

    public String getTerminalType() {
        return TerminalType;
    }

    public void setTerminalType(String terminalType) {
        TerminalType = terminalType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
