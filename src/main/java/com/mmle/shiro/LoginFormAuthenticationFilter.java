package com.mmle.shiro;


import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;


/**
 * 
 * <p>Title: CustomFormAuthenticationFilter</p>
 * <p>Description:自定义FormAuthenticationFilter，认证之前实现 验证码校验 </p>
 */
public class LoginFormAuthenticationFilter extends FormAuthenticationFilter {
	
	private static String StaffLoginSuccessUrl = "";
	
	//使用这个需要再shiro.xml中配置
	//原FormAuthenticationFilter的认证方法
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		//在这里进行验证码的校验
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session =httpServletRequest.getSession();
		String validateCode = (String) session.getAttribute("validateCode");
		System.out.println("session中的验证码："+validateCode);
		
		//输入的验证和session中的验证进行对比 
		String randomcode = httpServletRequest.getParameter("randomcode");
		System.out.println("输入的验证码:"+randomcode);
		if(randomcode!=null && validateCode!=null && !randomcode.equalsIgnoreCase(validateCode)){
			//如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中，拒绝访问，不再校验账号和密码 
			System.out.println("验证码不成功");
			httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
			httpServletRequest.setAttribute("msg", "验证码错误");
			return true; 
		}
		return super.onAccessDenied(request, response);
	}
	
	//重写验证通过的代码。没写的话successUrl没法自动跳转。原因并不详
	//登录界面role的参数在这里验证。但是登录验证就得访问2次数据库。。
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,Subject subject, ServletRequest request, ServletResponse response)
		      throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		//如果参数是中文要加下面这2句否则会乱码
		//String role= httpServletRequest.getParameter("role");      
		//aaa= new String(aaa.getBytes("iso-8859-1"),"UTF-8");
		
//		//判断登录的是员工还是用户
//		Staff staff = staffDao.selectStaffById((String)token.getPrincipal());
//		if(staff!=null){
//			String role = (String)httpServletRequest.getParameter("role");
//			
//			
//			if(staff.getRole()!=role){
//				httpServletRequest.setAttribute("shiroLoginFailure", "roleError");
//				return true;
//			}
//			System.out.println(staff);
//			//禁止使用的账号
//			if(staff.getState()==0){
//				httpServletRequest.setAttribute("shiroLoginFailure", "disabledAccount");
//				return true;
//			}
//			//将登录信息保存在Session中
//			httpServletRequest.getSession().setAttribute("staff", staff);
//			
//			WebUtils.issueRedirect(request, response,StaffLoginSuccessUrl);
//			
//			}
		return false;
		}		

//	//rememberMe功能不是很安全。如果把保存的cooike数据拿到别的浏览器上也是可以登录成功的
//	@Override
//	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
//		Subject subject = getSubject(request, response);  
//        //如果 isAuthenticated 为 false 证明不是登录过的，同时 isRememberd 为true 证明是没登陆直接通过记住我功能进来的  
//        if(!subject.isAuthenticated() && subject.isRemembered()){  
//            //获取session看看是不是空的  
//            Session session = subject.getSession(true);  
//            //随便拿session的一个属性来看session当前是否是空的，我用userId，你们的项目可以自行发挥  
//            if(session.getAttribute("userId") == null){  
//            	//如果是空的才初始化，否则每次都要初始化，项目得慢死  
//            }
//            //这边根据前面的前提假设，拿到的是username
//            String username = subject.getPrincipal().toString();
//            System.out.println(username);
//            //在这个方法里面做初始化用户上下文的事情，比如通过查询数据库来设置session值，你们自己发挥  
//            //globalUserService.initUserContext(username, subject);  
//            }
//        //这个方法本来只返回 subject.isAuthenticated() 现在我们加上 subject.isRemembered() 让它同时也兼容remember这种情况  
//        return subject.isAuthenticated() || subject.isRemembered();  
//        }

}
	

