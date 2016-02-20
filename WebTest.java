package hw07;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTest
{
	WebDriver drv = new FirefoxDriver();

	@Before
	public void testBefore()
	{
		drv.get("file:///C:/html_hw3.html");
	}
	@Test
	public void test001onebutton_01()
	{
		drv.findElement(By.id("btn1")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("1", str);
		drv.close();
	}
	@Test
	public void test001onebutton_02()
	{
		drv.findElement(By.id("btn2")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("2", str);
		drv.close();
	}
	@Test
	public void test001onebutton_03()
	{

		drv.findElement(By.id("btn3")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("3", str);
		drv.close();
	}
	@Test
	public void test001onebutton_04()
	{
		drv.findElement(By.id("btn4")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("4", str);
		drv.close();
	}
	@Test
	public void test001onebutton_05()
	{
		drv.findElement(By.id("btn5")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("5", str);
		drv.close();
	}
	@Test
	public void test001onebutton_06()
	{
		drv.findElement(By.id("btn6")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("6", str);
		drv.close();
	}
	@Test
	public void test001onebutton_07()
	{
		drv.findElement(By.id("btn7")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("7", str);
		drv.close();
	}
	@Test
	public void test001onebutton_08()
	{
		drv.findElement(By.id("btn8")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("8", str);
		drv.close();
	}
	@Test
	public void test001onebutton_09()
	{
		drv.findElement(By.id("btn9")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("9", str);
		drv.close();
	}
	@Test
	public void test001onebutton_10()
	{
		drv.findElement(By.id("btn0")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("0", str);
		drv.close();
	}
	@Test
	public void test001onebutton_11()
	{
		drv.findElement(By.id("btnplus")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("+", str);
		drv.close();
	}
	@Test
	public void test001onebutton_12()
	{
		drv.findElement(By.id("btnminus")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("-", str);
		drv.close();
	}
	@Test
	public void test001onebutton_13()
	{
		drv.findElement(By.id("btndiv")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("/", str);
		drv.close();
	}
	@Test
	public void test001onebutton_14()
	{
		drv.findElement(By.id("btnmult")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("*", str);
		drv.close();
	}
	@Test
	public void test001onebutton_15()
	{
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btncancell")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("", str);
		drv.close();
	}
	@Test
	public void test002manybutton_01()
	{
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btn7")).click();
		drv.findElement(By.id("btn7")).click();
		drv.findElement(By.id("btn4")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("111774", str);
		drv.close();
	}
	@Test
	public void test002manybutton_02()
	{
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn5")).click();
		drv.findElement(By.id("btn7")).click();
		drv.findElement(By.id("btn2")).click();
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn5")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("357235", str);
		drv.close();
	}
	@Test
	public void test002manybutton_03()
	{
		drv.findElement(By.id("btn5")).click();
		drv.findElement(By.id("btn7")).click();
		drv.findElement(By.id("btn8")).click();
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btn9")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("578319", str);
		drv.close();
	}
	@Test
	public void test003opers_01()
	{
		drv.findElement(By.id("btn5")).click();
		drv.findElement(By.id("btnplus")).click();
		drv.findElement(By.id("btn8")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("5+8=13", str);
		drv.close();
	}
	@Test
	public void test003opers_02()
	{
		drv.findElement(By.id("btn5")).click();
		drv.findElement(By.id("btn2")).click();
		drv.findElement(By.id("btnplus")).click();
		drv.findElement(By.id("btn8")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("52+8=60", str);
		drv.close();
	}
	@Test
	public void test003opers_03()
	{
		drv.findElement(By.id("btn8")).click();
		drv.findElement(By.id("btnminus")).click();
		drv.findElement(By.id("btn6")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("8-6=2", str);
		drv.close();
	}
	@Test
	public void test003opers_04()
	{
		drv.findElement(By.id("btn8")).click();
		drv.findElement(By.id("btn9")).click();
		drv.findElement(By.id("btnminus")).click();
		drv.findElement(By.id("btn5")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("89-5=84", str);
		drv.close();
	}
	@Test
	public void test003opers_05()
	{
		drv.findElement(By.id("btn8")).click();
		drv.findElement(By.id("btndiv")).click();
		drv.findElement(By.id("btn4")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("8/4=2", str);
		drv.close();
	}
	@Test
	public void test003opers_06()
	{
		drv.findElement(By.id("btn8")).click();
		drv.findElement(By.id("btn8")).click();
		drv.findElement(By.id("btndiv")).click();
		drv.findElement(By.id("btn4")).click();
		drv.findElement(By.id("btn4")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("88/44=2", str);
		drv.close();
	}
	@Test
	public void test003opers_07()
	{
		drv.findElement(By.id("btn4")).click();
		drv.findElement(By.id("btnmult")).click();
		drv.findElement(By.id("btn6")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("4*6=24", str);
		drv.close();
	}
	@Test
	public void test003opers_08()
	{
		drv.findElement(By.id("btn2")).click();
		drv.findElement(By.id("btn0")).click();
		drv.findElement(By.id("btnmult")).click();
		drv.findElement(By.id("btn6")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("20*6=120", str);
		drv.close();
	}
	@Test
	public void test004rand_01()
	{
		drv.findElement(By.id("btn2")).click();
		drv.findElement(By.id("btn0")).click();
		drv.findElement(By.id("btn6")).click();
		drv.findElement(By.id("btnplus")).click();
		drv.findElement(By.id("btn6")).click();
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn4")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("206+634=840", str);
		drv.close();
	}
	@Test
	public void test004rand_02()
	{
		drv.findElement(By.id("btn7")).click();
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn9")).click();
		drv.findElement(By.id("btnminus")).click();
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btn8")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("739-118=621", str);
		drv.close();
	}
	@Test
	public void test004rand_03()
	{
		drv.findElement(By.id("btn7")).click();
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn9")).click();
		drv.findElement(By.id("btnmult")).click();
		drv.findElement(By.id("btn2")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("739*2=1478", str);
		drv.close();
	}
	@Test
	public void test004rand_04()
	{
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btndiv")).click();
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btn1")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("333/111=3", str);
		drv.close();
	}
	@Test
	public void test005err_01()
	{
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btn3")).click();
		drv.findElement(By.id("btncalc")).click();
		String str = drv.findElement(By.id("res3")).getAttribute("value");
		assertEquals("Недостаточно данных", str);
		drv.close();
	}
}
