package com.cucumber.pageObject.angularJSWebsite;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cucumber.utils.WebDriverUtils;

public class AddSomeControlPage extends AbstractPage {
	WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
	
	public AddSomeControlPage(WebDriver driver){
		super(driver);
	}

	/*public List<WebElement> getTodoCheckBoxes() {
		//checkboxes are even index
	}*/
	
	public List<WebElement> getTodoLabels() {
		List<WebElement> todoLabelsWebElements = new ArrayList<WebElement>();
		int i = 0;
		List<WebElement> webElements = getTodoCheckBoxesAndLabels();
		for(WebElement webElement : webElements){
			//labels are odd index
			if(i % 2 != 0){
				todoLabelsWebElements.add(webElement);
			}
			i++;
		}
		return todoLabelsWebElements;
	}
	
	private List<WebElement> getTodoCheckBoxesAndLabels(){
		/*
		 * This the html script that is used to determine the todo list.
		 * Need to return the <input to represent the checkbox and the <span to represent the checkbox label.
		 * The span class="done-true" or "class-false" represents if the checkbox is selected.	
		 * 
		 * <li ng-repeat="todo in todoList.todos" class="ng-scope">
	      		<label class="checkbox">
	        		<input ng-model="todo.done" class="ng-pristine ng-untouched ng-valid ng-not-empty" type="checkbox">
	        		<span class="done-true">learn angular</span>
	      		</label>
	    	</li>
		 * 
		 *  I use the Selenium xpath locator to return a List of WebElements of <input and <span tags.
		 *  
		 *  By.xpath("//label[@class='checkbox']/*"
		 *  1.  //label -->  Return all the labels
		 *  2.  [@class='checkbox'] --> With the attribute 'checkbox'
		 *  3.  /* --> Return all the children tags of the found label tag.
		 * 
		 *  I should use the xpath locator as the last resort.  
		 *  Should attempt to use the Selenium locator by id or by class first.
		 */
		return driver.findElements(By.xpath("//label[@class='checkbox']/*"));
	}
	
	public WebElement addNewTodoText(){
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("input"), "placeholder", "add new todo here");
	}
	
	public WebElement addNewTodoButton(){
		return webDriverUtils.getWebElementByLocatorFilteredByAttributeValue(By.tagName("input"), "type", "submit");
	}
	
}
