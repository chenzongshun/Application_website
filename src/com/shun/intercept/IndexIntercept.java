package com.shun.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shun.controller.IndexController;

/**
* @author czs
* @version 创建时间：2018年6月22日 下午10:50:09 
*/
public class IndexIntercept implements HandlerInterceptor {


	@Override
	/**
	 * 画面渲染后
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("画面渲染后");
		
//		new IndexController().jlip(request);
	}

	@Override
	/**
	 * 拦截方法后
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("拦截方法后");
	}

	@Override
	/**
	 * 拦截前，记得放行
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("拦截前");
		return true;
	}

}
