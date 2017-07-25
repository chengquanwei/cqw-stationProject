package com.yszc.blog.shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yszc.blog.dto.User;
import com.yszc.blog.service.Impl.UserServiceImpl;

public class ShiroDbRealm extends AuthorizingRealm {  
    @Autowired  
    private UserServiceImpl userService;  
    public static final String SESSION_USER_KEY = "admin";  
  
    /** 
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {  
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(ShiroDbRealm.SESSION_USER_KEY);  
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
//        info.addRole(user.getRole().trim());  
        return info;  
    }  
  
    /** 
     * 认证回调函数，登录信息和用户验证信息验证 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(  
         AuthenticationToken authcToken) throws AuthenticationException {  
        // 把token转换成User对象  
    	UsernamePasswordToken userLogin = (UsernamePasswordToken) authcToken;  
        // 验证用户是否可以登录  
        User ui = userService.doUserLogin(userLogin.getUsername());  
        if(ui == null)  
            return null; // 异常处理，找不到数据  
        // 设置session  
        Session session = SecurityUtils.getSubject().getSession();  
        session.setAttribute(ui.getUserName(), ui);   
        /**
         * SimpleAuthenticationInfo里存放的是SecurityUtils.getSubject().login(token)进行验证的信息
         * 当执行SecurityUtils.getSubject().login(token)时，会先执行SimpleAuthenticationInfo进行认证
         * 
         *  org.apache.shiro.authc.SimpleAuthenticationInfo.SimpleAuthenticationInfo(Object principal, Object credentials, String realmName)
         * 并且当SecurityUtils.getSubject().getPrincipal()时，获取的是ui的值（第一个参数）
         */
        return new SimpleAuthenticationInfo(ui, ui.getPassword(), getName());  
    }  
  
//    private User tokenToUser(UsernamePasswordToken authcToken) {  
//        User user = new User();  
//        user.setUserName(authcToken.getUsername());  
//        user.setPassword(String.valueOf(authcToken.getPassword()));  
//        return user;  
//    }  
  
    //一定要写getset方法  
    public UserServiceImpl getUserService() {  
        return userService;  
    }  
  
    public void setUserService(UserServiceImpl userService) {  
        this.userService = userService;  
    }  
}  