package com.entity.model;

import com.entity.CaipinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 菜品信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-18 21:25:45
 */
public class CaipinxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 菜品分类
	 */
	
	private String caipinfenlei;
		
	/**
	 * 菜品图片
	 */
	
	private String caipintupian;
		
	/**
	 * 菜品口味
	 */
	
	private String caipinkouwei;
		
	/**
	 * 菜品特色
	 */
	
	private String caipintese;
		
	/**
	 * 商家地址
	 */
	
	private String shangjiadizhi;
		
	/**
	 * 单次限购
	 */
	
	private Integer onelimittimes;
		
	/**
	 * 菜品库存
	 */
	
	private Integer alllimittimes;
		
	/**
	 * 菜品详情
	 */
	
	private String caipinxiangqing;
		
	/**
	 * 员工工号
	 */
	
	private String yuangonggonghao;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 价格
	 */
	
	private Double price;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：菜品分类
	 */
	 
	public void setCaipinfenlei(String caipinfenlei) {
		this.caipinfenlei = caipinfenlei;
	}
	
	/**
	 * 获取：菜品分类
	 */
	public String getCaipinfenlei() {
		return caipinfenlei;
	}
				
	
	/**
	 * 设置：菜品图片
	 */
	 
	public void setCaipintupian(String caipintupian) {
		this.caipintupian = caipintupian;
	}
	
	/**
	 * 获取：菜品图片
	 */
	public String getCaipintupian() {
		return caipintupian;
	}
				
	
	/**
	 * 设置：菜品口味
	 */
	 
	public void setCaipinkouwei(String caipinkouwei) {
		this.caipinkouwei = caipinkouwei;
	}
	
	/**
	 * 获取：菜品口味
	 */
	public String getCaipinkouwei() {
		return caipinkouwei;
	}
				
	
	/**
	 * 设置：菜品特色
	 */
	 
	public void setCaipintese(String caipintese) {
		this.caipintese = caipintese;
	}
	
	/**
	 * 获取：菜品特色
	 */
	public String getCaipintese() {
		return caipintese;
	}
				
	
	/**
	 * 设置：商家地址
	 */
	 
	public void setShangjiadizhi(String shangjiadizhi) {
		this.shangjiadizhi = shangjiadizhi;
	}
	
	/**
	 * 获取：商家地址
	 */
	public String getShangjiadizhi() {
		return shangjiadizhi;
	}
				
	
	/**
	 * 设置：单次限购
	 */
	 
	public void setOnelimittimes(Integer onelimittimes) {
		this.onelimittimes = onelimittimes;
	}
	
	/**
	 * 获取：单次限购
	 */
	public Integer getOnelimittimes() {
		return onelimittimes;
	}
				
	
	/**
	 * 设置：菜品库存
	 */
	 
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	
	/**
	 * 获取：菜品库存
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
				
	
	/**
	 * 设置：菜品详情
	 */
	 
	public void setCaipinxiangqing(String caipinxiangqing) {
		this.caipinxiangqing = caipinxiangqing;
	}
	
	/**
	 * 获取：菜品详情
	 */
	public String getCaipinxiangqing() {
		return caipinxiangqing;
	}
				
	
	/**
	 * 设置：员工工号
	 */
	 
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	
	/**
	 * 获取：员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
