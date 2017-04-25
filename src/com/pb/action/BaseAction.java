package com.pb.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class BaseAction implements SessionAware,RequestAware,ServletResponseAware,ApplicationAware {
	public Map<String,Object> session;
	public Map<String,Object> request;
	public HttpServletResponse response;
	public Map<String,Object> application; 

	@Override
	public void setSession(Map<String, Object> session) {		
		this.session=session;		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	//响应json
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONString(object);
			System.out.println("json:"+json);
			this.response.setContentType("text/html;charset=utf-8");
			this.response.getWriter().write(json);
			this.response.getWriter().flush();
			this.response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//响应json,并过滤不需要的属性
	public void writeJson(Object object,String... propertyNames) {
		try {
			//过滤属性
			PropertyFilter pf= filterProperty(propertyNames);
			//套用过滤规则
			String json = JSON.toJSONString(object, pf, SerializerFeature.DisableCircularReferenceDetect);
			
			System.out.println("json:"+json);
			
			this.response.setContentType("text/html;charset=utf-8");
			this.response.getWriter().write(json);
			this.response.getWriter().flush();
			this.response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//属性过滤器
	private PropertyFilter filterProperty(final String... propertyNames) {
		// 过滤不显示的属性及关联属性
		PropertyFilter propertyFilter = new PropertyFilter() {

			public boolean apply(Object arg0, String propertyName, Object arg2) {
				if (propertyNames != null && propertyNames.length > 0) {
					for (String pname : propertyNames) {
						if (propertyName.equals(pname)) {
							return false;
						}
					}
				}
				return true;
			}
		};

		return propertyFilter;
	}

	
}
