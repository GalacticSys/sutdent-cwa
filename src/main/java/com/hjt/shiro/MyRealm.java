package com.hjt.shiro;

import com.hjt.dao.PermissionDao;
import com.hjt.dao.RoleDao;
import com.hjt.dao.UserDao;
import com.hjt.pojo.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Resource
    UserDao userDao;
    @Resource
    RoleDao roleDao;
    @Resource
    PermissionDao permissionDao;

    //登录验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
//        String userCode = usernamePasswordToken.getUsername();
//        String type = usernamePasswordToken.getHost();
//        String password = new String((char[]) usernamePasswordToken.getCredentials());
//        if ("1".equals(usernamePasswordToken.getHost())){
//            Student student = userDao.findStudentByCode(userCode);
//             if (student!=null){
//                 if (student.getStu_pwd().equals(password)){
//                     UserActive studentActive = new UserActive();
//                     studentActive.setObject(student);
//                     List<Role> roleByStudentId = roleDao.findRoleByUserId(student.getStu_id(),type);
//                     studentActive.setRoleList(roleByStudentId);
//                     List<Permission> permissionList = new ArrayList<>();
//                     roleByStudentId.forEach(
//                             role -> {
//                                 List<Permission> permissionByRoleId = permissionDao.findPermissionByRoleId(role.getId());
//                                 permissionList.addAll(permissionByRoleId);
//                             }
//                     );
//                     studentActive.setPermissionLsit(permissionList);
//                     SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(studentActive,student.getStu_pwd(),getName());
//                    return authorizationInfo;
//                 }
//             }
//        }
//        else if ("2".equals(usernamePasswordToken.getHost())||"3".equals(usernamePasswordToken.getHost())){
//            JiaoShi jiaoShi = userDao.findTeacherByCode(userCode,type);
//            if (jiaoShi!=null){
//
//                if (jiaoShi.getJiaoshi_pwd().equals(password)){
//                    JiaoshiActive studentActive = new JiaoshiActive();
//                    studentActive.setJiaoShi(jiaoShi);
//                    List<Role> roleByUserId = roleDao.findRoleByUserId(jiaoShi.getJiaoshi_id(),type);
//                    studentActive.setRoleList(roleByUserId);
//                    List<Permission> permissionList = new ArrayList<>();
//                    roleByUserId.forEach(
//                            role -> {
//                                List<Permission> permissionByRoleId = permissionDao.findPermissionByRoleId(role.getId());
//                                permissionList.addAll(permissionByRoleId);
//                            }
//                    );
//                    studentActive.setPermissionLsit(permissionList);
//                    SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(studentActive,jiaoShi.getJiaoshi_pwd(),getName());
//                    return authorizationInfo;
//                }
//            }
//        }
//        if ("4".equals(usernamePasswordToken.getHost())){
//            GuanLiYuan guanLiYuan = userDao.findGuanLiYuanByCode(usernamePasswordToken.getUsername());
//            if (guanLiYuan!=null){
//
//                if (guanLiYuan.getGuanliyuan_pwd().equals(password)){
//                    GuanliYuanActive guanliYuanActive = new GuanliYuanActive();
//                    guanliYuanActive.setGuanLiYuan(guanLiYuan);
//                    List<Role> roleByUserId = roleDao.findRoleByUserId(guanLiYuan.getGuanliyuan_id(),type);
//                    guanliYuanActive.setRoleList(roleByUserId);
//                    List<Permission> permissionList = new ArrayList<>();
//                    roleByUserId.forEach(
//                            role -> {
//                                List<Permission> permissionByRoleId = permissionDao.findPermissionByRoleId(role.getId());
//                                permissionList.addAll(permissionByRoleId);
//                            }
//                    );
//                    guanliYuanActive.setPermissionLsit(permissionList);
//                    SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(guanliYuanActive,guanLiYuan.getGuanliyuan_pwd(),getName());
//                    return authorizationInfo;
//                }
//            }
//        }
        return null;
    }


//    获取权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        UserActive primaryPrincipal = (UserActive) principalCollection.getPrimaryPrincipal();
//        System.out.println(primaryPrincipal.toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        primaryPrincipal.getPermissionLsit().forEach(
//                permission -> {
//                    simpleAuthorizationInfo.addStringPermission(permission.getName());
//                }
//        );
//        primaryPrincipal.getRoleList().forEach(
//                role -> {
//                    simpleAuthorizationInfo.addRole(role.getName());
//                }
//        );
        return simpleAuthorizationInfo;
    }


}
