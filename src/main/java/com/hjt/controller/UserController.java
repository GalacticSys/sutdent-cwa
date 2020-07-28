package com.hjt.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.hjt.pojo.JiaoShi;
import com.hjt.pojo.Student;
import com.hjt.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Autowired
    UserService userService;
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login (String type,String userCode,String password,Model model,HttpSession session){
			System.out.println("value=/login.action,method=RequestMethod.POST");
			System.out.println(type);
			System.out.println(userCode);
			System.out.println(password);
			if(type != null)
			{
				if(type.equals("0"))
				{
					model.addAttribute("msg","请选择客户类型");
				}
				Subject subject = SecurityUtils.getSubject();
				UsernamePasswordToken token = new UsernamePasswordToken(userCode,password,type);
				try {
					subject.login(token);
				}catch (Exception e){
					e.printStackTrace();
					return "index";
				}
				if ("1".equals(type)){
					session.setAttribute("USER_SESSION", new Student(token.getUsername(),token.getPassword().toString()));
					session.setAttribute("USER_TYPE", type);
					model.addAttribute("student",token.getUsername());
					model.addAttribute("msg","学生");
					return "html/student/student";
				}
				if ("2".equals(type)){
					return "html/teacher/teacher";
				}
				if ("3".equals(type)){
					return "html/Administrators/guanliyuan";
				}
				if ("4".equals(type)){
					return "html/teacher/teacher";
				}
			}
			return "index";
	}
	//login.action GET请求
	@RequestMapping(value="/login.action",method=RequestMethod.GET)
	public String toLogin()
	{
		System.out.println("method=RequestMethod.GET");
		return "index";
	}

	//重置密码请求
		@RequestMapping(value="/chongZhiMiMa.action",method=RequestMethod.POST)
		@ResponseBody
		public String chongZhiMiMa(String type,String new_userCode,String new_userIdentity,String new_userPwd, Model model){
			System.out.println("chongZhiMiMa"+type);
			System.out.println("new_userCode="+new_userCode);
			System.out.println("new_userPwd="+new_userPwd);
			if(type.equals("1"))
			{
				model.addAttribute("type","1");
				Student student = userService.findStudentById(new_userCode);
				if(student!=null)
				{
					if(student.getStu_identity().equals(new_userIdentity))
					{
						int result = userService.updateStudentMima(new_userPwd, new_userCode);
						if(result<1)
						{
							return "FALL";
						}
						return "OK";
					}
				}
				return "FALL";
			}
			if(type.equals("2"))
			{
				System.out.println("教师重置密码");
				String jiaoShi = null;
				model.addAttribute("type","2");
				JiaoShi teacher = userService.findTeacherById(new_userCode, jiaoShi);
				if(teacher!=null)
				{
					System.out.println("以code查询教师不为空");
					if(teacher.getJiaoshi_identity().equals(new_userIdentity))
					{
						System.out.println("身份证号正确");
						int result = userService.updateTeachertMima(new_userPwd, new_userCode);
						if(result<1)
						{
							return "FALL";
						}
						return "OK";
					}
				}
			}
			return "FALL";
		}
		//退出登录
		@RequestMapping("/logout.action")
		public String logout(HttpSession session) throws IOException
		{
			session.getAttribute("USER_SESSION");
			System.out.println("/logout.action"+session.getAttribute("USER_SESSION"));
			System.out.println("清除session中的值");
			session.invalidate();
			//System.out.println("session.invalidate();/logout.action"+session.getAttribute("USER_SESSION"));
			return "index";
		}
}
