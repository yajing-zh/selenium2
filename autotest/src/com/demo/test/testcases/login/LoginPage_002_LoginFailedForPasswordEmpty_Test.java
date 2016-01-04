package com.demo.test.testcases.login;
import java.util.Map;

import org.testng.annotations.Test;

import com.demo.test.base.BaseParpare;
import com.demo.test.pages.HomePage;
import com.demo.test.pageshelper.HomePageHelper;
import com.demo.test.pageshelper.LoginPageHelper;
/**
 * @author Young
 * @description 登录的时候，只输入用户名但是没有输入密码，点击登录按钮提示：“This is a required field.”
 * */

public class LoginPage_002_LoginFailedForPasswordEmpty_Test extends BaseParpare{
  @Test(dataProvider="testData")
  public void loginFailedForPasswordEmpty(Map<String, String> data) {
	  //等待首页元素加载完毕
	  HomePageHelper.waitHomePageLoad(seleniumUtil, timeOut);
	  //点击首页的account链接
	  HomePageHelper.clickOnHomePage(seleniumUtil, HomePage.HP_LINK_ACCOUNT);
	  //点击log in链接，进入登录页面
	  HomePageHelper.clickOnHomePage(seleniumUtil, HomePage.HP_LINK_LOGIN);
	  //等待登录页面加载
	  LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
	  // 输入登录信息
	  LoginPageHelper.typeLoginInfo(seleniumUtil,data.get("EMAIL"), data.get("PASSWORD"));
	  //验证没有输入密码的提示信息
	  LoginPageHelper.checkPasswordEmptyWarningInfo(seleniumUtil, data.get("WARNINGINFO"), timeOut);
  }
}
