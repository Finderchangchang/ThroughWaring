package liuliu.throughwaring.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/11.
 */
public class CompanyModel implements Serializable {
    private String companyId;//企业编码
    private String companyType;//企业类型
    private String companyName;//企业名称
    private String companyArea;//所属辖区
    private String companyLegalPerson;//法定代表人
    private String companySecurityPerson;//治安负责人
    private String companyPhoneNumber;//联系电话
    private String companyEastPoint;//东径（123.123456）
    private String companyNorthPoint;//北纬
    private String companyOveralImage;//企业照片
    private String companyPoliceId;//民警编号
    private String companyTerminalId;//设备编号
    private String companyCreateTime;//企业创建时间
    private String companyChangeTime;//企业修改时间
    private String companyComment;//备注
}
