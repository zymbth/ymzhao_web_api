package com.ymzhao.website.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * user informations
 * </p>
 *
 * @author ymzhao
 * @since 2020-03-19
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer usrtype;

    private String usrname;

    private String pwd;

    private String tel;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUsrtype() {
        return usrtype;
    }

    public void setUsrtype(Integer usrtype) {
        this.usrtype = usrtype;
    }
    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", usrtype=" + usrtype +
            ", usrname=" + usrname +
            ", pwd=" + pwd +
            ", tel=" + tel +
            ", email=" + email +
        "}";
    }
}
