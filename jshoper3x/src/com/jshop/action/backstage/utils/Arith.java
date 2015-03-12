package com.jshop.action.backstage.utils;
import   java.math.BigDecimal;  
/**  
  *   由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精  
  *   确的浮点数运算，包括加减乘除和四舍五入。  
  */  
 
public   class   Arith{  
	   private static final int DEF_DIV_SCALE = 10;
	    
	    /**
	     * 两个Double数相加
	     * @param v1
	     * @param v2
	     * @return Double
	     */
	    public static Double add(Double v1,Double v2){
	        BigDecimal b1 = new BigDecimal(v1.toString());
	        BigDecimal b2 = new BigDecimal(v2.toString());
	        return b1.add(b2).doubleValue();
	    }
	    
	    /**
	     * 两个Double数相减
	     * @param v1
	     * @param v2
	     * @return Double
	     */
	    public static Double sub(Double v1,Double v2){
	        BigDecimal b1 = new BigDecimal(v1.toString());
	        BigDecimal b2 = new BigDecimal(v2.toString());
	        return b1.subtract(b2).doubleValue();
	    }
	    
	    /**
	     * 两个Double数相乘
	     * @param v1
	     * @param v2
	     * @return Double
	     */
	    public static Double mul(Double v1,Double v2){
	        BigDecimal b1 = new BigDecimal(v1.toString());
	        BigDecimal b2 = new BigDecimal(v2.toString());
	        return b1.multiply(b2).doubleValue();
	    }
	    
	    /**
	     * 两个Double数相除
	     * @param v1
	     * @param v2
	     * @return Double
	     */
	    public static Double div(Double v1,Double v2){
	        BigDecimal b1 = new BigDecimal(v1.toString());
	        BigDecimal b2 = new BigDecimal(v2.toString());
	        return b1.divide(b2,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();
	    }
	    
	    /**
	     * 两个Double数相除，并保留scale位小数
	     * @param v1
	     * @param v2
	     * @param scale
	     * @return Double
	     */
	    public static Double div(Double v1,Double v2,int scale){
	        if(scale<0){
	            throw new IllegalArgumentException(
	            "The scale must be a positive integer or zero");
	        }
	        BigDecimal b1 = new BigDecimal(v1.toString());
	        BigDecimal b2 = new BigDecimal(v2.toString());
	        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	    }
};   