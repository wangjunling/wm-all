package site.wmblog.common.web.xuser;

import site.wmblog.common.constant.Constant;
import site.wmblog.common.util.CryptoUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by panwang.chengpw on 5/8/15.
 */
public class XUser implements Serializable{

    private static final long serialVersionUID = -7980776945341594313L;
    /**
     * 用户名
     */
    private String  userName;
    /**
     * 密码
     */
    private String  password;
    /**
     * 用户id
     */
    private Long    uid;
    /**
     * 是否登录
     */
    private boolean isSignedIn = false;
    /**
     * 是否自动登录
     */
    private boolean isSavePass = false;

    public XUser() {
    }

    public XUser(Long uid, String userName, String password, boolean isSavePass) {
        this.isSavePass = isSavePass;
        this.password = password;
        this.uid = uid;
        this.userName = userName;
    }

    public boolean isSignedIn() {
        return isSignedIn;
    }

    public void setIsSignedIn(boolean isSignedIn) {
        this.isSignedIn = isSignedIn;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean getIsSavePass() {
        return isSavePass;
    }

    public void setIsSavePass(boolean isSavePass) {
        this.isSavePass = isSavePass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecPassword() {
        if (StringUtils.isBlank(getPassword())) {
            return null;
        }
        return CryptoUtil.encryptAES(getPassword(), Constant.COOKIE_CRYPTO_PASS);
    }
}
