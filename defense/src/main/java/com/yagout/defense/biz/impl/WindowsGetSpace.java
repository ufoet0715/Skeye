package com.yagout.defense.biz.impl;

import java.io.File;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yagout.defense.biz.WindowsGetSpaceBiz;
import com.yagout.defense.biz.bean.DiskBean;
import com.yagout.defense.util.CommonResult;
@Service
public class WindowsGetSpace implements WindowsGetSpaceBiz{
	

	@Value("${journalPath}")
	private String journalPath;
	/**
	 * 获取windows磁盘分区列表
	 * @return
	 */
	public static File[] getRoots(){
		File[] roots = File.listRoots();// 获取磁盘分区列表  
		return roots;
	}
	/**
	 * 转换字节与G转换
	 * @param num
	 * @return
	 */
    public static long change(long num) {  
        return num / 1024 / 1024 / 1024;  
    }  
  /**
   * 磁盘使用率函数
   * @param num1 {已经使用空间}
   * @param num2 {总共磁盘空间}
   * @return
   */
    public static String getPercent(Object num1, Object num2) {  
        double val1 = Double.valueOf(num1.toString());  
        double val2 = Double.valueOf(num2.toString());  
        if (val2 == 0) {  
            return "0.0%";  
        } else {  
            DecimalFormat df = new DecimalFormat("#0.00");  
            return df.format(val1 / val2 * 100) + "%";  
        }  
    }
    public CommonResult disk(){
    	CommonResult commonResult=new CommonResult();
    	DiskBean diskBean=new DiskBean();
    	try {
    		File file=new File(journalPath);
   		 System.out.println(file.getPath() + "信息如下:"); 
   		 long free = file.getFreeSpace();  
           long total = file.getTotalSpace();  
           long use = total - free; 
           diskBean.setFree("可用" + change(free) + "G");// 空闲空间  
           diskBean.setUse("已经使用 " + change(use) + "G");// 可用空间  
           diskBean.setTotal("总共" + change(total) + "G");// 总空间  
           diskBean.setPercent("已用" + getPercent(use, total));
           commonResult.setData(diskBean);
           commonResult.setIsSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return commonResult;
    }
 
    /**
	 * main函数测试
	 * @param args
	 */
	public static void main(String[] args) {  
       /* File[] roots = getRoots();// 获取磁盘分区列表  
        for (File file : roots) {  
            System.out.println(file.getPath() + "信息如下:");  
            long free = file.getFreeSpace();  
            long total = file.getTotalSpace();  
            long use = total - free;  
            System.out.println("空闲未使用 = " + change(free) + "G");// 空闲空间  
            System.out.println("已经使用 = " + change(use) + "G");// 可用空间  
            System.out.println("总容量 = " + change(total) + "G");// 总空间  
            System.out.println("使用百分比 = " + getPercent(use, total));  
            System.out.println();  
        }  */
		
		
    }  
    
    
}
