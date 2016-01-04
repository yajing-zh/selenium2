package com.demo.test.testcases.home;

import java.util.Map;

import org.testng.annotations.Test;

import com.demo.test.base.BaseParpare;
import com.demo.test.pageshelper.HomePageHelper;
import com.demo.test.pageshelper.SearchResultPageHelper;

/**
 * @author Young
 * @description 在首页输入框输入“OK”,然后点击搜索页面，跳转到搜索页面。
 * */

public class HomePage_002_SearchFunction_Test extends BaseParpare {
	@Test(dataProvider = "testData")
	public void searchFunction(Map<String, String> data) {
		// 等待首页元素加载完毕
		HomePageHelper.waitHomePageLoad(seleniumUtil, timeOut);
		// 关键字搜索
		HomePageHelper.keywordSearch(seleniumUtil, data.get("KEYWORD"));
		// 等待搜索结果页面加载
		SearchResultPageHelper.waitSearchResultPageElementLoad(seleniumUtil,
				timeOut);
		// 检查搜索结果是不是正确的
		SearchResultPageHelper.checkSearchResult(seleniumUtil,
				data.get("KEYWORD"));
	}
}
